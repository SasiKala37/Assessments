/** 
 * Purpose:Implementation of stack using linked list
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

public class StackReverse<T extends Comparable<T>> {
	Node<T> top;
	int size = 0;

	public static class Node<T extends Comparable<T>> {
		private Node<T> next;
		private T data;

		Node(T data) {
			this.data = data;
			this.next = null;
		}

		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * push the data into the stack
	 * 
	 * @param data
	 *            the data is push to stack
	 */
	public void push(T data) {
		Node<T> node = new Node<T>(data, null);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
		size++;
	}

	/**
	 * Display the stack data
	 */
	public void traverse() {
		Node<T> temp = top;
		if (temp == null) {
			System.out.println("Empty stack");
		}
		//System.out.println("Pushed Elements: ");
		for(int i=0;i<100;i++) {
		while (temp != null) {
			//System.out.print(temp.data+" ");
			T array=(T) temp.data;
			temp = temp.next;
			
			
		}}
	}

	/**
	 * find the size of the stack
	 * 
	 * @return returns the number of elements present in stack
	 */
	public int size() {
		return size;
	}

	/**
	 * check whether the stack is empty or not
	 * 
	 * @return it returns the true or false whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * pop the data in stack at top position
	 * 
	 * @return it returns the pop element from the stack
	 */
	public void pop() {
		if (isEmpty()) {
			System.out.println("EMpty stack");
		}
		Node<T> temp = top;
		System.out.println(temp.data);
		top = temp.next;
		size--;
	}

	/**
	 * find which element at the top position
	 * 
	 * @return it return top element
	 */
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}

	/**
	 * Display the calender format
	 */
	public void displayCalender() {
		Node<T> temp = top;
		if (temp == null) {
			System.out.println("Empty stack");
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (temp != null) {
					System.out.print(temp.data + " ");
					temp = temp.next;
				}
			}
			System.out.println();
		}

	}
	public void traversePrime() {
		Node<T> temp = top;
		if (temp == null) {
			System.out.println("Empty stack");
		}
		//System.out.println("Pushed Elements: ");
		int low=0;int high=100;
		while(low<high) {
			if(temp.data.compareTo((T) Integer.toString(high))<0) {
				if(temp!=null) {
					System.out.println(temp.data+" ");
					temp = temp.next;
				}
			}
			low=low+100;
			high=low+100;
			System.out.println();
		}
		
	}
}
