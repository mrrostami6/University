package main;

import project.Person;
import project.Student;
import project.Teacher;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            printMenu();
            int order = scan.nextInt();
            switch (order) {
                case 1:
                    save("student");
                    break;
                case 2:
                    save("teacher");
                    break;
                case 3:
                    update("student");
                    break;
                case 4:
                    update("teacher");
                    break;
                case 5:
                    delete("student");
                    break;
                case 6:
                    delete("teacher");
                    break;
                case 7:
                    set();
                    break;
                case 8:
                    Teacher.showStudentsBasedTeacherId();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Please Enter A Valid Number...");
            }
        }

    }

    public static void printMenu() {
        System.out.println("1 --> Add Student\n" +
                "2 --> Add Teacher\n" +
                "3 --> Update Student\n" +
                "4 --> Update Teacher\n" +
                "5 --> Delete Student\n" +
                "6 --> Delete Teacher\n" +
                "7 --> Set Student For Teacher Or Teacher For Student\n" +
                "8 --> Show Teacher's Students\n" +
                "9 --> Exit");
        System.out.println("Please Enter A Number To Continue : ");
    }

    public static void save(String name) throws SQLException {
        // define new inf array : from ConsoleScanner
        // array[0] = firstName , array[1] = lastName , array[2] = id
        String[] inf = ConsoleScanner.getInf();

        // condition for polymorphism
        Person person;
        if (inf != null && name.equals("student")) {
            person = new Student(inf[0], inf[1], Integer.parseInt(inf[2]));
            person.save();
        }
        else if (inf != null && name.equals("teacher")) {
            person = new Teacher(inf[0], inf[1], Integer.parseInt(inf[2]));
            person.save();
        }
    }

    public static void update(String name) throws SQLException {
        // define new inf array : from ConsoleScanner
        // array[0] = firstName , array[1] = lastName , array[2] = id
        String[] inf = ConsoleScanner.getInfUpdate();

        Person person;
        // condition for polymorphism
        if (inf != null && name.equals("student")) {
            person = new Student(inf[0], inf[1], Integer.parseInt(inf[2]));
            person.update();
        }
        else if (inf != null && name.equals("teacher")) {
            person = new Teacher(inf[0], inf[1], Integer.parseInt(inf[2]));
            person.update();
        }

    }

    public static void delete(String name) throws SQLException {
        Integer id = ConsoleScanner.getInfDelete();
        Person person;

        // condition for polymorphism
        if (id != null && name.equals("student")) {
            person = new Student("", "", id);
            person.delete();
        }
        else if (id != null && name.equals("teacher")) {
            person = new Teacher("", "", id);
            person.delete();
        }
    }

    public static void set() throws SQLException {
        // define new ids array : from ConsoleScanner
        // array[0] = teacher ID , array[1] = student ID
        Integer[] ids = ConsoleScanner.getInfSet();
        if (ids != null){
            Person.set(ids[0], ids[1]);
        }

    }
}