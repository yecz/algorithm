package org.ycz.algorithm.task2;

/**
 * @program: algorithm
 * @description: 生命游戏
 * @author: yechengzong
 * @create: 2020-04-02 09:50
 **/
public class Solution {
	public void gameOfLife(int[][] board) {
		int xlen = board.length;
		if(xlen==0){
			return ;
		}
		int ylen = board[0].length;
		int[][] temp = new int[xlen][ylen];
		for(int x=0;x<xlen;x++) {
			for (int y = 0; y < ylen; y++) {
				temp[x][y] = board[x][y];
			}
		}
		for(int x=0;x<xlen;x++) {
			for (int y = 0; y < ylen; y++) {
				board[x][y] = getStatu(x,y,xlen-1,ylen-1,temp);
			}
		}
	}

	public int getStatu(int x,int y,int xlen,int ylen,int[][] board){
		int status = board[x][y];
		int x1=x-1;
		int x2=x+1;
		int y1=y-1;
		int y2=y+1;
		x1 = x1<0?0:x1;
		x2 = x2>xlen?xlen:x2;
		y1 = y1<0?0:y1;
		y2 = y2>ylen?ylen:y2;
		int live = 0;
		for(int i=x1;i<=x2;i++){
			for(int j=y1;j<=y2;j++){
				if(!(i==x&&j==y) && board[i][j]==1){
					live++;
				}
			}
		}
		if(status == 1) {
			if (live < 2 || live>3) {
				return 0;
			} else if (live == 2 || live == 3) {
				return 1;
			}
		}else{
			if(live == 3){
				return 1;
			}
		}
		return status;
	}
}
