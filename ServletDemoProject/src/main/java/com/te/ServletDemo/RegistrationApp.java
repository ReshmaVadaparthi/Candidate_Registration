package com.te.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import com.te.dao.StudentDao;
import com.te.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegistrationApp extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();

        // Get parameters from the form
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String location = request.getParameter("location");
        
       

//        // Simple validation
//        if ("Admin".equals(username) && "12345".equals(password)) {
//            output.println("<h2 style='color:green;'>Hello "+username +" , Your Registration is Successfully Completed.</h2>");
//        } else {
//            output.println("<h2 style='color:Red;'>Invalid username or password.</h2>");
//        }
            
        Student student = new Student(username.toUpperCase(),gender.toUpperCase(),location.toUpperCase());
        StudentDao dao = new StudentDao();
        
        dao.saveStudent(student);
        
        output.println("<h2 style='color:green;text-align:center;'>Hello "+username +" , Your Registration is Successfully Completed.</h2>");
        
         
        output.close();
    }
}
	

