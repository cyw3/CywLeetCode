package com.cyw.regularexpressions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://blog.csdn.net/allwefantasy/article/details/3136570
 * @author cyw
 *
 */
public class Typical {

	/**
	 * 在regex包中，包括了两个类，Pattern(模式类)和Matcher(匹配器类)。
	 * Pattern类是用来表达和陈述所要搜索模式的对象，Matcher类是真正影响搜索的对象。
	 * 另加一个新的例外类，PatternSyntaxException，当遇到不合法的搜索模式时，
	 * 会抛出例外。
	 * @param args
	 */
	public static void main(String [] args){
		//从一个文本文件逐行读入，并逐行搜索电话号码数字，一旦找到所匹配的，然后输出在控制台。
		//(\d{3})\s\d{3}-\d{4}
//		对java的解释器来说，在反斜线字符(/)前的字符有特殊的含义。在java中，与regex有关的包，
//		并不都能理解和识别反斜线字符(/)，尽管可以试试看。但为避免这一点，
//		即为了让反斜线字符(/)在模式对象中被完全地传递，应该用双反斜线字符(/)。
//		此外圆括号在正则表达中两层含义，如果想让它解释为字面上意思(即圆括号)，也需要在它前面用双反斜线字符(/)。
		BufferedReader in;
		//设置 匹配模式 
//		Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
//		Pattern pattern = Pattern.compile("\\s");
		Pattern pattern = Pattern.compile("(\\(\\d{3}\\)|\\d{3})\\s?\\d{3}(-|)?\\d{4}");//电话号码匹配器
		try {
			in = new BufferedReader(new FileReader("phone.txt"));

			String s;
			while ((s = in.readLine()) != null) {
				//执行、匹配 模式
				Matcher matcher = pattern.matcher(s);
//				find()方法，就像你所想象的，用来搜索与正则表达式相匹配的任何目标字符串，
//				group()方法，用来返回包含了所匹配文本的字符串。
				if (matcher.find()) {
					System.out.println(matcher.group());
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
