import Polyclinic.Patient.Patient;
import Polyclinic.Polyclinic;

import java.util.Scanner;

public class Algorithms03 {
    public static void main(String[] args) {
        Polyclinic pol = new Polyclinic(4);
        /*
        pol.addPatient(new Patient("Джон","Муржской"));
        pol.addPatient(new Patient("Майк","Муржской"));
        pol.addPatient(new Patient("Клара","Женский"));
        pol.addPatient(new Patient("Адам","Муржской"));
        pol.addPatient(new Patient("Оля","Женский"));
        pol.addPatient(new Patient("Коля","Муржской"));
        */

        tho: while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите действие\n" +
                    "1. Добавить пациента\n" +
                    "2. Установить количество принемаемых пациентов\n" +
                    "3. Начать рабору\n" +
                    " >>  ");
            switch (scanner.nextInt()){
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    String name;
                    String gender;
                    System.out.printf("Введите имя пациента >>  ");
                    name = scanner1.nextLine();
                    System.out.printf("Введите пол пациента >>  ");
                    gender = scanner1.nextLine();
                    pol.addPatient(new Patient(name, gender));
                    break;
                case 2:
                    System.out.println("Введиие число >>  ");
                    pol.setNumberPatientVisits(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(pol.work());
                    break tho;
                default:
                    break;
            }
        }
    }
}
