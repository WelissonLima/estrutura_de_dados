package main.br.lima.model;

import java.util.List;

public class Stack<T> extends Dequeue<T>{

	public Stack() {
	}
	
	public Stack(Integer max) {
		super(max);
	}
	
	public boolean empty() {
		return super.empty();
	}
	
	public void offer(T element) {
		super.offerFirst(element);
	}
	
	public T peek() {
		return super.peekFirst();
	}
	
	public T pop() {
		return super.popFirst();
	}
	
	public Integer size() {
		return super.size();
	}

	public List<T> getElements() {
		return super.getElements();
	}
}
