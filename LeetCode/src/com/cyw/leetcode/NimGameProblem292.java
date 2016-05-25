package com.cyw.leetcode;

/**
 * DP
 * @author cyw
 *
 */
public class NimGameProblem292 {
	//有可能赢即可, 我先开始
//	:Memory Limit Exceeded  1348820612
//    public boolean canWinNim(int n) {
//        if(n<=0) return false;
//        if(n>0 && n<=3) return true;
//        //一个一维数组，记录输赢。自底向上
//        boolean[] expr = new boolean[n+1];
//        expr[0] = false;
//        expr[1] = true;
//        expr[2] = true;
//        expr[3] = true;
//        for(int i=4;i<=n;i++){
//        	if(expr[i-1] && expr[i-2] && expr[i-3]) expr[i]=false;
//        	else expr[i] = true;
//        }
//        return expr[n];
//    }
    
    //位映射 位运算  Memory Limit Exceeded
//    public boolean canWinNim(int n) {
//        if(n<=0) return false;
//        if(n>0 && n<=3) return true;
//        //一个一维数组，记录输赢。自底向上
//        //一个字节，有符号
//        byte[] expr = new byte[(n>>3)+1];
//        expr[0] = (byte) (expr[0] | 14);
//        for(int i=4;i<=n;i++){
//        	int byt = i>>3;
//        	int pos = i%8;
//        	
//        	if(pos==0){
//            	if((expr[byt-1] & (1<<7)) == 0 || 
//            			(expr[byt-1] & (1<<6)) == 0 ||
//            			(expr[byt-1] & (1<<5)) == 0){
//            		expr[byt] = (byte) (expr[byt] | (1<<pos));
//            	}
//        	}else if(pos==1){
//            	if((expr[byt] & (1<<(pos-1))) == 0 || 
//            			(expr[byt-1] & (1<<(7))) == 0 ||
//            			(expr[byt-1] & (1<<(6))) == 0){
//            		expr[byt] = (byte) (expr[byt] | (1<<pos));
//            	}
//        	}else if(pos==2){
//            	if((expr[byt] & (1<<(pos-1))) == 0 || 
//            			(expr[byt] & (1<<(pos-2)))== 0 ||
//            			(expr[byt-1] & (1<<(7))) == 0){
//            		expr[byt] = (byte) (expr[byt] | (1<<pos));
//            	}
////        	}else if(pos==3){
////            	if((expr[byt] & (1<<(pos-1))) == 0 || 
////            			(expr[byt] & (1<<(pos-2))) == 0 ||
////            			(expr[byt] & (1<<(pos-3))) == 0){
////            		expr[byt] = (byte) (expr[byt] | (1<<pos));
////            	}
//        	}else{
//            	if((expr[byt] & (1<<(pos-1))) == 0 || 
//            			(expr[byt] & (1<<(pos-2))) == 0 ||
//            			(expr[byt] & (1<<(pos-3))) == 0){
//            		expr[byt] = (byte) (expr[byt] | (1<<pos));
//            	}
//        	}
//        }
//        return (expr[expr.length-1] & (1<<(n%8)))!=0;
//    }
	
	/**
3\
Proof:
the base case: when n = 4, as suggested by the hint from the problem, no matter which number that that first player, the second player would always be able to pick the remaining number.
For 1* 4 < n < 2 * 4, (n = 5, 6, 7), the first player can reduce the initial number into 4 accordingly, which will leave the death number 4 to the second player. i.e. The numbers 5, 6, 7 are winning numbers for any player who got it first.
Now to the beginning of the next cycle, n = 8, no matter which number that the first player picks, it would always leave the winning numbers (5, 6, 7) to the second player. Therefore, 8 % 4 == 0, again is a death number.
Following the second case, for numbers between (2*4 = 8) and (3*4=12), which are 9, 10, 11, are winning numbers for the first player again, because the first player can always reduce the number into the death number 8.
	 */
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
    
    public static void main(String [] args){
    	NimGameProblem292 nim = new NimGameProblem292();
    	System.out.println(nim.canWinNim(5));
    }

    
}
