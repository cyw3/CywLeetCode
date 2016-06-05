package com.cyw.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A singleton which can be Serializable.
 * @author cyw
 *
 */
public class SerSingleton implements Serializable {
	String name;
	private SerSingleton(){
		System.out.println("Singleton is created.");
		name = "SerSingleton";
	}
	private static SerSingleton instance = new SerSingleton();
	
	public static SerSingleton getInstance(){
		return instance;
	}
	
	public static void createString(){
		System.out.println("CreateString in Singleton.");
	}
	
	/**
	 * 阻止生成新的实例，总是返回当前对象
	 * 当去掉这一代码之后，保证序列化反序列化过程中的，单例一致。
	 * 实现了readresolve方法后，会替代掉readObject方法。直接使用readResolve方法来替换原来的返回值，在形式上构成单例。
	 * @return
	 */
	private Object readResolve(){
		return instance;
	}
	
	//test
	public static void main(String [] args) throws IOException, ClassNotFoundException{
		SerSingleton s1 = null;
		SerSingleton s = SerSingleton.getInstance();
		
		FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("SerSingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		s1 = (SerSingleton) ois.readObject();
		
//		asser
	}
}
