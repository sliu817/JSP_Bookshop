package common;

import java.text.*;

public class Format {
//	���Զ����ʽ���ͼ��۸�
	public static String numFormat(double num){
		DecimalFormat df = new DecimalFormat("��#######0.00");
		String dff = df.format(num);
		return dff;	
	}

}
