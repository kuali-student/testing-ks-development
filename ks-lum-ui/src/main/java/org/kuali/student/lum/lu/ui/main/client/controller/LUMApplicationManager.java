package org.kuali.student.lum.lu.ui.main.client.controller;

import java.util.List;

import org.kuali.student.common.ui.client.application.ApplicationComposite;
import org.kuali.student.common.ui.client.mvc.Controller;
import org.kuali.student.common.ui.client.mvc.Model;
import org.kuali.student.common.ui.client.mvc.View;
import org.kuali.student.common.ui.client.mvc.events.LogoutEvent;
import org.kuali.student.common.ui.client.mvc.events.LogoutHandler;
import org.kuali.student.core.dictionary.dto.ObjectStructure;
import org.kuali.student.lum.lu.ui.course.client.configuration.LUConstants;
import org.kuali.student.lum.lu.ui.course.client.configuration.LUCreateUpdateView;
import org.kuali.student.lum.lu.ui.course.client.configuration.LUDictionaryManager;
import org.kuali.student.lum.lu.ui.course.client.configuration.history.KSHistory;
import org.kuali.student.lum.lu.ui.course.client.service.CluProposal;
import org.kuali.student.lum.lu.ui.course.client.service.CluProposalRpcService;
import org.kuali.student.lum.lu.ui.course.client.service.CluProposalRpcServiceAsync;
import org.kuali.student.lum.lu.ui.course.client.service.LuRpcService;
import org.kuali.student.lum.lu.ui.course.client.service.LuRpcServiceAsync;
import org.kuali.student.lum.lu.ui.home.client.view.HomeMenuController;
import org.kuali.student.lum.lu.ui.main.client.events.ChangeViewStateEvent;
import org.kuali.student.lum.lu.ui.main.client.events.ChangeViewStateHandler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public class LUMApplicationManager extends Controller{

    ApplicationComposite app = new ApplicationComposite();
    
    private final SimplePanel viewPanel = new SimplePanel();

    private final View homeMenu = new HomeMenuController(this);
    //private CourseProposalManager createCourse = new CourseProposalManager(this);
    KSHistory history;

    private LUCreateUpdateView courseView;
    private LUCreateUpdateView modifyView;
    
    private Model<CluProposal> cluModel = new Model<CluProposal>();

    private LuRpcServiceAsync luRpcServiceAsync = GWT.create(LuRpcService.class);
    private CluProposalRpcServiceAsync cluProposalRpcServiceAsync = GWT.create(CluProposalRpcService.class);
    
    public LUMApplicationManager(){
        super();
        loadDictionary();
        history = new KSHistory(this);
        super.initWidget(app);
        app.setContent(viewPanel);
        viewPanel.addStyleName("LUMMain-Content");
    }

    protected void onLoad() {
        addApplicationEventHandler(ChangeViewStateEvent.TYPE, new ChangeViewStateHandler() {
            public void onViewStateChange(ChangeViewStateEvent event) {
                //This is very hacky
                if (event.getEventSource() != null && event.getEventSource() instanceof SelectionEvent){                    
                    List<String> selectedIds = (List<String>)((SelectionEvent)event.getEventSource()).getSelectedItem();
                    if (modifyView == null){
                        modifyView = new LUCreateUpdateView(LUMApplicationManager.this, LUConstants.LU_TYPE_CREDIT_COURSE, LUConstants.LU_STATE_PROPOSED, false);
                    }
                    modifyView.setId(selectedIds.get(0));
                }
                showView(event.getViewType());  
            }
        });
        addApplicationEventHandler(LogoutEvent.TYPE, new LogoutHandler() {
            public void onLogout(LogoutEvent event) {
                Window.Location.assign("/j_spring_security_logout");
            }
        });
    }

    public enum LUMViews {
        HOME_MENU, CREATE_COURSE, EDIT_COURSE_PROPOSAL
    }

    @Override
    protected <V extends Enum<?>> View getView(V viewType) {
        switch ((LUMViews) viewType) {
            case HOME_MENU:
                return homeMenu;
            case CREATE_COURSE:
                if (courseView == null){
                    courseView = new LUCreateUpdateView(LUMApplicationManager.this, LUConstants.LU_TYPE_CREDIT_COURSE, LUConstants.LU_STATE_PROPOSED);
                }
                ((LUCreateUpdateView)courseView).addLayoutToHistory(history, LUMViews.CREATE_COURSE); 
                return courseView;
            case EDIT_COURSE_PROPOSAL:
                if (modifyView == null){
                    modifyView = new LUCreateUpdateView(LUMApplicationManager.this, LUConstants.LU_TYPE_CREDIT_COURSE, LUConstants.LU_STATE_PROPOSED, false);
                }
                ((LUCreateUpdateView)modifyView).addLayoutToHistory(history, LUMViews.EDIT_COURSE_PROPOSAL);
                return modifyView;
            default:
                return null;
        }
    }

    //Accessor for get view
    public <V extends Enum<?>> View getControllerView(V viewType){
    	return this.getView(viewType);
    }
    
    @Override
    protected void hideView(View view) {
        viewPanel.clear();

    }

    @Override
    protected void renderView(View view) {
        // TODO Bsmith - THIS METHOD NEEDS JAVADOCS
        viewPanel.setWidget((Composite)view);
    }

    @Override
    public void showDefaultView() {
    	final String docId=Window.Location.getParameter("docId");
    	String backdoorId=Window.Location.getParameter("backdoorId");
    	if(docId!=null){
    		if(backdoorId!=null){
    			cluProposalRpcServiceAsync.loginBackdoor(backdoorId, new AsyncCallback<Boolean>(){
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					public void onSuccess(Boolean result) {
						if(result){
				            if (modifyView == null){
				                modifyView = new LUCreateUpdateView(LUMApplicationManager.this, LUConstants.LU_TYPE_CREDIT_COURSE, LUConstants.LU_STATE_PROPOSED, false);
				            }
				            modifyView.setId(docId);
				            showView(LUMViews.EDIT_COURSE_PROPOSAL);
						}else{
							Window.alert("Error with backdoor login");
						}
					}
    			
    			});
    		}else{
	            if (modifyView == null){
	                modifyView = new LUCreateUpdateView(LUMApplicationManager.this, LUConstants.LU_TYPE_CREDIT_COURSE, LUConstants.LU_STATE_PROPOSED, false);
	            }
	            modifyView.setId(docId);
	            this.showView(LUMViews.EDIT_COURSE_PROPOSAL);
    		}
    	}
    	else{
    		this.showView(LUMViews.HOME_MENU);
    	}
    }

    public Class<? extends Enum<?>> getViewsEnum() {
        return LUMViews.class;
    }        

    private void loadDictionary() {
        
        //  If msg load OK, load proposalInfo structure
        luRpcServiceAsync.getObjectStructure(LUDictionaryManager.STRUCTURE_PROPOSAL_INFO, new AsyncCallback<ObjectStructure>(){
            public void onFailure(Throwable caught) {
                throw new RuntimeException("Unable to load proposalInfo object structure", caught);                
            }

            @Override
            public void onSuccess(ObjectStructure result) {
                
                LUDictionaryManager.getInstance().loadStructure(result);

                //  If proposal Info structure load OK, load cluInfo structure                      
                luRpcServiceAsync.getObjectStructure(LUDictionaryManager.STRUCTURE_CLU_INFO, new AsyncCallback<ObjectStructure>(){
                    public void onFailure(Throwable caught) {
                        throw new RuntimeException("Unable to load cluInfo object structure", caught);                
                    }

                    @Override
                    public void onSuccess(ObjectStructure result) {
                        LUDictionaryManager.getInstance().loadStructure(result);
                        
                        //  If proposal Info structure load OK, load cluInfo structure                      
                        luRpcServiceAsync.getObjectStructure(LUDictionaryManager.STRUCTURE_CLU_ID_INFO, new AsyncCallback<ObjectStructure>(){
                            public void onFailure(Throwable caught) {
                                throw new RuntimeException("Unable to load cluIdentifierInfo object structure", caught);                
                            }

                            @Override
                            public void onSuccess(ObjectStructure result) {
                                LUDictionaryManager.getInstance().loadStructure(result);

                            }
                        }
                        );


                    }
                }
                );


            }
        }
        );

    }

    public void setCluId(String id){
        this.courseView.setId(id);
    }
}
