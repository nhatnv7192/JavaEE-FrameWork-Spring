package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import contextApplication.MailHelper;
import contextApplication.contextApplication;
import entities.Item;
import entities.orderDetails;
import entities.product;
import model.Cart;
import model.handlingOrder;
import model.handlingProduct;
import spel.random;
import spel.spelcore;

@Controller
@RequestMapping(value="/website")
public class cartController {
	private contextApplication context = new contextApplication();
	private handlingProduct obhandlingProduct = new handlingProduct();
	private handlingOrder obhandlingOrder = new handlingOrder();
	private String bean = "edaoproduct";
	private String beanOrder = "edaoorder";
	@RequestMapping(value="/pluscart",method=RequestMethod.GET)
	public String plusCart(@RequestParam("productId") int productId,HttpSession session,HttpServletRequest request)
	{
		System.out.println("in ra idproduct :"+productId);
		//
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		product product = ob.selectDetail(productId);
		session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart.getCartItems().containsKey(productId))
		{
			cart.plusToCart(productId, new Item(product, cart.getCartItems().get(productId).getQuantity()));
		}
		else
		{
			cart.plusToCart(productId, new Item(product, 1));
		}
		
		session.setAttribute("cart", cart);
		
		return "redirect:/website/index.html";
	}
	@RequestMapping(value="/category/pluscartnew",method=RequestMethod.GET)
	public String plusCartNew(@RequestParam("productId") int productId,HttpSession session,HttpServletRequest request)
	{
		System.out.println("in ra idproduct :"+productId);
		//
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		product product = ob.selectDetail(productId);
		session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart.getCartItems().containsKey(productId))
		{
			cart.plusToCart(productId, new Item(product, cart.getCartItems().get(productId).getQuantity()));
		}
		else
		{
			cart.plusToCart(productId, new Item(product, 1));
		}
		
		session.setAttribute("cart", cart);
		
		return "redirect:/website/category/1.html?arrange=";
	}
	@RequestMapping(value="/removecart",method=RequestMethod.GET)
	public String removeCart(@RequestParam("productId") int productId,HttpSession session,HttpServletRequest request)
	{
		Cart cart = (Cart) session.getAttribute("cart");
		
		cart.removeCart(productId);
		session.setAttribute("cart", cart);
		
		return "redirect:/website/index.html";
		
		
	}
	@RequestMapping(value="/pluscartdetail",method=RequestMethod.GET)
	public String plusCartDetail(@RequestParam("productId") int productId,HttpSession session,HttpServletRequest request)
	{
		//
		
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
		product product = ob.selectDetail(productId);
		session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart.getCartItems().containsKey(productId))
		{
			cart.plusToCart(productId, new Item(product, cart.getCartItems().get(productId).getQuantity()));
		}
		else
		{
			cart.plusToCart(productId, new Item(product, 1));
		}
		
		session.setAttribute("cart", cart);
		return "redirect:/website/detail.html?productId="+productId;
	}
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String order(HttpServletRequest request,HttpSession session)
	{
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
		Date date = new Date();
		double shippingCost = 30000;
		//random orderCode
		random rd = new random();
		String orderCode = rd.random("00000");
		String today = dateFormat.format(date);
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		//new Contruster Ob Order
		entities.order order = new entities.order(orderCode, today, shippingCost, name, phone, address, email);
		
		//insert Order
		handlingOrder ob = (handlingOrder) context.beanApplicationContext(obhandlingOrder, beanOrder);
		boolean check = ob.insertOrder(order);
		if(check == true)
		{
			return "404";
		}
		else
		{
			//send Email
			MailHelper mail = new MailHelper();
			mail.sendEmailSend(email);
			//select orderCode
			session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			int orderCodenew = (ob.selectOrderId(orderCode));
			for(Map.Entry<Integer, Item> list:cart.getCartItems().entrySet())
			{
				ob.insertOrderDetail(orderCodenew, list.getValue().getProduct().getProductId(), list.getValue().getQuantity(), list.getValue().getProduct().getPrice(), list.getValue().getProduct().getDiscount());
			}
			session.invalidate();
			return "redirect:/website/index.html";
		}
		
	}
	@RequestMapping(value="/admin/selectorder")
	public String selectOrder(ModelMap mm)
	{
		handlingOrder ob = (handlingOrder) context.beanApplicationContext(obhandlingOrder, beanOrder);
		List<entities.order> orderProduct = ob.selectOrder();
		mm.put("orderProduct",orderProduct);
		return "selectorder";
	}
	@RequestMapping(value="/orderdetails")
	public String selectOrderDetails(@RequestParam("orderId") int orderId,ModelMap mm)
	{
		handlingOrder ob = (handlingOrder) context.beanApplicationContext(obhandlingOrder, beanOrder);
		List<orderDetails> listOrderDetails = ob.selectorderDetails(orderId); 
		mm.put("listOrderDetails", listOrderDetails);
		return "orderdetails";
	}
}
