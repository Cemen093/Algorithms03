package Polyclinic;

import Polyclinic.Patient.Patient;

import java.util.ArrayDeque;

public class Polyclinic {
    //выбрал дек так как у него есть ссылка на начало и конец, как раз то что нужно,
    //хотя можно было взять и реализацию с только зобавлением в конец и взятием с начала
    private ArrayDeque<Patient> queue = new ArrayDeque<>();
    //взял не особо думая над выбором, нам просто нужно их где то складировать,
    //хотя потом пожалел, когда вывод надо было делать.
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
        int man = 0;
        int female = 0;
        int size = Math.min(NumberPatientVisits, queue.size());
        int len = 20;
        String separator = "";
        for (int i = 0; i < len; i++) {
            separator += "-";
        }

        String countdown1 = String.format("+%20s+\n|%20s|\n+%20s+\n", separator, "Имя", separator);
        for (int i = 0; i < size; i++) {
            countdown1 += String.format("|%20s|\n+%20s+\n", queue.peekFirst().getName(), separator);
            if (queue.peekFirst().getGender() == "Муржской") man++;
            else female++;
            patientCare.addLast(queue.pollFirst());
        }
        countdown1 += "\n";
        String countdown2 = String.format("+%20s+%20s+%20s+\n|%20s|%20s|%20s|\n+%20s+%20s+%20s+\n|%20s|%20s|%20s|\n+%20s+%20s+%20s+\n",
                separator, separator, separator,
                "Принято", "Муржчин", "Женщин",
                separator, separator, separator,
                "Количество", man, female,
                separator, separator, separator);

        return new String(countdown1 + "\n" + countdown2);
    }

}
