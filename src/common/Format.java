package common;

import java.text.*;

public class Format {
//	按自定义格式输出图书价格
	public static String numFormat(double num){
		DecimalFormat df = new DecimalFormat("¤#######0.00");
		String dff = df.format(num);
		return dff;	
	}

}
