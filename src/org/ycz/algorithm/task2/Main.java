package org.ycz.algorithm.task2;

/**
 * @program: algorithm
 * @description: 生命游戏
 * @author: yechengzong
 * @create: 2020-04-02 09:49
 **/
public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		solution.gameOfLife(board);
		System.out.println(board);
	}
}
