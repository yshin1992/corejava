package episode4;

import java.util.Date;
import java.util.GregorianCalendar;

public class LowCloneDemo {

	/*
	 * 浅克隆实例
	 * 注意观察
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1=new Employee("Jane");
		e1.setHireDate(new GregorianCalendar(2009, 6, 12).getTime());
		Employee e2=e1.clone();
		e2.setName("Kate");
		Date d=e2.getHireDate();
		d.setYear(2011);
		e2.setHireDate(d);
		System.out.println(e1);
		System.out.println(e2);
		
	}

}

class Employee implements Cloneable{
	private String name;
	
	protected Date hireDate;
	
//	private IDPassport psport;
	
	public Employee(String name){
		this.name=name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public Date getHireDate(){
		return this.hireDate;
	}
	
//	public void setPsport(String id,String name){
//		psport=new IDPassport();
//		psport.setName(name);
//		psport.setId(id);
//	}
	
	public Employee clone() throws CloneNotSupportedException{
		return (Employee) super.clone();
	}
	public void setHireDate(int year,int month,int day){
		hireDate=new GregorianCalendar(year,month-1,day).getTime();
	}
	
	public void setHireDate(Date date){
		hireDate=date;
	}
	
	public String toString(){
		return "Employee["+name+","+hireDate+"]";
	}
}

class IDPassport{
	String id;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name+"/"+this.id;
	}
}
