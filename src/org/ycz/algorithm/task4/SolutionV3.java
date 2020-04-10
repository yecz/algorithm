package org.ycz.algorithm.task4;

/**
 * @program: algorithm
 * @description: 接雨水
 * @author: yechengzong
 * @create: 2020-04-04 11:25
 **/
public class SolutionV3 {
	public int trap(int[] height) {
		int result = 0;
		int xlen = height.length;
		if(xlen==0){
			return  result;
		}
		for(int i=0;;i++){
			int count = getCount(height,i,xlen);
			if(count <0){
				break;
			}
			result = result + count;
		}
		return result;
	}

	private int getCount(int[] data, int h,int xlen) {
		int result = 0,temp = 0,top = xlen;
		boolean flag = false;

		for(int i=0;i<xlen;i++){
			if(data[i]-1>=h && flag == false){
				flag = true;
				temp = 0;
				continue;
			}else if(data[i]-1>=h && flag == true){
				result += temp;
				temp = 0;
				continue;
			}
			temp++;

			if(temp == xlen&&flag==false){
				return -1;
			}
			if(--top == 1){
				return -2;
			}

		}
		return result;
	}




}
