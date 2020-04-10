package org.ycz.algorithm.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: algorithm
 * @description: 接雨水
 * @author: yechengzong
 * @create: 2020-04-04 11:25
 **/
public class SolutionV4 {
	public int trap(int[] height) {
		int result = 0;
		int xlen = height.length;
		if(xlen==0){
			return  result;
		}
		int ylen = getMaxHeight(height);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future<Integer>> futures = new ArrayList<>();
		for(int i=ylen-1;i>=0;i--){
			final  int h = i;
			Future<Integer> future = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					return getCount(height,h,xlen);
				}
			});
			futures.add(future);
		}

		try {
			for (Future<Integer> future:futures) {
				result += future.get();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			executorService.shutdown();
		}
		return result;
	}

	private int getCount(int[] data, int h,int xlen) {
		int result = 0,temp = 0;
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
			if(flag){
				temp++;
			}
			if(temp == xlen){
				return -1;
			}

		}
		return result;
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
