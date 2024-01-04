package com.abhi.jdbc;

import com.abhi.jdbc.dao.StudentDao;
import com.abhi.jdbc.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Student Management App");
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Press 1 to Add Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to display Student");

            //exercise ->
            System.out.println("Press 4 to update Student");

            System.out.println("Press 4 to exit App");
            int c = Integer.parseInt(bufferedReader.readLine());

            if(c == 1){
                //add student
                System.out.println("Enter user name");
                String name = bufferedReader.readLine();
                System.out.println("Enter user phone");
                String phone = bufferedReader.readLine();

                System.out.println("Enter user city");
                String city = bufferedReader.readLine();

                //create student object
                Student st = new Student(name,phone,city);
                System.out.println(st);
                boolean ans =StudentDao.insertToDB(st);

                if(ans){
                    System.out.println("Student successfully added ");
                }
                else {
                    System.out.println("Something went wrong....");
                }
            }
            else if(c==2){
                //delete student
                System.out.println("Enter student id to delete");
                int idToDelete = Integer.parseInt(bufferedReader.readLine());

                boolean flag = StudentDao.deleteStudent(idToDelete);
                if(flag){
                    System.out.println("Student successfully deleted");
                }
                else {
                    System.out.println("Some went wrong.. ");
                }
            }
            else if(c==3){
                StudentDao.showStudentsFromDB();
            }
            else if(c==4){
                //exit
                break;
            }
            else{

            }
        }
        System.out.println("Thank you for using my application");
        System.out.println("See you soon bubye..!!");
    }
}
