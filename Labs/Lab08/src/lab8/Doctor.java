package lab8;

public class Doctor 
{
	int employeeID;
	String firstName, lastName, ssn;
	
	public Doctor(String firstName, String lastName, String ssn)
	{
		this.firstName = firstName; this.lastName = lastName; this.ssn = ssn;
		String fullName = firstName + lastName;
		this.employeeID = fullName.hashCode();
	}
	
	public void prescribe(Patient patient)
	{
		if(patient.symptom.equals("Headache"))
		{
			Diagnosis diagnosis = new Diagnosis(1,"Dehydration");
			Medication medication = new Medication(1,"Tylenol");
			patient.setDiagnosis(diagnosis);
			patient.setMedication(medication);
		}
		
		else if(patient.symptom.equals("Cough"))
		{
			Diagnosis diagnosis = new Diagnosis(2,"Common cold");
			Medication medication = new Medication(2,"Cough drops");
			patient.setDiagnosis(diagnosis);
			patient.setMedication(medication);
		}
		
		else if(patient.symptom.equals("Fever"))
		{
			Diagnosis diagnosis = new Diagnosis(3,"Influenza");
			Medication medication = new Medication(1,"Tamiflu");
			patient.setDiagnosis(diagnosis);
			patient.setMedication(medication);
		}
		
		else
		{
			patient.setDiagnosis(null);
			patient.setMedication(null);
			System.out.println("Cannot be diagnosed.");
		}
	}
}
