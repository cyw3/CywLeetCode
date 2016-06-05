package com.cyw.agentmode;

public class DBQuery implements IDBQuery {
	
	public DBQuery(){
		try {
			//模拟耗时操作。重量级对象。构造很慢
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String request() {
		return "request String";
	}

}
