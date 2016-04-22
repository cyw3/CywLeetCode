package com.cyw.swordoffer;

/**
 * 字符串的交集
 * 判断两个字符串的交集，比如A="Kingsofat",B="WihinUgga",交集是"inga"，输出便是"inga"
 * @author cyw
 * O(n)
 */
public class IntersectionOfString {
	public static String intersectionOfString(StringBuffer A, StringBuffer B){
		if(A==null || B==null) return null;
		//A、B不为null
		int[] ch = new int[52];
		int ALen = A.length();
		int BLen = B.length();
		//遍历A
		for(int i=0;i<ALen;i++){
			char temp = A.charAt(i);
			if(temp>='A' && temp<='Z')
				ch[temp-'A'+26] = 1;
			else if(temp>='a' && temp<='z')
				ch[temp-'a'] = 1;
		}
		//遍历B
		for(int i=0;i<BLen;i++){
			char temp = B.charAt(i);
			if(temp>='A' && temp<='Z')
				ch[temp-'A'+26]++;
			else if(temp>='a' && temp<='z')
				ch[temp-'a']++;
		}
		//遍历数组
		StringBuffer C = new StringBuffer();
		for(int i=0;i<52;i++){
			if(ch[i]>1){
				if(i<26)
					C.append((char)(i+'a'));
				else
					C.append((char)(i+'A'-26));
			}
		}
		return C.toString();
	}
	
	public static void main(String [] args){
		StringBuffer A = new StringBuffer("Kingsofat");
		StringBuffer B = new StringBuffer("WihinUgga");
		System.out.println(intersectionOfString(A,B));
	}

}
