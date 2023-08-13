package lab8;

import java.time.LocalDate;
import java.time.Period;

public class Patient 
{
	int patientID;
	String firstName, lastName, ssn, dateOfBirth;
	String symptom;
	char gender;
	Diagnosis diagnosis;
	Medication medication;
	double height, weight;

	public Patient(String firstName, String lastName, String ssn, String dateOfBirth, char gender, double weight, double height) 
	{
		this.firstName = firstName; this.lastName = lastName; this.ssn = ssn; this.dateOfBirth = dateOfBirth; this.gender = gender; this.weight = weight; this.height = height; 
		String fullName = firstName + lastName;
		this.patientID = fullName.hashCode();
	}
	
	public int calculateAge()
	{
		LocalDate curDate = LocalDate.now();
		LocalDate dob = LocalDate.parse(dateOfBirth);
		return Period.between(dob,curDate).getYears();
	}
	
	public void setDiagnosis(Diagnosis diagnosis)
	{
		this.diagnosis = diagnosis;
	}

	public void setMedication(Medication medication)
	{
		this.medication = medication;
	}

	public void setSymptom(String symptom) 
	{
		this.symptom = symptom;
	}

	public int getPatientID() 
	{
		return this.patientID;
	}

	public String getLastName() 
	{
		return this.lastName;
	}

	public String getFirstName() 
	{
		return this.firstName;
	}

	public String getSsn() 
	{
		return this.ssn;
	}

	public Diagnosis getDiagnosis() 
	{
		return this.diagnosis;
	}

	public Medication getMedication() 
	{
		return this.medication;
	}
}
