import java.util.Iterator;

public class Dept implements Entity_ {
	String name;
	LinkedList<Student_> deptstudentslist = new LinkedList<>();
	public Dept(String n) {
		name=n;
	}

	public String name() {
		return name;
	}
	
	public void add( Student_ s) {
		deptstudentslist.add( s);
	}

	public  Iterator<Student_> studentList(){
		return deptstudentslist.iter();
	}
}
