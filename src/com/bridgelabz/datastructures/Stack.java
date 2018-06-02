package com.bridgelabz.datastructures;

public class Stack<T extends Comparable<T>> {
	Node<T> top;
	int size = 0;
    LinkedList<T> linkedList=new LinkedList<>();
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
			linkedList.addLast(data);
			/*node.next = top;
			top = node;*/
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
		System.out.println("Pushed Elements: ");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
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
	public T pop() {
		if (isEmpty()) {
			System.out.println("EMpty stack");
		}
		Node<T> temp = top;
		System.out.print(temp.data);
		top = temp.next;
		size--;
		return temp.data;
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
	 * Display the stack data in one line
	 */
	public void displayInLine() {

		Node<T> temp = top;
		if (temp == null) {
			System.out.println("Empty stack");
		}
		// System.out.println("Pushed Elements: ");
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
}
