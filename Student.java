import java.util.Iterator;


public class Student implements Student_ {
	String name;
	String entryno,hostel,departm;
	
	LinkedList<CourseGrade_> course_list = new LinkedList<CourseGrade_>();
	
	
	public Student(String n,String e,String h,String d) {
		name = n;
		entryno= e;
		hostel = h;
		departm = d;
	}
	
	
	public void addGrade(Course cou, GradeInfo_ g) {
		CourseGrade_ cg = new CourseGrade(cou,g);
		course_list.add(cg);
		
	}
	
	public String name() {
		return name;
	}               	
	   public String entryNo() {
		   return entryno;
	   }            	
	   public String hostel() {
		   return hostel;
	   }             	
	   public String department() {
		   return departm;
	   }         	
	   public String completedCredits() {
		   int earnedcredits=0;
		   Iterator<CourseGrade_> itr = course_list.iter();
		   while(itr.hasNext()) {
			   CourseGrade_ c = itr.next();
			   
			   if (c.grade().getGrade() != GradeInfo_.LetterGrade.I) {
				   earnedcredits+=3;
				   
			   }
			   
		   }
		   return Integer.toString(earnedcredits);
		   
	   }
		   
	   public String cgpa() {
		   int earnedcredits=0;
		   float mult=0;
		   Iterator<CourseGrade_> itr = course_list.iter();
		   while(itr.hasNext()) {
			   CourseGrade_ c = itr.next();
			   
			   if (c.grade().getGrade() != GradeInfo_.LetterGrade.I) {
				   earnedcredits+=3;
				   mult+=3*GradeInfo_.gradepoint(c.grade().getGrade());
				   
				   
			   }
			   
			   
		   }
		   float cgpa=mult/earnedcredits;
		   return String.format("%.2f", cgpa);
	   }

	@Override
	public Iterator<CourseGrade_> courseList() {
		return course_list.iter();
	}

}
