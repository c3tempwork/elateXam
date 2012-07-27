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
package de.thorstenberger.taskmodel.complex.complextaskhandling.impl;

import java.util.ArrayList;
import java.util.List;

import de.thorstenberger.taskmodel.complex.ComplexTaskFactory;
import de.thorstenberger.taskmodel.complex.complextaskdef.ComplexTaskDefRoot;
import de.thorstenberger.taskmodel.complex.complextaskhandling.SubTasklet;
import de.thorstenberger.taskmodel.complex.jaxb.ComplexTaskHandling.Try.Page;
import de.thorstenberger.taskmodel.complex.jaxb.SubTaskType;

/**
 * @author Thorsten Berger
 *
 */
public class PageImpl implements de.thorstenberger.taskmodel.complex.complextaskhandling.Page {

	private Page pageType;
	private ComplexTaskFactory complexTaskFactory;
	private ComplexTaskDefRoot complexTaskDefRoot;

	/**
	 *
	 */
  public PageImpl(Page pageType, ComplexTaskFactory complexTaskFactory, ComplexTaskDefRoot complexTaskDefRoot) {
		this.pageType = pageType;
		this.complexTaskFactory = complexTaskFactory;
		this.complexTaskDefRoot = complexTaskDefRoot;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskhandling.Page#getNumber()
	 */
	public int getNumber() {
		return pageType.getNo();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskhandling.Page#getProcessStatus()
	 */
	public int getProcessStatus(){
		List<SubTasklet> subtasklets = getSubTasklets();
		int numOfProcessedSubTasks = 0;

		for( SubTasklet subTasklet : subtasklets )
			if( subTasklet.isProcessed() ) {
        numOfProcessedSubTasks++;
      }

		if( numOfProcessedSubTasks == 0 )
			return NOT_PROCESSED;
		else if( numOfProcessedSubTasks == subtasklets.size() )
			return COMPLETELY_PROCESSED;
		else
			return PARTLY_PROCESSED;
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskhandling.Page#getSubTasklets()
	 */
	public List<SubTasklet> getSubTasklets() {
		List<SubTasklet> ret = new ArrayList<SubTasklet>();

		for(SubTaskType stt: pageType.getMcSubTaskOrClozeSubTaskOrTextSubTask()){
			ret.add( complexTaskFactory.instantiateSubTasklet( stt, complexTaskDefRoot, getCategoryRefId() ) );
			
		}

		return ret;
	}

	/**
	 * Relevant for adding this page to a Try.
	 * @return
	 */
  public Page getPage() {
		return pageType;
	}


	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskhandling.Page#getCategoryRefId()
	 */
	public String getCategoryRefId() {
		return pageType.getCategoryRefID();
	}

	/* (non-Javadoc)
	 * @see de.thorstenberger.taskmodel.complex.complextaskhandling.Page#getHash()
	 */
	public long getHash() {
		long hash = 0;
		List<SubTasklet> subtasklets = getSubTasklets();
		for( SubTasklet subTasklet : subtasklets ) {
      hash += subTasklet.getHash();
    }

		return hash;
	}

}
