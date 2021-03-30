import java.io.*;
import java.util.Iterator;


public class Assignment1<Bubblesort> {
	
	static LinkedList<Hostel> allHostels = new LinkedList<Hostel>();
	static LinkedList<Dept> allDepts = new LinkedList<Dept>();
	static LinkedList<Course> allCourses = new LinkedList<Course>();
	static LinkedList<Student> allStudents = new LinkedList<Student>();
	
	public static void main (String args[]) throws IOException {
		
		String sfilename = args[0];
		String cfilename= args[1];
		String qfilename= args[2];
		
		getdata(sfilename,cfilename);
		answerQueries(qfilename);
	}
	
	
	private static void getdata(String s, String c ) throws IOException {
		FileReader in = new FileReader(s);
		BufferedReader br = new BufferedReader(in);
		FileReader in1 = new FileReader(c);
		BufferedReader br1 = new BufferedReader(in1);
		String line;
		while((line =br.readLine())!=null) {
			String arr[]=line.split(" ");
			Student obj= new Student(arr[1],arr[0],arr[3],arr[2]);
			allStudents.add(obj);
			
			Hostel obj1 = null;
			
			int flag = 0;
			
			Iterator<Hostel> list = allHostels.iter();
			while (list.hasNext()) {
				obj1 = list.next();
				if(arr[3].equals(obj1.name())) {
					flag =1;
					break;
				}
			}
			if (flag==0) {
				obj1 = new Hostel(arr[3]);
				allHostels.add(obj1);
			}
//			
			obj1.add(obj);
			
			Dept obj2 = null;
			
			int flag1 = 0;
			
			Iterator<Dept> list1 = allDepts.iter();
			while (list1.hasNext()) {
				obj2 = list1.next();
				if(arr[2].equals(obj2.name())) {
					flag1 =1;
					break;
				}
			}
			if (flag1==0) {
				obj2 = new Dept(arr[2]);
				allDepts.add(obj2);
			}
//			
			obj2.add(obj);
			
		}
		String line1;
		while((line1=br1.readLine())!= null) {
			String arr1[]=line1.split(" ",4);
			
			Course obj3 = null;
			int flag2=0;
			Iterator<Course> list2 = allCourses.iter();
			while(list2.hasNext()) {
				obj3=list2.next();
				if(arr1[1].equals(obj3.name())) {
					flag2=1;
					break;
				}
			}
			if (flag2==0) {
				obj3=new Course(arr1[1],arr1[3]);
				allCourses.add(obj3);
			}
			
			
			Iterator<Student> list3 = allStudents.iter();
			while(list3.hasNext()) {
				Student s1 = list3.next();
				if(arr1[0].equals(s1.entryNo())) {
					GradeInfo_.LetterGrade grade = GradeInfo_.LetterGrade.valueOf(arr1[2]);
					
					GradeInfo g = new GradeInfo(grade);
					
					s1.addGrade(obj3,g);
					obj3.add(s1);
					break;
				}
			}
			
			
			
		}	
		
		br.close();
		br1.close();
		
	}
	private static void answerQueries(String q) throws IOException {
		FileReader in2 = new FileReader (q);
		BufferedReader br2= new BufferedReader (in2);
		
		String line2 ;
		
		LinkedList<String> queries= new LinkedList<String>();
		
		while((line2=br2.readLine())!=null) {
			queries.addhead(line2);
		}
		
		Iterator<String> i7 = queries.iter();
		
		while(i7.hasNext()) {
			line2 = i7.next();
			String arr2[]= line2.split(" ");
			String shr = arr2[0];
			if (shr.equals("SHARE")) {
				String entryno =arr2[1];
				String entity = arr2[2];
				
				Iterator <Student> stud = allStudents.iter();
				
				while(stud.hasNext()) {
					Student s = stud.next();
					if (entryno.equals(s.entryNo())) {
						if (s.hostel().equals(entity)) {

							Iterator <Hostel> h1 = allHostels.iter();
							while (h1.hasNext()) {
								Hostel h2 = h1.next();
								if (h2.name().equals(entity)) {
									Iterator<Student_> s1 = h2.studentList();
									String[] array= new String[h2.studentslist.count()];
									int n = 0;
									while(s1.hasNext()) {
										Student_ s3 = s1.next();
										if (s3.entryNo().equals(entryno)) {
											System.out.print("");
										}
										else {
											array[n] = s3.entryNo()+" ";
											n++;
										}
										
									}

									BubbleSort.sort(array, n);
									for(int i= 0;i<n;i++) {
										System.out.print(array[i]);
									}
									
									System.out.println();
								}
							}
						
						}		
						
					
						else if (s.department().equals(entity)) {

							Iterator<Dept> d1 = allDepts.iter();
							while (d1.hasNext()) {
								Dept d2 = d1.next();
								if (d2.name().equals(entity)) {
									Iterator<Student_> s1 = d2.studentList();
									String[] array1 = new String[d2.deptstudentslist.count()] ;
									int n1 = 0;
									while(s1.hasNext()) {
										Student_ s4 = s1.next();
										if (s4.entryNo().equals(entryno)) {
											System.out.print("");
										}
										else {
											//System.out.print(s4.entryNo()+" ");
											array1[n1]=s4.entryNo()+" ";
											n1++;
										}
						
									}
									BubbleSort.sort(array1, n1);
									for(int i= 0;i<n1;i++) {
										System.out.print(array1[i]);
										
									}
									System.out.println();
								}
						
							}
					
						}
						else
						{

							Iterator<Course> c1 = allCourses.iter();
							while(c1.hasNext()) {
								Course c = c1.next();
								String course = c.name(); 
								
								if (course.equals(entity)) {
									
									Iterator<Student_> s1 = c.studentList();
									String[] array2 = new String[c.coursestudentslist.count()];
									int n2=0;
									while(s1.hasNext()) {
										Student_ s3 = s1.next();
										if (s3.entryNo().equals(entryno)) {
											System.out.print("");
										}
										else {
											//System.out.print(s3.entryNo()+" ");
											array2[n2] =s3.entryNo()+" ";
											n2++;
										}	
				
									}
									BubbleSort.sort(array2,n2);
									for(int j =0;j<n2;j++) {
										System.out.print(array2[j]);
									}
									System.out.println();
		
								}
											
									
										
							}
									
						}
						
					}
						
				}	
							
							
			}				
			String info =arr2[0];
			if(info.equals("INFO")) {
				String w1 = arr2[1];
				
				Iterator<Student> stud1 = allStudents.iter();
				
				while(stud1.hasNext()) {
					Student s1= stud1.next();
					String dad1 = s1.entryno;
					if (w1.equals(dad1)) {
						String[] array3 = new String[s1.course_list.count()];
						int n3= 0;
						String ret = s1.entryNo() +" "+s1.name()+" "+s1.department()+" "+s1.hostel()
							+" " + s1.cgpa() + " " 	;
						
						Iterator<CourseGrade_> iter = s1.courseList();
						while(iter.hasNext()) {
							CourseGrade_ s9 = iter.next();
							array3[n3] = s9.coursenum()+" "+s9.grade().getGrade()+" ";
							n3++;
						}
						BubbleSort.sort(array3,n3);
						for(int d=0;d<n3;d++) {
							ret+=array3[d];
						}
						System.out.println(ret);
					}
					
				}
			}
			

					
					
			String courset = arr2[0];
			if(courset.equals("COURSETITLE")) {
				String w2 = arr2[1];
				
				Iterator<Course> stud2 = allCourses.iter();
			
				while(stud2.hasNext()) {
					Course s2= stud2.next();
					String dad2 = s2.name();
					if(w2.equals(dad2)) {
						System.out.println(s2.title());
					}
				}
				}
			}
		
			br2.close();
		
		}
}



class BubbleSort {
  public static void sort(String []array,int length) {
    int  c, d; 
    String swap;
    int n =length;
   
    for (c = 0; c < ( n - 1 ); c++) {
      for (d = 0; d < n - c - 1; d++) {
        if (array[d].compareTo( array[d+1])>0) 
        {
          swap       = array[d];
          array[d]   = array[d+1];
          array[d+1] = swap;
        }
      }
    }
 
  }
}

