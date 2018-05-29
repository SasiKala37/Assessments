package com.bridgelabz.datastructures;

import java.util.ArrayList;

public class Map<k, v> {
	public static class HashNode<k, v> {
		private k key;
		private v value;
		HashNode<k, v> next;

		HashNode(k key, v value) {
			this.key = key;
			this.value = value;
		}
	}

	SortedLinkedList<String> list = new SortedLinkedList<>();
	private ArrayList<v> bucketArray;
	private int bucketNumber;
	private int size;
	HashNode<k, v> head;
	public Map() {
		bucketNumber = 10;
		bucketArray = new ArrayList<>();
		size = 0;

		// Create empty chains
		for (int i = 0; i < bucketNumber; i++)
			bucketArray.add(null);

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int getBucketIndex(k key) {

		int hashCode = key.hashCode();
		int index = hashCode % bucketNumber;
		return index;
	}

	public v get(k key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<k, v> head = (HashNode<k, v>) bucketArray.get(bucketIndex);
		boolean searchKey = list.search( (String) key);
		if (searchKey) {
			return head.value;
		} else {
			return null;
		}
	}

	public void put(k key, v value) {
		int bucketIndex = getBucketIndex(key);
		@SuppressWarnings("unchecked")
		HashNode<k, v> head = (HashNode<k, v>) bucketArray.get(bucketIndex);
		//size++;
		//head = (HashNode<k, v>) bucketArray.get(bucketIndex);
		HashNode<k, v> newNode = new HashNode<k, v>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, (v) newNode);

		if ((1.0 * size) / bucketNumber >= 0.7) {
			ArrayList<HashNode<k, v>> temp = (ArrayList<HashNode<k, v>>) bucketArray;
			bucketArray = new ArrayList<>();
			bucketNumber = 2 * bucketNumber;
			size = 0;
			for (int i = 0; i < bucketNumber; i++)
				bucketArray.add(null);

			for (HashNode<k, v> headNode : temp) {
				while (headNode != null) {
					put(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
		size++;
	}
	/*public void hashDisplay() {
		head=bucketArray.get(bucketIndex)
		if(size==0) {
			System.out.println("empty");
		}
		HashNode<k, v> temp=head;
		while(temp.next!=null) {
			System.out.print(temp.value);
			temp=temp.next;
		}
	}*/

	public v remove(k key) {

		// Apply hash function to find index for given key
		int bucketIndex = getBucketIndex(key);

		// Get head of chain
		HashNode<k, v> head = (HashNode<k, v>) bucketArray.get(bucketIndex);

		// Search for key in its chain
		HashNode<k, v> prev = null;
		while (head != null)
        {
            // If Key found
            if (head.key.equals(key))
                break;
 
            // Else keep moving in chain
            prev = head;
            head = head.next;
        }
 
		if (head == null) {
			return null;
		}
		size--;
		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArray.set(bucketIndex, (v) head.next);
		}

		return head.value;

	}
}
