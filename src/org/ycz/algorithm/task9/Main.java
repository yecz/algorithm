package org.ycz.algorithm.task9;

import java.util.List;

/**
 * @program: algorithm
 * @description: 括号生成
 * @author: yechengzong
 * @create: 2020-04-09 14:41
 **/
public class Main {
	public static void main(String[] args) {

		Solution solution = new Solution();
		List<String> result = solution.generateParenthesis(5);
		System.out.println(result.size());
	}

}
