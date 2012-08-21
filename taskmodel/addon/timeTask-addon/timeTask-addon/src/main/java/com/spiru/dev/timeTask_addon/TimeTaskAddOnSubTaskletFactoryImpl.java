package com.spiru.dev.timeTask_addon;


import de.thorstenberger.taskmodel.complex.addon.AddOnSubTaskletFactory;
import de.thorstenberger.taskmodel.complex.complextaskdef.ComplexTaskDefRoot.CorrectionModeType;
import de.thorstenberger.taskmodel.complex.complextaskhandling.AddOnSubTasklet;
import de.thorstenberger.taskmodel.complex.jaxb.AddonSubTaskDef;
import de.thorstenberger.taskmodel.complex.jaxb.ComplexTaskHandling.Try.Page.AddonSubTask;

public class TimeTaskAddOnSubTaskletFactoryImpl  implements
AddOnSubTaskletFactory {

public AddOnSubTasklet createAddOnSubTasklet( Object subTaskDef, Object subTask, CorrectionModeType correctionMode, float reachablePoints) {
return new SubTasklet_TimeTaskImpl((AddonSubTaskDef)subTaskDef,(AddonSubTask)subTask, correctionMode, reachablePoints);
}

public String getAddonTaskType() {
System.out.println("Subtasklet CompareTextTask successfully loaded");

return "TimeTask";
}

}
