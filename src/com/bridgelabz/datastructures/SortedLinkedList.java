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

	/**
	 * Method to add element after the reference element of linked list
	 */
	public void insertAfter(T data, T reference) {
		Node<T> temp = head;
		while (temp != null && !temp.data.equals(reference)) {
			temp = temp.next;
		}

		if (temp != null)
			temp.next = new Node<T>(data, temp.next);
	}

	/**
	 * Method to display linked list
	 */
	public void display() {
		if (count == 0) {
			System.out.println("Empty");
			return;
		}
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Method to search the element in a linked list
	 *
	 * @param value
	 * @return
	 */
	public boolean search(T value) {
		Node<T> temp = head;
		while (temp != null) {
			if (temp.data.compareTo(value) == 0)
				return true;
			temp = temp.next;
		}
		return false;
	}

	/**
	 * Method to find size
	 */
	public int getCount() {
		Node<T> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/**
	 * Method to remove element at index
	 */
	public T removeAt(int index) {
		if (index == 0) {
			T temp = head.data;
			head = (Node<T>) head.next;
			count--;
			return temp;
		}
		Node<T> t = head;
		int count = 0;
		while (count < index - 1) {
			t = (Node<T>) t.next;
			count++;
		}
		T temp = t.next.data;
		t.next = t.next.next;
		count--;
		return temp;
	}

	/**
	 * Method to remove reference element node
	 *
	 * @param reference
	 */
	public void remove(T reference) {
		if (head == null) {
			System.out.println("Head cannot be null!!");
		}
		if (head.data.equals(reference)) {
			head = head.next;
			return;
		}

		Node<T> cur = head;
		Node<T> prev = null;

		while (cur != null && !cur.data.equals(reference)) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null) {
			System.out.println("cannot be null!!");
		}
		prev.next = cur.next;
	}

	public Object removeFirst() {
		Object temp = head.data;
		head = (Node<T>) head.next;
		count--;
		return temp;
	}

	public void reverse(Node<T> start) {
		if (start.next != null) {
			reverse(start.next);
		}
	}

	public void reverse() {
		reverse(head);
	}

	public void displayMid() {
		Node<T> mid = head;
		int count = 0;
		while (count != count / 2) {
			mid = mid.next;
			count++;
		}
		System.out.println(mid.data);
	}

	public T getNth(int index) {
		Node<T> temp = head;
		int count = 0;
		while (temp != null) {
			if (count == index) {
				return temp.data;
			}
			count++;
			temp = temp.next;
		}
		return null;

	}

	public void addSorted(T data) {
		Node<T> current;
		Node<T> new_node = new Node<T>(data);
		if (head == null || head.data.compareTo(new_node.data) >= 0) {
			new_node.next = head;
			head = new_node;
		} else {

			current = head;

			while (current.next != null && current.next.data.compareTo(new_node.data) < 0) {
				current = current.next;

			}
			new_node.next = current.next;
			current.next = new_node;
		}
		count++;
	}

}
