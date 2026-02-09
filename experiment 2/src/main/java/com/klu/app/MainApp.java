package com.klu.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.klu.model.Department;
import com.klu.model.Employee;
import com.klu.util.HibernateUtil;

import java.util.Scanner;

public class MainApp {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println(".........Main Menu.........");
            System.out.println("1.Insert employee");
            System.out.println("2.Display Employee");
            System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");
            System.out.println("Select your choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertEmployee(sc);
                    break;
                case 2:
                    displayEmployee(sc);
                    break;
                case 3:
                    updateEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("Thank you");
                    break;
            }

        } while (choice != 5);

        factory.close();
        sc.close();
    }

    // INSERT
    static void insertEmployee(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Department Name:");
        String deptName = sc.next();

        Department dept = new Department();
        dept.setDeptName(deptName);

        System.out.println("Enter Employee Name:");
        String ename = sc.next();

        System.out.println("Enter Employee Salary:");
        double sal = sc.nextDouble();

        Employee emp = new Employee();
        emp.setEmpName(ename);
        emp.setEmpSalary(sal);
        emp.setDepartment(dept);

        session.persist(dept);
        session.persist(emp);

        tx.commit();
        session.close();

        System.out.println("Employee inserted successfully");
    }

    // DISPLAY
    static void displayEmployee(Scanner sc) {
        Session session = factory.openSession();

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.println("Name: " + emp.getEmpName());
            System.out.println("Salary: " + emp.getEmpSalary());
            System.out.println("Dept: " + emp.getDepartment().getDeptName());
        } else {
            System.out.println("Employee not found");
        }

        session.close();
    }

    // UPDATE
    static void updateEmployee(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.println("Enter New Salary:");
            emp.setEmpSalary(sc.nextDouble());
            tx.commit();
            System.out.println("Salary updated");
        } else {
            System.out.println("Employee not found");
            tx.rollback();
        }

        session.close();
    }

    // DELETE
    static void deleteEmployee(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            session.remove(emp);
            tx.commit();
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
            tx.rollback();
        }

        session.close();
    }
}
