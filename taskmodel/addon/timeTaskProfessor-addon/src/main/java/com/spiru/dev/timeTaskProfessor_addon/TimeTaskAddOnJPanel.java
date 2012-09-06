package com.spiru.dev.timeTaskProfessor_addon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.spiru.dev.timeTaskProfessor_addon.Utils.ConnectionLine;
import com.spiru.dev.timeTaskProfessor_addon.Utils.DatePoint;
import com.spiru.dev.timeTaskProfessor_addon.Utils.DragElement;
import com.spiru.dev.timeTaskProfessor_addon.Utils.JPanelEditor;
import com.spiru.dev.timeTaskProfessor_addon.Utils.JPanelOfElements;
import com.spiru.dev.timeTaskProfessor_addon.Utils.JPanelPlayGround;
import com.spiru.dev.timeTaskProfessor_addon.Utils.MyDropTargetListener;
import com.spiru.dev.timeTaskProfessor_addon.Utils.MyMouseListener;
import com.spiru.dev.timeTaskProfessor_addon.Utils.Symbol;


/**
 * Panel auf dem alle anderen Objekte liegen
 * @author Yves
 *
 */
public class TimeTaskAddOnJPanel extends JPanel {
	
	private JPanelOfElements  jpanelOfElements;
	private JPanelPlayGround jpanelPlayground;
	private JPanel jpanelButtons;
	private JButton jbuttonDelete;
	private JButton jbuttonDeleteAll;
	private MyMouseListener mouseListener;	
	private JScrollPane scrollPanePlayground;
	private JScrollPane scrollPane;
	private TimeTaskAddOnApplet applet;
	
    public TimeTaskAddOnJPanel(TimeTaskAddOnApplet applet) {
    	this.applet = applet;
    	init();
    }
    
    @Override
    public void paint(Graphics g){
    	scrollPanePlayground.paintAll(scrollPanePlayground.getGraphics());
    	super.paint(g);
    }
    
    private void init(){
    	mouseListener = new MyMouseListener();
    	// The elements 
    	List<Object> objects = new ArrayList<Object>(); 
    	jpanelOfElements = new JPanelOfElements(objects, mouseListener);
    	jpanelButtons = new JPanel();
    	jbuttonDelete = new JButton("Markierung entfernen");
    	jbuttonDelete.addMouseListener(mouseListener);
    	jbuttonDelete.setActionCommand("DELETE");
    	jbuttonDeleteAll = new JButton("Alles entfernen");
    	jbuttonDeleteAll.addMouseListener(mouseListener);
    	jbuttonDeleteAll.setActionCommand("DELETE_ALL");
    	jpanelButtons.add(jbuttonDelete);
    	jpanelButtons.add(jbuttonDeleteAll);
    	
    	jpanelPlayground = new JPanelPlayGround(mouseListener);
    	mouseListener.setPlayGround(jpanelPlayground);
    	new MyDropTargetListener(jpanelPlayground);
    	scrollPane = new JScrollPane(jpanelOfElements);
    	scrollPane.setBounds(0,130,400,60);
    	jpanelButtons.setBounds(0,190,400,40);
    	    	
    	scrollPanePlayground = new JScrollPane(jpanelPlayground);
    	scrollPanePlayground.setBounds(0,230,400,170);
    	
    	JPanelEditor panelInput = new JPanelEditor(this, mouseListener);
    	panelInput.setBounds(0,0,400,130);
    	
    	JButton buttonSave = new JButton("Save");
    	buttonSave.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt) {
				buttonActionSave();
				
			}
    		
    	});
    	buttonSave.setBounds(
    			10,
    			scrollPanePlayground.getY()+scrollPanePlayground.getHeight()+5,
    			370,
    			25
    			);
    	
    	this.add(panelInput);
    	this.add(scrollPane);
    	this.add(jpanelButtons);
    	this.add(scrollPanePlayground);
    	this.add(buttonSave);
    	this.setLayout(null);    	
    	this.setBounds(0,0,400,460);
    }
    
    private void buttonActionSave(){
    	save();
    }
    
    public void addElement(String id, String name, String color){
    	Color c = new Color(Integer.parseInt(color));
    	DragElement e = new DragElement(name, c,mouseListener, Integer.parseInt(id));
    	addElement(e);
    }
    
    public void addElement(DragElement e){
    	for(DragElement n:jpanelOfElements.getElementList()){
    		if (e.getColor() == n.getColor() || e.getCaption().equals(n.getCaption())){
    			return;
    		}
    	}
    	jpanelOfElements.getElementList().add(e);
    	jpanelOfElements.add(e);
    	scrollPane.paintAll(scrollPane.getGraphics());
    }
    
    public void deleteElement(){
    	List<DragElement> elementList = jpanelOfElements.getElementList();
    	List<DragElement> deleteList = new ArrayList<DragElement>();
    	for(DragElement n:elementList){
    		if(n.isMarked()){
    			jpanelOfElements.remove(n);
    			deleteList.add(n);
    		}
    	}
    	elementList.removeAll(deleteList);
    	scrollPane.paintAll(scrollPane.getGraphics());
    }
    
    public void addSymbol(String eventID, String posX, String posY, String lineX){
    	List<DragElement> elementList = jpanelOfElements.getElementList();
    	List<Symbol> symbolList = jpanelPlayground.getSymbols();
    	
    	for(DragElement n:elementList){
    		if(n.getId() == Integer.parseInt(eventID)){       			
    			Point pos = new Point(Integer.parseInt(posX),Integer.parseInt(posY));
    			Symbol sym = new Symbol(pos,n.getColor(),n.getId());
    			symbolList.add(sym);    			
    			sym.setConnectionLine(new ConnectionLine(sym, Integer.parseInt(lineX), (int)jpanelPlayground.getTimeLine().getLine().getP1().getY()));
    			jpanelPlayground.add(sym);
    			sym.addMouseListener(mouseListener);
    			scrollPane.paintAll(scrollPane.getGraphics());
    			break;
    		}
    	}    	
    }
    
    public void addDatePoint(String caption, boolean visible){
    	DatePoint dp = new DatePoint(caption, visible);
    	addDatePoint(dp);
    }
    
    public void addDatePoint(DatePoint d){
    	List<DatePoint> datePoints = jpanelPlayground.getTimeLine().getDatePoints();
    	for(DatePoint n:datePoints){
    		if(n.getCaption().equals(d.getCaption())){
    			return;
    		}
    	}
    	datePoints.add(d);
    	jpanelPlayground.add(d);
    	
    	// fill
    	List<Date> dates = new ArrayList<Date>();
    	for(DatePoint n:datePoints){
    		dates.add(n.getDate());
    	}    	
    	// sort
    	boolean sort = true;
    	while(sort){
    		sort=false;
    		for(int i=1; i<dates.size(); i++){
    			if (dates.get(i-1).after(dates.get(i))){
    				Date tmp = dates.get(i-1);
    				dates.set(i-1, dates.get(i));
    				dates.set(i, tmp);
    				DatePoint dp = datePoints.get(i-1);
    				datePoints.set(i-1, datePoints.get(i));
    				datePoints.set(i, dp);
    				sort = true;
    			}
    		}
    	}
    	
    	jpanelPlayground.getTimeLine().sortDatePoints();   
    	scrollPanePlayground.paintAll(scrollPanePlayground.getGraphics());    	
    }
    
    public void deleteDate(){
    	List<DatePoint> datePoints = jpanelPlayground.getTimeLine().getDatePoints();
    	List<DatePoint> dates = new ArrayList<DatePoint>();
    	for(DatePoint n:datePoints){
    		if(n.isMarked()){
    			dates.add(n);
    			jpanelPlayground.remove(n);
    		}
    	}
    	datePoints.removeAll(dates);
    	jpanelPlayground.getTimeLine().sortDatePoints();   
    	scrollPanePlayground.paintAll(scrollPanePlayground.getGraphics()); 
    }
    
    public int getCountOfElements(){
    	return jpanelOfElements.getElementList().size();
    }
    
    public String save(){
    	List<DragElement> elements = jpanelOfElements.getElementList();
    	List<DatePoint> datePoints = jpanelPlayground.getTimeLine().getDatePoints();
    	List<Symbol> symbols = jpanelPlayground.getSymbols();
    	String ret = "";
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	try{
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element memento = document.createElement("Memento");
			document.appendChild(memento);	    		
			Element addonConfig = document.createElement("addonConfig");
			memento.appendChild(addonConfig);	    		
    		Element timelineSubTaskDef = document.createElement("timelineSubTaskDef");
    		memento.appendChild(timelineSubTaskDef);	    			    			    		
    		for(DragElement n:elements){
    			Element assignedEvent = document.createElement("assignedEvent");
    			assignedEvent.setAttribute("id", ""+n.getId());
    			assignedEvent.setAttribute("name",n.getCaption());
    			assignedEvent.setAttribute("color",String.valueOf(n.getColor().getRGB()));
    			timelineSubTaskDef.appendChild(assignedEvent);
    		}	
    		// alle Intervalle prüfen
    		for(int i=1; i<datePoints.size(); i++){
    			Element date = document.createElement("date");
    			date.setAttribute("dateId",""+i);
    			date.setAttribute("datePoint1",datePoints.get(i-1).getCaption());
    			date.setAttribute("datePoint2",datePoints.get(i).getCaption());
    			if (!datePoints.get(i-1).isDateVisible() && !datePoints.get(i).isDateVisible()){
    				date.setAttribute("whichDatePointAsTextbox","all");
    			}else{
    				if (!datePoints.get(i-1).isDateVisible())
    					date.setAttribute("whichDatePointAsTextbox","datePoint1");
    				if (!datePoints.get(i).isDateVisible())
    					date.setAttribute("whichDatePointAsTextbox","datePoint2");	    				
    			}
    			timelineSubTaskDef.appendChild(date);
    			int dp1x = datePoints.get(i-1).getX()+datePoints.get(i-1).getWidth()/2;
    			int dp2x = datePoints.get(i).getX()+datePoints.get(i).getWidth()/2;
    			List<Symbol> listSymbols = new ArrayList<Symbol>();	    			
    			// alle Elemente zwischen dem Intervall
    			for(Symbol n:symbols){
    				int sx = (int)n.getConnectionLine().getLine().getP2().getX();
    				if(sx >= dp1x && sx <= dp2x){
    					listSymbols.add(n);
    				}
    			}
    			boolean sort = true;
    			while(sort){
    				sort=false;
    				for(int k=1; k<listSymbols.size(); k++){
    					int x1 = (int)listSymbols.get(k-1).getConnectionLine().getLine().getP2().getX();
    					int x2 = (int)listSymbols.get(k).getConnectionLine().getLine().getP2().getX();
    					if(x1>x2){
    						sort=true;
    						Symbol tmp = listSymbols.get(k-1);
    						listSymbols.set(k-1, listSymbols.get(k));
    						listSymbols.set(k, tmp);
    					}
    				}
    			}
    			// in xml speichern
    			int order = 0;
    			for(Symbol n:listSymbols){	    				
    				Element correctAssignmentID = document.createElement("correctAssignmentID");
    				correctAssignmentID.setAttribute("order",""+order++);
    				correctAssignmentID.setAttribute("eventId",""+n.getId());
    				correctAssignmentID.setAttribute("LineX",""+(int)n.getConnectionLine().getLine().getX2());
    				correctAssignmentID.setAttribute("PosX",""+n.getX());
    				correctAssignmentID.setAttribute("PosY",""+n.getY());
    				int sx = (int)n.getConnectionLine().getLine().getP2().getX();
    				if (dp1x == sx){
    					correctAssignmentID.setAttribute("isFixedToDate","datePoint1");
    					// test, element zum linken date nicht doppelt speichern
    					if (i>1)
    						continue;
    				}
    				else if(dp2x == sx){
    					correctAssignmentID.setAttribute("isFixedToDate","datePoint2");
    				}
    				date.appendChild(correctAssignmentID);
    			}
    		}
			// write DOM to string
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StringWriter stringWriter = new StringWriter();
			StreamResult result =  new StreamResult(stringWriter);
			transformer.transform(source, result);
			ret = stringWriter.toString();
			// having it as base64 string so browsers won't complain
			ret = DatatypeConverter.printBase64Binary(ret.getBytes("utf-8"));	    	
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (TransformerConfigurationException e) {
		e.printStackTrace();
	} catch (TransformerException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}	    	
	return ret;
    }
        
}
