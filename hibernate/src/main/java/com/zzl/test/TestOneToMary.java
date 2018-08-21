package com.zzl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.zzl.pojo.Card;
import com.zzl.pojo.City;
import com.zzl.pojo.Province;
import com.zzl.pojo.Tuser;

public class TestOneToMary {
	
	@Test
	public void  OneToMary() {
//		  //的到配置文件的根节点
		Configuration cfg =new Configuration().configure();
//		//得到session的工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		//得到session
		Session session = sessionFactory.openSession();
//	    //得到事务
		Transaction transaction = session.beginTransaction();
		//创建省份
		Province pr=new Province();
		pr.setPname("湖北2");
		
		//创建城市
		City c1=new City();
		c1.setCname("武汉2");
		City c2=new City();
		c2.setCname("湘汗2");
		City c3=new City();
		c3.setCname("武洲2");
		

		//互设
		c1.setProvince(pr);
		c2.setProvince(pr);
		c3.setProvince(pr);
		
		pr.getScity().add(c1);
		pr.getScity().add(c2);
		pr.getScity().add(c3);
		
		//保存
		session.save(pr);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}
	
	
//	@Test
//	public void update() {
////		  //的到配置文件的根节点
//		Configuration cfg =new Configuration().configure();
////		//得到session的工厂
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
////		//得到session
//		Session session = sessionFactory.openSession();
////	    //得到事务
//		Transaction transaction = session.beginTransaction();
//		
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//
//	}
	
	
	
	
//	@Test
//	public void del() {
//		Configuration cfg = new Configuration().configure();
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		
//
//		
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//		
//	} 

}
