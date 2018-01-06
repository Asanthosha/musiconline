package musiconlinebackend.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import musiconlinebackend.model.Category;
import musiconlinebackend.model.Product;
import musiconlinebackend.model.Supplier;
import musiconlinebackend.model.User;


@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HibernateConfiguration 
{

	
	@Autowired
	@Bean(name="datasource")
	
	public DataSource getHibernateData()
	{
		
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/musiconline");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		
		System.out.println("H2 DataBase connected.....");
		
		return datasource;
		
	}
	
	
	private Properties getHibernateProperties()
	{
		Properties p=new Properties();
		
		p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
				p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.show_sql", "true");
		
		System.out.println(" Table created .....");
		
		return p;
		
	}
	
    @Autowired
    @Bean(name="sessionFactory")
	public SessionFactory getHibernateSession(DataSource datasource)
	{
    	LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
		
		lsfb.addProperties(getHibernateProperties());
		
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Product.class);
		
		
		return lsfb.buildSessionFactory();
		
	}

     @Autowired
     @Bean(name="transactionManager")
public HibernateTransactionManager getHibernateTransaction(SessionFactory sf)
{
	
	HibernateTransactionManager tm=new HibernateTransactionManager(sf);
	
	return tm;
	
	
}
  
}


