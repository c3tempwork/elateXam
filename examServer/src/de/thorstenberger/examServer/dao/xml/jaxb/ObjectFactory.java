//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.10.02 at 04:23:47 CEST 
//


package de.thorstenberger.examServer.dao.xml.jaxb;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.thorstenberger.examServer.dao.xml.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
public class ObjectFactory
    extends de.thorstenberger.examServer.dao.xml.jaxb.impl.runtime.DefaultJAXBContextImpl
{

    private static java.util.HashMap defaultImplementations = new java.util.HashMap();
    private static java.util.HashMap rootTagMap = new java.util.HashMap();
    public final static de.thorstenberger.examServer.dao.xml.jaxb.impl.runtime.GrammarInfo grammarInfo = new de.thorstenberger.examServer.dao.xml.jaxb.impl.runtime.GrammarInfoImpl(rootTagMap, defaultImplementations, (de.thorstenberger.examServer.dao.xml.jaxb.ObjectFactory.class));
    public final static java.lang.Class version = (de.thorstenberger.examServer.dao.xml.jaxb.impl.JAXBVersion.class);

    static {
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskHandling.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.UsersType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.UsersTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskDefsType.TaskDefType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsTypeImpl.TaskDefTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.CorrectorHistoryType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl.CorrectorHistoryTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskDefsType.TaskDefType.ComplexTaskDefType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsTypeImpl.TaskDefTypeImpl.ComplexTaskDefTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskDefsType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.CorrectorAnnotationType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl.CorrectorAnnotationTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskDefs.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.ConfigType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.ConfigTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.UsersType.UserType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.UsersTypeImpl.UserTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.StudentAnnotationType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl.StudentAnnotationTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.Users.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.UsersImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl");
        defaultImplementations.put((de.thorstenberger.examServer.dao.xml.jaxb.Config.class), "de.thorstenberger.examServer.dao.xml.jaxb.impl.ConfigImpl");
        rootTagMap.put(new javax.xml.namespace.QName("http://examServer.thorstenberger.de/users", "users"), (de.thorstenberger.examServer.dao.xml.jaxb.Users.class));
        rootTagMap.put(new javax.xml.namespace.QName("http://examServer.thorstenberger.de/config", "config"), (de.thorstenberger.examServer.dao.xml.jaxb.Config.class));
        rootTagMap.put(new javax.xml.namespace.QName("http://examServer.thorstenberger.de/taskHandling", "taskHandling"), (de.thorstenberger.examServer.dao.xml.jaxb.TaskHandling.class));
        rootTagMap.put(new javax.xml.namespace.QName("http://examServer.thorstenberger.de/taskDefs", "taskDefs"), (de.thorstenberger.examServer.dao.xml.jaxb.TaskDefs.class));
    }

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.thorstenberger.examServer.dao.xml.jaxb
     * 
     */
    public ObjectFactory() {
        super(grammarInfo);
    }

    /**
     * Create an instance of the specified Java content interface.
     * 
     * @param javaContentInterface
     *     the Class object of the javacontent interface to instantiate
     * @return
     *     a new instance
     * @throws JAXBException
     *     if an error occurs
     */
    public java.lang.Object newInstance(java.lang.Class javaContentInterface)
        throws javax.xml.bind.JAXBException
    {
        return super.newInstance(javaContentInterface);
    }

    /**
     * Get the specified property. This method can only be
     * used to get provider specific properties.
     * Attempting to get an undefined property will result
     * in a PropertyException being thrown.
     * 
     * @param name
     *     the name of the property to retrieve
     * @return
     *     the value of the requested property
     * @throws PropertyException
     *     when there is an error retrieving the given property or value
     */
    public java.lang.Object getProperty(java.lang.String name)
        throws javax.xml.bind.PropertyException
    {
        return super.getProperty(name);
    }

    /**
     * Set the specified property. This method can only be
     * used to set provider specific properties.
     * Attempting to set an undefined property will result
     * in a PropertyException being thrown.
     * 
     * @param value
     *     the value of the property to be set
     * @param name
     *     the name of the property to retrieve
     * @throws PropertyException
     *     when there is an error processing the given property or value
     */
    public void setProperty(java.lang.String name, java.lang.Object value)
        throws javax.xml.bind.PropertyException
    {
        super.setProperty(name, value);
    }

    /**
     * Create an instance of TaskHandling
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskHandling createTaskHandling()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingImpl();
    }

    /**
     * Create an instance of UsersType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.UsersType createUsersType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.UsersTypeImpl();
    }

    /**
     * Create an instance of TaskDefsTypeTaskDefType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskDefsType.TaskDefType createTaskDefsTypeTaskDefType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsTypeImpl.TaskDefTypeImpl();
    }

    /**
     * Create an instance of TaskHandlingTypeTaskletTypeCorrectorHistoryType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.CorrectorHistoryType createTaskHandlingTypeTaskletTypeCorrectorHistoryType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl.CorrectorHistoryTypeImpl();
    }

    /**
     * Create an instance of TaskDefsTypeTaskDefTypeComplexTaskDefType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskDefsType.TaskDefType.ComplexTaskDefType createTaskDefsTypeTaskDefTypeComplexTaskDefType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsTypeImpl.TaskDefTypeImpl.ComplexTaskDefTypeImpl();
    }

    /**
     * Create an instance of TaskDefsType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskDefsType createTaskDefsType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsTypeImpl();
    }

    /**
     * Create an instance of TaskHandlingTypeTaskletTypeCorrectorAnnotationType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.CorrectorAnnotationType createTaskHandlingTypeTaskletTypeCorrectorAnnotationType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl.CorrectorAnnotationTypeImpl();
    }

    /**
     * Create an instance of TaskDefs
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskDefs createTaskDefs()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskDefsImpl();
    }

    /**
     * Create an instance of TaskHandlingType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType createTaskHandlingType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl();
    }

    /**
     * Create an instance of ConfigType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.ConfigType createConfigType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.ConfigTypeImpl();
    }

    /**
     * Create an instance of UsersTypeUserType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.UsersType.UserType createUsersTypeUserType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.UsersTypeImpl.UserTypeImpl();
    }

    /**
     * Create an instance of TaskHandlingTypeTaskletTypeStudentAnnotationType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType.StudentAnnotationType createTaskHandlingTypeTaskletTypeStudentAnnotationType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl.StudentAnnotationTypeImpl();
    }

    /**
     * Create an instance of Users
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.Users createUsers()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.UsersImpl();
    }

    /**
     * Create an instance of TaskHandlingTypeTaskletType
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.TaskHandlingType.TaskletType createTaskHandlingTypeTaskletType()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.TaskHandlingTypeImpl.TaskletTypeImpl();
    }

    /**
     * Create an instance of Config
     * 
     * @throws JAXBException
     *     if an error occurs
     */
    public de.thorstenberger.examServer.dao.xml.jaxb.Config createConfig()
        throws javax.xml.bind.JAXBException
    {
        return new de.thorstenberger.examServer.dao.xml.jaxb.impl.ConfigImpl();
    }

}
