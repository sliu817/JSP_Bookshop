package common;

import java.text.*;

public class Format {
	public static String numFormat(double num){
		DecimalFormat df = new DecimalFormat("$#######0.00");
		String dff = df.format(num);
		return dff;	
	}

}
