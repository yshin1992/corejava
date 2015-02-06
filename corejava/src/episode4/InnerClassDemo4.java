package episode4;

import java.util.logging.Logger;

public class InnerClassDemo4 {

	/*
	 * 静态内部类
	 */
	
	public static void main(String[] args) {
		ArrayAlg.Pair p=new ArrayAlg().getMaxMin(new double[]{12.2,33,42,10,4,5});
		System.out.println("Max :" +p.getFirst()+"\tMin :"+p.getSecond());
	}
	
}

class ArrayAlg{
	
	public Pair getMaxMin(double[] value){
		double max=Double.MIN_VALUE;
		double min=Double.MAX_VALUE;
		for(double v:value){
			max=max<v?v:max;
			min=min>v?v:min;
		}
		return new Pair(max,min);
	}
	
	static class Pair{
		//当内部类不需要访问外部类的属性时，就可以使用静态内部类
		double first;
		double second;
		public Pair(double first,double second){
			this.first=first;
			this.second=second;
		}
		
		public double getFirst(){
			return this.first;
		}
		
		public double getSecond(){
			return this.second;
		}
	}
	
}

