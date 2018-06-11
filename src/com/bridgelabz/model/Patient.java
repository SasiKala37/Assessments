package com.bridgelabz.model;

public class Patient {

	private String patientName;
	private int patientId;
	private long mobileNumber;
	private int age; 
	
	public Patient() {
		
	}
	public Patient(String patientName, int patientId, long mobileNumber,int age) { 
		this.patientName = patientName;
		this.patientId = patientId;
		this.mobileNumber = mobileNumber;
		this.age=age;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String toString() {
		return patientName+" "+patientId+" "+mobileNumber+" "+age;
	}

}
