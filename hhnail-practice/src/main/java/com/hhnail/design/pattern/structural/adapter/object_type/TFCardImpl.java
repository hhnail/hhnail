package com.hhnail.design.pattern.structural.adapter.object_type;

public class TFCardImpl implements TFCard {

	@Override
	public String readTF() {
		return "TFCard data: data init!";
	}

	@Override
	public void writeTF(String data) {
		System.out.println("TFCard write: " + data);
	}
}
