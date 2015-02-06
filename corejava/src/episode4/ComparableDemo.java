package episode4;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ComparableDemo {

	public static void main(String[] args) {
		Student stu1=new Student();
		stu1.setName("Kane");
		stu1.setStuno(2);
		Student stu2=new Student();
		stu2.setName("Jiliy");
		stu2.setStuno(30);
		Student stu3=new Student();
		stu3.setName("Lali");
		stu3.setStuno(1);
		Map<Student,String> map=new TreeMap<Student,String>();//TreeMap会自动对Key进行排序
		map.put(stu1, "Student1");
		map.put(stu2, "Student2");
		map.put(stu3, "Student3");
		
		for(Iterator<Entry<Student, String>> it=map.entrySet().iterator();it.hasNext();){
			Entry entry=(Entry)it.next();
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}

}

class Student implements Comparable<Student> {
	private int stuno;

	private String name;

	public int getStuno() {
		return stuno;
	}

	public void setStuno(int stuno) {
		this.stuno = stuno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		if (o.stuno > this.stuno)
			return -1;
		else if (o.stuno < this.stuno)
			return 1;
		else
			return 0;
	}
	
	public String toString(){
		return "Student "+this.name+"("+this.stuno+")";
	}

}