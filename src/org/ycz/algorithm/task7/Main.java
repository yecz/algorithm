package org.ycz.algorithm.task7;

/**
 * @program: algorithm
 * @description: 旋转矩阵
 * @author: yechengzong
 * @create: 2020-04-07 16:57
 **/
public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		solution.rotate(matrix);
	}
}
