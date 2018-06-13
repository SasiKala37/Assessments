/***
 * Purpose: PatientService interface to declare the methods of Patient service
 * 
 * @author Sasikala
 * @version 1.0
 * @since 9-06-2018
 * */
package com.bridgelabz.service;

public interface PatientService {
	public void takeAppointment();

	public void showPatientDetails();

	public void searchPatientByName(String patientName);

	public void searchPatientById(int patientId);

	public void searchPatientByMobileNumber(long mobileNumber);

	public void showPopularDoctor();
}
