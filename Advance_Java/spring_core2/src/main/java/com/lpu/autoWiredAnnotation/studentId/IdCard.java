package com.lpu.autoWiredAnnotation.studentId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdCard {
	@Value("56789")
	private int idNo;
	
	@Value("LPU")
	private String collegeName;
	
	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public void idInfo() {
		System.out.println("Id information");
	}
}
