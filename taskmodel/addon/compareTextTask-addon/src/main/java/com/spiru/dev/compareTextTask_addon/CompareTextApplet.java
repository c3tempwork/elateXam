package com.spiru.dev.compareTextTask_addon;

/*
 * YOU NEED TO DISABLE "Temporary Internet Files" in
 * Java Web Start Settings to avoid loading old JARs
 *
 * @url www.linuxquestions.org/questions/linux-software-2/firefox-java-applet-cache-551644/ 
 */

import java.applet.Applet;

import javax.xml.bind.DatatypeConverter;

import org.w3c.dom.Element;

import com.spiru.dev.compareTextTask_addon.Utils.XMLBase64;

@SuppressWarnings("serial")
public class CompareTextApplet extends Applet {
	private CompareTextPanel jpanel;
	/**
	 * Initialization method that will be called after the applet is loaded into
	 * the browser.
	 */
	@Override
	public void init() {
		//this.getParameter("..."); // HTML: <parma name="" value=""></param>
		// http://docs.oracle.com/javase/tutorial/deployment/applet/invokingAppletMethodsFromJavaScript.html
		// http://stackoverflow.com/questions/7278626/javascript-to-java-applet-communication
		String text = this.getParameter("initialText");
		String xmldef = this.getParameter("xmlDef"); // is expected to contain Base64 representation of avaiableTasks part in Memento
		String sofar = this.getParameter("soFarSolution"); // will be "null" (literally!) unless student triggered Save Page
		if (xmldef == null) // is NULL, when Applet is not loaded from a Webbrowser, but from Eclipse
			xmldef = DatatypeConverter.printBase64Binary("<avaiableTags><tag name=\"p\"><desc>Markiert einen Absatz.</desc></tag><tag name=\"soundslikefun\"><desc>Tut das und das.</desc></tag></avaiableTags>".getBytes());
		boolean view_only = Boolean.parseBoolean(this.getParameter("viewOnly")); // correcor shouldn't be able to manipulate result
		Element avaiableTags = XMLBase64.base64StringToElement(xmldef, null);
		//this.setSize(800, 400);
		jpanel = new CompareTextPanel(text, sofar, avaiableTags, view_only, this.getWidth(), this.getHeight());
		//jpanel.setSize(800, 400);
		add(jpanel);
	}
	public String getResult() {
		return jpanel.getRightTextAreaContent();
	}
	public boolean hasChanged() {
		return jpanel.getRightTextAreaContent() != jpanel.getLeftTextAreaContent();
	}
	@Override
	public void start() {
	}
	@Override
	public void stop() {
	}
}
