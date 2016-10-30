package contextApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class contextApplication {
	private ApplicationContext context;	
	private String xml = "../applicationContext.xml";
	public Object beanApplicationContext(Object ob,String bean)
	{
		context = new ClassPathXmlApplicationContext(xml);
		ob = context.getBean(bean);
		return ob;
	}
}
