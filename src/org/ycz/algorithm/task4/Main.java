package org.ycz.algorithm.task4;

import java.util.concurrent.ExecutionException;

/**
 * @program: algorithm
 * @description: 接雨水
 * @author: yechengzong
 * @create: 2020-04-04 11:55
 **/
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		int [] height = FileToArray.getIntArrayFromFile("e:\\bigdata\\intArray.txt");
		long start = System.currentTimeMillis();
//		Solution solution = new Solution();
//		System.out.println(solution.trap(height));
//		System.out.println(System.currentTimeMillis()-start + "ms");
//		start = System.currentTimeMillis();
		SolutionV2 solutionV2 = new SolutionV2();
		System.out.println(solutionV2.trap(height));
		System.out.println(System.currentTimeMillis()-start + "ms,v2");
		start = System.currentTimeMillis();
		Solutionv5 solutionV5= new Solutionv5();
		System.out.println(solutionV5.trap(height));
		System.out.println(System.currentTimeMillis()-start + "ms,v5");
		start = System.currentTimeMillis();
		SolutionV4 solutionV4 = new SolutionV4();
		System.out.println(solutionV4.trap(height));
		System.out.println(System.currentTimeMillis()-start + "ms,v4");
	}
}
