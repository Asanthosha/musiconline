package musiconlinebackend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import musiconlinebackend.dao.ProductDAO;
import musiconlinebackend.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired 
	SessionFactory sessionFactory;
	
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory =sessionFactory;
	}
	
	@Transactional
	public boolean addProduct(Product product) 
	{

		try 
		{
sessionFactory.getCurrentSession().saveOrUpdate(product);
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
