package org.ycz.algorithm.task10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithm
 * @description: 翻转字符串里的单词
 * @author: yechengzong
 * @create: 2020-04-10 11:04
 **/
public class Solution2 {
	public String reverseWords(String s) {
		s = s.trim();
		List<String> strs = Arrays.asList(s.split("\\s+"));
		Collections.reverse(strs);
		return String.join(" ",strs);
	}

}
