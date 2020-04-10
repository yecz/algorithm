package org.ycz.algorithm.task5;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @program: algorithm
 * @description: 最近最少使用缓存
 * @author: yechengzong
 * @create: 2020-04-05 09:53
 **/
class LFUCache {

	private int capacity;
	private Node minFreq = null;

	private LinkedList<Node> linkedList;

	public LinkedList<Node> getLinkedList() {
		return linkedList;
	}

	public LFUCache(int capacity) {
		this.capacity = capacity;
		linkedList = new LinkedList<Node>();
	}

	public int get(int key) {
		for (Node node:linkedList){
			if(node.getKey()==key){
				node.setFreq(node.getFreq()+1);
				linkedList.remove(node);
				linkedList.addFirst(node);
				setMinFreq();
				return node.getValue();
			}
		}

		return  -1;
	}

	private void setMinFreq() {
		for (Node node:linkedList){
			minFreq = minFreq!=null&&minFreq.getFreq()< node.getFreq()?minFreq:node;
		}
	}

	public void put(int key, int value) {
		if(capacity<=0){
			return;
		}
		Node node = new Node(key,value,0);
		if(linkedList.contains(node)){
			int index = linkedList.indexOf(node);
			Node nodeOld = linkedList.get(index);
			node.setFreq(nodeOld.getFreq());
			linkedList.remove(index);

		} else 	if(linkedList.size()>=capacity){
			linkedList.remove(minFreq);
			minFreq = null;
		}
		setMinFreq();
		linkedList.addFirst(node);
	}
	class Node{
		private int key;
		private int freq;
		private int value;

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Node node = (Node)o;
			return key == node.key;
		}

		@Override
		public int hashCode() {
			return Objects.hash(key);
		}

		public Node(int key, int value, int freq) {
			this.key = key;
			this.freq = freq;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getFreq() {
			return freq;
		}

		public void setFreq(int freq) {
			this.freq = freq;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" + "key=" + key + ", freq=" + freq + ", value=" + value + '}';
		}
	}

	public Node getMinFreq() {
		return minFreq;
	}
}

