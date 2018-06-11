package com.bridgelabz.serviceimplementation;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.util.Utility;

public class ManagerServiceImplementation {
	Doctor doctor = new Doctor();
	Patient patient = new Patient();
	Utility utility = new Utility();
	ArrayList<Doctor> doctorList = new ArrayList<>();
	ArrayList<Patient> patientList = new ArrayList<>();
	DoctorServiceImplementation implementation = new DoctorServiceImplementation();
	PatientServiceImplementation patientServiceImpl = new PatientServiceImplementation();
	

	/**
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addDocotor() throws JsonParseException, JsonMappingException, IOException {

		doctorList = Utility.parseJSONArray(implementation.file, Doctor.class);
		doctor = utility.doctorDetails();
		doctorList.add(doctor);

		Utility.mapper.writeValue(implementation.file, doctorList);
	}

	/**
	 * @param time
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void updateDocotorDetails(int doctorId)
			throws JsonParseException, JsonMappingException, IOException {
		doctorList = Utility.parseJSONArray(implementation.file, Doctor.class);
		boolean search = false;
		ArrayList<Doctor> findList = new ArrayList<>();
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorId() == doctorId) {
				findList.add(doctorList.get(i));
				search = true;
			}
		}
		if (search) {
			System.out.println("Enter the time to update");
			String time = Utility.userInputString();
			for (int i = 0; i < findList.size(); i++) {
				findList.get(i).setAvailableTime(time);
			}
		}
		Utility.mapper.writeValue(implementation.file, doctorList);
	}

	/**
	 * @param doctorId
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void deleteDoctor(int doctorId) throws JsonGenerationException, JsonMappingException, IOException {
		doctorList = Utility.parseJSONArray(implementation.file, Doctor.class);
		boolean search = false;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorId() == doctorId) {
				doctorList.remove(i);
				search = true;
			}
		}
		if (search) {
			Utility.mapper.writeValue(implementation.file, doctorList);
			System.out.println("Doctor record deleted");
		} else {
			System.out.println("Doctor record not found to delete");
		}

	}

	/**
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addPatient() throws JsonParseException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(patientServiceImpl.file1, Patient.class);
		patient = utility.patientDetails();
		patientList.add(patient);

		Utility.mapper.writeValue(patientServiceImpl.file1, patientList);
	}

	/**
	 * @param patientId
	 * @param age
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void updatePatientByAge(int patientId)
			throws JsonGenerationException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(patientServiceImpl.file1, Patient.class);
		boolean search = false;
		ArrayList<Patient> findList = new ArrayList<>();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientId() == patientId) {
				findList.add(patientList.get(i));
				search = true;
			}
		}	
		if (search) {
			System.out.println("Enter the age of patient");
			int age=Utility.userInputInteger();
			for (int i = 0; i < findList.size(); i++) {
				findList.get(i).setAge(age);
			}
		}
		else {
			System.out.println("Patient id not found");
		}
		Utility.mapper.writeValue(patientServiceImpl.file1, patientList);
	}
/**
 * @param patientId
 * @param mobileNum
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 */
public void updatePatientByMobileNum(int patientId) throws JsonGenerationException, JsonMappingException, IOException {
	patientList = Utility.parseJSONArray(patientServiceImpl.file1, Patient.class);
	boolean search = false;
	ArrayList<Patient> findList = new ArrayList<>();
	for (int i = 0; i < patientList.size(); i++) {
		if (patientList.get(i).getPatientId() == patientId) {
			findList.add(patientList.get(i));
			search = true;
		}
	}
	if (search) {
		System.out.println("Enter the mobile number of patient");
		long mobileNum=Utility.userInputLong();
		for (int i = 0; i < findList.size(); i++) {
			findList.get(i).setMobileNumber(mobileNum);
		}
	}
	Utility.mapper.writeValue(patientServiceImpl.file1, patientList);
}
	/**
	 * @param patientId
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void deletePatient(int patientId) throws JsonGenerationException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(patientServiceImpl.file1, Patient.class);
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientId() == patientId) {
				patientList.remove(i);
				search = true;
			}
		}
		if (search) {
			Utility.mapper.writeValue(patientServiceImpl.file1, patientList);
			System.out.println("Patient record deleted");
		} else {
			System.out.println("Patient record not found to delete");
		}

	}
}
