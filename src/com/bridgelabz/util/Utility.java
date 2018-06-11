package com.bridgelabz.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;

public class Utility {
	public static Scanner scanner = new Scanner(System.in);
	public static ObjectMapper mapper=new ObjectMapper();
	 Doctor doctor;
	Patient patient;
	public static String userInputString() {
		return scanner.next();
	}

	public static int userInputInteger() {
		return scanner.nextInt();
	}

	public static Double userInputDouble() {
		return scanner.nextDouble();
	}

	public static boolean userInputBoolean() {
		return scanner.nextBoolean();
	}

	public static Long userInputLong() {
		return scanner.nextLong();
	}
	
	public static String userInputNextLine() {
		return scanner.nextLine();
	}
	
	public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ArrayList<T> arrayList = new ArrayList<T>();
        CollectionType javaType = mapper.getTypeFactory()
                  .constructCollectionType(List.class, clazz);
        arrayList = mapper.readValue(file, javaType);

        return arrayList;

    }
	
   public Doctor doctorDetails() {
	    System.out.println("Enter Doctor name");
	    userInputNextLine();
	    String name=userInputNextLine();
	    System.out.println("Enter Doctor id");
	    int id=userInputInteger();
	    System.out.println("Enter Doctor available time");
	    String time=userInputString();
	    System.out.println("Enter Doctor Specialization");
	    String specialization=userInputString();
	    System.out.println("Enter count of patients");
	    int count=userInputInteger();
	    doctor=new Doctor(name,id,time,specialization,count);
	    return doctor;
   }
   public Patient patientDetails() {
	   System.out.println("Enter Patient name");
	   userInputNextLine();
	   String name=userInputNextLine();
	   System.out.println("Enter patient id");
	   int id=userInputInteger();
	   System.out.println("Enter mobile number");
	   long mobile=userInputLong();
	   System.out.println("Enter patient age");
	   int age=userInputInteger();
	  patient=new Patient(name,id,mobile,age);
	  return patient;
   }
    
   /*public <T> void search(ArrayList<T> list,T doctorName) {
	   
	   boolean search = false;
	   Method method=Class.forName("com.bridgelabz.model.Doctor").getMethod("getDoctorName");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).method.getName().equalsIgnoreCase(doctorName)) {
				System.out.println("Doctor available ");
				search = true;
			}
		}
		if (!search) {
			System.out.println("Doctor not Available");
		}
   }
*/
}
