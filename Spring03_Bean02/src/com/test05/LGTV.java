package com.test05;

public class LGTV implements TV {
	
	public LGTV () {
		super();
		System.out.println("lg tv 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("lg tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("lg tv off");
	}

}
