package episode4;

import java.util.Date;
import java.util.GregorianCalendar;

public class DeepCloneDemo {

	/*
	 * 浅克隆实例
	 * 注意观察运行结果
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee2 e1=new Employee2("Jane");
		e1.setHireDate(new GregorianCalendar(2009, 6, 12).getTime());
		Employee2 e2=(Employee2) e1.clone();
		e2.setName("Kate");
		Date d=e2.getHireDate();
		d.setYear(2011);
		e2.setHireDate(d);
		System.out.println(e1);
		System.out.println(e2);
		
	}

}

class Employee2 extends Employee{

	public Employee2(String name) {
		super(name);
	}
	
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned=(Employee2) super.clone();
		
		cloned.hireDate=(Date) hireDate.clone();
		
		return cloned;
	}
	
}