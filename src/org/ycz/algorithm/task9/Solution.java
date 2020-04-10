package org.ycz.algorithm.task9;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 括号生成
 * @author: yechengzong
 * @create: 2020-04-09 14:11
 **/
public class Solution {
	List<String> list = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
		dfs(n,n,"");
		return list;
	}

	private void dfs(int left, int right, String current) {
		if(left ==0 && right ==0){
			list.add(current);
		}
		if(left>0){
			dfs(left-1,right,current +"(");
		}
		if(right>left){
			dfs(left,right-1,current+")");
		}
	}
}
