/**
 * Purpose: factory class for the inventory management
 * @author SasiKala
 * @version 1.0
 * @since 08-06-2018
 */

package com.bridgelabz.oops;

import java.util.ArrayList;

public class InventoryFactory {
	 ArrayList<PoJoProductDetails> rice=new ArrayList<>();
     public ArrayList<PoJoProductDetails> getrice(){
          return rice;
      }
      public void setStockList(ArrayList<PoJoProductDetails> rice) {
          this.rice=rice;
      }
      ArrayList<PoJoProductDetails> pulse=new ArrayList<>();
	public ArrayList<PoJoProductDetails> getPulse() {
		return pulse;
	}
	public void setPulse(ArrayList<PoJoProductDetails> pulse) {
		this.pulse = pulse;
	}
	ArrayList<PoJoProductDetails> wheat=new ArrayList<>();
	public ArrayList<PoJoProductDetails> getWheat() {
		return wheat;
	}
	public void setWheat(ArrayList<PoJoProductDetails> wheat) {
		this.wheat = wheat;
	}
}
