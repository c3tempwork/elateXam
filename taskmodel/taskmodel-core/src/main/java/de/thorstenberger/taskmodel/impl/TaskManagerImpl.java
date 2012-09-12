/*

Copyright (C) 2005 Thorsten Berger

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
/**
 *
 */
package de.thorstenberger.taskmodel.impl;

import java.util.List;

import de.thorstenberger.taskmodel.CategoryFilter;
import de.thorstenberger.taskmodel.MethodNotSupportedException;
import de.thorstenberger.taskmodel.ReportBuilder;
import de.thorstenberger.taskmodel.TaskApiException;
import de.thorstenberger.taskmodel.TaskCategory;
import de.thorstenberger.taskmodel.TaskDef;
import de.thorstenberger.taskmodel.TaskFactory;
import de.thorstenberger.taskmodel.TaskFilter;
import de.thorstenberger.taskmodel.TaskFilterException;
import de.thorstenberger.taskmodel.TaskManager;
import de.thorstenberger.taskmodel.TaskletContainer;
import de.thorstenberger.taskmodel.UserInfo;

/**
 * @author Thorsten Berger
 *
 */
public class TaskManagerImpl implements TaskManager {

	private TaskFactory taskFactory;
	private TaskletContainer taskletContainer;
	private ReportBuilder reportBuilder;

	/**
	 *
	 */
	public TaskManagerImpl( TaskFactory taskFactory, TaskletContainer taskletContainer /*Map typeMapping*/ ) {
//		this.typeMapping = typeMapping;
		this.taskFactory = taskFactory;
		this.taskletContainer = taskletContainer;
	}

	/**
	 * returns null in this implementation
	 * @see de.thorstenberger.taskmodel.TaskManager#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getTaskDefs()
	 */
	public List<TaskDef> getTaskDefs() {
		return taskFactory.getTaskDefs();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getTaskDefs(java.lang.String)
	 */
	public List<TaskDef> getTaskDefs( TaskFilter filter ) throws TaskFilterException {
		return taskFactory.getTaskDefs( filter );
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getTaskDef(long)
	 */
	public TaskDef getTaskDef(long id) {
		return taskFactory.getTaskDef( id );
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getTaskDef(de.thorstenberger.taskmodel.TaskFilter, long)
	 */
	public TaskDef getTaskDef(TaskFilter filter, long id) throws TaskFilterException {
		if( !filter.matchesCriteria( getTaskDef( id ) ) )
			throw new TaskFilterException( "Task ID does not match criteria." );
		return null;
	}

	/**
	 * @return Returns the taskletContainer.
	 */
	public TaskletContainer getTaskletContainer() {
		return taskletContainer;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getCategories()
	 */
	public List<TaskCategory> getCategories() {
		return taskFactory.getCategories();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getCategories(de.thorstenberger.taskmodel.CategoryFilter)
	 */
	public List<TaskCategory> getCategories(CategoryFilter categoryFilter) {
		return taskFactory.getCategories( categoryFilter );
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getReportBuilder()
	 */
	public ReportBuilder getReportBuilder() {
		if( reportBuilder == null )
			reportBuilder = new ReportBuilderImpl( this );
		return reportBuilder;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#availableUserAttributes()
	 */
	public List<UserAttribute> availableUserAttributes() {
		return taskFactory.availableUserAttributes();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getCorrectors()
	 */
	public List<UserInfo> getCorrectors() {
		return taskFactory.getCorrectors();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskManager#getUserInfo(java.lang.String)
	 */
	public UserInfo getUserInfo(String login) {
		return taskFactory.getUserInfo( login );
	}

	public void storeTaskCategory(TaskCategory category) {
		taskFactory.storeTaskCategory(category);
	}

	public void deleteCategory(long id_long) throws MethodNotSupportedException {
		taskFactory.deleteTaskCategory(id_long);
	}

	public TaskCategory getCategory(long id) throws MethodNotSupportedException {
		return taskFactory.getCategory(id);
	}

	public void storeTaskDef(TaskDef taskDef, long taskCategoryId) throws TaskApiException {
		taskFactory.storeTaskDef(taskDef,taskCategoryId);
	}
	public void deleteTaskDef(long id) throws MethodNotSupportedException {
		taskFactory.deleteTaskDef(id);
	}

}
