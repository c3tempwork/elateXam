package com.spiru.dev.rtypeTask_addon;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import de.thorstenberger.taskmodel.MethodNotSupportedException;
import de.thorstenberger.taskmodel.complex.ParsingException;
import de.thorstenberger.taskmodel.complex.complextaskhandling.CorrectionSubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.SubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.subtasklets.SubTasklet_MC;
import de.thorstenberger.taskmodel.view.SubTaskView;
import de.thorstenberger.taskmodel.view.ViewContext;

public class SubTaskView_RtypeTask extends SubTaskView{

	private SubTasklet_RtypeTask rtypeSubTasklet;

	/**
	 *
	 */
	public SubTaskView_RtypeTask( SubTasklet_RtypeTask rtypeSubTasklet ) {
		this.rtypeSubTasklet = rtypeSubTasklet;
		
	}

	/**
	 * @see de.thorstenberger.uebman.services.student.task.complex.SubTaskView#getRenderedHTML(int)
	 */
	public String getRenderedHTML( ViewContext context, int relativeTaskNumber) {
		return getRenderedHTML( relativeTaskNumber, false );
	}

	public String getRenderedHTML(int relativeTaskNumber, boolean corrected) {
		//HttpServletRequest request=(HttpServletRequest) context.getViewContextObject();
		StringBuffer ret = new StringBuffer();

		ret.append("\n");
		ret.append("<table>");
		ret.append("\n");
		ret.append("<tr>");
		ret.append("\n  <td nowrap valign=top> <input type=\"radio\" name=\"task[" + relativeTaskNumber +
						"].ss\" value=\"A\"</td>");
		ret.append("\n");
		ret.append("</tr>");
		ret.append("\n");
		ret.append("</table>");

		return ret.toString();
	}

	public String getCorrectedHTML( ViewContext context, int relativeTaskNumber ){		
		return getRenderedHTML( -1, true );
	}

	public String getCorrectionHTML(String actualCorrector, ViewContext context ){	
	    StringBuffer ret = new StringBuffer();
	    ret.append( getRenderedHTML( -1, true ) );

	    ret.append(getCorrectorPointsInputString(actualCorrector, "Rtype", rtypeSubTasklet));

	    return ret.toString();
	}

	/**
	 * @see de.thorstenberger.uebman.services.student.task.complex.SubTaskView#getSubmitData(java.util.Map, int)
	 */
	public SubmitData getSubmitData(Map postedVarsForTask) throws ParsingException {
		Iterator it = postedVarsForTask.keySet().iterator();
		while( it.hasNext() ) {
			String key=(String) it.next();
			String value = (String) postedVarsForTask.get(key);				
			return new RtypeTaskSubmitData( value );
		}
		throw new ParsingException();
	}

	public CorrectionSubmitData getCorrectionSubmitData( Map postedVars ) throws ParsingException, MethodNotSupportedException{
	    Iterator it = postedVars.values().iterator();
	    if( it.hasNext() ){
	        float points;
            try {
                points = NumberFormat.getInstance().parse( (String) it.next() ).floatValue();
            } catch (ParseException e) {
                throw new ParsingException( e );
            }
            return new RtypeTaskCorrectionSubmitData( points );
	    }else
	        throw new ParsingException();
	}

}
