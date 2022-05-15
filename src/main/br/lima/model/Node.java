package main.br.lima.model;

public class Node<T> {
	
	private T element;
	private Node<T> previous;
	private Node<T> next;
	
	public Node(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}
	
	public Node<T> getPrevious() {
		return previous;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
