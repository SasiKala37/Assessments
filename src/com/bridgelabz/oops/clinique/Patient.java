package com.bridgelabz.oops.clinique;

public class Patient {

	private String patientName;
	private int id;
	private long mobileNumber;

	public Patient(String patientName, int id, long mobileNumber) { 
		this.patientName = patientName;
		this.id = id;
		this.mobileNumber = mobileNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
