/***
 * Purpose: ManagerService interface to declare the methods of manager service
 * 
 * @author Sasikala
 * @version 1.0
 * @since 9-06-2018
 * */
package com.bridgelabz.service;

public interface ManagerService {
	public void addDocotor() ;

	public void updateDocotorDetails(int doctorId) ;

	public void deleteDoctor(int doctorId) ;

	public void addPatient(); 

	public void updatePatientByAge(int patientId) ;

	public void deletePatient(int patientId) ;
}

