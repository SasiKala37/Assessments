package com.bridgelabz.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface DoctorSrevice {
	public void showDoctorDetails() throws JsonParseException, JsonMappingException, IOException;

	public void searchByDoctorName(String docotorName);

	public void searchByDoctorId(int doctorId);

	public void searchBySpecialization(String specialization);

}


