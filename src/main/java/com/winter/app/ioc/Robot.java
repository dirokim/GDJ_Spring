package com.winter.app.ioc;

import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private LeftArm leftArm;
	private RightArm rightArm;
	
	
	
	
	
	public LeftArm getLeftArm() {
		return leftArm;
	}
	public void setLeftArm(LeftArm leftArm) {
		this.leftArm = leftArm;
	}
	public RightArm getRightArm() {
		return rightArm;
	}
	public void setRightArm(RightArm rightArm) {
		this.rightArm = rightArm;
	}
	
	
}
