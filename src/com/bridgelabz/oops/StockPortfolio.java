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
