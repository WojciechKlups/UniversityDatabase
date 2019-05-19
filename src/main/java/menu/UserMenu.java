package menu;

import CRUDs.StudentCRUD;

import java.util.Scanner;

public class UserMenu {

    public void userMenuDisplayer() {
        Scanner scan = new Scanner(System.in);
        StudentCRUD student = new StudentCRUD();
        int userInput = 0;
        System.out.println("Welcome to the University Database Manager!");
        System.out.println("What do you want to edit? [1] Student data, [2] Teacher data, [3] Division data, [4] Course data?");
        userInput = scan.nextInt();
        scan.nextLine();
        switch (userInput) {
            case 1:
                System.out.println("What data you want to edit? [1]Add student, [2]View all students, [3]Update student's data, [4]Delete student");
                userInput = scan.nextInt();
                scan.nextLine();
                switch (userInput) {
                    case 1:
                        student.addStudent();
                        break;
                    case 2:
                        student.printStudents();
                        break;
                    case 3:
                        student.updateStudentData();
                        break;
                    case 4:
                        student.deleteStudent();
                        break;
                }
                break;
            case 2:
                System.out.println("Work in progress");
                break;
            case 3:
                System.out.println("Work in progress");
            case 4:
                System.out.println("Work in progress");
        }
    }
}
