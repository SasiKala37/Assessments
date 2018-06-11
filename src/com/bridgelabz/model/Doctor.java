package com.bridgelabz.model;

public class Doctor {
	private String doctorName;
	private int doctorId;
	private String availableTime;
	private String specialization;
	private int countOfPatients;
	public Doctor() {
		
	}
	public Doctor(String doctorName, int doctorId, String availableTime, String specialization,int countOfPatients) {
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.availableTime = availableTime;
		this.specialization = specialization;
		this.countOfPatients=countOfPatients;
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

	public int getCountOfPatients() {
		return countOfPatients;
	}

	public void setCountOfPatients(int countOfPatients) {
		this.countOfPatients = countOfPatients;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String toString() {
		return doctorName+" "+doctorId+" "+availableTime+" "+specialization+" "+countOfPatients;
	}

}
