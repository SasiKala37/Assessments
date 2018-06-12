package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface ManagerService {
	public void addDocotor() ;

	public void updateDocotorDetails(int doctorId) ;

	public void deleteDoctor(int doctorId) ;

	public void addPatient(); 

	public void updatePatientByAge(int patientId) ;

	public void deletePatient(int patientId) ;
}

