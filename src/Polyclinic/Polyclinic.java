package Polyclinic;

import Polyclinic.Patient.Patient;

import java.util.ArrayDeque;

public class Polyclinic {
    private ArrayDeque<Patient> queue = new ArrayDeque<>();
    private ArrayDeque<Patient> patientCare = new ArrayDeque<>();
    private int NumberPatientVisits;

    public Polyclinic(int NumberPatientVisits) {
        this.NumberPatientVisits = NumberPatientVisits;
    }

    public void addPatient(Patient a){
        queue.addLast(a);
    }

    public void setNumberPatientVisits(int numberPatientVisits) {
        NumberPatientVisits = numberPatientVisits;
    }

    public String work(){
        int size = Math.min(NumberPatientVisits, queue.size());
        String separator = "+-----";
        for (int i = 0; i < size; i++) {
            separator += "+--------------------";
        }
        separator += "+\n";

        String countdown1 = String.format("|%5s|", "Имя");
        String countdown2 = String.format("|%5s|", "Пол");
        for (int i = 0; i < size; i++) {
            countdown1 += String.format("%20s|", queue.peekFirst().getName());
            countdown2 += String.format("%20s|", queue.peekFirst().getGender());
            patientCare.addLast(queue.pollFirst());
        }
        countdown1 += "\n";
        countdown2 += "\n";

        return new String(separator + countdown1 + separator + countdown2 + separator);
    }

}
