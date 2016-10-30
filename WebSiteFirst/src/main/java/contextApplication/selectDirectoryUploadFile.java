package contextApplication;

import spel.spelcore;

public class selectDirectoryUploadFile {
	String directoryImage;
	String directory;
	private spelcore spel = new spelcore();
	public String selectDirectory(String description,String nameFile)
	{
		
		if(description.equals("hot deals"))
		{
			directory = "../images/product_hotdeals/";
			directoryImage = spel.spelNoiChuoi(directory, nameFile);
			
		}
		else if(description.equals("special offer"))
		{
			directory = "../images/product_special/";
			directoryImage = spel.spelNoiChuoi(directory, nameFile);
		}
		else if(description.equals("new"))
		{
			directory = "../images/product_new/";
			directoryImage = spel.spelNoiChuoi(directory, nameFile);
		}
		else if(description.equals("feature"))
		{
			directory = "../images/product_feature/";
			directoryImage = spel.spelNoiChuoi(directory, nameFile);
		}
		else if(description.equals("arrivals"))
		{
			directory = "../images/product_new/arrivals/";
			directoryImage = spel.spelNoiChuoi(directory, nameFile);
		}
		return directoryImage;
	}
	public String selectDirectoryServer(String uploadDirectory,String description)
	{
		
		if(description.equals("hot deals"))
		{
			directory = "/product_hotdeals/";
			directoryImage = spel.spelNoiChuoi(uploadDirectory, directory);
			
		}
		else if(description.equals("special offer"))
		{
			directory = "/product_special/";
			directoryImage = spel.spelNoiChuoi(uploadDirectory, directory);
		}
		else if(description.equals("new"))
		{
			directory = "/product_new/";
			directoryImage = spel.spelNoiChuoi(uploadDirectory, directory);
		}
		else if(description.equals("feature"))
		{
			directory = "/product_feature/";
			directoryImage = spel.spelNoiChuoi(uploadDirectory, directory);
		}
		else if(description.equals("arrivals"))
		{
			directory = "/product_new/arrivals/";
			directoryImage = spel.spelNoiChuoi(uploadDirectory, directory);
		}
		return directoryImage;
	}
}
