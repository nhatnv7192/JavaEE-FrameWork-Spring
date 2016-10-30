package controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import contextApplication.MailHelper;
import contextApplication.contextApplication;
import entities.category;
import entities.product;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.handlingCategory;
import model.handlingProduct;
@Controller
@RequestMapping(value="website")
public class viewDemo {
	private contextApplication context = new contextApplication();
	private handlingProduct obhandlingProduct = new handlingProduct();
	private handlingCategory obhandlingCategory = new handlingCategory();
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String view1(ModelMap mm,HttpSession session)
	{
		String bean ="edaoproduct";
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		
		String query = "select * from product";
		List<product> listProduct = ob.selectProduct(query);
		String queryTop12 = "select * from product where description='new' limit 6";
		List<product> listTop12	 = ob.selectProduct(queryTop12);
		
		//special product ramdom
		String querySpecial1 = "select * from product where description='special offer' order by rand() limit 3";
		List<product> listSpecial1 = ob.selectProduct(querySpecial1);
		
		String querySpecial2 = "select * from product where description='special offer' order by rand() limit 3";
		List<product> listSpecial2	 = ob.selectProduct(querySpecial2);
		
		String querySpecial3 = "select * from product where description='special offer' order by rand() limit 3";
		List<product> listSpecial3	 = ob.selectProduct(querySpecial3);
		
		String queryClotherTop6 = "select * from product where (categoryId='1' and description='new') limit 6";
		List<product> listProductNewTop6 = ob.selectProduct(queryClotherTop6);
		
		String queryElectonicTop6 = "select * from product where(categoryId='2' and description='new') limit 6";
		List<product> listElectronic6 = ob.selectProduct(queryElectonicTop6);
		
		String queryShoesTop6 = "select * from product where(categoryId='3' and description='new') limit 6";
		List<product> listShoes6 = ob.selectProduct(queryShoesTop6);
		
		String queryFeatureTop6 = "select * from product where(description='feature') limit 6";
		List<product> listFeature6= ob.selectProduct(queryFeatureTop6);
		
		String queryBestSell = "select * from product order by rand() limit 2";
		List<product> listBestSell = ob.selectProduct(queryBestSell);
		
		mm.put("listProduct", listProduct);
		if(session.isNew())
		{
			session.setAttribute("listProduct", listProduct);
		}
		mm.put("listSpecial1",listSpecial1);
		mm.put("listSpecial2",listSpecial2);
		mm.put("listSpecial3",listSpecial3);
		mm.put("listProductTop12", listTop12);
		mm.put("listProductNewTop6",listProductNewTop6);
		mm.put("listElectronic6", listElectronic6);
		mm.put("listShoes6", listShoes6);
		mm.put("listFeature6", listFeature6);
		mm.put("listBestSell", listBestSell);
		return "home";
	}
	@RequestMapping(value="/admin/{idPage}",method=RequestMethod.GET)
	public String viewAdmin(ModelMap mm,@PathVariable int idPage,@RequestParam("select") String select,Principal principal)
	{
		
		int total = 7;
		int idpage = idPage;
		if(idPage == 1)
		{}
		else
		{
			idPage = (idPage -1) * total + 1;
		}
		List<product> listProduct = null;
		String bean = "edaoproduct";
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		if(select.equals(""))
		{
			listProduct = ob.select10RecordProduct(idPage-1, total);
		}
		else
		{
			
			 listProduct = ob.select10RecordProduct(idPage-1, total,select);
			
		}
		
		//get username login
		String username = principal.getName();
		mm.put("listProduct", listProduct);
		mm.put("idpage", idpage);
		mm.put("username", username);
		return "admin";
	}
	@RequestMapping(value="/admin/category.html",method=RequestMethod.GET)
	public String managerCategory(ModelMap mm)
	{
		String bean="edaocategory";
		handlingCategory ob = (handlingCategory) context.beanApplicationContext(obhandlingCategory, bean);
		List<category> listCategory = ob.selectCategory();

		mm.put("listCategory", listCategory);	
		return "categoryAdmin";
	}
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public String login(ModelMap mm)
	{
		return "login";
	}
	@RequestMapping(value="/loginfailed",method=RequestMethod.GET)
	public String loginFailed()
	{
		return "loginfailed";
	}
	//Redirect trang
	@RequestMapping(value="/category/{idPage}",method=RequestMethod.GET)
	public String viewCategory(@PathVariable("idPage") int idPage,@RequestParam("arrange") String arrange,ModelMap mm)
	{
		String bean = "edaoproduct";
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		String query = null;
		int recordStart = (idPage - 1)*12;
		int recordEnd = idPage * 12;
		if(arrange =="")
		{
			query = "select * from product limit "+recordStart+","+recordEnd+"";
		}
		else
		{
			query = "select * from product where description='"+arrange+"' limit "+recordStart+","+recordEnd+"";
		}
		List<product> listProduct = ob.selectProduct(query);
		
		mm.put("listProduct", listProduct);
		return "category";
	}
	@RequestMapping(value="/checkout",method=RequestMethod.GET)
	public String viewCheckout()
	{
		return "checkout";
	}
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String viewContact()
	{
		return "contact";
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String viewDetail(@RequestParam("productId") int productId,HttpSession session,ModelMap mm)
	{
		
		List<product> listProduct = (List<product>) session.getAttribute("listProduct");
		String bean = "edaoproduct";
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		product productDetail = ob.selectDetail(productId);
		mm.put("productDetail", productDetail);
		
		mm.put("listProduct", listProduct);
		return "detail";
	}
	@RequestMapping(value="/faq",method=RequestMethod.GET)
	public String viewFaq()
	{
		return "faq";
	}
	@RequestMapping(value="/my-wishlist",method=RequestMethod.GET)
	public String viewMyWishtList()
	{
		return "my-wishlist";
	}
	@RequestMapping(value="/product-comparison",method=RequestMethod.GET)
	public String viewProductComparison()
	{
		return "product-comparison";
	}
	@RequestMapping(value="/shopping-cart",method=RequestMethod.GET)
	public String viewShoppingCart()
	{
		
		return "shopping-cart";
	}
	@RequestMapping(value="/sign-in",method=RequestMethod.GET)
	public String viewSingIn()
	{
		return "sign-in";
	}
	@RequestMapping(value="/terms-conditions",method=RequestMethod.GET)
	public String viewTermCondition()
	{
		return "terms-conditions";
	}
	@RequestMapping(value="/track-orders",method=RequestMethod.GET)
	public String viewTrackOrder()
	{
		return "track-orders";
	}
	@RequestMapping(value="/blog",method=RequestMethod.GET)
	public String viewBlog()
	{
		return "blog";
	}
	@RequestMapping(value="/blog-details",method=RequestMethod.GET)
	public String viewBlogDetail()
	{
		return "blog-details";
	}
	@RequestMapping(value="/404",method=RequestMethod.GET)
	public String view404()
	{
		return "404";
	}
}
