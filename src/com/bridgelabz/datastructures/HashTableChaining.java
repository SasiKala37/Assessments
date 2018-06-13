/** 
 * Purpose:Implementation of hash table using linked list
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

public class HashTableChaining {
	private Node[] table;
	private int size;

	public static class Node {
		Node next;
		int data;

		public Node(int x) {
			data = x;
			next = null;
		}

	}

	/**
	 * Parameterized constructor to initialize the table size
	 * 
	 * @param tableSize
	 *            size of the hash table
	 */
	public HashTableChaining(int tableSize) {
		table = new Node[nextPrime(tableSize)];
		size = 0;
	}

	/**
	 * check hash table is empty or not
	 * 
	 * @return true/false if it is empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * find the size of the table
	 * 
	 * @return size of the table
	 */
	public int getSize() {
		return size;

	}

	/**
	 * to calculate the hash table index value
	 * 
	 * @param value
	 *            insertion value
	 * @return hash value index position
	 */
	public int hash(Integer value) {
		int hashValue = value.hashCode();
		hashValue %= table.length;
		if (hashValue < 0)
			hashValue += table.length;
		return hashValue;

	}

	/**
	 * insert value into hash table
	 * 
	 * @param value
	 */
	public void insert(int value) {
		size++;
		int position = hash(value);
		Node nptr = new Node(value);
		if (table[position] == null)
			table[position] = nptr;
		else {
			nptr.next = table[position];
			table[position] = nptr;
		}
	}

	/**
	 * remove the specified value from the hash table
	 * 
	 * @param value
	 *            specify to remove
	 */
	public void remove(int value) {
		int position = hash(value);
		Node start = table[position];
		Node end = start;

		if (start.data == value) {
			size--;
			table[position] = start.next;
			return;
		}

		while (end.next != null && end.next.data != value)
			end = end.next;

		if (end.next == null) {
			System.out.println("\nElement not found\n");
			return;

		}

		size--;

		if (end.next.next == null) {
			end.next = null;
			return;
		}

		end.next = end.next.next;
		table[position] = start;

	}

	/**
	 * finding the next prime numbers
	 * 
	 * @param n
	 *            value to find next prime
	 * @return next prime value
	 */
	public static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		for (; !isPrime(n); n += 2)
			;
		return n;
	}

	/**
	 * check the number is prime or not
	 * 
	 * @param n
	 *            number to check prime or not
	 * @return true/false if it is prime or not
	 */
	public static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;

	}

	/**
	 * check the key is present or not
	 * 
	 * @param key
	 *            to check present or not
	 * @return true/false if key is present or not
	 */
	public boolean contains(int key) {
		for (int i = 0; i < table.length; i++) {
			Node start = table[i];
			while (start != null) {
				if (start.data == key) {
					return true;
				}
				start = start.next;
			}
		}
		return false;
	}

	/**
	 * to print the hash table elements
	 */
	public void printHashTable() {
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			System.out.print("Bucket " + i + ":  ");
			Node start = table[i];
			while (start != null) {
				System.out.print(start.data + " ");
				start = start.next;
			}
			System.out.println();
		}
	}
}
