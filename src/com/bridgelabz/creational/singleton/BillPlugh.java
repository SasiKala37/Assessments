package com.bridgelabz.creational.singleton;

public class BillPlugh {
	private BillPlugh(){}
    
    private static class SingletonHelper{
        private static final BillPlugh INSTANCE = new BillPlugh();
    }
    
    public static BillPlugh getInstance(){
        return SingletonHelper.INSTANCE;
    }
	public static void main(String[] args) {
		System.out.println(getInstance());
	}

}
