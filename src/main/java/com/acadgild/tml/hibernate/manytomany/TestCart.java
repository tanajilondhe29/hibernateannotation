package com.acadgild.tml.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.acadgild.tml.hibernate.util.HibernateUtil;

public class TestCart {

	public static void main(String[] args) {

		System.out.println("********************* MANY TO MANY EXAMPLE *********************");
		ItemMN item = new ItemMN(0, 100, "iPhone");
		
		ItemMN item2 = new ItemMN(0, 50, "nokia");
		
		
		Set<ItemMN> items = new HashSet<ItemMN>();
		items.add(item);
		items.add(item2);
		
		CartMN cart = new CartMN(0, 150, items);
		cart.setTotal(150);
		
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(cart);
			session.getTransaction().commit();
			sessionFactory.close();

			System.out.println("Cart ID=" + cart.getId());
			System.out.println("Item ID=" + item.getId());
			System.out.println("Item2 ID=" + item2.getId());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionFactory != null && !sessionFactory.isClosed())
				sessionFactory.close();
		}
	}
}
