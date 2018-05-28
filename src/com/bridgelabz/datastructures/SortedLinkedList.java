package com.bridgelabz.datastructures;

public class SortedLinkedList<T extends Comparable<T>> {
	public static class Node<T extends Comparable<T>> {
		private T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			next = null;
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getValue() {
			return data;
		}
	}

	Node<T> head;
	int count = 0;
	boolean insert = false;

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return count;
	}

	public void add(T data) {
		Node<T> newNode = new Node<T>(data, null);
		if (head == null) {
			head = newNode;
		} else if (data.compareTo(head.data) <= 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				if (data.compareTo(temp.data) >= 0 && data.compareTo(temp.next.data) <= 0) {
					temp.next = newNode;
					newNode.next = head.next;
					insert = true;
				} else {
					temp = head.next;
					head.next = head.next.next;
				}
			}
			if (insert == false) {
				head.next = newNode;
			}
		}
		count++;
	}

	/**
	 * Display the Linked List data
	 * 
	 * @return
	 */
	public void traverse() {
		Node<T> temp = head;
		if (temp == null) {
			System.out.println("Empty linked list");
		}
		
		while (temp != null) {
			System.out.println(temp.getValue());
			temp = temp.next;

		}

	}
}
