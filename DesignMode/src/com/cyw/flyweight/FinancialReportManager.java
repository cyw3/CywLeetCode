package com.cyw.flyweight;

/**
 * 具体的享元类
 * @author cyw
 *
 */
public class FinancialReportManager implements IReportManager{

	protected String tenantId = null;
	public FinancialReportManager(String tenantId){
		this.tenantId = tenantId;
	}
	
	public String createReport() {
		return "This is a financial report!";
	}

}
