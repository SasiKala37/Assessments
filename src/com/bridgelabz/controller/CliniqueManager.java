package com.bridgelabz.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceimplementation.ManagerServiceImplementation;
import com.bridgelabz.serviceimplementation.PatientServiceImplementation;
import com.bridgelabz.util.Utility;

public class CliniqueManager {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		int choice = 0;
		PatientServiceImplementation patientServiceImplementation = new PatientServiceImplementation();
		DoctorServiceImplementation doctorServiceImplementation = new DoctorServiceImplementation();
		ManagerServiceImplementation managerServiceImplementation = new ManagerServiceImplementation();
		/*
		 * managerServiceImplementation.printReport();
		 * patientServiceImplementation.takeAppointment();
		 * patientServiceImplementation.showPopularDoctor();
		 */
		System.out.println("WELCOME TO AADHRSHA CLINIQUE");
		System.out.println("1: Show Popular Doctor");
		System.out.println("2:Take Appointment");
		System.out.println("3:Doctor Details ");
		System.out.println("4:Patient Details");
		System.out.println("5:Print Report");
		while (choice < 10) {
			System.out.println("Enter your choice");
			choice = Utility.userInputInteger();
			switch (choice) {
			case 1:
				System.out.println("Show popular Doctor");
				patientServiceImplementation.showPopularDoctor();
				break;
			case 2:
				System.out.println("Take Appointment");
				patientServiceImplementation.takeAppointment();
				break;
			case 3:
				System.out.println("Doctor Details Modifications");
				System.out.println("1:Add Doctor Details");
				System.out.println("2:Update Doctor Details");
				System.out.println("3:Delete Doctor Details");
				System.out.println("4:Search Doctor by id");
				System.out.println("5:Search Doctor by Name");
				System.out.println("6:Search Doctor by Specialization");
				int dop = 0;
				while (dop < 7) {
					System.out.println("Enter your choice");
					dop = Utility.userInputInteger();
					switch (dop) {
					case 1:
						managerServiceImplementation.addDocotor();
						break;
					case 2:
						System.out.println("Enter doctor Id ");
						int id = Utility.userInputInteger();
						managerServiceImplementation.updateDocotorDetails(id);
						break;
					case 3:
						System.out.println("Enter doctor Id");
						int did = Utility.userInputInteger();
						managerServiceImplementation.deleteDoctor(did);
						break;
					case 4:
						System.out.println("Enter doctor Id");
						int did1 = Utility.userInputInteger();
						doctorServiceImplementation.searchByDoctorId(did1);
						break;
					case 5:
						System.out.println("Enter the doctor name");
						Utility.userInputNextLine();
						doctorServiceImplementation.searchByDoctorName(Utility.userInputNextLine());
						break;
					case 6:
						System.out.println("Enter Doctor Specialization");
						String spcl = Utility.userInputString();
						doctorServiceImplementation.searchBySpecialization(spcl);
						break;
					}
					dop++;
				}

			case 4:
				System.out.println("Patient Details");
				System.out.println("1:Show Patient Details");
				System.out.println("2:SEARCH PATIENT BY NAME");
				System.out.println("3:SEARCH PATIENT BY ID");
				System.out.println("4:SEARCH PATIENT BY MOBILE NUMBER");
				System.out.println("5:ADD PATIENT DETAILS");
				System.out.println("6:UPDATE PATIENT BY AGE");
				System.out.println("7:UPDATE PATIENT BY MOBILE NUMBER");
				System.out.println("8:DELETE PATIENT BY ID");
				int ch = 0;
				while (ch < 9) {
					System.out.println("Enter your choice");
					ch = Utility.userInputInteger();
					switch (ch) {
					case 1:
						patientServiceImplementation.showPatientDetails();
						break;

					case 2:
						System.out.println("Enter Patient name");
						Utility.userInputNextLine();
						String patientName = Utility.userInputNextLine();
						patientServiceImplementation.searchPatientByName(patientName);
						break;
					case 3:
						System.out.println("Enter Patient Id");
						int patientId = Utility.userInputInteger();
						patientServiceImplementation.searchPatientById(patientId);
						break;
					case 4:
						System.out.println("Enter Patient Mobile number");
						long mobileNum = Utility.userInputLong();
						patientServiceImplementation.searchPatientByMobileNumber(mobileNum);
						break;
					case 5:
						managerServiceImplementation.addPatient();
						break;
					case 6:
						System.out.println("Enter patientid to update");
						int ptid = Utility.userInputInteger();
						managerServiceImplementation.updatePatientByAge(ptid);
						break;
					case 7:
						System.out.println("Enter patientid to update");
						int ptid1 = Utility.userInputInteger();
						managerServiceImplementation.updatePatientByMobileNum(ptid1);
						break;
					case 8:
						System.out.println("Enter patientid to delete");
						int pid = Utility.userInputInteger();
						managerServiceImplementation.deletePatient(pid);
						break;
					default:
						System.out.println("Exit");
					}
					ch++;
				}
				break;
			case 5:
				System.out.println("Print report");
				 managerServiceImplementation.printReport();
				break;
			default:
				System.out.println("Exit");
			}
			choice++;
		}

	}

}
