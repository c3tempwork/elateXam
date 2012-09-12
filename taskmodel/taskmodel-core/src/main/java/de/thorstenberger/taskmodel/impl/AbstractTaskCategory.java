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

import de.thorstenberger.taskmodel.TaskCategory;
import de.thorstenberger.taskmodel.TaskDef;

/**
 * @author Thorsten Berger
 *
 */
public class AbstractTaskCategory implements TaskCategory {

	private long id;
	private String name;
	private List<TaskDef> taskDefs;

	/**
	 *
	 */
	public AbstractTaskCategory( long id, String name, List<TaskDef> taskDefs ) {
		this.id = id;
		this.name = name;
		this.taskDefs = taskDefs;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskCategory#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskCategory#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.TaskCategory#getTaskDefs()
	 */
	public List<TaskDef> getTaskDefs() {
		return taskDefs;
	}

	public void setName(String name) {
		this.name=name;
	}

}
