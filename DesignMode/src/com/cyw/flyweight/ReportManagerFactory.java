package com.cyw.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式的核心：享元工厂类
 * 维护一个对象列表，
 * @author cyw
 *
 */
public class ReportManagerFactory {
	Map<String, IReportManager> financialReportManager = 
			new HashMap<String, IReportManager>();
	Map<String, IReportManager> employeeReportManager = 
			new HashMap<String, IReportManager>();
	
	public IReportManager getFinancialManager(String tenantId){
		//通过id获取享元
		IReportManager ir = financialReportManager.get(tenantId);
		if(ir == null){
			//维护已经创建的享元对象
			ir = new FinancialReportManager(tenantId);
			financialReportManager.put(tenantId, ir);
		}
		return ir;
	}
	
	public IReportManager getEmployeeReportManager(String tenantId){
		IReportManager ir = employeeReportManager.get(tenantId);
		if(ir == null){
			ir = new EmployeeReportManager(tenantId);
			employeeReportManager.put(tenantId, ir);
		}
		return ir;
	}
	
}
