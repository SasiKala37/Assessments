/**
 * Purpose:Implementation class for the ManagerService Interface
 * 
 * @author SasiKala
 * @version 1.0
 * @since 9-06-2018
 * 
 * */
package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.util.Utility;

public class ManagerServiceImplementation implements ManagerService {
	Utility utility = new Utility();
	
	ArrayList<Doctor> doctorList = new ArrayList<>();
	Doctor doctor = new Doctor();
	
	Patient patient = new Patient();
	ArrayList<Patient> patientList = new ArrayList<>();

	Appointment appointment = new Appointment();
	ArrayList<Appointment> appointmentList = new ArrayList<>();

	File appFile = new File(
			"/home/bridgelabz/basicjavaprograms/cliniquemanagement/src/com/bridgelabz/files/appointment.json");
	File doctorFile = new File(
			"/home/bridgelabz/basicjavaprograms/cliniquemanagement/src/com/bridgelabz/files/doctor.json");
	File patientFile = new File(
			"/home/bridgelabz/basicjavaprograms/cliniquemanagement/src/com/bridgelabz/files/patient.json");

	@Override
	public void addDocotor() {
		try {
			doctorList = Utility.parseJSONArray(doctorFile, Doctor.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		doctor = utility.doctorDetails();
		doctorList.add(doctor);

		try {
			Utility.mapper.writeValue(doctorFile, doctorList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateDocotorDetails(int doctorId) {
		try {
			doctorList = Utility.parseJSONArray(doctorFile, Doctor.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		try {
			Utility.mapper.writeValue(doctorFile, doctorList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDoctor(int doctorId) {
		try {
			doctorList = Utility.parseJSONArray(doctorFile, Doctor.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean search = false;
		for (int i = 0; i < doctorList.size(); i++) {
			if (doctorList.get(i).getDoctorId() == doctorId) {
				doctorList.remove(i);
				search = true;
			}
		}
		if (search) {
			try {
				Utility.mapper.writeValue(doctorFile, doctorList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Doctor record deleted");
		} else {
			System.out.println("Doctor record not found to delete");
		}

	}

	@Override
	public void addPatient() {
		try {
			patientList = Utility.parseJSONArray(patientFile, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		patient = utility.patientDetails();
		patientList.add(patient);

		try {
			Utility.mapper.writeValue(patientFile, patientList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePatientByAge(int patientId) {
		try {
			patientList = Utility.parseJSONArray(patientFile, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			int age = Utility.userInputInteger();
			for (int i = 0; i < findList.size(); i++) {
				findList.get(i).setAge(age);
			}
		} else {
			System.out.println("Patient id not found");
		}
		try {
			Utility.mapper.writeValue(patientFile, patientList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updatePatientByMobileNum(int patientId)
			throws JsonGenerationException, JsonMappingException, IOException {
		patientList = Utility.parseJSONArray(patientFile, Patient.class);
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
			long mobileNum = Utility.userInputLong();
			for (int i = 0; i < findList.size(); i++) {
				findList.get(i).setMobileNumber(mobileNum);
			}
		}
		Utility.mapper.writeValue(patientFile, patientList);
	}

	@Override
	public void deletePatient(int patientId) {

		try {
			patientList = Utility.parseJSONArray(patientFile, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientId() == patientId) {
				patientList.remove(i);
				search = true;
			}
		}
		if (search) {
			try {
				Utility.mapper.writeValue(patientFile, patientList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Patient record deleted");
		} else {
			System.out.println("Patient record not found to delete");
		}

	}

	public void addAppointement(int index) throws JsonParseException, JsonMappingException, IOException {
		appointmentList = Utility.parseJSONArray(appFile, Appointment.class);

		for (int i = 0; i < doctorList.size(); i++) {
			if (i == index) {
				appointment.setDoctorName(doctorList.get(index).getDoctorName());
				appointment.setDoctorId(doctorList.get(index).getDoctorId());
			}
		}

		System.out.println("Enter patient Name");
		Utility.userInputNextLine();
		String patientName = Utility.userInputNextLine();
		appointment.setPatientName(patientName);
		System.out.println("Enter Patient Id");
		int patientId = Utility.userInputInteger();
		appointment.setPatientId(patientId);
		appointment.setTimeStamp(appointment.getTimeStamp());

		appointmentList.add(appointment);

		Utility.mapper.writeValue(appFile, appointmentList);
	}

	public void fixAppontement( String fixedDoctor)
			throws JsonParseException, JsonMappingException, IOException {

		int count;
		int index = 0;
		doctorList = Utility.parseJSONArray(doctorFile, Doctor.class);

		
			for (int i = 0; i < doctorList.size(); i++) {
				if (doctorList.get(i).getDoctorName().equalsIgnoreCase(fixedDoctor)) {
					index = i;
					break;
				}
			}
			count=doctorList.get(index).getCountOfPatients();
			if(count<=5) {
				addPatient();
				addAppointement(index);
				count=count+1;
				doctorList.get(index).setCountOfPatients(count);
				Utility.mapper.writeValue(doctorFile, doctorList);
			}
			
			else {
				System.out.println("Search for someother doctor");
			}
		}
	public void printReport() {
		try {
			appointmentList = Utility.parseJSONArray(appFile, Appointment.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Appointment list:appointmentList) {
			try {
				System.out.println(Utility.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
