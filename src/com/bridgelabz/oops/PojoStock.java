/**
 * Purpose:  POJO class for the stock management
 * @author SasiKala
 * @version 1.0
 * @since -06-2018
 */
package com.bridgelabz.oops;

public class PojoStock {
	private String stockName;
	private long numberOfStocks;
	private long sharePrice;
	

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public long getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(long sharePrice) {
		this.sharePrice = sharePrice;
	}

	public long getNumberOfStocks() {
		return numberOfStocks;
	}

	public void setNumberOfStocks(long numberOfStocks) {
		this.numberOfStocks = numberOfStocks;
	}

}
