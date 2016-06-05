package com.cyw.singleton;

/**
 * 单例模式，是设计模式中使用最为普遍的模式之一。
 * 是一种对象创建模式，确保一类一对象。好处是：
 * 1、对于频繁的使用的队象，可以省略很多创建所花费的时间。尤其是对于那些重量级的对象
 * 2、由于new操作的次数减少，对系统的内存的使用频率也会降低，降低GC压力。
 * 核心是：通过一个接口，返回唯一的对象实例。
 * 缺点是，不会延迟加载。即是说，在其他地方若用到该类时候，单例也会被加载
 * @author cyw
 *	The first mode of singleton.
 */
public class Singleton {
	/**
	 * 构造函数是private，确保不会被其他代码实例化
	 */
	private Singleton() {
		//The process of creating a instance is too slow.
		System.out.println("Singleton is created!");
	}

	private static Singleton instance = new Singleton();
	public static Singleton getInstance(){
		return instance;
	}

	//不能延迟加载，在该类使用比如这个方法的时候，也会加载单例类。因为instance是static的。
	public static void createString(){
		System.out.println("CreateString in Singleton");
	}
	
	public static void main(String [] args){
		Singleton.createString();
		/**
		 * 输出了：
		 * Singleton is created!
		 * CreateString in Singleton
		 * 说明，单例类也被加载了。
		 */
	}
	
}
