import java.util.Iterator;

public class Hostel implements Entity_ {
	String name;
	LinkedList<Student_> studentslist = new LinkedList<Student_>();
	
	public Hostel(String n) {
		name =n;
	}
	
	public String name() {
		return name;
	} 
	public void add( Student_ s) {
		studentslist.add(s);
	}
	 
	 
	public Iterator<Student_> studentList(){
		return studentslist.iter();
	}
}
