package musiconlinebackend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musiconlinebackend.dao.SupplierDAO;
import musiconlinebackend.model.Supplier;


public class SupplierTestcases {

	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		System.out.println("Starting into Initiailze Supplier Test case ");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("musiconlinebackend");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		System.out.println("Ending into Initialization supplier test case ");;
		
	
	}

	@Test
	public void createSupplierTest()
	{
		
		System.out.println("Starting into creating Supplier Test case ");
		Supplier supplier=new Supplier();
		
		supplier.setSid(1000);
		supplier.setSname("santhu");
		
				
		assertTrue("problem in User", supplierDAO.addSupplier(supplier));
		
		System.out.println("Ending..... into Createing Supplier....");
		
	}
                                                                                                                                                                                                        

}

