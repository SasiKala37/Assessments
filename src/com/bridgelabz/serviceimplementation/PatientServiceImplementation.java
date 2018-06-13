package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.util.Utility;

public class PatientServiceImplementation implements PatientService, Serializable {
	DoctorServiceImplementation doctorServiceImplementation = new DoctorServiceImplementation();
	ManagerServiceImplementation managerServiceImpl = new ManagerServiceImplementation();
	ArrayList<Patient> patientList = new ArrayList<>();
	File file1 = new File(
			"/home/bridgelabz/basicjavaprograms/cliniquemanagement/src/com/bridgelabz/files/patient.json");

	@Override
	public void takeAppointment() {
		doctorServiceImplementation.showDoctorDetails();
		System.out.println("Search Doctor by name");
		/*int choice = 0;
		while (choice < 4) {
			System.out.println("Enter your choice");
			choice = Utility.userInputInteger();
			switch (choice) {
			*/
				System.out.println("Enter qthe doctor name");
				Utility.userInputNextLine();
				String fixedDoctor = Utility.userInputNextLine();
				boolean avail = doctorServiceImplementation.searchByDoctorName(fixedDoctor);
				System.out.println("index" + avail);
				if (avail) {
					
						try {
							managerServiceImpl.fixAppontement(fixedDoctor);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Doctor is not available!!!!");
					}
				}

				/*break;
			case 2:
				System.out.println("Enter doctor Id");
				int did1 = Utility.userInputInteger();
				doctorServiceImplementation.searchByDoctorId(did1);
				break;
			case 3:
				System.out.println("Enter Doctor Specialization");
				String spcl = Utility.userInputString();
				doctorServiceImplementation.searchBySpecialization(spcl);
				break;
			}
			choice++;
		}*/

	}

	@Override
	public void showPatientDetails() {
		try {
			patientList = Utility.parseJSONArray(file1, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < patientList.size(); i++) {

			try {
				System.out.println(Utility.mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(patientList.get(i).toString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void searchPatientByName(String patientName) {
		try {
			patientList = Utility.parseJSONArray(file1, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	@Override
	public void searchPatientById(int patientId) {
		try {
			patientList = Utility.parseJSONArray(file1, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientId() == patientId) {
				System.out.println("Patient available ");
				search = true;
			}
		}
		if (!search) {
			System.out.println("Patient not Available");
		}

	}

	@Override
	public void searchPatientByMobileNumber(long mobileNumber) {
		try {
			patientList = Utility.parseJSONArray(file1, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean search = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getMobileNumber() == mobileNumber) {
				System.out.println("Patient available ");
				search = true;
			}
		}
		if (!search) {
			System.out.println("Patient not Available");
		}

	}

	public boolean checkAvailableTime(String time) {
		for (int i = 0; i < doctorServiceImplementation.doctorList.size(); i++) {
			if (doctorServiceImplementation.doctorList.get(i).getAvailableTime().equalsIgnoreCase(time)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void showPopularDoctor() {
		ArrayList<Integer> countPatients=new ArrayList<>();
		 try {
			managerServiceImpl.doctorList=Utility.parseJSONArray(managerServiceImpl.doctorFile, Doctor.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 for (int i = 0; i <managerServiceImpl.doctorList.size() ; i++) {
			 int count=managerServiceImpl.doctorList.get(i).getCountOfPatients();
			countPatients.add(count);
		}
		 System.out.println("Popular doctor: "+Collections.max(countPatients));
		 for (int i = 0; i < managerServiceImpl.doctorList.size(); i++) {
			if(managerServiceImpl.doctorList.get(i).getCountOfPatients()==Collections.max(countPatients)) {
				String popular=managerServiceImpl.doctorList.get(i).getDoctorName();
				System.out.println("Popular doctor:"+popular);
			}
		}
		 
	}

}
