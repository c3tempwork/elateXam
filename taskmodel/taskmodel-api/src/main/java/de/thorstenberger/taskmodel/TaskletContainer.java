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
package de.thorstenberger.taskmodel;

import java.util.List;
import java.util.Map;

/**
 * A tasklet container manages the lifecycle of tasklets. It is exclusively responsible for creation,
 * updating and storage of tasklets.
 * @author Thorsten Berger
 *
 */
public interface TaskletContainer {

	public Tasklet createTasklet( long taskId, String userId ) throws TaskApiException;

	public Tasklet getTasklet( long taskId, String userId ) throws TaskApiException;
	public Tasklet getTaskletForStudent( long taskId, String userId, boolean noupdate ) throws TaskApiException;

	public List<Tasklet> getTasklets( long taskId ) throws TaskApiException;

	public void removeTasklet( long taskId, String userId ) throws TaskApiException;

	public TaskStatistics calculateStatistics( long taskId ) throws TaskApiException;

	public void assignRandomTaskletToCorrector( long taskId, String correctorId ) throws TaskApiException;

  /**
   * Assign all tasklets of this task where status == SOLVED or status == CORRECTING. This routines avoids reassigning a
   * tasklet to a corrector, if he already corrected it.
   * 
   * @param taskId
   * @param correctorIds
   * @returns statistics about the number of assigned tasklets per corrector.
   * @throws TaskApiException
   */
  Map<String, Integer> distributeTaskletsToCorrectors(long taskId, String... correctorIds) throws TaskApiException;

	public List<Tasklet> getTaskletsAssignedToCorrector( long taskId, String correctorId ) throws TaskApiException;

	public void storeTasklet( Tasklet tasklet ) throws TaskApiException;

    /**
     * force subsequent refresh from the persistent store, that means the TaskFactory implementation
     */
    public void reset();


	/**
	 * Store
	 * @param msg
	 * @param tasklet
	 * @param ip
	 */
	public void logPostData( String msg, Tasklet tasklet, String ip );

	public void logPostData( String msg, Throwable throwable, Tasklet tasklet, String ip );

}
