package com.model;
import java.util.List;

import org.hibernate.Session;

//import com.mysql.cj.Query;
import org.hibernate.Transaction;


public class RetriveTest {
	public static void main(String[]args) {
		Transaction tr=null;
		try(Session ses=HibernateUtil.getSessionFactory().openSession()){
			tr=ses.beginTransaction();
			org.hibernate.query.Query<Question> qry=ses.createQuery("from Question",Question.class);
					List<Question> qi=qry.list();
			for(Question q:qi) {
				System.out.println(q.getId()+"\t"+q.getQuestion());
				List<Answer>ans=q.getAnswer();
				for(Answer b:ans)
				{
					System.out.println(b.getAnswername()+"\t"+b.getPostedBy());
				}
			//	Address ad=e.getAddr();
				//System.out.println("Address is"+ad.getLine1()+ad.getLine2()+ad.getCity()+ad.getPin());
			}
			  tr.commit();
			  ses.close();}
			  catch(Exception e) {e.printStackTrace();}
		}
	}