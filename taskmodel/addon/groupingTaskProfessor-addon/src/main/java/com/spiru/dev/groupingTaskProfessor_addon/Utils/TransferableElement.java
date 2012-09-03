package com.spiru.dev.groupingTaskProfessor_addon.Utils;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TransferableElement implements Transferable {

	protected static DataFlavor elementFlavor =
	        new DataFlavor(Element.class, "A Element Object");
	
    protected static DataFlavor[] supportedFlavors = {
        elementFlavor
    };
	
    /** Element, das uebertragen werden soll */
    private Element element;
    
    /**
     * Konstruktor eines zu uebertragendes Objektes
     * @param element Elemnt mit Drag'n Drop
     */
    public TransferableElement(Element element) { 
    	this.element = element;     	
    }
    
	//@Override
	public Element getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavor))
	         return element;
	     else 
	         throw new UnsupportedFlavorException(flavor);
	}

	//@Override
	public DataFlavor[] getTransferDataFlavors() {		 
		
		return supportedFlavors;
	}

	//@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if (flavor.equals(elementFlavor)) 
			return true;
		return false;
	}

}
