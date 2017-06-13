package cn.hdu.acm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;


/**
 * 
 * @version 2016-12-30
 * @author zhoujianyi
 *
 */
public class P1007 {
	
	
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		int n;
		BigDecimal[][] points = new BigDecimal[100000][2];
		
		
		
		int X,Y;
		int x,y;
		
		BigDecimal tmax;
		BigDecimal amax;
		BigDecimal MAX;
		
		while (cin.hasNextInt()) {
			n = cin.nextInt();
			if (n > 2) {
				
				HashMap dist = new HashMap(n*(n-1)/2);
				
				MAX = new BigDecimal("0");
				X=Y=0;

				for (int i = 0; i < n; ++i) {
					points[i][0] = cin.nextBigDecimal();
					points[i][1] = cin.nextBigDecimal();
				}
				// System.out.println(is[0] + " " + is[1]);
				for (int i = 0; i < n-1; ++i) {  //从第一个点开始到第n-1个，算每个点和其他点的距离
					amax = BigDecimal.valueOf(0);
					x=y=0;
					for (int j = i + 1; j < n; ++j) {
						BigDecimal d1 = points[i][0].subtract(points[j][0]);
						BigDecimal d2 = points[i][1].subtract(points[j][1]);
						
						tmax = (d1.multiply(d1)).add(d2.multiply(d2));
						
						//取第i个点到其他点的最大值
						
						if(tmax.compareTo(amax) > 0){
							amax=tmax;
							x=i;
							y=j;
						}
					}
					
					//取每个最大值中的最大值,也就是找到距离最大的两个点
					if(MAX.compareTo(amax) < 0 ){
						MAX=amax;
						X=x;
						Y=y;
					}
				}
				
				MAX = BigDecimal.valueOf(0);
				
				//这两个点和其他的点组成圆，找到最大的半径即可
				for(int i=0;i<n;++i){
					if(i != X && i!=Y){
						
						//计算圆心到点的距离，即半径
						amax= calculate_cicular(points[X][0],points[X][1],points[Y][0],points[Y][1],points[i][0],points[i][1]);
						
						
						if(MAX.compareTo(amax) < 0){
							MAX=amax;
						}
					}
					
				}
				
				MAX = new BigDecimal(Math.sqrt(MAX.doubleValue()));
				
				System.out.println(MAX.setScale(2, BigDecimal.ROUND_CEILING));
			}else if(n==2){
				BigDecimal x1 = cin.nextBigDecimal();
				BigDecimal y1 = cin.nextBigDecimal();
				BigDecimal x2 = cin.nextBigDecimal();
				BigDecimal y2 = cin.nextBigDecimal();
				
				tmax= x1.subtract(x2).pow(2);
				amax= y1.subtract(y2).pow(2);
				MAX = BigDecimal.valueOf(Math.sqrt(tmax.add(amax).doubleValue()));
				
				System.out.println(MAX.divide(new BigDecimal("2.0")).setScale(2, BigDecimal.ROUND_CEILING));
				
			}

			else {
				return;
			}
		}
	}
	
	
	static BigDecimal calculate_cicular(BigDecimal x1,BigDecimal y1,BigDecimal x2,BigDecimal y2,BigDecimal x3,BigDecimal y3)
	{

		BigDecimal a, b, c, g, e, f,X,Y ,R;

	    e = (x2.subtract(x1)).pow(2);
	    f = (y2.subtract(y1)).pow(2);
	    
	    g = (x2.multiply(x2)).subtract(x1.multiply(x1)).add(y2.multiply(y2)).subtract(y1.multiply(y1));
	    
	    a = (x3.subtract(x2)).pow(2);
	    b = (y3.subtract(y2)).pow(2);
	    
	    c = (x3.multiply(x3)).subtract(x2.multiply(x2)).add(y3.multiply(y3)).subtract(y2.multiply(y2));
	    
	    X = (g.multiply(b).subtract(c.multiply(f))).divide((e.multiply(b).subtract(a.multiply(f))));
	    
	    Y = (a.multiply(g).subtract(c.multiply(e))).divide((a.multiply(f).subtract(b.multiply(e))));
	    
	    //返回R的平方
	    R = (X.subtract(x1)).pow(2).add((Y.subtract(y1)).pow(2));
	    
	    return R;
	}
}
