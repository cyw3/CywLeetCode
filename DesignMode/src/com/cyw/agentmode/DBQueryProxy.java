package com.cyw.agentmode;

public class DBQueryProxy implements IDBQuery {

	private DBQuery real = null;
	
	public String request() {
		//在需要的时候才创建
		if(real==null)
			real = new DBQuery();
		return real.request();
	}

}
