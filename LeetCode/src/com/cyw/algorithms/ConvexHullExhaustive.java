package com.cyw.algorithms;

import java.util.*;

public class ConvexHullExhaustive {
	public static class Line {//线
		 Point p1, p2;
		 Line(Point p1, Point p2) {
		  this.p1 = p1;
		  this.p2 = p2;
		 }
		}

	public static class Point{//点
		  int x;
		  int y;
		}

	List<Point> pts = null;//点集
	List<Line> lines = new ArrayList<Line>();//点集pts的凸包

	public void setPointList(List<Point> pts) {
	     this.pts = pts;
	}

	public List<Line> eval() {
		    lines.clear();
		    if (pts == null) { return lines; }
		    int n = pts.size();
		    int a, b, c, cc, l, r;
		    for (int i = 0; i < n; i++) {
		     for (int j = i+1; j < n; j++) {//穷举点集中任意两点组成的直线ax+by=c
		       a = pts.get(j).y - pts.get(i).y;//
		       b = pts.get(i).x - pts.get(j).x;
		       c = pts.get(i).x * pts.get(j).y -pts.get(i).y * pts.get(j).x;
		       l = r = 0;
		       int k;
		       for (k = 0; k < n; k++) {//穷举点集中的每一点
		         cc = a * pts.get(k).x + b * pts.get(k).y;
		         if (cc > c) l++;
		         else if (cc < c) r++;
		         if (l * r != 0) break;//直线两侧都有点,
		       }
		      if (k == n) {//凸包中添加一条边
		        lines.add(new Line(pts.get(i), pts.get(j)));
		      }
		     }
		   }
		   return lines;
		  }
}


  
