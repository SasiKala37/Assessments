package com.bridgelabz.model;

public class Appointment {
	private String patientName;
	private int patientId;
	private String doctorName;
	private int doctorId;
	private String timeStamp;
	public Appointment() {
		
	}
	public Appointment(String patientName, int patientId, String doctorName, int doctorId, String timeStamp) {
		super();
		this.patientName = patientName;
		this.patientId = patientId;
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.timeStamp = timeStamp;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String toString() {
		return patientName+" "+patientId+" "+doctorName+" "+doctorId+" "+timeStamp;
	}

}