package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 * @author cyw
 *
 */
public class RestoreIPAddressesProblem93 {
    public List<String> restoreIpAddresses(String s) {
    	List<String> list = new ArrayList<String>();
    	if(s==null || s.length()>12 || s.length()<4) return list;
    	
    	//递归 dfs 深度优先
    	handle(list, s,0,0);
		return list;
    }
    
    public void handle(List<String> list, String s,int start,int index){
    	if(list==null || start<0 || s==null || s.length()<=0 || index<0) return;
    	if(start>=s.length()) return;
    	if(index==3 && s.length()-start>3) return; 
    	
//    	System.out.println("s:"+s);
    	int len = s.length();
    	for(int i=1;i<=3;i++){
    		//start+i  这个最大为lenght
    		if(start+i>len) return;
    		if(i>1 && s.charAt(start)=='0'){
//    			System.out.println(s);
//    			System.out.println("i:"+i+" ch:"+s.charAt(start));
    			return;
    		}
    		if(index>=3) break;
    		int tem = Integer.parseInt(s.substring(start, start+i));
//    		System.out.println("start:"+start+" i:"+i+" tem:"+tem);
    		if(tem>=0 && tem<=255 ){
    				handle(list, s.substring(0, start+i)+"."+s.substring(start+i), start+1+i,index+1);
    		}
    	}
    	if(index<3) return;
    	long tem = Long.parseLong(s.substring(start));
    	if(tem>=0 && tem<=255 && !list.contains(s) &&
    			s.substring(start, len).equals(Long.toString(tem))) {
    		System.out.println(s);
    		list.add(s);
    	}
    }

    
    public static void main(String [] args){
//    	System.out.println("255".subSequence(0, 3));
//    	"010010"  ["0.10.0.10","0.100.1.0"] 25525511135
//    	System.out.println(Integer.parseInt("005"));
    	List list = (ArrayList) 
    			new RestoreIPAddressesProblem93().restoreIpAddresses("");
    	int len = list.size();
    	for(int i=0;i<len;i++){
    		System.out.println(list.get(i));
    	}
    }
}
