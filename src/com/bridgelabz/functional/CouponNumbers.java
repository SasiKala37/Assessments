/**
 * Purpose: Prints the unique coupon numbers 
 * @author SasiKala
 * @version 1.0
 * @since 18-05-2018
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class CouponNumbers
{
	public static void main(String[] args) throws Throwable 
	{
		
			  int number=Integer.parseInt(args[0]);
			  int noOfDistinctCoupons=Utility.distinctCouponNumber(number);
			  System.out.println("Number of distinct coupons"+noOfDistinctCoupons);
	}
}
