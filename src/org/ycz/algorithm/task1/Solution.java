package org.ycz.algorithm.task1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 1111
 * @author: yechengzong
 * @create: 2020-04-01 20:59
 **/
public class Solution {
	public int[] maxDepthAfterSplit(String seq) {
		int seqLen = seq.length();
		char[] seqs = seq.toCharArray();
		int[] answer = new int[seqLen];
		int a = 0,b=1;
		LinkedList<Character> queueA = new LinkedList<>();
		LinkedList<Character> queueB = new LinkedList<>();
			for(int i = 0;i<seqLen;i++){
				char temp = seqs[i];
				if(queueA.size()==0 && temp =='(' ){
					queueA.addLast(temp);
					answer[i] = a;
				}else if(queueB.size()==0 && temp =='(' ){
					queueB.addLast(temp);
					answer[i] = b;
				}else if(queueA.size()>0 && queueA.size()>=queueB.size() && queueA.peekLast()!= temp ){
					queueA.pollLast();
					answer[i] = a;
				}else if(queueB.size()>0 && queueB.size()>=queueA.size() && queueB.peekLast()!= temp){
					queueB.pollLast();
					answer[i] = b;
				}else if(temp =='(' && queueA.size()<=queueB.size()){
					queueA.addLast(temp);
					answer[i] = a;
				}else if(temp =='(' && queueB.size()<=queueA.size()){
					queueB.addLast(temp);
					answer[i] = b;
				}
			}
		return answer;
	}
	public int[] maxDepthAfterSplitV2(String seq) {
		int seqLen = seq.length();
		int[] answer = new int[seqLen];
		int a = 0,b=1;
		int countA = 0 ,countB =0 ;
		for(int i = 0;i<seqLen;i++){
			char temp = seq.charAt(i);
			if(countA ==0 && temp =='(' ){
				countA++;
				answer[i] = a;
			}else if(countB ==0 && temp =='(' ){
				countB++;
				answer[i] = b;
			}else if(countA>0 && countA>=countB && '('!= temp ){
				countA--;
				answer[i] = a;
			}else if(countB>0 && countB>=countA && '('!= temp){
				countB--;
				answer[i] = b;
			}else if(temp =='(' && countA<=countB){
				countA++;
				answer[i] = a;
			}else if(temp =='(' && countB<=countA){
				countB++;
				answer[i] = b;
			}
		}
		return answer;
	}
	public int[] maxDepthAfterSplitV3(String seq) {
		int seqLen = seq.length();
		int[] answer = new int[seqLen];
		int countA = 0 ,countB =0 ;
		for(int i = 0;i<seqLen;i++){
			char temp = seq.charAt(i);
			if(countA ==0 && temp =='(' ){
				countA++;
			}else if(countB ==0 && temp =='(' ){
				countB++;
				answer[i] = 1;
			}else if(countA>0 && countA>=countB && '('!= temp ){
				countA--;
			}else if(countB>0 && countB>=countA && '('!= temp){
				countB--;
				answer[i] = 1;
			}else if(temp =='(' && countA<=countB){
				countA++;
			}else if(temp =='(' && countB<=countA){
				countB++;
				answer[i] = 1;
			}
		}
		return answer;
	}
}
