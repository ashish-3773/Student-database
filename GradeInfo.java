
public class GradeInfo implements GradeInfo_ {
	LetterGrade grade;
	
	public GradeInfo(LetterGrade lg) {
		grade = lg;
	}

	@Override
	public LetterGrade getGrade() {
		return grade;
	}
	
}
