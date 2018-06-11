package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Patient;
import com.bridgelabz.util.Utility;

public class PatientServiceImplementation {
	File file1 = new File(
			"/home/bridgelabz/basicjavaprograms/cliniquemanagement/src/com/bridgelabz/files/patient.json");
	
	ArrayList<Patient> patientList = new ArrayList<>();

	public boolean takeAppointment() {
		
		return true;
	}

	public void showPatientDetails() throws JsonParseException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(file1, Patient.class);

		for (int i = 0; i < patientList.size(); i++) {

			System.out.println(
					Utility.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(patientList.get(i).toString()));
		}
	}

	public void searchPatientByName(String patientName) throws JsonParseException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(file1, Patient.class);
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equalsIgnoreCase(patientName)) {
				System.out.println("Patient available ");
				search = true;
			}
		}
		if (!search) {
			System.out.println("Patient not Available");
		}

	}

	public void searchPatientById(int patientId) throws JsonParseException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(file1, Patient.class);
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientId()==patientId) {
				System.out.println("Patient available ");
				search = true;
			}
		}
		if (!search) {
			System.out.println("Patient not Available");
		}

	}

	public void searchPatientByMobileNumber(long mobileNumber) throws JsonParseException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(file1, Patient.class);
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getMobileNumber()==mobileNumber) {
				System.out.println("Patient available ");
				search = true;
			}
		}
		if (!search) {
			System.out.println("Patient not Available");
		}
	}

	public void showPopularDoctor() {
		
	}
}
