package com.bridgelabz.oops.clinique;

public class Doctor {
	private String doctorName;
	private int doctorId;
	private String availableTime;
	private String specialization;

	public Doctor(String doctorName, int doctorId, String availableTime, String specialization) {
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.availableTime = availableTime;
		this.specialization = specialization;
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

}
