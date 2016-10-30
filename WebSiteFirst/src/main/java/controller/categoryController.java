package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import contextApplication.contextApplication;
import model.handlingCategory;

@Controller
@RequestMapping(value="website")
public class categoryController {
	private handlingCategory obhandlingcategory = new handlingCategory();
	private contextApplication context = new contextApplication();
	private String bean ="edaocategory";
	@RequestMapping(value="/admin/createcategory",method=RequestMethod.GET)
	public String createCategory()
	{
		return "createCategory";
	}
	@RequestMapping(value="/admin/createcategorynew",method=RequestMethod.POST)
	public String createCategoryNew(@RequestParam("name") String name,@RequestParam("status") String status,ModelMap mm)
	{
		handlingCategory hl = (handlingCategory) context.beanApplicationContext(obhandlingcategory, bean);
		boolean check = hl.insertCategory(name, status);
		System.out.println("In ra check ::::"+check);
		if(check == false)
		{
			mm.put("message1", "Create new category complete");
			return "redirect:/website/admin/category.html";
		}
		else
		{
			mm.put("message1", "Loi~");
			return "createCategory";
		}
		
	}
	@RequestMapping(value="/admin/deletecategory",method=RequestMethod.GET)
	public String deleteCategory(@RequestParam("categoryId") int categoryId)
	{
		System.out.println("xin chao moi nguoi");
		handlingCategory hl = (handlingCategory) context.beanApplicationContext(obhandlingcategory, bean);
		boolean check = hl.deleteCategory(categoryId);
		if(check)
		{
			return "redirect:/website/admin/category.html";
		}
		else
		{
			return "";
		}
		
	}
}
