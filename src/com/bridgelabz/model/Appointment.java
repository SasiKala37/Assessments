/**
 * Purpose:Appointment Pojo class for the Stock management
 * @author SasiKala
 * @version 1.0
 * @since 9-06-2018
 * 
 * */
package com.bridgelabz.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Appointment {
	private String doctorName;
	private int doctorId;
	private String patientName;
	private int patientId;
	private String timeStamp;
	 private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
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
		return sdf.format(timestamp);
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String toString() {
		return patientName+" "+patientId+" "+doctorName+" "+doctorId+" "+timeStamp;
	}

}
