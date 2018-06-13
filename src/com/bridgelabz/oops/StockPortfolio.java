/**
 * Purpose:Stock portfolio to store data in ArrayList
 * @author SasiKala
 * @version 1.0
 * @since -06-2018
 */
package com.bridgelabz.oops;

import java.util.ArrayList;

public class StockPortfolio {
	 ArrayList<PojoStock> stockList=new ArrayList<PojoStock>();
     public ArrayList<PojoStock> getstockList(){
          return stockList;
      }
      public void setStockList(ArrayList<PojoStock> stockList) {
          this.stockList=stockList;
      }

	
}
