package lab8;

import javax.swing.JOptionPane;

public class EMR 
{
	public static void main(String[] args) 
	{
		Patient patient = new Patient("John", "Doe", "111-11-1111", "1970-11-18", 'm', 170, 70);
		String symptom = JOptionPane.showInputDialog("Please enter your symptom:");
		patient.setSymptom(symptom);
		Doctor doctor = new Doctor("Jane", "Smith", "222-22-2222");
		doctor.prescribe(patient);
				
		String patientProfile = "Patient ID: " + patient.getPatientID() + "\n";
		patientProfile = patientProfile + "Name: " + patient.getLastName() + ", " + patient.getFirstName() + "\n";
		patientProfile = patientProfile + "SSN: " + patient.getSsn() + "\n";
		patientProfile = patientProfile + "Age: " + patient.calculateAge() + "\n";
			
		if(patient.getDiagnosis() != null)
		{
		patientProfile = patientProfile + "Diagnosis: " + patient.getDiagnosis().getName() + "\n";
		}
		else
		{
			patientProfile = patientProfile + "Diagnosis: none\n";
		}
				
		if(patient.getMedication() != null)
		{
			patientProfile = patientProfile + "Medication: " + patient.getMedication().getName() + "\n";
		}
		else
		{
			patientProfile = patientProfile + "Medication: none\n";
		}		
		JOptionPane.showMessageDialog(null, patientProfile);
	}
}
