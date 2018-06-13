/***
 * Purpose: ManagerService interface to declare the methods of manager service
 * 
 * @author Sasikala
 * @version 1.0
 * @since 9-06-2018
 * */
package com.bridgelabz.service;

public interface ManagerService {
	//Add doctor details
	public void addDocotor() ;

	/**
	 * update doctor based on id
	 * @param doctorId
	 */
	public void updateDocotorDetails(int doctorId) ;

	/**
	 * delete doctor based on id
	 * @param doctorId
	 */
	public void deleteDoctor(int doctorId) ;

	//Add Patient details
	public void addPatient(); 

	/**
	 * update Patient age based on id
	 * @param patientId
	 */
	public void updatePatientByAge(int patientId) ;

	/**
	 * delete Patient  based on id
	 * @param patientId
	 */
	public void deletePatient(int patientId) ;
}

