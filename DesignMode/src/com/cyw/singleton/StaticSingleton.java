package com.cyw.singleton;

/**
 * The third mode of singleton.
 * 使用内部类来维持单例的实例。
 * 当StaticSingleton被加载到JVM时候，其内部类不会被初始化。只有当getInstance时候，才会加载instance。
 * @author cyw
 * 即可延迟加载，又不必使用同步关键字。
 */
public class StaticSingleton {
	private StaticSingleton(){
		System.out.println("StaticSingleton is created!");
	}
	
	private static class SingletonHolder{
		private static StaticSingleton instance = new StaticSingleton();
	}
	public static StaticSingleton getInstance(){
		return SingletonHolder.instance;
	}

}
