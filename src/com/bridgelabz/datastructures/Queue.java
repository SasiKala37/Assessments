/** 
 * Purpose:Implementation of Queue using linked list
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

public class Queue<T extends Comparable<T>> {
	Node<T> rear;
	Node<T> front;
	int count = 0;

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
	 * check Queue is empty or not
	 * 
	 * @return it returns true or false whether it is empty or not
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Insert the data in queue
	 * 
	 * @param data
	 *            the data is passed to insert
	 */
	public void enqueue(T data) {
		Node<T> temp = new Node<T>(data, null);
		if (rear == null) {
			front = temp;
			rear = temp;
		} else {
			rear.next = temp;
			rear = rear.next;
		}
		count++;
	}

	public void enqueueS(String data) {
		Node<T> temp = new Node(data, null);
		if (rear == null) {
			front = temp;
			rear = temp;
		} else {
			rear.next = temp;
			rear = rear.next;
		}
		count++;
	}
	/**
	 * Delete the Queue elements
	 */
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("empty queue");
		}
		Node<T> temp = front;
		front = temp.next;
		if (front == null) {
			rear = null;
		}
		count--;
		System.out.println("Deleted data: " + temp.data);
	}

	/**
	 * Display the Queue elements
	 */
	public void display() {
		if (count == 0) {
			System.out.println("Empty");
		}
		Node<T> temp = front;
		// System.out.println("Queue elements");
		while (temp != rear.next) {
			System.out.println(temp.data+" ");
			temp = temp.next;
		}
	}

	/**
	 * find the size of queue
	 * 
	 * @return returns the count which indicates the number of elements in the queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Display the queue elements
	 */
	public void displayInLine() {
		if (count == 0) {
			System.out.println("Empty");
		}
		Node<T> temp = front;
		while (temp != rear.next) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();

	}

	/**
	 * display the Queue elements in calender format 
	 */
	public void displayCalender() {
		if (count == 0) {
			System.out.println("Empty");
		}
		Node<T> temp = front;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (temp != rear.next) {
					System.out.print(temp.data + " ");
					temp = temp.next;
				}
			}
			System.out.println();
		}

	}

}
