package com.bridgelabz.datastructures;



public class Deque<T extends Comparable<T>> {
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

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public T getData() {
			return data;
		}
	}

	Node<T> rear;
	Node<T> front;
	int count = 0;

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		return count;
	}

	public void insertAtFront(T data) {
		Node<T> newNode = new Node<T>(data, null);
		if (front == null) {
			front = newNode;
			rear = front;
		} else {
			newNode.setNext(front);
			front = newNode;
		}
		count++;
	}

	public void insertAtRear(T data) {
		Node<T> newNode = new Node<T>(data, null);
		if (rear == null) {
			rear = newNode;
			front = rear;
		} else {
			rear.setNext(newNode);
			rear = newNode;
		}
		count++;
	}

	public T dequeueAtFront() {
		if (isEmpty()) {
			System.out.println("Empty queue");
		}
		Node<T> temp = front;
		front = temp.getNext();
		if (front == null) {
			rear = null;
		}
		count--;
		return temp.getData();
	}

	public T dequeueAtRear() {
		if (isEmpty()) {
			System.out.println("Empty Queue");
		}
		 T tempData=rear.getData();
		Node<T> sample = front;
		Node<T> temp = front;
		while (sample != rear) {
			temp = sample;
			sample = sample.getNext();
		}
		rear = temp;
		rear.setNext(null);
		count--;
		 return tempData;
	}

	public void display() {
		if (count == 0) {
			System.out.println("Empty");
		}
		Node<T> temp = front;
		while (temp != rear.getNext()) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public T peekAtFront() {
		if (isEmpty()) {
			System.out.println("Empty deque");
		}
		return front.getData();
	}

	public T peekAtRear() {
		if (isEmpty()) {
			System.out.println("Empty deque");
		}
		return rear.getData();
	}
}
