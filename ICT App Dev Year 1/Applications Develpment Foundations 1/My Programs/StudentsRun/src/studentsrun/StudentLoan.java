package studentsrun;

import java.util.Scanner;

        public class StudentLoan {
    
        Student[] students = new Student[20];
        int noOfStudents;
    
        public StudentLoan(){
        students[0] = new Student("Thabiso", 220296006,50000.0);
        students[1] = new Student("Smitties",1234,10000.0);
        students[2] = new PostGraduate("Mpho",201812345,20000.0,"I dont know");
        students[3] = new PostGraduate("Jannie",67543,30000.0,"I dont know");
        noOfStudents=4;
      }

        public int menus(){
            
        Scanner kbd = new Scanner(System.in);
            int option;
            
        System.out.println("1:Add student");
        System.out.println("2:Display students");
        System.out.println("3:Display interest");
        System.out.println("4:Exit");
            
        option = kbd.nextInt();
        return option;
     }
         
         public Student createStudent(){
            
            Scanner scn = new Scanner(System.in);
            
            System.out.println("Pease enter Name:");
            String name = scn.nextLine();
            System.out.println("Please enter Student number:");
            long studentNumber = scn.nextLong();
            System.out.println("Please enter Loan amount:");
            double loanAmount = scn.nextInt();
            
            Student student = new Student(name,studentNumber,loanAmount);

            return student;
     }
            public PostGraduate createPostGraduate(){
            
            Scanner scn = new Scanner(System.in);
            
            System.out.println("Pease enter Name:");
            String name = scn.nextLine();
            System.out.println("Please enter Student number:");
            long studentNumber = scn.nextLong();
            System.out.println("Please enter Loan amount:");
            double loanAmount = scn.nextInt();
            System.out.println("Please enter Thesis:");
            String thesis = scn.nextLine();
            
            PostGraduate postgraduate = new PostGraduate(name,studentNumber,loanAmount,thesis);

            return postgraduate;
     }
            public void displayAllStudents(){
             
            System.out.println("Displaying all Students");
            System.out.println("----------------------");
            for (int i = 0; i < noOfStudents; i++) {
            System.out.println(students[i].toString());
            System.out.println("-------------------------");
     }
     }
         
            public void displayloanAmounts(){
            
            for (int i = 0; i <noOfStudents ; i++) {
            if (students[i] instanceof Student) {
                Student student = (Student) students[i];
            System.out.println("Loan Amounts and Interest\n");
            System.out.println("------------------------------");
            System.out.println(""+ student.getLoanAmount()+ "\t" + "" + student.interest());
            
            
     }
     }
     }       
           public void add(){
            
             int choice;
             Student student;
             PostGraduate postgraduate;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 for student");
            System.out.println("Enter 2 for post graduate");
               
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                student = createStudent();
                students[noOfStudents] = student;
                noOfStudents++;
                break;
            case 2:
                postgraduate = createPostGraduate();
                students[noOfStudents] = postgraduate;
                noOfStudents++;
                break;
            default:
                System.out.println("Wrong choice");
        }
        }
            
           public void menuControl(){
             
             int option;
             while (true) {
             option = menus();
              switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    displayloanAmounts();
                    break;
                case 4:
                    menus();
                    break;
                case 5:
                    System.out.println("Thank you.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option");
                    System.out.println("Please try again.");
        }
        }
        }
        }
