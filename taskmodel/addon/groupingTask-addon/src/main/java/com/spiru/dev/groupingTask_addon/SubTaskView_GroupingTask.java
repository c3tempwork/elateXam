package com.spiru.dev.groupingTask_addon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.spiru.dev.groupingTask_addon.Utils.Base64;

import de.thorstenberger.taskmodel.MethodNotSupportedException;
import de.thorstenberger.taskmodel.complex.ParsingException;
import de.thorstenberger.taskmodel.complex.complextaskhandling.CorrectionSubmitData;
import de.thorstenberger.taskmodel.complex.complextaskhandling.SubmitData;
import de.thorstenberger.taskmodel.view.SubTaskView;
import de.thorstenberger.taskmodel.view.ViewContext;

public class SubTaskView_GroupingTask extends SubTaskView{

	private SubTasklet_GroupingTask groupingSubTasklet;

	/**
	 *
	 */
	public SubTaskView_GroupingTask( SubTasklet_GroupingTask groupingSubTasklet ) {
		this.groupingSubTasklet = groupingSubTasklet;
		
	}

	/**
	 * @see de.thorstenberger.uebman.services.student.task.complex.SubTaskView#getRenderedHTML(int)
	 */
	public String getRenderedHTML( ViewContext context, int relativeTaskNumber) {		
		return getRenderedHTML( relativeTaskNumber, false );
	}

	public String getRenderedHTML(int relativeTaskNumber, boolean corrected) {
		//final StringBuffer ret = new StringBuffer();
		String path = "com/spiru/dev/groupingTask_addon/GroupingTaskAddOnApplet.class";
		String ret = "<applet archive=\"applet/groupingTask.jar\" code=\"" + path + "\""
				+ " id=\"applet_%s\""
				+ " width=\"710\" height=\"540\" title=\"Java\">\n";			
				
		ret += "<param name=\"handling\" value=\""+groupingSubTasklet.loadFromHandling()+"\">";
		ret += "<param name=\"correction\" value=\""+corrected+"\">";
		ret += "<param name=\"memento\" value=\""+groupingSubTasklet.getMemento()+"\" >";
		/*
		List<String> items = groupingSubTasklet.getBoxContainerAttributes();
		for(int i=0; i<items.size(); i++){
			ret += "<param name=\"e"+i+"\" value=\""+items.get(i)+"\">";
		}*/
		
		ret+= "</applet>\n";
		ret += "<textarea name=\"task[%s].result\" id=\"task_%s.result\" style=\"display:none;\"></textarea>";
		if (!corrected) {
			ret += "<script type=\"text/javascript\">\n";
			ret += " var preSave_task_%s = function(){\n";
			ret += " 	document.getElementById(\"task_%s.result\").value = document.applet_%s.getResult();\n";
			//ret += " 	alert(document.getElementById(\"task_%s.result\").value);\n";
			ret += "};\n";
			ret += " var leavePage_task_%s = function(){\n";
			ret += " 	if( document.applet_%s.hasChanged() ){\n";
			ret += " 		setModified();\n";
			ret += " 	};\n";
			ret += " };\n";
			ret += "preSaveManager.registerCallback( preSave_task_%s );\n";
			ret += "leavePageManager.registerCallback( leavePage_task_%s );\n";
			ret += "</script>\n";
		}
		return ret.replaceAll("%s",""+relativeTaskNumber);
	}

	public String getCorrectedHTML( ViewContext context, int relativeTaskNumber ){
		/*
		 * getImage from handling (base64)
		 */						
		if (groupingSubTasklet.getImage() == null) {			
			return "<p><b>Aufgabe nicht bearbeitet!</b></p>";
		} 
		else {			
			// getImage as base64-string
			String base = groupingSubTasklet.getImage();		
			// convert String to Image			
			Image img = new ImageIcon(Base64.base64ToByteArray(base)).getImage();
			// create bufferedImage
			BufferedImage bufferedImage = new BufferedImage( img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB );
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(img, 0,0, null);
			g.dispose();		
			////// save Image			
			String typ = "png";
			//Linux
			String pfad = "/opt/apache-tomcat-7.0.29/webapps/";
						
			//Dem Bild eine zufällige ID mitgeben, damit bei gleichzeitiger PDF-Erstellung
			//keine Kollisionen mit anderen gleichnamigen Bildern anderer Studenten entstehen
			SecureRandom random = new SecureRandom();	
			//String name = "taskmodel-core-view/Grouping"+relativeTaskNumber+ "_" + new BigInteger(51, random).toString(32) + ".".concat(typ);
			String name = "taskmodel-core-view\\Grouping"+relativeTaskNumber+ "_" + new BigInteger(51, random).toString(32) + ".".concat(typ);
			File datei = new File( pfad + name );					
			// write Image
			try {
				ImageIO.write( bufferedImage, typ, datei );				
			} catch (IOException e) { 
				e.printStackTrace();
			}		
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();
			if (width>600) width = 600;
			if (height>600) height = 600;
			// ImageTag for View und pdf			
			String imgTag = "<img src=\""+name+"\" alt=\"groupingImg\" width=\""+width+"\" height=\""+height+"\">";			
			return imgTag;
		}
	}

	public String getCorrectionHTML(String actualCorrector, ViewContext context ){		
	    StringBuffer ret = new StringBuffer();
	    ret.append( getRenderedHTML( -1, true ) );	    
	    ret.append(getCorrectorPointsInputString(actualCorrector, "Grouping", groupingSubTasklet));

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
			return new GroupingTaskSubmitData( value );
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
            return new GroupingTaskCorrectionSubmitData( points );
	    }else
	        throw new ParsingException();
	}

}
