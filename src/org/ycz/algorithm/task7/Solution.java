package org.ycz.algorithm.task7;

/**
 * @program: algorithm
 * @description: 旋转矩阵
 * @author: yechengzong
 * @create: 2020-04-07 16:39
 **/
public class Solution {
	public void rotate(int[][] matrix) {
		if(matrix == null){
			return ;
		}
		int len = matrix.length;
		if(len<=1) {
			return;
		}
		int offset = len%2;
		for(int x=0;x<len/2;x++) {
			for (int y = x; y <len-1-x; y++) {
				int temp = matrix[x][y];
				matrix[x][y] =   matrix[len-1-y][x];
				matrix[len-1-y][x]  =  matrix[len-1-x][len-1-y];
				matrix[len-1-x][len-1-y] = matrix[y][len-1-x];
				matrix[y][len-1-x] = temp;
			}
		}
	}
}
