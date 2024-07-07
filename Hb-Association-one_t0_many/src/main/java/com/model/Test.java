package com.model;
`		``
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String args[]) {
		Transaction tr = null;
		try(Session ses =HibernateUtil.getSessionFactory().openSession()){
				tr=ses.beginTransaction();
				Question q1 = new Question();
				q1.setQuestion("What is hibernate ?");
				Question q2 = new Question();
				q2.setQuestion("What is Entity class ?");
				Answer a1 = new Answer(101,"*hibernate used for maven projects","raj" );
				Answer a2 = new Answer(102,"*Entity is called simple java class","rajkumar" );
				Answer b1 = new Answer(101,"hibernate used for maven projects","viswa" );
				Answer b2 = new Answer(102,"Entity is called simple java class","subi" );
				List<Answer> l1=new ArrayList<Answer>();
				l1.add(a1);
				l1.add(b1);
				List<Answer> l2=new ArrayList<Answer>();
				l2.add(a2);
				l2.add(b2);
				q1.setAnswer(l1);
				q2.setAnswer(l2);
				ses.merge(q1);
				ses.merge(q2);
				
				tr.commit();
				ses.close();
         	}  
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
