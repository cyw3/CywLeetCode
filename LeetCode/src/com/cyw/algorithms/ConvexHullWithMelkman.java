package com.cyw.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Melkman求凸包算法
 * http://xiaoming2xiaohong.iteye.com/blog/1297456
 * @author cyw
 *Melkman凸包算法继承Graham-Scan算法的主要思想，并更近一步地采用双端队列，
 *动态地在队列两头进行增删操作，维护“凸性”。
 *
 *"左转判定" :  (包括Graham扫描法 都是使用了这个判定)
 *这一思想在凸包算法里十分的重要. 而如何判断两个向量 p1=(x1,y1) 和 p2=(x2,y2) 
 *是否左转,非常简单的只需判断 x1*y2-x2*y1 的正负值,为正说明 p1 到 p2 为左转. 
 *其实就是判断一个向量到另一个向量是逆时针转还是顺时针转
 */
public class ConvexHullWithMelkman {
	private Point[] pointArray;//坐标数组
	private final int N;//数据个数
	private int D[]; // 数组索引，双向表

	public ConvexHullWithMelkman(List<Point> pList) {
		this.pointArray = new Point[pList.size()];
		N = pList.size();
		int k = 0;
		for (Point p : pList) {
			pointArray[k++] = p;
		}
		D = new int[2 * N];
	}

	/**
	 * 求凸包点
	 * 
	 * @return 所求凸包点
	 */
	/**
	 * 基本思想是，从一个三角形开始，对每一个其他点，判断该点是否在该三角形内部，不在则
	 * 添加该点，使得三角形不断地扩大范围，多边形的变数也在变化。
	 * 获得到的点，序号可以连成一个闭环
	 * 另外是否在该多边形内部，根据从两端开始，逆时针的，在两边的左边（逆时针）
		具体的步骤是：
		1、初始化。跟Graham一样，取一点，得到角度，然后排序各点。
		2、接着 向双向表中依次装入P2,P0,P1,P2. 注意：这是一个收尾相连的三角形，三点不共线。
		3、设置 双向表的左右指针分别是bot、top。该范围内是，不断扩大范围的凸包点多边形
		
		4、反复i++，即是按照顺序，判断Pi是否在该多边形的内部，直到不在内部，
		即是d[t-1]、d[t-2]、Pi(逆时针方向)不做左转，或者d[bot+1]、d[bot+2]、Pi不做左转
		
		5、循环以下步骤直至d[t-1]、d[t-2]、Pi做左转
			t--;	//退栈，判断是否在新的凸包内部。防止出现凹处
			将Pi从右压入d
			
			循环以下步骤直至d[bot+1]、d[bot+2]、Pi做左转
			b++;	//退栈，判断是否在新的凸包内部。防止出现凹处
			将Pi从左压入d
			
			（每次执行第五步时候，两端的都需要压入相同的数，使得凸包闭环）
	
	这个算法可以在各点有序的前提下，每次获知一个点，就可以将先前的凸包改造成新的凸包。
	因此，这是一个在线算法，有着其他算法无法比拟的优势。
	 * @return
	 */
	public Point[] getTubaoPoint() {
		// 获得最小的Y，作为P0点
		float minY = pointArray[0].getY();
		int j = 0;
		for (int i = 1; i < N; i++) {
			if (pointArray[i].getY() < minY) {
				minY = pointArray[i].getY();
				j = i;
			}
		}
		//交换内容
		swap(0, j);

		// 计算除第一顶点外的其余顶点到第一点的线段与x轴的夹角
		for (int i = 1; i < N; i++) {
			pointArray[i].setArCos(angle(i));
		}

		quickSort(1, N - 1); // 根据所得到的角度进行快速排序

		int bot = N - 1;
		int top = N;
		D[top++] = 0;
		D[top++] = 1;
		int i;

		for (i = 2; i < N; i++) {// 寻找第三个点 要保证3个点不共线！！==0 代表共线
			if (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]], pointArray[i]) != 0)
				break;
			D[top - 1] = i; // 共线就更换顶点
		}

		D[bot--] = i;
		D[top++] = i; // i是第三个点 不共线！！

//		最初的一次
		int t;
		if (isLeft(pointArray[D[N]], pointArray[D[N + 1]], pointArray[D[N + 2]]) < 0) {
			// 此时队列中有3个点，要保证3个点a,b,c是成逆时针的，不是就调换ab
			t = D[N];
			D[N] = D[N + 1];
			D[N + 1] = t;
		}

		//开始
		for (i++; i < N; i++) {
			// 如果成立就是i在凸包内，跳过 //top=n+3 bot=n-2
//			此时top、bot没有改变
			if (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]],pointArray[i]) > 0 &&
					isLeft(pointArray[D[bot + 1]], pointArray[D[bot + 2]],pointArray[i]) > 0) {
				continue;
			}
			
			//非左转 则退栈
			while (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]],
					pointArray[i]) <= 0) {
				top--;
			}
			D[top++] = i;
			
			//反向表非左转 则退栈
			while (isLeft(pointArray[D[bot + 1]], pointArray[D[bot + 2]],
					pointArray[i]) <= 0) {
				bot++;
			}
			D[bot--] = i;
		}

		// 凸包构造完成，D数组里bot+1至top-1内就是凸包的序列(头尾是同一点)
		Point[] resultPoints = new Point[top - bot - 1];
		int index = 0;
		for (i = bot + 1; i < top - 1; i++) {
			System.out.println(pointArray[D[i]].getX() + ","
					+ pointArray[D[i]].getY());
			resultPoints[index++] = pointArray[D[i]];
		}
		return resultPoints;
	}

	/**
	 * 判断ba相对ao是不是左转
	 * 
	 * @return 大于0则左转
	 */
	private float isLeft(Point o, Point a, Point b) {
		float aoX = a.getX() - o.getX();
		float aoY = a.getY() - o.getY();
		float baX = b.getX() - a.getX();
		float baY = b.getY() - a.getY();

		return aoX * baY - aoY * baX;
	}

	/**
	 * 实现数组交换
	 * 
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		Point tempPoint = new Point();
		tempPoint.setX(pointArray[j].getX());
		tempPoint.setY(pointArray[j].getY());
		tempPoint.setArCos(pointArray[j].getArCos());

		pointArray[j].setX(pointArray[i].getX());
		pointArray[j].setY(pointArray[i].getY());
		pointArray[j].setArCos(pointArray[i].getArCos());

		pointArray[i].setX(tempPoint.getX());
		pointArray[i].setY(tempPoint.getY());
		pointArray[i].setArCos(tempPoint.getArCos());
	}

	/**
	 * 快速排序
	 * 
	 * @param top
	 * @param bot
	 */
	private void quickSort(int top, int bot) {
		int pos;
		if (top < bot) {
			pos = loc(top, bot);
			quickSort(top, pos - 1);
			quickSort(pos + 1, bot);
		}
	}

	/**
	 * 移动起点，左侧为小，右侧为大
	 * 
	 * @param top
	 * @param bot
	 * @return 移动后的位置
	 */
	private int loc(int top, int bot) {
		double x = pointArray[top].getArCos();
		int j, k;
		j = top + 1;
		k = bot;
		while (true) {
//			
			while (j < bot && pointArray[j].getArCos() < x)
				j++;
//			
			while (k > top && pointArray[k].getArCos() > x)
				k--;
			if (j >= k)
				break;
			swap(j, k);
		}
		swap(top, k);
		return k;
	}

	/**
	 * 角度计算
	 * 
	 * @param i 指针
	 * @return
	 */
	private double angle(int i) {
		double j, k, m, h;
		j = pointArray[i].getX() - pointArray[0].getX();
		k = pointArray[i].getY() - pointArray[0].getY();
		m = Math.sqrt(j * j + k * k); // 得到顶点i 到第一顶点的线段长度
		if (k < 0)
			j = (-1) * Math.abs(j);
		h = Math.acos(j / m); // 得到该线段与x轴的角度
		return h;
	}

	/**data.txt:
0	1
0	4
1	3
2	2
3	1
3	4
	 */
	public static void main(String args[]) {
		// File file = new File("G:/yl.txt");
		File file = new File("D:/data.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Point> pointList = new ArrayList<Point>();
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (str != null) {
			String[] s = str.split("\\t", 2);
			float x = Float.parseFloat(s[0].trim());
			float y = Float.parseFloat(s[1].trim());
			Point p = new Point();
			p.setX(x);
			p.setY(y);
			// System.out.println("文件数据：" + x + ", " + y);
			pointList.add(p);
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数据个数：" + pointList.size());

		ConvexHullWithMelkman m = new ConvexHullWithMelkman(pointList);
		m.getTubaoPoint();
	}
}