package cn.hdu.acm;

import java.util.Arrays;
import java.util.Scanner;

public class P1040 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();

		int m;

		while (n > 0) {
			--n;
			m = cin.nextInt();
			long[] line = new long[m];
			for (int i = 0; i < m; ++i) {
				line[i] = cin.nextLong();
			}

			if(m>1){
				Arrays.sort(line);
				
				for(int j=0;j<m-1;++j){
					System.out.print(line[j]+" ");
				}
			}

			System.out.println(line[m-1]);

		}
	}

}
