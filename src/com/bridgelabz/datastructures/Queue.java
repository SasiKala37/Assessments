package com.bridgelabz.datastructures;

public class Queue<T extends Comparable<T>> {
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

	Node<T> rear;
	Node<T> front;
	int count = 0;

	public boolean isEmpty() {
		return front == null;
	}

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

	public void display() {
		if (count == 0) {
			System.out.println("Empty");
		}
		Node<T> temp = front;
		while (temp != rear.next) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public int size() {
		return count;
	}

}
