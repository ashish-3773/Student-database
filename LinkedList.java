import java.util.Iterator;

public class LinkedList<T> implements LinkedList_<T> {
	Position<T> head;
	Position<T> tail;
	int count=0;

	public Position_<T> add(T e){

		
	Position<T> p= new Position<T>(e,null);
				
	if(head==null){
	head=p;
	tail=p;
		
	}
	else{
		tail.after=p;
		tail=p;
	}
	count++;
	return p;
	}
	
	public void addhead(T e) {
		Position<T> p= new Position<T>(e,null);
		
		p.after = head;
		head = p;
		count++;
		
	}
	
	public Iterator<Position_<T>>  positions() {
   		
		return new hasiterator<T>(this);
	}
	public Iterator<T> iter() {
		return new Titerator<T>(this);
	}
	
   	public  int count() {
   		return count;
   		
   	}                    	
}

class hasiterator<T> implements Iterator<Position_<T>>{
	Position_<T> now;
	public hasiterator(LinkedList<T> list){
		 now=list.head;
	}
	
	public boolean hasNext() {
		return(now!=null);
	}
	public Position_<T> next() {
		Position_<T> curr= now;
		now=curr.after();
		return curr;
		
	}
}

class Titerator<T> implements Iterator<T>{
	Position_<T> now;
	public Titerator(LinkedList<T> list){
		 now=list.head;
	}
	
	public boolean hasNext() {
		return(now!=null);
	}
	public T next() {
		Position_<T> curr= now;
		now=curr.after();
		return curr.value();
	}
}

