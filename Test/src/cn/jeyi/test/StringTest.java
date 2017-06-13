package cn.jeyi.test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// StringBuilder sb=new StringBuilder(10);
		// System.out.println(sb.capacity());
		// System.out.println(sb.length());
		//
		// //将string类型装换为其他各种类型
		// System.out.println(Integer.valueOf("0012"));
		// System.out.println(Byte.valueOf("0012"));
		// // System.out.println(Byte.valueOf("-0012.0"));
		// // System.out.println(Short.valueOf("12.5"));
		// System.out.println(Long.valueOf("12403"));
		//
		//
		// System.out.println(Character.isJavaIdentifierStart('π'));
		//
		//
		// long i=-35;
		// System.out.println(Integer.toBinaryString((int) i));
		// System.out.println(i>>2);
		// System.out.println(i>>34);
		//
		// int j=35;
		// System.out.println(j<<3);
		// System.out.println(j<<35);
		//
		// String s1="hello";
		// String s2="hello";
		// System.out.println(s1==s2);
		// s1=s1.substring(0, 2);
		// s2=s2.substring(0, 2);
		// System.out.println(s1==s2);
		//
		// String name= JOptionPane.showInputDialog("WTF?");
		// JOptionPane.showMessageDialog(null, name);
		//
		//
		//
		//
		// NumberFormat formatter=NumberFormat.getCurrencyInstance();
		// String s = formatter.format(i);
		// System.out.println(s);
		//
		// BigInteger tmp=BigInteger.valueOf(1);
		//
		// for(int i1=1;i1<89;++i1){
		// tmp=tmp.multiply(BigInteger.valueOf(i1));
		// }

		String str = "http://www.ccb.com/ccb.jsp--_";
		Pattern p = Pattern.compile("(http://)?[\\w.\\/-]{1,200}");
		Matcher m = p.matcher(str);
		boolean b = m.matches();

		System.out.println(b);

		BigDecimal be = new BigDecimal(53345.1700001);

		System.out.println(be.setScale(2, BigDecimal.ROUND_CEILING).toString());//
		
		System.out.println(sqrt("16.0"));
	

	}

	static BigInteger sqrt(String theNumber) {
		int length = theNumber.length(), i;
		BigInteger res = BigInteger.ZERO;
		BigInteger twenty = BigInteger.valueOf(20);
		BigInteger t, x = BigInteger.ZERO, v, few = BigInteger.ZERO;
		BigInteger hg = BigInteger.valueOf(100);
		String tmpString = null;
		int pos = 2 - length % 2;
		tmpString = theNumber.substring(0, pos);
		while (true) {
			v = few.multiply(hg).add(BigInteger.valueOf(Integer.parseInt(tmpString)));
			if (res.compareTo(BigInteger.ZERO) == 0)
				i = 9;
			else
				i = v.divide(res.multiply(twenty)).intValue();
			for (; i >= 0; i--) {
				t = res.multiply(twenty).add(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i));
				if (t.compareTo(v) <= 0) {
					x = t;
					break;
				}
			}
			res = res.multiply(BigInteger.TEN).add(BigInteger.valueOf(i));
			few = v.subtract(x);
			pos++;
			if (pos > length)
				break;
			tmpString = theNumber.substring(pos - 1, ++pos);
		}
		return res;
	}
	
	public static BigInteger factorial(int i){
		BigInteger res = new BigInteger("1");
		if(i <= 0){
			return BigInteger.valueOf(0);
		}else if(i==1){
			res = BigInteger.valueOf(1);
		}else{
			for (int j = 2; j <= i; j++) {
				res = res.multiply(BigInteger.valueOf(j));
			}
		}
		
		return res;
		
	}

}
