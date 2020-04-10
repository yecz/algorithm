package org.ycz.algorithm.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 文件读取int 数组
 * @author: yechengzong
 * @create: 2020-04-04 13:00
 **/
public class FileToArray {
		public static int[] getIntArrayFromFile(String fileName)  {
			//使用BufferedReader 最大好处是可以按行读取,每次读取一行
			try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				//定义字符串,用于保存每行读取到的数据
				String temp;
				while ((temp = br.readLine()) != null) {
					//通过函数吧字符串数组解析成整数数组
					return aryChange(temp);
				}
			}catch (IOException ex){
			}
			return null;
		}

		static int[] aryChange(String temp) {
			// 字符串数组解析成int数组
			// .trim()可以去掉首尾多余的空格
			String[] ss = temp.trim().split(",");
			// .split("\\s+")
			// 表示用正则表达式去匹配切割,\\s+表示匹配一个或者以上的空白符
			int[] ary = new int[ss.length];
			for (int i = 0; i < ary.length; i++) {
				ary[i] = Integer.parseInt(ss[i]);// 解析数组的每一个元素
			}
			return ary;// 返回一个int数组
		}
}
