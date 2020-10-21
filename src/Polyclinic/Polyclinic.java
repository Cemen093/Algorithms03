package Polyclinic;

import Polyclinic.Patient.Patient;

import java.util.ArrayDeque;

public class Polyclinic {
    //выбрал дек так как у него есть ссылка на начало и конец, как раз то что нужно,
    //хотя можно было взять и реализацию с только зобавлением в конес и взятием с начала
    private ArrayDeque<Patient> queue = new ArrayDeque<>();
    //взял не особо думая над выбором, нам просто нужно их где то складирывать,
    //хотя потом пожалел, когда вывод надо мыло делать.
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
