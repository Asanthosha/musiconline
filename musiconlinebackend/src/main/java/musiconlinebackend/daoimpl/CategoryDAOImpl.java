package musiconlinebackend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import musiconlinebackend.dao.CategoryDAO;
import musiconlinebackend.model.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired 
	SessionFactory sessionFactory;
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory =sessionFactory;
	}
	
	@Transactional
	public boolean addCategory(Category category) 
	{

		try 
		{
sessionFactory.getCurrentSession().saveOrUpdate(category);
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
