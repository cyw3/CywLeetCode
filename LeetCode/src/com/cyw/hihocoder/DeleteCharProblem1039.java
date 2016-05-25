package com.cyw.hihocoder;

import java.util.Scanner;

public class DeleteCharProblem1039 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(sc.hasNext()){
			String str = sc.next();
			if(str==null || str.length()<=0) continue;
			gamePoint(str);
		}
	}

	
	private static void gamePoint(String str) {
		if(str==null || str.length()<=0) return;
		
		char[] chArr = str.toCharArray();
		int point =0 ;
		int len = chArr.length;
		int start=0;
		int end=start+1;
		
		for(;end<len;end++){
			if(chArr[end]=='D')continue;
			if(chArr[start]!=chArr[end]){
				if(end-start>1){
					for(int i=start;i<end;i++){
						if(chArr[i]!='D'){
							chArr[i] = 'D';
							point++;
						}
					}
				}
				start = end;
			}
		}
		
		
		
	}
}
