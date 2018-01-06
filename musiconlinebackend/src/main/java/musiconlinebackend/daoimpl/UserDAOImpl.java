package musiconlinebackend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import musiconlinebackend.dao.UserDAO;
import musiconlinebackend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{

	@Autowired 
	SessionFactory sessionFactory;
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory =sessionFactory;
	}
	
	@Transactional
	public boolean addUser(User user) 
	{

		try 
		{
sessionFactory.getCurrentSession().saveOrUpdate(user);
System.out.println("Insertion Successfully....");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception raised......"+e);
		return false;
		}
	}

	
}
