/*

Copyright (C) 2006 Steffen Dienst

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
package de.thorstenberger.taskmodel.view;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import de.thorstenberger.taskmodel.MethodNotSupportedException;
import de.thorstenberger.taskmodel.complex.ParsingException;
import de.thorstenberger.taskmodel.complex.complextaskhandling.CorrectionSubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.SubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.correctionsubmitdata.PaintCorrectionSubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.submitdata.PaintSubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.subtasklets.SubTasklet_Paint;

public class SubTaskView_Paint extends SubTaskView {

	public SubTasklet_Paint paintSubTasklet;

	public SubTaskView_Paint(final SubTasklet_Paint paintSubTasklet) {
		this.paintSubTasklet = paintSubTasklet;
	}

	@Override
	public String getCorrectedHTML(final ViewContext context, final int relativeTaskNumber) {
		return getRenderedHTML(context, 999999, true);
	}

	@Override
	public String getCorrectionHTML(final String actualCorrector, final ViewContext context) {

		final StringBuilder ret = new StringBuilder();
		ret.append(getRenderedHTML(context, 999999, true));

		ret.append(getCorrectorPointsInputString(actualCorrector, "text", paintSubTasklet));

		return ret.toString();
	}

	@Override
	public CorrectionSubmitData getCorrectionSubmitData(final Map postedVars) throws ParsingException,
	MethodNotSupportedException {
		final Iterator it = postedVars.values().iterator();
		if (it.hasNext()) {
			float points;
			try {
				points = NumberFormat.getInstance().parse((String) it.next()).floatValue();
			} catch (final ParseException e) {
				throw new ParsingException(e);
			}
			return new PaintCorrectionSubmitData(points);
		} else
			throw new ParsingException();
	}

	/**
	 * @see de.thorstenberger.uebman.services.student.task.complex.SubTaskView#getRenderedHTML(int)
	 */
	@Override
	public String getRenderedHTML(final ViewContext context, final int relativeTaskNumber) {
		return getRenderedHTML(context, relativeTaskNumber, false);
	}

	public String getRenderedHTML(final ViewContext context, final int relativeTaskNumber, final boolean corrected) {
		final HttpServletRequest request = (HttpServletRequest) context.getViewContextObject();
		final StringBuffer ret = new StringBuffer();

		// workaround: textarea nicht disabled
		// corrected = false;

		/*
		// This code is not working with Chrome:
		final String userAgent = request.getHeader("User-Agent");
		final boolean mozilla = userAgent != null && userAgent.startsWith("Mozilla") && userAgent.indexOf("MSIE") == -1;
        ret.append("<div align=\"center\">\n");
        ret.append("<object\r\n"
        		+
        		(mozilla ? "    classid = \"java:drawing/DrawingApplet.class\"\r\n"
        				: "    classid = \"clsid:8AD9C840-044E-11D1-B3E9-00805F499D93\"\r\n") +
        				"    codebase = \"http://java.sun.com/update/1.5.0/jinstall-1_5-windows-i586.cab#Version=5,0,0,7\"\r\n" +
        				"    WIDTH = \"600\" HEIGHT = \"" + (corrected ? 355 : 395) + "\" NAME = \"drawTask_" + relativeTaskNumber
        				+ "\" >\r\n" +
        				"    <param name=\"code\" value=\"drawing/DrawingApplet.class\" >\r\n" +
        				"    <param name=\"codebase\" value=\"" + request.getContextPath() + "/drawTask\" >\r\n" +
        				"    <param name=\"archive\" value=\"drawtask.jar\" >\r\n" +
        				"    <param name=\"name\" value=\"drawTask_" + relativeTaskNumber + "\" >\r\n" +
        				"    <param name=\"mayscript\" value=\"true\" >\r\n" +
        				"    <param name=\"type\" value=\"application/x-java-applet;version=1.5\">\r\n" +
        		"    <param name=\"scriptable\" value=\"true\"> ");
        */
		String path = "drawing/DrawingApplet.class";
		ret.append("<applet archive=\"drawTask/drawtask.jar\" code=\"" + path + "\" " +
				"width = \"600\" height = \"" + (corrected ? 355 : 395) + "\" NAME = \"drawTask_" + relativeTaskNumber +  "title=\"Java\">\n" +
				"    <param name=\"code\" value=\"drawing/DrawingApplet.class\" >\r\n" +
				"    <param name=\"codebase\" value=\"" + request.getContextPath() + "/drawTask\" >\r\n" +
				"    <param name=\"archive\" value=\"drawtask.jar\" >\r\n" +
				"    <param name=\"name\" value=\"drawTask_" + relativeTaskNumber + "\" >\r\n" +
				"    <param name=\"mayscript\" value=\"true\" >\r\n" +
				"    <param name=\"type\" value=\"application/x-java-applet;version=1.5\">\r\n" +
				"    <param name=\"scriptable\" value=\"true\"> ");

		// ret.append("<applet name=\"drawTask_" + relativeTaskNumber + "\" codebase=\"");
		// ret.append(request.getContextPath()).append("/drawTask\" code=\"drawing/DrawingApplet.class\" archive=\"drawtask-1.0.jar\" width=\"600\" height=\"395\" mayscript>\n");
		ret.append("<param name=\"mutableForeground\" value=\"").append(paintSubTasklet.getMutablePictureString()).append("\">\n");
		ret.append("<param name=\"foreground\" value=\"").append(paintSubTasklet.getUserForegroundString()).append("\">\n");
		ret.append("<param name=\"background\" value=\"").append(paintSubTasklet.getBackgroundPictureString()).append("\">\n");
		ret.append("<param name=\"undoData\" value=\"").append(paintSubTasklet.getUndoData()).append("\">\n");
		ret.append("<param name=\"resetted\" value=\"").append(paintSubTasklet.isResetted()).append("\">\n");
		if (corrected) {
			ret.append("<param name=\"viewonly\" value=\"true\">\n");
		}

		ret.append("</applet>\n<br/><br/>\n");
		ret.append("<textarea name=\"task[" + relativeTaskNumber + "].text\" cols=\"" +
				paintSubTasklet.getTextFieldWidth() + "\" rows=\"" + paintSubTasklet.getTextFieldHeight() +
				"\" onChange=\"setModified()\"" +
				(corrected ? " readonly=\"true\"" : "") + ">\n");
		ret.append(paintSubTasklet.getTextualAnswer());
		ret.append("</textarea>\n");
		ret.append("</div>\n");

		ret.append("<input type=\"hidden\" id=\"task_" + relativeTaskNumber + ".image\" name=\"task[" + relativeTaskNumber + "].image\">\n");
		ret.append("<input type=\"hidden\" id=\"task_" + relativeTaskNumber + ".resetted\" name=\"task[" + relativeTaskNumber + "].resetted\">\n");

		if (!corrected) {
			ret.append("<script type=\"text/javascript\">\n");
			ret.append(" var preSave_task_" + relativeTaskNumber + " = function(){\n");
			ret.append(" document.getElementById(\"task_" + relativeTaskNumber + ".image\").value = document.drawTask_" + relativeTaskNumber + ".getForegroundPictureWithUndoData(5);\n");
			ret.append(" document.getElementById(\"task_" + relativeTaskNumber + ".resetted\").value = document.drawTask_" + relativeTaskNumber + ".isResetted();\n");
			ret.append("};\n");
			ret.append(" var leavePage_task_" + relativeTaskNumber + " = function(){\n");
			ret.append(" 	if( document.drawTask_" + relativeTaskNumber + ".hasChanged() ){\n");
			ret.append(" 		setModified();\n");
			ret.append(" 	};\n");
			ret.append(" };\n");
			ret.append("preSaveManager.registerCallback( preSave_task_" + relativeTaskNumber + " );\n");
			ret.append("leavePageManager.registerCallback( leavePage_task_" + relativeTaskNumber + " );\n");
			ret.append("</script>\n");
		}
		return ret.toString();

	}

	@Override
	public SubmitData getSubmitData(final Map postedVarsForTask)
			throws ParsingException {

		final Iterator keyIt = postedVarsForTask.keySet().iterator();
		String pictureString = null;
		String textString = null;
		String undoData = null;
		boolean isResetted = false;

		while (keyIt.hasNext()) {
			final String key = (String) keyIt.next();
			if (getMyPart(key).equals("image")) {
				pictureString = (String) postedVarsForTask.get(key);
			} else if (getMyPart(key).equals("text")) {
				textString = (String) postedVarsForTask.get(key);
			} else if (getMyPart(key).equals("resetted")) {
				isResetted = Boolean.valueOf((String) postedVarsForTask.get(key));
			}
		}
		if (pictureString != null) {
			final int pos = pictureString.indexOf("%%%");
			if (pos != -1) {
				undoData = pictureString.substring(pos + 3);
				pictureString = pictureString.substring(0, pos);
			}
		}
		return new PaintSubmitData(pictureString, undoData, isResetted, textString);
	}

}
