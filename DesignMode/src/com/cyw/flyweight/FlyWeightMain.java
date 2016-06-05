package com.cyw.flyweight;

/**
 * 享元对象是不可代替的，各自有自己的含义和用途；
 * 而对象池中的对象时等价的，可以相互替代
 * @author cyw
 *
 */
public class FlyWeightMain {
	public static void main(String [] args){
		ReportManagerFactory rmf = new ReportManagerFactory();
		IReportManager ir = rmf.getFinancialManager("A");
		System.out.println(ir.createReport());
	}

}
