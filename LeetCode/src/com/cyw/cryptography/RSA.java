package com.cyw.cryptography;

/**
 * 非对称性加密算法(公钥加密、私钥解密)
 * 来源：http://www.ruanyifeng.com/blog/2013/06/rsa_algorithm_part_one.html
 * 欧拉函数：f(n)=n(1-1/p1)(1-1/p2)......(1-1/pr)
 * 
 * （RSA的核心）欧拉定理：a的φ(n)次方被n除的余数为1。（a与n互质）
 * 公钥（n,e）;私钥（n,d）
 * 要知道d就必须分解n。对极大整数做因数分解的难度决定了RSA算法的可靠性。暴力破解
 * 
 * 加密：　m^e ≡ c (mod n)   ;(m转为整数，m<n,发送c)
 * 解密：c^d ≡ m (mod n) ；(接触信息m)
 * @author cyw
 */
public class RSA {
	
	/**
	 * 1、p、q互质。都质数
	 * 2、n = q*p
	 * --3、计算n的欧拉函数φ(n)。（质因数分解）
	 * 4、随机选择一个整数e，条件是1< e < φ(n)，且e与φ(n) 互质。(可取e=φ(n)-1)
	 * 5、计算e对于φ(n)的模反元素d。
	 * 6、将n和e封装成公钥，n和d封装成私钥。
	 * 
	 * 1、两个大质数p,q。
	 * 2、模数n=p*q。
	 * 3、欧拉函数fn=(p-1)(q-1)。
	 * 4、随机数e，1 
	 * 5、模逆d，即最小整数d，e*d=1 mod f。
	 */
	
	private long p;
	private long q;
	private long n;
	private long fn;
	private long e;
	private long d;
	
	public RSA(){}
	public RSA(long p, long q){
		this.p = p;
		this.q = q;
		this.n = p*q;
		this.fn = (p-1)*(q-1);
		this.e = fn-1;
		generateD(e, fn);
	}
	
	public RSA(long p, long q,long e){
		this.p = p;
		this.q = q;
		this.n = p*q;
		this.fn = (p-1)*(q-1);
		this.e = e;
		generateD(e, fn);
	}
	
	public long getFn(){
		return fn;
	}
	
	/**
	 * 扩展欧几里得算法
	 * 辗转相除法
	 */
	public long[] getEx(long a, long b){
		long[] result = new long[3];
		if(b==0){
			result[0] = 1;
			result[1] = 0;
			result[2] = a;
			return result;
		}else{
			result = getEx(b, a%b);
			long t = result[0];
			result[0] = result[1];
			result[1] = t-(a/b)*result[1];
			return result;
		}
	}
	
	private long generateD(long e, long fn){
//		e*d + fn*y == 1;
		long[] result = getEx(e, fn);
		this.d = result[0];
		return result[0];
	}
	
	public long getP() {
		return p;
	}
	public void setP(long p) {
		this.p = p;
	}
	public long getQ() {
		return q;
	}
	public void setQ(long q) {
		this.q = q;
	}
	public long getN() {
		return n;
	}
	public void setN(long n) {
		this.n = n;
	}
	public long getE() {
		return e;
	}
	public void setE(long e) {
		this.e = e;
	}
	public long getD() {
		return d;
	}
	public void setD(long d) {
		this.d = d;
	}
	public void setFn(long fn) {
		this.fn = fn;
	}
	/**
	 * 过程：
	 * （1）乙方生成两把密钥（公钥和私钥）。公钥是公开的，任何人都可以获得，私钥则是保密的。
	 * （2）甲方获取乙方的公钥，然后用它对信息加密。
	 * （3）乙方得到加密后的信息，用私钥解密。
	 */
	public long[] generatePublicKey(){
		long[] re = {n, e};
		return re; 
	}
	private long[] generatePrivateKey(){
		long[] re = {n, d};
		return re;
	}
	
	/**
	 * 加密
	 */
	public long encryption(long m, long[] re){
//		m^e ≡ c (mod n)
		long n = re[0];
		long e = re[1];
		System.out.println("e:"+e);
		return (long) (Math.pow(m, e)%n);
	}
	/**
	 * 解密
	 * @return 
	 */
	public long decryption(long c, long[] re){
//		c^d ≡ m (mod n)
		long n = re[0];
		long d = re[1];
		System.out.println("d:"+d);
		return (long) (Math.pow(c, d)%n);
	}
	
	
	public static void main(String [] args){
		RSA r = new RSA(3,7,17);
		long[] pk = r.generatePublicKey();
		long[] prk = r.generatePrivateKey();
		System.out.println(r.getN());
		System.out.println(r.getFn());
		System.out.println(r.getD());
		System.out.println(r.getE());
		System.out.println(r.encryption(3, pk));
		System.out.println(r.decryption(12,prk));
		
		System.out.println(Math.pow(3, 17)%21);
		System.out.println(Math.pow(12, 5)%21);
	}
}
