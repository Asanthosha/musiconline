package musiconlinebackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import musiconlinebackend.dao.ProductDao;
import musiconlinebackend.model.Product;



@SuppressWarnings("deprecation")

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	//==============insert product=========================
	public void insertProduct(Product product)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
	//============for retrieve product list=========================
	public List<Product>retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product>list=session.createQuery("from Product").list();
		session.getTransaction().commit();
		return list;
	}
	//=============for find product by pid========================
	public Product findById(int pid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product p=null;
		try
		{
			session.getTransaction();
			p=session.get(Product.class, pid);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
		
	}
	//============for get product by pid===================================
	public List<Product>getProdById(int cid)
	{
		Session session=sessionFactory.openSession();
		List<Product>products=null;
		session.beginTransaction();
		products=session.createQuery("from Product where cid="+cid).list();
		System.out.println(products);
		session.getTransaction().commit();
		return products;
	}
	//============for delete product============================
	public void deleteProduct(int pid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product product=(Product)session.get(Product.class, pid);
		session.delete(product);
		session.getTransaction().commit();
	}
	//============for update product=====================
	public void update(Product p)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
	}
	
}