import java.util.Iterator;

public  class Course implements Entity_ {
	String name;
	String title;
	LinkedList<Student_> coursestudentslist = new LinkedList<Student_>();
	public Course(String n, String t ) {
		name=n;
		title=t;
	}
	
	public String name() {
		return name;
	}
	
	public String title() {
		return title;
	}
	
	public void add(Student_ s) {
		
		coursestudentslist.add(s);
	}
	
	public Iterator<Student_> studentList(){
		return coursestudentslist.iter();
	}


}
