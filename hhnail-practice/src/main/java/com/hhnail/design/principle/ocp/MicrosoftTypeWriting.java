package com.hhnail.design.principle.ocp;

import lombok.Data;

@Data
public class MicrosoftTypeWriting {

	private AbstractSkin skin;

	public void display() {
		skin.display();
	}

}
