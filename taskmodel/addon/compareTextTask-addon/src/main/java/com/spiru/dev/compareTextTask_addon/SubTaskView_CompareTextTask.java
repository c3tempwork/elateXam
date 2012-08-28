package com.spiru.dev.compareTextTask_addon;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;

import de.thorstenberger.taskmodel.MethodNotSupportedException;
import de.thorstenberger.taskmodel.complex.ParsingException;
import de.thorstenberger.taskmodel.complex.complextaskhandling.CorrectionSubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.SubmitData;
import de.thorstenberger.taskmodel.view.SubTaskView;
import de.thorstenberger.taskmodel.view.ViewContext;

public class SubTaskView_CompareTextTask extends SubTaskView{

	private SubTasklet_CompareTextTask subTasklet;

	/**
	 *
	 */
	public SubTaskView_CompareTextTask( SubTasklet_CompareTextTask subTaskletObject ) {
		this.subTasklet = subTaskletObject;
	}

	/**
	 * @see de.thorstenberger.uebman.services.student.task.complex.SubTaskView#getRenderedHTML(int)
	 */
	@Override
	public String getRenderedHTML( ViewContext context, int relativeTaskNumber) {
		return getRenderedHTML( relativeTaskNumber, false );
	}

	public String getRenderedHTML(int relativeTaskNumber, boolean corrected) {
		final StringBuffer ret = new StringBuffer();
		String path = "com/spiru/dev/compareTextTask_addon/CompareTextApplet.class";
		/*
		ret.append("<script src=\"http://java.com/js/deployJava.js\"></script>\n"); // need that locally (no internet access during exams)
		ret.append("<script>\n");
		ret.append("    var attributes = {codebase:'http://java.sun.com/products/plugin/1.5.0/demos/jfc/Java2D', code:'com/spiru/dev/compareTextTask_addon/CompareTextApplet.class', width:710, height:540};\n");
		ret.append("    var parameters = {fontSize:16};\n");
		ret.append("    var version = '1.6';\n");
		ret.append("    deployJava.runApplet(attributes, parameters, version);\n");
		ret.append("</script>\n");
		*/
		ret.append("<applet archive=\"compareTextTask/compareTextTask.jar\" code=\"" + path + "\" width=\"710\" height=\"540\" title=\"Java\">\n");
		ret.append("<param name=\"initialText\" value=\"" + subTasklet.getInitialText() + "\">\n");
		ret.append("<param name=\"xmlDef\" value=\"" + subTasklet.getTagsString() + "\">\n");
		ret.append("</applet>\n");
		return ret.toString();
	}

	@Override
	public String getCorrectedHTML( ViewContext context, int relativeTaskNumber ){
		return getRenderedHTML( -1, true );
	}

	@Override
	public String getCorrectionHTML(String actualCorrector, ViewContext context ){
		StringBuffer ret = new StringBuffer();
		ret.append( getRenderedHTML( -1, true ) );

		ret.append(getCorrectorPointsInputString(actualCorrector, "Anordnung", subTasklet));

		return ret.toString();
	}

	/**
	 * @see de.thorstenberger.uebman.services.student.task.complex.SubTaskView#getSubmitData(java.util.Map, int)
	 */
	@Override
	public SubmitData getSubmitData(Map postedVarsForTask)
			throws ParsingException {

		Iterator it = postedVarsForTask.keySet().iterator();
		while( it.hasNext() ) {
			String key=(String) it.next();
			if( getMyPart( key ).equals( "Anordnung" ) )
				return new CompareTextTaskSubmitData( (String) postedVarsForTask.get(key) );
		}
		throw new ParsingException();

	}

	@Override
	public CorrectionSubmitData getCorrectionSubmitData( Map postedVars ) throws ParsingException, MethodNotSupportedException{
		Iterator it = postedVars.values().iterator();
		if( it.hasNext() ){
			float points;
			try {
				points = NumberFormat.getInstance().parse( (String) it.next() ).floatValue();
			} catch (ParseException e) {
				throw new ParsingException( e );
			}
			return new CompareTextTaskCorrectionSubmitData( points );
		} else
			throw new ParsingException();
	}

}
