package musiconlinebackend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musiconlinebackend.dao.UserDAO;
import musiconlinebackend.model.User;

public class UserTestCases {


	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		System.out.println("Starting into Initiailze User Test case ");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("musiconlinebackend");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		System.out.println("Ending into Initialization user test case ");;
		
	
	}

	@Test
	public void createUserTest()
	{
		
		System.out.println("Starting into creating User Test case ");
		User user=new User();
		
		user.setEmail("santhu@gmail.com");
		user.setName("santhu");
		user.setPassword("santhu");
		user.setPhone("9876543210");
		user.setRoll("ROLE_USER");
		user.setAddress("Dilsuknagar,Hyderabad");
		user.setEnabled("true");
				
		assertTrue("problem in User", userDAO.addUser(user));
		
		System.out.println("Ending..... into Createing User....");
		
	}
                                                                                                                                                                                                        

}
