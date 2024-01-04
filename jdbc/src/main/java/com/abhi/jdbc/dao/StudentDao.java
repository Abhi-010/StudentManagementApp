package com.abhi.jdbc.dao;

import com.abhi.jdbc.CP;
import com.abhi.jdbc.models.Student;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;

public class StudentDao {
    public static boolean insertToDB(Student student){// throws SQLException {

        boolean flag = false;
        try{
            Connection con = CP.createConnection();
            String query = "insert into students(sname,s_phone,s_city) values (?,?,?)";

            //prepared Statements..

            PreparedStatement pstmt = con.prepareStatement(query);

            //set the values of the parameters

            pstmt.setString(1, student.getName());
            pstmt.setString(2,student.getStudentPhone());
            pstmt.setString(3,student.getStudentCity());

            //execute..
            pstmt.executeUpdate();

            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    public static boolean deleteStudent(int id){
        boolean flag = false;

        try{
            Connection con = CP.createConnection();
            String query = "delete from students where s_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void showStudentsFromDB(){
        try{
            Connection con = CP.createConnection();
            String query = "select * from students;";
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);

            while(set.next()){
                int id = set.getInt(1);
                String  name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Phone : " + phone);
                System.out.println("City : " + city);
                System.out.println("=====================");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
