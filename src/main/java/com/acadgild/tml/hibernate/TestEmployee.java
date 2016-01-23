package com.acadgild.tml.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.acadgild.tml.hibernate.onetoone.Employee;
import com.acadgild.tml.hibernate.onetoone.EmployeeDetail;
import com.acadgild.tml.hibernate.util.HibernateUtil;

public class TestEmployee {

	public static void main(String[] args) {
		System.out.println("**********************one to one mapping ************************");
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        EmployeeDetail employeeDetail = new EmployeeDetail("MG Road", "Pune", "Maharashtra", "India");
         
        Employee employee = new Employee("Acdgild", "User", new Date(110215),
                "452-4145-222");
        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);
         
        session.save(employee);
 
         
        List<Employee> employees = session.createQuery("from Employee").list();
        for (Employee employee1 : employees) {
            System.out.println(employee1.getFirstname() + " , "
                    + employee1.getLastname() + ", "
                    + employee1.getEmployeeDetail().getState());
        }
 
        session.getTransaction().commit();
        session.close();
	}
}
