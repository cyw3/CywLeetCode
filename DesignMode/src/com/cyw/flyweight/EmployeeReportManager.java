package com.cyw.flyweight;

public class EmployeeReportManager implements IReportManager{

	protected String tenantId = null;
	public EmployeeReportManager(String tenantId){
		this.tenantId = tenantId;
	}
	public String createReport() {
		return "This is a empoyee report!";
	}

}
