package com.cyw.aboutjava;

/**
 * Java中的深拷贝(深复制)和浅拷贝(浅复制)
 * 浅拷贝是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），
 * 而不拷贝对象包含的引用指向的对象。
 * 深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。
 * @author cyw
 *
 */

import java.io.*;

public class AboutCopy {
	
	//ShallowCopy浅拷贝，使用默认是clone拷贝构造函数
	static class Professor0 implements Cloneable {
	    String name;
	    int age;
	    Professor0(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
	}
	static class Student0 implements Cloneable {
	    String name;// 常量对象。
	    int age;
	    Professor0 p;// 学生1和学生2的引用值都是一样的。
	    Student0(String name, int age, Professor0 p) {
	        this.name = name;
	        this.age = age;
	        this.p = p;
	    }
	    //自定义拷贝函数
	    public Object clone() {
	        Student0 o = null;
	        try {
	            o = (Student0) super.clone();
	        } catch (CloneNotSupportedException e) {
	            System.out.println(e.toString());
	        }
	 
	        return o;
	    }
	}
	 
//	public class ShallowCopy {
    public static void main(String[] args) {
    	
    	//ShallowCopy
        Professor0 p = new Professor0("wangwu", 50);
        Student0 s1 = new Student0("zhangsan", 18, p);
        Student0 s2 = (Student0) s1.clone();
        s2.p.name = "lisi";
        s2.p.age = 30;
        s2.name = "z";
        s2.age = 45;
        //即是说，引用属性只拷贝了引用。s2.p 与 s1.p 地址是一样的
        System.out.println("学生s1的姓名：" + s1.name + "\n学生s1教授的姓名：" + s1.p.name + "," + "\n学生s1教授的年纪" + s1.p.age);// 学生1的教授
        
        
        //深拷贝DeepCopy
        long t1 = System.currentTimeMillis();
        Professor pD = new Professor("wangwu", 50);
        Student s1D = new Student("zhangsan", 18, pD);
        Student s2D = (Student) s1.clone();
        s2D.p.name = "lisi";
        s2D.p.age = 30;
        System.out.println("name=" + s1D.p.name + "," + "age=" + s1D.p.age);// 学生1的教授不改变。
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

    }
//	}
    
    //DeepCopy  一、递归clone
    static class Professor implements Cloneable {
        String name;
        int age;
     
        Professor(String name, int age) {
            this.name = name;
            this.age = age;
        }
     
        public Object clone() {
            Object o = null;
            try {
                o = super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.toString());
            }
            return o;
        }
    }
     
    static class Student implements Cloneable {
        String name;
        int age;
        Professor p;
     
        Student(String name, int age, Professor p) {
            this.name = name;
            this.age = age;
            this.p = p;
        }
     
        public Object clone() {
            Student o = null;
            try {
                o = (Student) super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.toString());
            }
            o.p = (Professor) p.clone();
            return o;
        }
    }
     
//    public class DeepCopy {
//        public static void main(String args[]) {
//            long t1 = System.currentTimeMillis();
//            Professor p = new Professor("wangwu", 50);
//            Student s1 = new Student("zhangsan", 18, p);
//            Student s2 = (Student) s1.clone();
//            s2.p.name = "lisi";
//            s2.p.age = 30;
//            System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);// 学生1的教授不改变。
//            long t2 = System.currentTimeMillis();
//            System.out.println(t2-t1);
//        }
//    }
    
    //二、序列化 深拷贝，但耗时
  //Serialization is time-consuming
    static class Professor2 implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        String name;
        int age;
     
        Professor2(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
     
    static  class Student2 implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        String name;// 常量对象。
        int age;
        Professor2 p;// 学生1和学生2的引用值都是一样的。
     
        Student2(String name, int age, Professor2 p) {
            this.name = name;
            this.age = age;
            this.p = p;
        }
     
        public Object deepClone() throws IOException, OptionalDataException,
                ClassNotFoundException {
            // 将对象写到流里
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            // 从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return (oi.readObject());
        }
     
    }
     
//    public class DeepCopy2 {
     
//        /**
//         * @param args
//         */
//        public static void main(String[] args) throws OptionalDataException,
//                IOException, ClassNotFoundException {
//            long t1 = System.currentTimeMillis();
//            Professor2 p = new Professor2("wangwu", 50);
//            Student2 s1 = new Student2("zhangsan", 18, p);
//            Student2 s2 = (Student2) s1.deepClone();
//            s2.p.name = "lisi";
//            s2.p.age = 30;
//            System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age); // 学生1的教授不改变。
//            long t2 = System.currentTimeMillis();
//            System.out.println(t2-t1);
//        }
//     
//    }
}
