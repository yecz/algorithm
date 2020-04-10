package org.ycz.algorithm.task3;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: algorithm
 * @description: 字符串转数字
 * @author: yechengzong
 * @create: 2020-04-03 09:21
 **/
public class Solution {
	private static Pattern NUMBER_PATTERN = Pattern.compile("(\\-|\\+)?\\d+");
	public int myAtoi(String str) {
		int result = 0 ;
		if(str == null || str.length()==0 || (str =str.trim()).length()==0){
			return result;
		}

		Matcher m = NUMBER_PATTERN.matcher(str);
		String sub = null ;
		while(m.find()) {
			sub = m.group();
			break;
		}
		if(sub!=null && str.indexOf(sub)==0){
			BigInteger temp  = new BigInteger(sub);
			if(temp.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>=0 ){
				result =  Integer.MAX_VALUE;
			}else if(temp.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))<=0){
				result =  Integer.MIN_VALUE;
			}else{
				result = temp.intValue();
			}

		}
		return result;
	}

	public int myAtoiV2(String str) {
		int result = 0 ;
		if(str == null || str.length()==0 || (str =str.trim()).length()==0){
			return result;
		}
		int i =0;
		boolean flag = false;
		for(;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='0'&& c <='9'){
				continue;
			}else if(i==0 &&(c=='-'|| c=='+')){
				flag = true;
				continue;
			}else{
				break;
			}
		}
		if(i==0 ||(i==1&&flag)){
			return 0;
		}
		str = str.substring(0,i);
		if(str!=null && str.indexOf(str)==0){
			BigInteger temp  = new BigInteger(str);
			if(temp.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>=0 ){
				result =  Integer.MAX_VALUE;
			}else if(temp.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))<=0){
				result =  Integer.MIN_VALUE;
			}else{
				result = temp.intValue();
			}

		}
		return result;
	}

	public int myAtoiV3(String str) {
		if(str == null || str.length()==0 || (str =str.trim()).length()==0){
			return 0;
		}
		int i =0;
		Long temp = 0L;
		boolean flag = false;
		for(;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='0'&& c <='9'){
				temp = temp*10 +(c-'0');
				if(flag) {
					if (-temp < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				}else{
					if (temp > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				}
				continue;
			}else if(i==0 &&(c=='-')){
				flag = true;
				continue;
			}else if(i==0 &&(c=='+')){
				continue;
			}else{
				break;
			}
		}
		return flag?-temp.intValue():temp.intValue();
	}
}
