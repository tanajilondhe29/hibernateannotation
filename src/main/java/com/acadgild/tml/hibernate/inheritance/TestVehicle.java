package com.acadgild.tml.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.acadgild.tml.hibernate.util.HibernateUtil;

public class TestVehicle {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle(10, "Car", "444ttd");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setName("Bike");
		twoWheeler.setSteeringHandle("Two wheeler");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setName("BMW");
		fourWheeler.setSteeringWheel("BMW sterring wheel");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);*/
		
		Vehicle vehicle2 = (Vehicle) session.get(Vehicle.class, 1);
		System.out.println("first fetch : "+vehicle2);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		Vehicle vehicle3 = (Vehicle) session2.get(Vehicle.class, 1);
		System.out.println("second fetch : "+vehicle3);
		session2.getTransaction().commit();
		session2.close();
	}
}
