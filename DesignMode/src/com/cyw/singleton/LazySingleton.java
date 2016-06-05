package com.cyw.singleton;

/**
 * The second mode of singleton.
 * 引入了延迟加载机制。
 * @author cyw
 *
 */
public class LazySingleton {
	private LazySingleton(){
		System.out.println("LazySingleton is ctreated!");
	}
	
	private static LazySingleton instance = null;
	//synchronized。否则在多线程情况下，会创建多个单例的。但是正因如此，在多线程环境下，时耗会大大增大。
	public static synchronized LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}


	//test
	public static void main(String [] args){
		for(int i=0;i<10;i++){
			new Thread(){
				public void run(){
					//Singleton
					long begin = System.currentTimeMillis();
					for(int i=0;i<100000;i++){
						Singleton.getInstance();
					}
					System.out.println("Singletonspeed:"+(System.currentTimeMillis()-begin));
					
					//LazySingleton
					begin = System.currentTimeMillis();
					for(int i=0;i<100000;i++){
						LazySingleton.getInstance();
					}
					System.out.println("LazySingletonspeed:"+(System.currentTimeMillis()-begin));
				}
			}.start();
		}
	}
}
