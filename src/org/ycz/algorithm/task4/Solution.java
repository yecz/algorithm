package org.ycz.algorithm.task4;

/**
 * @program: algorithm
 * @description: 接雨水
 * @author: yechengzong
 * @create: 2020-04-04 11:25
 **/
public class Solution {
	public int trap(int[] height) {
		int result = 0;
		int xlen = height.length;
		if(xlen==0){
			return  result;
		}
		int ylen = getMaxHeight(height);
		byte[][] data = init(height,xlen,ylen);
		for(int i=ylen-1;i>=0;i--){
			int count = getCount(data,i,xlen);
			if(count ==-1){
				break;
			}
			result = result + count;
		}
		return result;
	}

	private int getCount(byte[][] data, int h,int xlen) {
		int result = 0,temp = 0;
		boolean flag = false;

		for(int i=0;i<xlen;i++){
			if(data[i][h]==1 && flag == false){
				flag = true;
				temp = 0;
				continue;
			}else if(data[i][h]==1 && flag == true){
				result += temp;
				temp = 0;
				continue;
			}
			if(flag){
				temp++;
			}
			if(temp == xlen){
				return -1;
			}

		}
		return result;
	}

	private byte[][] init(int[] height, int xlen, int ylen) {
		byte[][] data = new byte[xlen][ylen];
		for(int i=0;i<xlen;i++){
			for(int j=0;j<height[i];j++){
				data[i][j] = 1;
			}
		}
		return data;
	}

	private int getMaxHeight(int[] height) {
		int h = 0;
			for(int i=0;i<height.length;i++){
				if(height[i]> h){
					h = height[i];
				}
			}
		return h;
	}
}
