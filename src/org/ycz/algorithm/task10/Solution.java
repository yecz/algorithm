package org.ycz.algorithm.task10;

/**
 * @program: algorithm
 * @description: 翻转字符串里的单词
 * @author: yechengzong
 * @create: 2020-04-10 11:04
 **/
public class Solution {
	public String reverseWords(String s) {
		s = s.trim();
		String[] strs = s.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = strs.length-1;i>=0;i--){
			if(strs[i].trim().length()==0){
				continue;
			}else{
				stringBuilder.append(strs[i]).append(' ');
			}
		}
		return stringBuilder.toString().trim();
	}

}
