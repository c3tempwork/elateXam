/*

Copyright (C) 2006 Thorsten Berger

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
package de.thorstenberger.taskmodel.complex.complextaskdef.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.thorstenberger.taskmodel.complex.ComplexTaskFactory;
import de.thorstenberger.taskmodel.complex.complextaskdef.Block;
import de.thorstenberger.taskmodel.complex.jaxb.ComplexTaskDef.Category;
import de.thorstenberger.taskmodel.complex.jaxb.TaskBlockType;
/**
 * @author Thorsten Berger
 *
 */
public class CategoryImpl implements de.thorstenberger.taskmodel.complex.complextaskdef.Category {

  private Category categoryType;
	private ComplexTaskFactory complexTaskFactory;

	/**
	 *
	 */
  public CategoryImpl(ComplexTaskFactory complexTaskFactory, Category categoryType) {
		this.complexTaskFactory = complexTaskFactory;
		this.categoryType = categoryType;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#getId()
	 */
	public String getId() {
		return categoryType.getId();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#getTasksPerPage()
	 */
	public Integer getTasksPerPage() {
		if( categoryType.isSetTasksPerPage() )
			return categoryType.getTasksPerPage();
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#getTitle()
	 */
	public String getTitle() {
		return categoryType.getTitle();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#isMixAllSubTasks()
	 */
	public boolean isMixAllSubTasks() {
    return categoryType.isSetMixAllSubTasks() && categoryType.isMixAllSubTasks();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#isPreserveOrderOfBlocks()
	 */
	public boolean isIgnoreOrderOfBlocks() {
    return categoryType.isSetIgnoreOrderOfBlocks() && categoryType.isIgnoreOrderOfBlocks();
	}

	/**
	 * backdoor access to JAXB element
	 * @return Returns the categoryType.
	 */
  public Category getCategory() {
		return categoryType;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#getBlocks()
	 */
	public List<Block> getBlocks() {
		List<Block> ret = new ArrayList<Block>();
    Iterator it = categoryType.getMcTaskBlockOrClozeTaskBlockOrTextTaskBlock().iterator();
		int i = 0;
		while( it.hasNext() ) {
      ret.add( complexTaskFactory.instantiateBlock( (TaskBlockType) it.next(), i++ ) );
    }
		return ret;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskdef.Category#getBlock(int)
	 */
	public Block getBlock(int index) {

    if (categoryType.getMcTaskBlockOrClozeTaskBlockOrTextTaskBlock().size() <= index)
			return null;

    return complexTaskFactory.instantiateBlock(categoryType.getMcTaskBlockOrClozeTaskBlockOrTextTaskBlock().get(index), index);

	}


}
