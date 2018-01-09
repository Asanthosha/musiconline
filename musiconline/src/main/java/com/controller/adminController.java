package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bytebuddy.asm.Advice.Return;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import musiconlinebackend.daoimpl.CategoryDaoImpl;
import musiconlinebackend.daoimpl.ProductDaoImpl;
import musiconlinebackend.daoimpl.SupplierDaoImpl;
import musiconlinebackend.model.Category;
import musiconlinebackend.model.Product;
import musiconlinebackend.model.Supplier;



@Controller
@RequestMapping("/admin")			
public class adminController 
{
	//==================go to adding.jsp=================================
	@RequestMapping("/adding")
	public String addPage()
	{
		return "adding";
	}
	//=================index Page===================================
	@RequestMapping("/index")
	public String gotoindex()
	{
		return "index";
	}
	//==========================for saving category===========================
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@RequestMapping(value="/saveCat",method=RequestMethod.POST)
	@Transactional			//@Transactional which starts a transaction on each method start, 
							//and commits it on each method exit ( or rollback if method was failed due to an error).
	public ModelAndView saveCategory(@RequestParam("cid")int cid,@RequestParam("name")String name)
	{
		ModelAndView mav=new ModelAndView();
		Category cat=new Category();
		cat.setCid(cid);
		cat.setName(name);
		categoryDaoImpl.insertCategory(cat);
		mav.setViewName("modal");
		return mav;
	}
	
	
	//==================for saving supplier=====================================
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@RequestMapping(value="/saveSupp",method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveSupplier(@RequestParam("sid")int sid,@RequestParam("supplierName")String name)
	{
		ModelAndView mav=new ModelAndView();
		Supplier sup=new Supplier();
		sup.setSid(sid);
		sup.setSupplierName(name);
		supplierDaoImpl.insertSupplier(sup);
		mav.setViewName("index");
		return mav;
	}
	
	//========================Model Attibute=====================================================
	
	@ModelAttribute
	public void addAttributes(Model m)
	{
		m.addAttribute("catList", categoryDaoImpl.retrieve());
		m.addAttribute("satList",supplierDaoImpl.retrieve());
		m.addAttribute("prodList", productDaoImpl.retrieve());
	}
	
	//=======================For Saving Product============================
	@Autowired
	ProductDaoImpl productDaoImpl;
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProduct(HttpServletRequest request,@RequestParam("file") MultipartFile file)
	{
		
		Product prod=new Product();
		prod.setName(request.getParameter("pName"));
		prod.setPrice(Float.parseFloat(request.getParameter("pPrice")));
	//	prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		
		//for category
		prod.setCategory(categoryDaoImpl.findById(Integer.parseInt(request.getParameter("pCategory"))));
		
		//for supplier
		prod.setSupplier(supplierDaoImpl.findById(Integer.parseInt(request.getParameter("pSupplier"))));
		
		//for adding image
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImgname(filename);
		productDaoImpl.insertProduct(prod);
		System.out.println("file path file"+filepath+" "+filename);
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "index";
	}
	//=================Display Product list========================================
	@RequestMapping("/productList")
	public ModelAndView productList()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("prodlist", productDaoImpl.retrieve());
		mav.setViewName("productList");
		return mav;
	}
	
	//======================delete the product============================================
	@RequestMapping("/deleteProduct/{pid}")							
	public String deleteProd(@PathVariable("pid") int pid)
	{
		productDaoImpl.deleteProduct(pid);
		return "redirect:/admin/productList?del";
		
	}
	
	//===========================update product=====================================
	@RequestMapping("/updateProduct")									
	public ModelAndView updateProd(@RequestParam("id")int pid)
	{
		ModelAndView mav=new ModelAndView();
		Product p=productDaoImpl.findById(pid);
		mav.addObject("prod", p);
		mav.addObject("cList", categoryDaoImpl.retrieve());
		mav.addObject("sList", supplierDaoImpl.retrieve());
		mav.setViewName("updateProduct");
		return mav;
	}
	
	@RequestMapping(value="/productUpdate",method=RequestMethod.POST)
	public ModelAndView editProduct(HttpServletRequest request,@RequestParam("file") MultipartFile file)
	{
		ModelAndView mav=new ModelAndView();
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pName");
		String pcat=request.getParameter("pCategory");
		String psup=request.getParameter("pSupplier");
		String pprice=request.getParameter("pPrice");
		String pstock=request.getParameter("pStock");
		String pdesc=request.getParameter("pDescription");
		
		Product prod1=new Product();
		prod1.setId(Integer.parseInt(pid));
		prod1.setName(pname);
		prod1.setPrice(Float.parseFloat(pprice));
	///	prod1.setDescription(pdesc);
		prod1.setStock(Integer.parseInt(pstock));
		
		//for category
		prod1.setCategory(categoryDaoImpl.findById(Integer.parseInt(pcat)));
		
		//for supplier
		prod1.setSupplier(supplierDaoImpl.findById(Integer.parseInt(psup)));
		
		//for adding image
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod1.setImgname(filename);
		productDaoImpl.insertProduct(prod1);
		System.out.println("file path file "+filepath+" "+filename);
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		mav.setViewName("redirect:/admin/productList?update");
		return mav;
	}
	
	//=================Display Category list for admin========================================
		@RequestMapping("/categoryList")
		public ModelAndView categoryList()
		{
			ModelAndView mav=new ModelAndView();
			mav.addObject("catList", categoryDaoImpl.retrieve());
			mav.setViewName("categoryList");
			return mav;
		}
		//===============delete category=====================================================
		@RequestMapping("/deleteCategory/{cid}")					
		public String deleteCat(@PathVariable("cid") int cid)
		{
			categoryDaoImpl.deleteCategory(cid);
			return "redirect:/admin/categoryList?del";
			
		}
		//============================update category===================================
		@RequestMapping("/updateCategory")								
		public ModelAndView updateCat(@RequestParam("cid")int cid)
		{
			ModelAndView mav=new ModelAndView();
			Category c=categoryDaoImpl.findById(cid);
			mav.addObject("cat", c);
			//mav.addObject("cList", categoryDaoImpl);
			//mav.addObject("sList", supplierDaoImpl);
			mav.setViewName("updateCategory");
			return mav;
		}
		
		@RequestMapping(value="/categoryUpdate",method=RequestMethod.POST)
		public ModelAndView editCategory(HttpServletRequest request)
		{
			ModelAndView mav=new ModelAndView();
			String cid=request.getParameter("cid");
			String name=request.getParameter("name");
						
			Category cat1=new Category();
			cat1.setCid(Integer.parseInt(cid));
			cat1.setName(name);	
			categoryDaoImpl.updateCategory(cat1);
			mav.setViewName("redirect:/admin/categoryList?update");
			return mav;
		}
		//==========================Display supplier list for admin==========================================
		@RequestMapping("/supplierList")
		public ModelAndView supplierList()
		{
			ModelAndView mav=new ModelAndView();
			mav.addObject("supList", supplierDaoImpl.retrieve());
			mav.setViewName("supplierList");
			return mav;
		}
		//===================delete supplier==========================================
		@RequestMapping("/deleteSupplier/{sid}")							
		public String deleteSup(@PathVariable("sid") int sid)
		{
			supplierDaoImpl.deleteSupplier(sid);
			return "redirect:/admin/supplierList?del";
			
		}
		//=================================update supplier======================================
		@RequestMapping("/updateSupplier")									
		public ModelAndView updateSup(@RequestParam("sid")int sid)
		{
			ModelAndView mav=new ModelAndView();
			Supplier s=supplierDaoImpl.findById(sid);
			mav.addObject("sup",s);
			//mav.addObject("sList", supplierDaoImpl);
			mav.setViewName("updateSupplier");
			return mav;
		}
		
		@RequestMapping(value="/supplierUpdate",method=RequestMethod.POST)
		public ModelAndView editSupplier(HttpServletRequest request)
		{
			ModelAndView mav=new ModelAndView();
			String sid=request.getParameter("sid");
			String name=request.getParameter("supplierName");
						
			Supplier sup=new Supplier();
			sup.setSid(Integer.parseInt(sid));
			sup.setSupplierName(name);	
			supplierDaoImpl.update(sup);
			mav.setViewName("redirect:/admin/supplierList?update");
			return mav;
		}
	
}