package com.cyw.algorithms;

public class ValidIpAddress {
	
	//测试：255.255.256.255
	//null
	//1.B.C.D
	//01.0.0.0
	//255.255.255.255
	//0.0.0.0
	public static void main(String [] args){
//		System.out.println("re1:"+isValidIpAddress("255.255.256.255"));
//		System.out.println("re2:"+isValidIpAddress(null));
//		System.out.println("re3:"+isValidIpAddress("1.B.C.D"));
//		System.out.println("re4:"+isValidIpAddress("01.0.0.0"));
		System.out.println("re5:"+isValidIpAddress("255.255.255.255"));
		System.out.println("re6:"+isValidIpAddress("0.0.0.0"));
		//结构应为：false, false, false, false, true, true
	}
	
	//判断是否为有效ip地址，ip地址的形式为XXX.XXX.XXX.XXX
	//对于XXX表示为0-256的数，但是如果第一位是0而且整数不为0则是非法的，如01
	public static boolean isValidIpAddress(String str){
		if(str==null)
			return false;
		
		int length = str.length();
		if(length<7 || length >15)
			return false;
		
		int subNum = 1;
		int startIndex = 0;
		int endIndex = 0;
		while(startIndex < length){
			if(subNum >4)
				return false;
			//endIndex定位sub的末尾位置
			while(str.charAt(endIndex)<='9' && str.charAt(endIndex)>='0'){
				endIndex++;
				if(endIndex >= length)
					endIndex--;
					break;
			}
			if(endIndex-startIndex>3 || endIndex==startIndex)
				return false;
			if(str.charAt(endIndex)=='.' || subNum ==4){
				subNum++;
				//记录每一段IP的数值
				String tem = str.substring(startIndex, endIndex);
//				System.out.println("tem:"+tem);
				int num = changeStringToInt(tem);
				if( num == -1){
					return false;
				}
			}else{
				break;
			}
			startIndex = ++endIndex;
		}
		if(subNum >= 5 || startIndex > length)
			return true;
		else 
			return false;
	}

	//1-3位字符串转换为255以内的整数,如果转换不成功则返回-1
	//具体判断方法，如果转换后的整数不在0-255之间的，则返回-1
	//001此类的认为是非法的，所以需要判断转换后整数的位数和字符串的长度是否一致，如果不一致则返回-1
	private static int changeStringToInt(String str) {
		if(str == null || str.length() == 0 )
		    return -1;
		int length = str.length();
		int result = 0;
		int i=0;
		while(i<length){
//			System.out.println("ch:"+str.charAt(i));
			if(str.charAt(i) < '0' || str.charAt(i) >'9'){
				result = -1;
		        break;
		    }
		    result = result*10 + str.charAt(i) - 48;
		    i++;
		}
		System.out.println("result:"+result);
		if(result <= 255 && result >= 0){
		    int resultLength = 1;
		    int tempResult = result;
		    while( (tempResult /=10) != 0 )
		      ++resultLength;
		    if(resultLength != length)
		      result = -1;
		 }else{
		    result = -1;
		 }
		 return result;
	}
}
