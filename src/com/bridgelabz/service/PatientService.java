package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface PatientService {
	public void takeAppointment();

	public void showPatientDetails();

	public void searchPatientByName(String patientName);

	public void searchPatientById(int patientId);

	public void searchPatientByMobileNumber(long mobileNumber);

	public void showPopularDoctor();
}
