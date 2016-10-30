package spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class spelcore {
	private ExpressionParser parser = new SpelExpressionParser();
	private Expression exp;
	public String spelNoiChuoi(String chuoi1,String chuoi2)
	{
		exp = parser.parseExpression("'"+chuoi1+"'.concat('"+chuoi2+"')");
		String chuoi = (String) exp.getValue();
		return chuoi;
	}
	public byte[] spelDocStringSangByte(String chuoi)
	{
		exp = parser.parseExpression("'"+chuoi+"'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
		return bytes;
	}
	public int spelLengthChuoi(String chuoi)
	{
		exp = parser.parseExpression("'"+chuoi+"'.bytes.length");
		int length = (Integer) exp.getValue();
		return length;
	}
	public String spelUpperCase(String chuoi)
	{
		exp = parser.parseExpression("'"+chuoi+"'.toUpperCase()");
		String upperCase = (String) exp.getValue();
		return upperCase;
	}
	public boolean spelSosanhLength(String chuoi,int length)
	{
		exp = parser.parseExpression("'"+chuoi+"'.length() =="+length+"");
		boolean check = (Boolean) exp.getValue();
		return check;
	}

}
