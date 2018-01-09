package musiconlinebackend.daoimpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import musiconlinebackend.dao.CategoryDao;
import musiconlinebackend.model.Category;


@SuppressWarnings("unused")

@Repository("categoryDaoImpl")

public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	//============insert category==============================
	public void insertCategory(Category category)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
	}
	//=================retrieve category list==============================
	public List<Category>retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category>list=session.createQuery("from Category").list();
		session.getTransaction().commit();
		return list;
	}
	//==============find category by cid==================================
	public Category findById(int cid)
	{
		Session session=sessionFactory.openSession();
		Category p=null;
		try
		{
			session.beginTransaction();
			p=session.get(Category.class, cid);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
		
	}
	//================for delete category================================
		public void deleteCategory(int cid)
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Category category=(Category)session.get(Category.class, cid);
			session.delete(category);
			session.getTransaction().commit();
		}
		//==========================update category======================================
		public void updateCategory(Category c)
		{
			Session session=sessionFactory.openSession();
			try
			{
				session.beginTransaction();
				session.update(c);
				session.getTransaction().commit();
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
				session.getTransaction().rollback();
			}
			
		}

}
