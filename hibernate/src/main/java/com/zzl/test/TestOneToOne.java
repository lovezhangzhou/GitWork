package com.zzl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.zzl.pojo.Card;
import com.zzl.pojo.Tuser;

public class TestOneToOne {
	
	@Test
	public void  OneToOne() {
//		  //的到配置文件的根节点
		Configuration cfg =new Configuration().configure();
//		//得到session的工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		//得到session
		Session session = sessionFactory.openSession();
//	    //得到事务
		Transaction transaction = session.beginTransaction();
		//创建主对象
		Tuser tu=new Tuser();
		tu.setUname("万五");
		//创建从表对象
		Card c=new Card();
		c.setCard("565656");
		//互设
		tu.setCard(c);
		c.setTuser(tu);
//		session.save(c);
//		session.save(tu);
		session.save(tu);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}
	
	
	@Test
	public void update() {
//		  //的到配置文件的根节点
		Configuration cfg =new Configuration().configure();
//		//得到session的工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		//得到session
		Session session = sessionFactory.openSession();
//	    //得到事务
		Transaction transaction = session.beginTransaction();
		
//	Tuser tuser = session.get(Tuser.class, 3);
		
//	   tuser.getCard().setCard("王五的卡号");
		Card card = session.get(Card.class,3);
	
		card.getTuser().setUname("赵六3");
		
		session.save(card);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
	
	
	
	
	@Test
	public void del() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//创建主对象
		Tuser tu= session.get(Tuser.class, 3);
		
		session.delete(tu);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	} 

}
