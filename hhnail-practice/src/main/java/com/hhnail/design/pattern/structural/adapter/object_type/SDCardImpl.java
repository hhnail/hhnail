package com.hhnail.design.pattern.structural.adapter.object_type;

public class SDCardImpl implements SDCard {
	@Override
	public String readSD() {
		return "SDCard data: data init!";
	}

	@Override
	public void writeSD(String data) {
		System.out.println("SDCard write: " + data);
	}
}
