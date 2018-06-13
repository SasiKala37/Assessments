/** 
 * Purpose:Implementation of Unordered linked list
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */

package com.bridgelabz.datastructures;

public class LinkedList<T extends Comparable<T>> {
	Node<T> head;
	int count = 0;

	public static class Node<T extends Comparable<T>> {
		private T data;
		private Node<T> next;

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

	/**
	 * add data at head position in the linked list
	 *
	 * @param data
	 *            data is passed to insert in linked list at head node
	 */
	public void addFirst(T data) {
		head = new Node<T>(data, head);
	}

	/**
	 * Add data at end of the linked list
	 *
	 * @param data
	 *            data is passed to insert in linked list
	 */
	public void addLast(T data) {

		if (head == null) {
			addFirst(data);
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(data, null);
		}
	}

	/**
	 * Display the Linked List data
	 * 
	 * @return it returns the linked list elements
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

	/**
	 * Insert data after the target position data
	 *
	 * @param position
	 *            pass the particular position to remove data
	 * @param data
	 *            at the given position to remove data
	 */
	public void insertAftrer(T position, T data) {
		Node<T> temp = head;
		while (temp != null && !temp.getValue().equals(position)) {
			temp = temp.next;
		}
		if (temp != null) {
			temp.next = new Node<T>(data, temp.next);
		}
	}

	/**
	 * Insert data before the target position data
	 *
	 * @param position
	 *            pass the particular position before the data
	 * @param data
	 *            data is insert before the position
	 */
	public void insertBefore(T position, T data) {
		Node<T> temp = head;
		if (temp == null) {
			return;
		}
		if (temp.getValue().equals(position)) {
			addFirst(data);
			return;
		}
		Node<T> currentValue = temp;
		Node<T> previousValue = null;

		while (currentValue != null && !currentValue.getValue().equals(position)) {
			previousValue = currentValue;
			currentValue = currentValue.next;
		}
		if (currentValue != null) {
			previousValue.next = new Node<T>(data, currentValue);
		}

	}

	/**
	 * insert the data in linked list
	 * 
	 * @param data
	 *            insert data into the linked list
	 */
	public void add(T data) {
		Node<T> new_node = new Node<T>(data);
		if (head == null) {
			head = new_node;
			count++;
			return;
		}
		Node<T> temp = head;
		while (temp.next != null) {
			temp = (Node<T>) temp.next;

		}
		temp.next = new_node;
		count++;
	}

	/**
	 * remove data from the linked list
	 *
	 * @param data
	 *            data pass to remove
	 */
	public void remove(T data) {
		if (head == null) {
			System.out.println("empty list");
			return;
		}
		if (head.data.compareTo(data) == 0) {
			head = head.next;
			count--;
			return;
		}
		Node<T> currentValue = head;
		Node<T> previousValue = null;
		while (currentValue != null && !currentValue.data.equals(data)) {
			previousValue = currentValue;
			currentValue = currentValue.next;
		}
		if (currentValue == null) {
			System.out.println(" Data is not found");
		}
		previousValue.next = currentValue.next;
		count--;
	}

	/**
	 * @param index
	 * @return
	 */
	public T removeAt(int index) {
		if (index == 0) {
			T temp = head.data;
			head = (Node<T>) head.next;
			count--;
			return temp;
		}
		Node<T> t = head;

		while (count < index - 1) {
			t = (Node<T>) t.next;

		}
		T temp = t.next.data;
		t.next = t.next.next;
		count--;
		return temp;
	}

	/**
	 * Search the given data found or not
	 *
	 * @param data
	 *            search the data in linked list
	 * @return
	 */
	public boolean search(T data) {
		Node<T> temp = head;
		if (temp == null) {
			System.out.println("Empty list");
			return false;
		}
		while (temp != null) {
			if (temp.getValue().compareTo(data) == 0) {
				System.out.println("Search data found");
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	/**
	 * get the index value based on index
	 * 
	 * @param index
	 *            to get the value
	 * @return if the value is found then returns index value otherwise it returns
	 *         null
	 */
	public T getIndexValue(int index) {
		Node<T> temp = head;
		int count = 0;
		if (temp == null) {
			return null;
		}
		while (temp != null) {
			if (count == index) {
				return temp.getValue();
			}
			count++;
			temp = temp.next;

		}
		return null;
	}

	public int size() {
		Node<T> temp = head;

		if (temp == null) {
			return 0;
		}
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}
