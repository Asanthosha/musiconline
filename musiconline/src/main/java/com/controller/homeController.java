package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import musiconlinebackend.daoimpl.CategoryDaoImpl;
import musiconlinebackend.daoimpl.ProductDaoImpl;
import musiconlinebackend.daoimpl.SupplierDaoImpl;
import musiconlinebackend.daoimpl.UserDaoImpl;
import musiconlinebackend.model.Product;
import musiconlinebackend.model.User;


@SuppressWarnings("unused")
@Controller
public class homeController 
{
	@Autowired
	UserDaoImpl userDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	//================Index page(Root)=============================================
	@RequestMapping("/")			
	public String index(Model m)
	{
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		return "index";
	}
	@RequestMapping("/index")
	public String home(Model m)
	{
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		return "index";
	}
		
	@ModelAttribute
	public void addAttributes(Model m)
	{
		m.addAttribute("catlist", categoryDaoImpl.retrieve());
		m.addAttribute("satlist",supplierDaoImpl.retrieve());
		m.addAttribute("productCustList", productDaoImpl.retrieve());
	}
	
	
	//===================after click on login (it go to login.jsp)=======================
	@RequestMapping("/goToLogin")
	public ModelAndView goToLogin(Model m)
	{
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	//============================Mapping of registration form===================================================
	@RequestMapping(value= "/register",method= RequestMethod.GET)
	public ModelAndView showRegister()
	{
		System.out.println("this is registration form.....");
		ModelAndView mav=new ModelAndView();
		mav.addObject("user", new User());
		mav.setViewName("register");
		return mav;
	}
	//=================for saving registration........(Inserting data into database)==============================================
	@RequestMapping(value= "/saveregister",method= RequestMethod.POST)
	public ModelAndView saveRegister(@Valid @ModelAttribute("user") User user,BindingResult result)
	{
		ModelAndView mav=new ModelAndView();
		System.out.println("save registration form........");
		if(result.hasErrors())
		{
			
			mav.setViewName("register");
			return mav;
		}
		else
		{
			user.setRole("ROLE_USER");
			userDaoImpl.insertUser(user);
			mav.setViewName("redirect:/goToLogin");	//will redirect to goToLogin request mapping  
			return mav;
		}
		
	}
	//=====================contact us==============================================
	@RequestMapping("/contactus")
	public String contactus(Model m)
	{
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		return "contactus";
	}
	
	
	//================display product list to the client/customer=================================
	@RequestMapping("/productCustList")
	public ModelAndView productCustList(@RequestParam("cid") int cid)
	{
		System.out.println("###########################"+cid);
		ModelAndView mav=new ModelAndView();
		mav.addObject("productList",productDaoImpl.getProdById(cid));
		mav.setViewName("productCustomerList");
		return mav;
	}
	//==================Dislay product details=====================================
	//@PathVariable= puts URL data into variable
	@RequestMapping(value= "/productDetails/{cid}")
	public ModelAndView prodDetails(@PathVariable("cid") int cid)
	{
		ModelAndView mav=new ModelAndView();
		Product product=productDaoImpl.findById(cid);
		mav.addObject("product", product);
		mav.setViewName("productDetails");
		return mav;
	}

	//===================Error Page===========================================================
	@RequestMapping("/error")
	public ModelAndView errorPage()
	{
		System.out.println("######################This is error page......##########################");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/error");
		return mav;
	}
	//================user login successfully====================================
	@RequestMapping("/userLogged")
	public ModelAndView userLogg(Model m)
	{
		
		System.out.println("#######################Successfull login.....!!!!!!#####################");
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/index");
		return mav;
	}
	
	/*@RequestMapping(value = "/goTologin", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) 
	{

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;

	}*/
	
	
}