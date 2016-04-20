package com.cyw.swordoffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author cyw
 *
 */
public class ReplaceSpace {
	
	/**
	 * 这是在C++之中的思路。
	 * 在java之中，使用StringBufer便于对String的操作
	 * 1、先遍历一次字符串，统计有多少个空格，替换之后的总长度
	 * 2、从字符串的后面开始复制以及替换
	 * @param str
	 * @return
	 */
    public static String replaceSpace(StringBuffer str) {
    	if(str==null)
    		return null;
    	char[] in = {'%','2','0'};
    	int len = str.length();
    	int count = 0;
    	for(int i=0;i<len;i++){
    		if(str.charAt(i)==' '){
    			count++;
    		}
    	}
    	int offerLen = len+count*2;
    	for(int i=0;i<offerLen;){
    		if(str.charAt(i)==' '){
    			str.deleteCharAt(i);
    			str.insert(i, in);
    			i += 3;
    		}else
    			i++;
    	}
		return str.toString();
    }
    
    public static void main(String [] args){
//    	StringBuffer str = new StringBuffer("We Are Happy");
//    	char[] str1 = {'1','2','3'};
//    	//追加
////    	str.append(str1, 0, 2);
////    	str.deleteCharAt(0);
//    	str.insert(1, str1);
//    	System.out.println(str);
    	
    	
    	System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    	System.out.println(replaceSpace(new StringBuffer("   ")));
    }
}
