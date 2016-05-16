package com.cyw.algorithms;

import java.util.Scanner;

public class ConvexHullWithGraham { 
     Point[] ch; //点集p的凸包
     Point[] p ; //给出的点集
     int n;
     int l;
     int len=0;
    public ConvexHullWithGraham(Point[] p,int n,int l){
       this.p=p;
       this.n=n;
       this.l=l;
       ch= new Point[n]; 
    }
   //小于0,说明向量p0p1的极角大于p0p2的极角  
   public  double multiply(Point p1, Point p2, Point p0) { 
       return ((p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - 
    		   (p2.getX()- p0.getX()) * (p1.getY()- p0.getY())); 
   } 
   //求距离
   public  double distance(Point p1, Point p2) { 
       return (Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) 
               * (p1.getY() - p2.getY()))); 
   } 
   public void answer(){
    double sum = 0; 
       for (int i = 0; i < len - 1; i++) { 
           sum += distance(ch[i], ch[i + 1]); 
       } 
       if (len > 1) { 
           sum += distance(ch[len - 1], ch[0]); 
       } 
       sum += 2 * l * Math.PI; 
       System.out.println(Math.round(sum)); 
   }
   public  int Graham_scan() { 
       int k = 0, top = 2; 
       Point tmp; 
       //找到最下且偏左的那个点   
       for (int i = 1; i < n; i++) 
           if ((p[i].getY() < p[k].getY()) 
                   || ((p[i].getY() == p[k].getY()) && (p[i].getX() < p[k].getX()))) 
               k = i; 
       //将这个点指定为pts[0],交换pts[0]与pts[k] 
       tmp = p[0]; 
       p[0] = p[k]; 
       p[k] = tmp; 
       //按极角从小到大,距离偏短进行排序   
       for (int i = 1; i < n - 1; i++) { 
           k = i; 
           for (int j = i + 1; j < n; j++) 
               if ((multiply(p[j], p[k], p[0]) > 0) 
                       || ((multiply(p[j], p[k], p[0]) == 0) && (distance( 
                               p[0], p[j]) < distance( 
                               p[0], p[k])))) 
                   k = j; //k保存极角最小的那个点,或者相同距离原点最近  
           tmp = p[i]; 
           p[i] = p[k]; 
           p[k] = tmp; 
       } 
       //前三个点先入栈  
       ch[0] = p[0]; 
       ch[1] = p[1]; 
       ch[2] = p[2]; 
        //判断与其余所有点的关系   
       for (int i = 3; i < n; i++) { 
            //不满足向左转的关系,栈顶元素出栈   
           while (top > 0 && multiply(p[i], ch[top], ch[top - 1]) >= 0) 
               top--; 
            //当前点与栈内所有点满足向左关系,因此入栈. 
           ch[++top] = p[i]; 
       } 
       len=top+1;
       return len; 
   } 
  
   /**
    * 从前有一个吝啬的国王要求他的总设计师在他的城堡周围建一道围墙。
    * 这国王非常吝啬，以至于他没有听总设计师的建一个拥有外形漂亮又高大的
    * 砖头塔楼的围墙的建议，而是要求用最少的石头和劳工围着整个城堡建围墙，
    * 但是要求围墙必须远离城堡一定的距离。要是国王发现发现设计师用了超过建造围
    * 墙所需要的材料，那么这个设计师的脑袋将保不住了。而且，国王要求设计师马上拿
    * 出一个建墙的计划，列出建造围墙所需要的最少的材料。你的任务是去帮助这个可怜的
    * 设计师保住他的性命，请写一个程序算出建造满足国王要求的围墙的最小的长度。
    * 这个任务事实上稍微有点简单，因为国王的城堡是一个多边形的，除开顶点处，
    * 其他的地方不会相交，并且位于平坦的地面上，设计师早已画好了一个笛卡尔坐标系，
    * 而且精确地计算出了城堡中每一个点的坐标。 
Input 
第一行包括两个整数，N,L，第一个整数是点的个数，第二个整数是围墙必须远离城堡的距离。接下来n行，每行两个数{中间一个空格}表示每一个点的坐标。所有的点各不相同。 

Output 
输出一个整数，即围墙的长度。答案四舍五入 

样例: 
Sample Input 

9 100 
200 400 
300 400 
300 300 
400 300 
400 400 
500 400 
500 200 
350 200 
200 200 
Sample Output 

1628 
	*/
   public static void main(String[] args)  { 
    
       Scanner in=new Scanner(System.in);
       int n = in.nextInt(); 
       int l = in.nextInt();
       int x, y; 
       Point[] p = new Point[n]; 
       for (int i = 0; i < n; i++) { 
           x = in.nextInt(); 
           y = in.nextInt();
           p[i] = new Point(x, y); 
       } 
      
       ConvexHullWithGraham ma=new ConvexHullWithGraham(p,n,l); 
       ma.Graham_scan(); 
       ma.answer();
   } 
} 
