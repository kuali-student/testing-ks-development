package org.apache.torque.mojo;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.torque.util.JdbcConfigurer;
import org.kuali.core.db.torque.DumpTask;
import org.kuali.core.db.torque.PropertyHandlingException;
import org.kuali.core.db.torque.StringFilter;

/**
 * Reads the content of tables from the database and exports the data to XML files.
 */
public abstract class ExportMojo extends AntTaskMojo {

	/**
	 * The XML file contains a name attribute for the schema being exported. This value is what will end up there
	 * 
	 * @parameter expression="${artifactId}" default-value="${project.artifactId}"
	 * @required
	 */
	private String artifactId;

	/**
	 * Comment that gets placed into the generated XML document
	 * 
	 * @parameter expression="${comment}"
	 *            default-value="Auto-generated by the maven-impex-plugin version ${project.version}"
	 */
	private String comment;

	/**
	 * Comma separated list of regular expressions for tables to include in the export
	 * 
	 * @parameter expression="${includes}"
	 */
	private String includes;

	/**
	 * Comma separated list of regular expressions for tables to exclude from the export
	 * 
	 * @parameter expression="${excludes}"
	 */
	private String excludes;

	/**
	 * Database type (oracle, mysql etc)
	 * 
	 * @parameter expression="${targetDatabase}"
	 * @required
	 */
	private String targetDatabase;

	/**
	 * The schema containing the tables to dump
	 * 
	 * @parameter expression="${schema}"
	 * @required
	 */
	private String schema;

	/**
	 * The fully qualified class name of the database driver.
	 * 
	 * @parameter expression="${driver}"
	 * @required
	 */
	private String driver;

	/**
	 * The connect URL of the database.
	 * 
	 * @parameter expression="${url}"
	 * @required
	 */
	private String url;

	/**
	 * The user name to connect to the database.
	 * 
	 * @parameter expression="${username}"
	 */
	private String username;

	/**
	 * The password for the database user.
	 * 
	 * @parameter expression="${password}"
	 */
	private String password;

	/**
	 * Returns the fully qualified class name of the database driver.
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * Sets the fully qualified class name of the database driver.
	 * 
	 * @param driver
	 *            the fully qualified class name of the database driver.
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * Returns the password of the database user.
	 * 
	 * @return the password of the database user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the database user.
	 * 
	 * @param password
	 *            the password of the database user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the connect URL to the database.
	 * 
	 * @return the connect URL to the database.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the connect URL to the database.
	 * 
	 * @param url
	 *            the connect URL to the database.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTargetDatabase() {
		return targetDatabase;
	}

	public void setTargetDatabase(String targetDatabase) {
		this.targetDatabase = targetDatabase;
	}

	public String getIncludes() {
		return includes;
	}

	public void setIncludes(String includePatterns) {
		this.includes = includePatterns;
	}

	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludePatterns) {
		this.excludes = excludePatterns;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	protected void configureTask() throws MojoExecutionException {
		try {
			JdbcConfigurer configurer = new JdbcConfigurer();
			configurer.updateConfiguration(this);
			configurer.validateConfiguration(this);
		} catch (PropertyHandlingException e) {
			throw new MojoExecutionException("Error handling properties", e);
		}
		super.configureTask();
		DumpTask task = (DumpTask) super.getAntTask();
		task.setIncludePatterns(StringFilter.getListFromCSV(getIncludes()));
		task.setExcludePatterns(StringFilter.getListFromCSV(getExcludes()));
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
}
