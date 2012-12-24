package com.spiru.dev.timeTask_addon.Utils;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

/**
 * Element to arrange on TimeLine with Color, Text or Image
 * @author Yves
 */
public class DragElement extends JPanel {
	
	private JLabel label;
	private JPanel colorPanel;
	private boolean isMarked=false;	
	private int id;
	private static int idElement = 0;
	private String caption;
	
	public DragElement(String caption, Color color){				
		id = idElement++;
		colorPanel = new JPanel();
		colorPanel.setBackground(color);
		this.add(colorPanel);		
		this.label = new JLabel(caption);	
		this.caption = caption;
		this.add(label);	
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.addMouseListener(mouseListener);
	}	
	
	/**
	 * markElement
	 * @param mark mark Element?	 
	 */
	public void markElement(boolean mark){
		Border border = this.getBorder();
		Border margin;
		
		if (mark){
			isMarked = true;
			margin = new LineBorder(Color.YELLOW,2);
			this.setBorder(new CompoundBorder(border, margin));	
		}
		else{
			isMarked = false;
			margin = new LineBorder(Color.BLACK,1);
			this.setBorder(margin);
		}
			
	}	
	
	public int getId(){
		return id;
	}
	
	public String getCaption(){
		return caption;
	}
	
	public void hideCaption(){
		label.setText("");
	}
	
	public boolean isMarked(){
		return isMarked;
	}		
	
	public Color getColor(){
		return colorPanel.getBackground(); 
	}
}
