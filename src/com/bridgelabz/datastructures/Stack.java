package com.bridgelabz.datastructures;

public class Stack<T extends Comparable<T>> {
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

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

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

	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}

	public void displayInLine() {
		
		Node<T> temp = top;
		if (temp == null) {
			System.out.println("Empty stack");
		}
		//System.out.println("Pushed Elements: ");
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
}
