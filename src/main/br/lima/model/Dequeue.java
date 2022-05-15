package main.br.lima.model;

import java.util.ArrayList;
import java.util.List;

import main.br.lima.exceptions.EmptyListException;
import main.br.lima.exceptions.SizeLimitListException;

public class Dequeue<T> {

	private Node<T> header;
	private Node<T> tailer;
	private Integer max;
	
	public Dequeue() {
	}
	
	public Dequeue(Integer max) {
		this.max = max;
	}
	
	public Dequeue(Dequeue<T> dequeue) {
		this.header = dequeue.header;
		this.tailer = dequeue.tailer;
		this.max = dequeue.max;
	}
	
	protected boolean empty() {
		return header == null;
	}
	
	protected void offerFirst(T element) {
		Node<T> node = new Node<>(element);
		Integer size = this.size();
		
		if(this.max == size) {
			throw new SizeLimitListException("Exceeded size limit.");
		} else if(this.header == null) {
			this.header = node;
			this.tailer = node;
		}else {
			node.setNext(this.header);
			this.header = node; 			
		}
	}
	
	protected void offerLast(T element) {
		Node<T> node = new Node<>(element);
		Integer size = this.size();
		
		if(this.max == size) {
			throw new SizeLimitListException("Exceeded size limit.");
		} else if(this.header == null) {
			this.header = node;
			this.tailer = node;
		} else if(this.header.getNext() == null) {
			node.setPrevious(this.header);
			this.header.setNext(node);
			this.tailer = node; 
		} else {
			Node<T> nodeLast = this.tailer;
			nodeLast.setNext(node);
			
			node.setPrevious(nodeLast);			
			
			this.tailer = node; 
		}		
	}
	
	protected T popFirst() {
		Node<T> nodeCurrent = this.header;
		
		if(empty()) {
			throw new EmptyListException("The list is empty.");
		} else if(this.header.getNext() == null) {
			this.header = null;
			this.tailer = null;
		} else{
			Node<T> nodeNext = this.header.getNext();
			nodeNext.setPrevious(null);			
			this.header = nodeNext;
		}		
		
		return nodeCurrent.getElement(); 
	}
	
	protected T popLast() {
		if(empty()) {
			throw new EmptyListException("The list is empty.");
		}
		
		Node<T> nodeLastCurrent = this.tailer;
		
		Node<T> nodePrevious = this.tailer.getPrevious();
		nodePrevious.setNext(null);
		
		this.tailer = nodePrevious;
		
		return nodeLastCurrent.getElement(); 
	}
	
	protected T peekFirst() {
		if(empty()) {
			throw new EmptyListException("The list is empty.");
		}
		
		return header.getElement(); 
	}
	
	protected T peekLast() {
		if(empty()) {
			throw new EmptyListException("The list is empty.");
		}
		
		return tailer.getElement(); 
	}
	
	protected Integer size() {
		Integer size = 0;
		
		Node<T> node = this.header;
		
		while (node != null) {
			size++;
			
			node = node.getNext();
		}
		
		
		return size;
	}
	
	protected List<T> getElements() {
		List<T> listElements = new ArrayList<>();
		
		Node<T> nodeHeader = this.header;
		while (nodeHeader != null) {
			listElements.add(nodeHeader.getElement());
			
			nodeHeader = nodeHeader.getNext();
		}
		
		return listElements;
	}
	
	public Integer getMaxSize() {
		return this.max;
	}
	
}
