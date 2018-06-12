package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface DoctorSrevice {
	public void showDoctorDetails();

	public boolean searchByDoctorName(String docotorName);

	public void searchByDoctorId(int doctorId);

	public void searchBySpecialization(String specialization);

}


