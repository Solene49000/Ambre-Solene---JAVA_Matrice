package matrice;

public class Pair<T, U> {

    private T first;
    private U second;

    Pair(T first, U second) {
        this.setKey(first);
        this.setValue(second);
    }

    public T getKey() {
        return first;
    }

    public U getValue() {
        return second;
    }
    
    public void setKey(T first) {
		this.first = first;
	}
    
    public void setValue(U second) {
		this.second = second;
	}
}
