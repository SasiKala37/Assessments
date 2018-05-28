package com.bridgelabz.datastructures;

public class Stack<T extends Comparable<T>> {
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

	int size = 0;
	Node<T> top;

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
		while (temp != null) {
			System.out.println("Pushed Elements: " + temp.data);
			temp = temp.next;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("EMpty stack");
		}
		Node<T> temp = top;
		top = temp.next;
		size--;
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}
}
