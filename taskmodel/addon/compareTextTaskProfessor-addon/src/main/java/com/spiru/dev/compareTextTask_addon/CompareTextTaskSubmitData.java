package com.spiru.dev.compareTextTask_addon;

import de.thorstenberger.taskmodel.complex.complextaskhandling.SubmitData;

public class CompareTextTaskSubmitData implements SubmitData {

	private String solution;

	public CompareTextTaskSubmitData(String solution) {
		this.solution=solution;
	}

	public String getAnswer() {
		return this.solution;
	}
}
