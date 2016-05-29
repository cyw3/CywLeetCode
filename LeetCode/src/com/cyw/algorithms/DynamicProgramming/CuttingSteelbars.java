package com.cyw.algorithms.DynamicProgramming;

/**
 * 切割钢条
 * 最佳的切割方案
 * 一段长度为i的钢条价格为pi
 * 给定一段长度为n的钢条和一个价格表pi，求切割钢条方案，使得销售收益最大
 * @author cyw
 *
 */
public class CuttingSteelbars {
	/*pi
1		2		3		4		5		6		7		8 		9		10
1		5		8		9		10		17		17		20		24		30
	*/
	//一个自顶向下的递归实现  O(2^n),但是反复计算相同的子问题，效率低
	public int cutRod(int[] p, int n){
		if(p==null || p.length<=0 || n<=0) return 0;
		
		int max = 0;
		//切割下的已知价格的钢条，以及待继续切割的又不剩余钢条
		for(int i=1;i<=n;i++){
			max = Math.max(p[i-1]+cutRod(p, n-i), max);
		}
		return max;
	}
	
	//以空间换时间。多项式阶的时间复杂度
	//自顶向下的DP，带缓存备忘 O(n^2)
	public int memoriedCutRod(int[] p, int n){
		if(p==null || p.length<=0 || n<=0) return 0;
		
		int[] cache = new int[n+1];
		for(int i=0;i<n+1;i++)
			cache[i] = Integer.MIN_VALUE;
		return memoriedCutRodAux(p, n, cache);
	}

	private int memoriedCutRodAux(int[] p, int n, int[] cache) {
		if(p==null || p.length<=0 || n<=0) return 0;
		if(cache==null) cache = new int[n+1];
		//关键在这！！！
		if(cache[n]>=0) return cache[n];
		
		int max = 0;
		for(int i=1;i<=n;i++){
			max = Math.max(max,p[i-1]+memoriedCutRodAux(p, n-i, cache));
		}
		cache[n] = max;
		return max;
	}
	
	//3\自底向上DP,最佳收益的缓存表  
//	Rn = max(Pn, R1+Rn-1, R2+Rn-2,... ,Rn-1+R1)  O(n^2)
	public int bottomUpCutRod(int[] p, int n){
		//p为价格表
		if(p==null || p.length<=0 || n<=0) return 0;
		
		//自底向上DP,最佳收益的缓存表
		int[] cache = new int[n+1];
		//长度i
		for(int i=1;i<=n;i++){
			int max = p[i-1];
			for(int j=1;j<i;j++){
				max = Math.max(max, p[j-1]+cache[i-j]);
			}
			cache[i] = max;
		}
		return cache[n];
	}
	
	//保存对应的切割方案，最优解
	public int[] extendedBottomUpCutRod(int[] p, int n){
		if(p==null || p.length<=0 || n<=0) return null;
		
		int[] cache = new int[n+1];
		//保存切割方案
		int[] result = new int[n+2];
		cache[0] = 0;
		result[0] = 0;
		
		//钢条长度
		for(int i=1;i<=n;i++){
			int max = p[i-1];
			//切割点
			int index = i;
			for(int j=1;j<i;j++){
//				max = Math.max(max, p[j-1]+cache[i-j]);
				int tem = p[j-1]+cache[i-j];
				if(max<tem){
					max = tem;
					index = j;
				}
			}
			cache[i] = max;
			result[i] = index;
		}
		result[n+1] = cache[n];
		return result;
	}
	public void printCutRod(int[] p, int n){
		if(p==null || p.length<=0 || n<=0) return;
		int[] result = extendedBottomUpCutRod(p, n);
		while(n>0){
			System.out.print(result[n]+" ");
			n -= result[n];
		}
		System.out.println();
		System.out.println("Max Profix:"+ result[n+1]);
	}
	
	
	public static void main(String [] args){
		CuttingSteelbars cu = new CuttingSteelbars();
		int[] p = {1,5,8,9,10,17,17,20,24	,30};
		System.out.println(cu.bottomUpCutRod(p, 5));
		System.out.println(cu.cutRod(p, 5));
		System.out.println(cu.memoriedCutRod(p, 5));
		
		cu.printCutRod(p, 5);
	}
	
}
