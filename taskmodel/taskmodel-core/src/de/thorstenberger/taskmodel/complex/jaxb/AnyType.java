//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.07.14 at 07:36:31 CEST 
//


package de.thorstenberger.taskmodel.complex.jaxb;


/**
 * Java content class for anyType complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at  line unknown)
 * <p>
 * <pre>
 * &lt;complexType name="anyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface AnyType {


    /**
     * Gets the value of the Content property.
     * 
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the Content property.
     * 
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.Object}
     * {@link java.lang.String}
     * 
     */
    java.util.List getContent();

    boolean isSetContent();

    void unsetContent();

}
