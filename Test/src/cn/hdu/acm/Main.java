/**
 * 
 */
package cn.hdu.acm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhouJianyi
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String b[];

		int n;

		n = Integer.parseInt(cin.nextLine());

		// System.out.println(n);
		while (n-- > 0) {
			String s = cin.nextLine();
			// System.out.println(s);
			b = s.split(" ");

			// System.out.println(b[2]);

			int i = 0;
			i = b.length;
			int[] a = new int[b.length];
			while (i-- > 0) {
				a[i] = Integer.parseInt(b[i]);
			}
			// System.out.println(a.length);

			Arrays.sort(a);

			int tmp = a[0];
			if (b.length == 1) { // 只有一个元素
				System.out.println(a[0]);
				continue;
			}

			else {
				for (i = 1; i < b.length - 1; ++i) {
					if (a[i] == tmp) {
						continue;
					} else {
						tmp = a[i];
						System.out.print(a[i] + " ");
					}

				}

				
				
				if (n == 0) {
					System.out.print(a[i]);
				} else {
					System.out.println(a[i]);
				}
			}
		}
	}

}
