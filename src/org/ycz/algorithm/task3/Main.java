package org.ycz.algorithm.task3;

/**
 * @program: algorithm
 * @description: 字符串转数字
 * @author: yechengzong
 * @create: 2020-04-03 15:23
 **/
public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "-2147483649";
		Long start = System.currentTimeMillis();
		System.out.println(solution.myAtoi(str));

		System.out.println(System.currentTimeMillis()-start +"ms");
		start =System.currentTimeMillis();
		System.out.println(solution.myAtoiV2(str));
		System.out.println(System.currentTimeMillis()-start+"ms");
		start =System.currentTimeMillis();
		System.out.println(solution.myAtoiV3(str));
		System.out.println(System.currentTimeMillis()-start+"ms");
	}
}
