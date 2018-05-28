package com.bridgelabz.datastructures;

public class OrderedList {

	public static void main(String[] args) {
		SortedLinkedList<Integer> sortedLinkedList=new SortedLinkedList<Integer>();
		sortedLinkedList.add(3);
		sortedLinkedList.add(1);
		sortedLinkedList.add(6);
		sortedLinkedList.add(4);
		sortedLinkedList.add(2);
		sortedLinkedList.traverse();
		int size=sortedLinkedList.size();
		System.out.println("size: "+size);
	}

}
