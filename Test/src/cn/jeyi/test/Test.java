package cn.jeyi.test;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = 12.28;
		double b = 10.0;
		BigDecimal A = new BigDecimal("12.80");
		BigDecimal B = new BigDecimal("10");
		System.out.println(A.divide(B));

		System.out.println(a - b);

		double i = 50.0;
		double j = 50;
		System.out.println(Math.abs(i - j));

		System.out.println(Math.abs(50.0 - 50.0) < 0.00000001);

		System.out.println(BigDecimal.valueOf(1000).multiply(
				BigDecimal.valueOf(0.005).divide(BigDecimal.valueOf(1.005), 10,
						BigDecimal.ROUND_HALF_UP)).setScale(2,BigDecimal.ROUND_HALF_UP));
		
		
		Map<String, String> TRADETYPE = new HashMap<String, String>();
		TRADETYPE.put("0210021234", "老1");
		
		TRADETYPE.put("210021234", "老2");
		
		if(TRADETYPE.containsKey("210021")){
			System.out.println(TRADETYPE.get("210021"));
		}
		
		
	}

}
