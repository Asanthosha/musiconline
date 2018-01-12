package musiconlinebackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import musiconlinebackend.dao.SupplierDao;
import musiconlinebackend.model.Supplier;




@SuppressWarnings("deprecation")
@Repository("supplierDaoImpl")
public class SupplierDaoImpl implements SupplierDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	//==============insert supplier===========================
	public void insertSupplier(Supplier supplier)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
	}
	//==================retrieve supplier list========================
	public List<Supplier>retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier>list=session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		return list;
	}
	//================find supplier by sid============================
	public Supplier findById(int sid)
	{
		Session session=sessionFactory.openSession();
		Supplier p=null;
		try
		{
			session.beginTransaction();
			p=session.get(Supplier.class, sid);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
		
	}
	//================delete supplier=======================
	public void deleteSupplier(int sid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier=(Supplier)session.get(Supplier.class, sid);
		session.delete(supplier);
		session.getTransaction().commit();
	}
	//==============update supplier==========================
	public void update(Supplier s)
	{
		Session session=sessionFactory.openSession();
		try
		{
			session.beginTransaction();
			session.update(s);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}
	
}
