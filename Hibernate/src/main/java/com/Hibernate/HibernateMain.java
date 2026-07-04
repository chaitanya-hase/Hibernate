package com.Hibernate;

import java.util.Scanner;

import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Session session = HibernateUtil.getSessionFactory().openSession();

        while (true) {

            System.out.println("\n1.Insert");
            System.out.println("2.Read");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

            case 1:

                session.beginTransaction();

                Student s = new Student();

                System.out.print("Enter Id : ");
                s.setId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Name : ");
                s.setName(sc.nextLine());

                System.out.print("Enter Marks : ");
                s.setMarks(sc.nextInt());

                session.persist(s);

                session.getTransaction().commit();

                System.out.println("Inserted Successfully");

                break;

            case 2:

                System.out.print("Enter Id : ");
                int id = sc.nextInt();

                Student st = session.get(Student.class, id);

                if (st != null) {
                    System.out.println(st.getId());
                    System.out.println(st.getName());
                    System.out.println(st.getMarks());
                } else {
                    System.out.println("Record Not Found");
                }

                break;

            case 3:

                session.beginTransaction();

                System.out.print("Enter Id : ");
                id = sc.nextInt();

                Student update = session.get(Student.class, id);

                if (update != null) {

                    sc.nextLine();

                    System.out.print("Enter New Name : ");
                    update.setName(sc.nextLine());

                    System.out.print("Enter New Marks : ");
                    update.setMarks(sc.nextInt());

                    session.merge(update);

                    session.getTransaction().commit();

                    System.out.println("Updated Successfully");

                } else {

                    System.out.println("Record Not Found");
                    session.getTransaction().rollback();

                }

                break;

            case 4:

                session.beginTransaction();

                System.out.print("Enter Id : ");

                id = sc.nextInt();

                Student delete = session.get(Student.class, id);

                if (delete != null) {

                    session.remove(delete);

                    session.getTransaction().commit();

                    System.out.println("Deleted Successfully");

                } else {

                    System.out.println("Record Not Found");
                    session.getTransaction().rollback();

                }

                break;

            case 5:

                session.close();

                HibernateUtil.getSessionFactory().close();

                sc.close();

                System.exit(0);

            default:

                System.out.println("Invalid Choice");

            }

        }

    }
}