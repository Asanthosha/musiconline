package musiconlinebackend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import musiconlinebackend.dao.SupplierDAO;
import musiconlinebackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired 
	SessionFactory sessionFactory;
	
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory =sessionFactory;
	}
	
	@Transactional
	public boolean addSupplier(Supplier supplier) 
	{

		try 
		{
sessionFactory.getCurrentSession().saveOrUpdate(supplier);
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
