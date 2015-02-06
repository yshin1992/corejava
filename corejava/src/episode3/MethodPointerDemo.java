package episode3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodPointerDemo {

	/*
	 * Java中的方法指针Method.invoke(obj,param...);
	 */
	public static void main(String[] args) {
		try {
			Method m1=MethodPointerDemo.class.getDeclaredMethod("square", double.class);
			Method m2=Math.class.getDeclaredMethod("sqrt", double.class);
			printTab(1, 10, 1, m1);
			printTab(1, 10, 1, m2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double square(double x){
		return x*x;
	}
	public static void printTab(double from,double to,double dx,Method f){
		System.out.println(f.getName());
		
		f.setAccessible(true);//防止出现can't access 异常
		for(double d=from;d<=to;d+=dx){
			try {
				double y=(double)f.invoke(null, d);
				System.out.printf("%10.4f | %10.4f\n",d,y);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
