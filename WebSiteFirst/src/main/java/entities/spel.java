package entities;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class spel {
	private static ExpressionParser parser = new SpelExpressionParser();
	private static Expression exp;
	public static void spelNoichuoi(String a,String b)
	{
		
		exp = parser.parseExpression("'"+a+"'.concat('"+b+"')");
		String message = (String) exp.getValue();
		System.out.println("String a :"+a);
		System.out.println("String a :"+b);
		System.out.println("----------------------");
		System.out.println("String ghep :"+message);
	}
	public static void spelNoibien(String name)
	{
		exp = parser.parseExpression("'"+name+"'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
		for(int i=0 ; i < bytes.length ; i++)
		{
			System.out.println(bytes[i]);
		}
	}
	public static void spelGiveLength(String name)
	{
		
		exp = parser.parseExpression("'"+name+"'.bytes.length");
		int length = (Integer) exp.getValue();
		System.out.println(length);
	}
	public static void spelUppercase(String name)
	{
		exp = parser.parseExpression("'"+name+"'.toUpperCase()");
		String upperCase = (String) exp.getValue();
		System.out.println(upperCase);
	}
	public static void spelSumTwoString(String chuoi1,String chuoi2)
	{
		exp = parser.parseExpression("'"+chuoi1+"'+'"+chuoi2+"'");
		String chuoi = (String) exp.getValue();
		System.out.println(chuoi);
	}
	public static void spelOperator(float a,float b)
	{
		exp = parser.parseExpression("("+a+"+"+b+")/2");
		double c = (Double) exp.getValue();
		System.out.println(c);
	}
	public static void spelSosanhLength(String chuoi, int length)
	{
		exp = parser.parseExpression("'"+chuoi+"'.length() =="+length+"");
		boolean check = (Boolean) exp.getValue();
		System.out.println(check);
	}
	public static void main(String[] args) {
//		spelNoichuoi("Nguyen Van Nhat", "My Linh");
//		spelNoibien("Nguyen Van Nhat");
//		spelGiveLength("Nguyen Van Nhat");
//		spelUppercase("nguyen van Nhat");
//		spelSumTwoString("Nguyen Van Nhat", "My Linh");
//		spelOperator(10, 7);
		spelSosanhLength("Nguyen Van Nhat", 15);
	}
}
