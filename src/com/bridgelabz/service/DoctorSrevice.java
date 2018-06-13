/***
 * Purpose: DoctorService interface to declare the methods of doctor service
 * 
 * @author Sasikala
 * @version 1.0
 * @since 9-06-2018
 * */
package com.bridgelabz.service;

public interface DoctorSrevice {
	// Show the doctor details
	public void showDoctorDetails();

	/**
	 * Search doctor by name
	 * @param docotorName 
	 * @return true/false if doctor available or not
	 */
	public boolean searchByDoctorName(String docotorName);

	/**
	 * Search doctor by
	 * @param doctorId
	 */
	public void searchByDoctorId(int doctorId);

	/**
	 * Search doctor by specialization
	 * @param specialization
	 */
	public void searchBySpecialization(String specialization);

}
