package spel;

import java.util.Random;

public class random {
	spelcore spel = new spelcore();
	public String random(String orderCode)
	{
		Random rd = new Random();
		String a = String.valueOf(rd.nextInt(9));
		String b = String.valueOf(rd.nextInt(9));
		String c = String.valueOf(rd.nextInt(9));
		String d = String.valueOf(rd.nextInt(9));
		String e = String.valueOf(rd.nextInt(9));
		String chuoi1 = spel.spelNoiChuoi(a, b);
		String chuoi2 = spel.spelNoiChuoi(chuoi1, c);
		String chuoi3 = spel.spelNoiChuoi(chuoi2, d);
		String chuoi4 = spel.spelNoiChuoi(chuoi3, e);
		String chuoi5 = spel.spelNoiChuoi(orderCode, chuoi4);
		return chuoi5;
	}
	
}	
