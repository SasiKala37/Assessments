package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class BST {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter the number of nodes:");
		int testCase=utility.userInputInteger();
		utility.numberOfBST(testCase);
	}

}
