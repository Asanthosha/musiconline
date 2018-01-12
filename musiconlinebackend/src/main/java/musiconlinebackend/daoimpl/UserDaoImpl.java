package musiconlinebackend.daoimpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;		//provides method to insert,update & delete object
import org.hibernate.SessionFactory;	//provides factory method to get object of session
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import musiconlinebackend.dao.UserDao;
import musiconlinebackend.model.User;


@Repository("UserDaoImpl")
	public class UserDaoImpl implements UserDao
	{
		@Autowired						
		SessionFactory sessionFactory;		
		
		public UserDaoImpl(SessionFactory sessionFactory)
		{
			super();
			this.sessionFactory=sessionFactory;
		}
		//==============insert user===================================
		public void insertUser(User user)
		{
			Session session=sessionFactory.openSession();	
			session.beginTransaction();						
			session.saveOrUpdate(user);				 
													
			session.getTransaction().commit();		
			
		}
		//=========find user by email====================
		public User findById(String email)
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			User u=null;
			try
			{
				session.getTransaction();
				u=session.get(User.class, email);
				session.getTransaction().commit();
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
				session.getTransaction().rollback();
			}
			return u;
			
		}

}
