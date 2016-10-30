package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

import javax.servlet.http.*;

import contextApplication.contextApplication;
import contextApplication.handlingFileUpload;
import contextApplication.selectDirectoryUploadFile;
import entities.category;
import entities.product;
import model.handlingCategory;
import model.handlingProduct;

@Controller
@RequestMapping(value = "/website")
public class productController {
	private contextApplication context = new contextApplication();
	private handlingProduct obhandlingProduct = new handlingProduct();
	private handlingCategory obhanglingCategory = new handlingCategory();
	private handlingFileUpload obhandlingfileupload = new handlingFileUpload();
	private selectDirectoryUploadFile obSelectDirectoryUploadFile = new selectDirectoryUploadFile();
	private String bean = "edaoproduct";
	private String beannew = "edaocategory";

	@RequestMapping(value = "/detailproduct", method = RequestMethod.GET)
	public String viewDetail(@RequestParam("productId") int productId, ModelMap mm) {
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);

		product product = ob.selectDetail(productId);
		mm.put("product", product);
		return "detailProduct";
	}

	@RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
	public String viewDelete(@RequestParam("productId") int productId, @RequestParam("idPage") int idPage) {
		handlingProduct ob = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);

		ob.deleteProduct(productId);
		return "redirect:/website/admin/" + idPage + ".html?select=";
	}

	@RequestMapping(value = "/createproductget", method = RequestMethod.GET)
	public String createProductGet(HttpSession session,ModelMap mm) {
		handlingCategory ob = (handlingCategory) context.beanApplicationContext(obhanglingCategory, beannew);
		List<category> listCategory = ob.selectCategory();
		if(session.isNew())
		{
			session.setAttribute("listCategory",listCategory);
		}
		mm.put("listCategory", listCategory);

		return "createProduct";
	}

	@RequestMapping(value = "/createproduct", method = RequestMethod.POST)
	public String createProduct(HttpSession session, @RequestParam("imageUrl") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse res, ModelMap mm) {
		String name = request.getParameter("name");
		if (name.equals("")) {
			mm.put("message1", "De nghi nhap day du thong tin");
			return "createProduct";
		} else {
			// insert vao database

			int categoryId = Integer.parseInt(request.getParameter("selectCategory"));
			float price = Float.parseFloat(request.getParameter("price"));
			int discount = Integer.parseInt(request.getParameter("selectDiscount"));
			String status = request.getParameter("selectStatus");
			String description = request.getParameter("selectDescription");

			String imageUrl = file.getOriginalFilename();
			System.out.println("In ra ten file :" + imageUrl);
			// check name images in valid?
			List<product> listProduct = (List<product>) session.getAttribute("listProduct");
			String imageUrlNew = obSelectDirectoryUploadFile.selectDirectory(description, imageUrl);

			boolean checkName = obhandlingfileupload.checkNameImage(listProduct, imageUrlNew);
			if (checkName == true) {
				List<category> listCategory = (List<category>) session.getAttribute("listCategory");
				mm.put("listCategory", listCategory);
				mm.put("message2", "Ten images bi trung,vui long doi lai ten images.....");
				return "createProduct";
			} else {
				// file Upload
				handlingFileUpload hlfile = new handlingFileUpload();
				boolean checkfile = hlfile.uploadFile(file, request, description);

				// insert database
				product product = new product(categoryId, name, price, discount, status, imageUrlNew, description);

				handlingProduct hl = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
				boolean check = hl.insertProduct(product);
				System.out.println(check);
				if (check) {
					mm.put("message", "Loi~ :");
					return "createProduct";
				} else {
					mm.put("message", " :Them san pham thanh cong ....."+name+"");
					return "redirect:/website/admin/1.html?select=''";
				}
			}
		}
	}
	@RequestMapping(value = "/editproductget", method = RequestMethod.GET)
	public String editProductGet(HttpSession session,@RequestParam("productId") String productId,@RequestParam("name") String name,@RequestParam("price") String price,ModelMap mm) {
		handlingCategory ob = (handlingCategory) context.beanApplicationContext(obhanglingCategory, beannew);
		String query = "select(name) from category";
		List<category> listCategory = ob.selectCategory();
		mm.put("listCategory", listCategory);
		if(session.isNew())
		{
			session.setAttribute("listCategory", listCategory);
		}
		mm.put("name",name);
		mm.put("price",price);
		mm.put("productId", productId);
		return "editProduct";
	}
	@RequestMapping(value = "/editproduct", method = RequestMethod.POST)
	public String editProduct(HttpSession session,@RequestParam("productId") int productId, @RequestParam("imageUrl") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse res, ModelMap mm) {
		String name = request.getParameter("name");
		if (name.equals("")) {
			
			mm.put("message1", "De nghi nhap day du thong tin");
			return "createProduct";
		} else {
			// insert vao database

			int categoryId = Integer.parseInt(request.getParameter("selectCategory"));
			float price = Float.parseFloat(request.getParameter("price"));
			int discount = Integer.parseInt(request.getParameter("selectDiscount"));
			String status = request.getParameter("selectStatus");
			String description = request.getParameter("selectDescription");

			String imageUrl = file.getOriginalFilename();
			System.out.println("In ra ten file :" + imageUrl);
			// check name images in valid?
			List<product> listProduct = (List<product>) session.getAttribute("listProduct");
			String imageUrlNew = obSelectDirectoryUploadFile.selectDirectory(description, imageUrl);

			boolean checkName = obhandlingfileupload.checkNameImage(listProduct, imageUrlNew);
			if (checkName == true) {
				List<category> listCategory = (List<category>) session.getAttribute("listCategory");
				mm.put("listCategory", listCategory);
				mm.put("message2", "Ten images bi trung,vui long doi lai ten images.....");
				return "createProduct";
			} else {
				// file Upload
				handlingFileUpload hlfile = new handlingFileUpload();
				boolean checkfile = hlfile.uploadFile(file, request, description);

				// insert database
				product product = new product(categoryId, name, price, discount, status, imageUrlNew, description);

				handlingProduct hl = (handlingProduct) context.beanApplicationContext(obhandlingProduct, bean);
				boolean check = hl.updateProduct(product,productId);
				System.out.println(check);
				if (check) {
					mm.put("message", "Loi~ :");
					return "createProduct";
				} else {
					mm.put("message", " :update san pham thanh cong ....."+name+"");
					return "redirect:/website/admin/1.html?select=''";
				}
			}
		}
	}
	
}
