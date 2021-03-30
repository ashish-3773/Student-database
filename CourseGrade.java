
public class CourseGrade implements CourseGrade_ {
	
	Course c;
	GradeInfo_ grade;
	
	public CourseGrade(Course cou, GradeInfo_ g){
		c = cou;
		grade=g;
	}
	
	public String coursetitle() {
		return c.title();
	}   	  
	public String coursenum() {
	   return c.name();
	}
	public GradeInfo_ grade() {
		return grade;
	}
}
