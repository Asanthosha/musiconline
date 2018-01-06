package musiconlinebackend.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musiconlinebackend.dao.ProductDAO;
import musiconlinebackend.model.Product;


public class ProductTestcases {

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		System.out.println("Starting into Initiailze User Test case ");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("musiconlinebackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		System.out.println("Ending into Initialization user test case ");;
		
	
	}

	@Test
	public void createUserTest()
	{
		
		System.out.println("Starting into creating User Test case ");

Product product=new Product();
		

	product.setPid(111);
	product.setPname("Mobile");
	product.setPrice(5000);
	product.setStock(20);
	product.setPdescription("good product");

		
		assertTrue("problem in User", productDAO.addProduct(product));
		
		System.out.println("Ending..... into Createing User....");
		
	}
                                                                                                                                                                                                        

}
