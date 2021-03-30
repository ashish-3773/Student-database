
public class Position<T> implements Position_<T> {
	T val;
	Position<T> after;
	
	public Position(T e,Position<T> f){
		val= e;
		after =f;	
	}

	public T value(){
	return val;
	}

	public Position_<T> after(){
	return after;	
	}
} 