import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    @Test
    public void createAndWorkWithLists() {
        Student valera = new Student();
        valera.setFirstName("Valera");
        valera.setLastname("The Tester");
        valera.setEmail("valerunchik@test.lv");
        valera.setPhone("+37128349936");

        Student liga = new Student("Līga", "Ivanova", "liga@test.lv", "+37120304050"); // через конструктор
        Student dimko = new Student("Dimko", "Kolobok", "kolobok@test.lv", "+37127000502");
        Student artis = new Student("Artis", "Best", "", "112");

        List<Student> students = new ArrayList<>();
        students.add(valera);   //0
        students.add(liga);     //1
        students.add(dimko);    //2
        students.add(artis);    //3

        //----------- FOR -------------
        for (int i = 0; i < students.size(); i++) {       //  i = i + 1 ->> i++
            System.out.println(students.get(i).getFirstName());
        }

        //--------- FOREACH -----------
        for (Student s : students) {
  //          System.out.println(s.getFirstName() + " " + s.getLastname());
            System.out.println(s.getFullName());
        }

        //---- FOREACH WITH IF ----------
        System.out.println("Printing students with phone starts with +371: ");
        for (Student s : students) {
                       if (s.getPhone().startsWith("+371")) {
                System.out.println(s.getFullName());
            }
        }
    }
}
