import java.util.Iterator;

public class Workassign {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		
		
		Iterator<Integer> iterator = list.iter();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		Hostel hostel = new Hostel("Zanskar");
				
				System.out.println(hostel.name());
	}

}
