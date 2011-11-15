package org.kuali.student.enrollment.class2.acal.service.assembler;

import org.kuali.student.enrollment.acal.dto.HolidayInfo;
import org.kuali.student.r2.common.assembler.DTOAssembler;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.atp.dto.MilestoneInfo;

public class HolidayAssembler  implements DTOAssembler<HolidayInfo, MilestoneInfo> {

    @Override
    public HolidayInfo assemble(MilestoneInfo milestoneInfo, ContextInfo context) {

        if (milestoneInfo == null){
            return null;
        }

        HolidayInfo holidayInfo = new HolidayInfo();
        holidayInfo.setKey(milestoneInfo.getKey());
        holidayInfo.setName(milestoneInfo.getName());
        holidayInfo.setDescr(milestoneInfo.getDescr());

        holidayInfo.setStartDate(milestoneInfo.getStartDate());
        holidayInfo.setEndDate(milestoneInfo.getEndDate());
        holidayInfo.setIsAllDay(milestoneInfo.getIsAllDay());
        holidayInfo.setIsDateRange(milestoneInfo.getIsDateRange());

        holidayInfo.setStateKey(milestoneInfo.getStateKey());
        holidayInfo.setTypeKey(milestoneInfo.getTypeKey());

        holidayInfo.setMeta(milestoneInfo.getMeta());
        holidayInfo.setAttributes(milestoneInfo.getAttributes());

        return holidayInfo;
    }

    @Override
    public MilestoneInfo disassemble(HolidayInfo holidayInfo, ContextInfo context) {

        if (holidayInfo == null){
            return null;
        }

        MilestoneInfo msInfo = new MilestoneInfo();

        msInfo.setKey(holidayInfo.getKey());
        msInfo.setName(holidayInfo.getName());
        msInfo.setDescr(holidayInfo.getDescr());

        msInfo.setStartDate(holidayInfo.getStartDate());
        msInfo.setEndDate(holidayInfo.getEndDate());
        msInfo.setIsAllDay(holidayInfo.getIsAllDay());
        msInfo.setIsDateRange(holidayInfo.getIsDateRange());

        msInfo.setStateKey(holidayInfo.getStateKey());
        msInfo.setTypeKey(holidayInfo.getTypeKey());

        msInfo.setMeta(holidayInfo.getMeta());
        msInfo.setAttributes(holidayInfo.getAttributes());

        return msInfo;
    }
}
