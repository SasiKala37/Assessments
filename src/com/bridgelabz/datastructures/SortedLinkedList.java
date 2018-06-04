package com.bridgelabz.datastructures;

public class SortedLinkedList<T extends Comparable<T>> {
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
		
		while (count < index - 1) {
			t = (Node<T>) t.next;
			
		}
		T temp = t.next.data;
		t.next = t.next.next;
		count--;
		return temp;
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
		if (head.data.compareTo(data)==0) {
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

	public T removeFirst() {
		T temp = head.data;
		head =  head.next;
		count--;
		return temp;
	}

	

	/*public void displayMid() {
		Node<T> mid = head;
		int count = 0;
		while (count != count / 2) {
			mid = mid.next;
			count++;
		}
		System.out.println(mid.data);
	}*/

	/**
	 * to get index of the particular value
	 * @param index
	 * @return
	 */
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
	 * insert the data in linked list
	 * 
	 * @param data
	 *            insert data into the linked list
	 */
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
