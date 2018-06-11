package com.bridgelabz.service;

public interface PatientService {
	public boolean takeAppointment();

	public void showPatientDetails();

	public void searchPatientByName(String patientName);

	public void searchPatientByPatientId(String patientId);

	public void searchPatientMobileNumber(long mobileNumber);

	public void showPopularDoctor();
}
