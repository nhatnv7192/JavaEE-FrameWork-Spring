package contextApplication;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import entities.product;

public class handlingFileUpload {
	private String uploadDirectory = "C:/Users/Nhat/Documents/workspace-sts-3.8.1.RELEASE/WebSiteFirst/src/main/webapp/images";
	private ServletContext context;
	private selectDirectoryUploadFile obSelectDirectory = new selectDirectoryUploadFile();
	public boolean uploadFile(CommonsMultipartFile file,HttpServletRequest request,String description)
	{
		//get pathReal
		context = request.getServletContext();
//		String path = context.getRealPath(uploadDirectory);
//		String pathnew = context.getContextPath();
		//get name file
		String filename = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		//write file 
		try 
		{
			String uploadDirectoryNew = obSelectDirectory.selectDirectoryServer(uploadDirectory, description);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uploadDirectoryNew) + File.separator +filename));
//			System.out.println(path+File.separator+filename);
//			System.out.println("pathnew :"+pathnew);
			System.out.println(uploadDirectory);
			stream.write(bytes);
			stream.flush();
			stream.close();
			return true;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean checkNameImage(List<product> listProduct,String imageUrl)
	{
		for (product product : listProduct) {
			if(product.getImageUrl().equals(imageUrl))
			{
				return true;
			}
		}
		return false;
	}
}
