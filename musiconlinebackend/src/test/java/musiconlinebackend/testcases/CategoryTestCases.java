package musiconlinebackend.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musiconlinebackend.dao.CategoryDAO;
import musiconlinebackend.model.Category;

public class CategoryTestCases 
{
static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		System.out.println("Starting into Initiailze Category Test case ");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("musiconlinebackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		System.out.println("Ending into Initialization category test case ");;
		
	
	}

	@Test
	public void createCategoryTest()
	{
		
		System.out.println("Starting into creating Category Test case ");
		Category category=new Category();
		
		category.setCid(200);
		category.setCname("santhu");
				
		assertTrue("problem in Category", categoryDAO.addCategory(category));
		
		System.out.println("Ending..... into Createing Category....");
		
	}
                         
}
