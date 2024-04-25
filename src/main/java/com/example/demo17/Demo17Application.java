package com.example.demo17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo17Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo17Application.class, args);

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();

		Student st1=new Student();
		st1.setId(001);
		st1.setName("PIKACHU"); //Also added another data for these 3 fields
		st1.setCity("TOKYO");

		Certificate certificate1=new Certificate();
		certificate1.setCourse("GFG 1");
		certificate1.setDuration("2 months");
		st1.setCerti(certificate1);

		Student st2=new Student();
		st2.setId(002);
		st2.setName("CHARIZARD"); //Also added another data for these 3 fields
		st2.setCity("CHAR ISLAND");

		Certificate certificate2=new Certificate();
		certificate2.setCourse("GFG 2");
		certificate2.setDuration("1.5 months");
		st2.setCerti(certificate2);

		Session session=factory.openSession();

		Transaction tx=session.beginTransaction();
		session.save(st1);
		session.save(st2);
		tx.commit(); //To commit the changes in our DB

		session.close();
		factory.close();

		System.out.println("Done");

	}

}
