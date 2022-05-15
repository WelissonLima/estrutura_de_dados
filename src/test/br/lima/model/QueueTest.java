package test.br.lima.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.br.lima.exceptions.EmptyListException;
import main.br.lima.exceptions.SizeLimitListException;
import main.br.lima.model.Queue;

class QueueTest {

	@Test
	void testEmptyTrueQueue()  {
		Queue<Object> queue = new Queue<Object>();
		queue.offer(1);
		queue.pop();
		
		assertTrue(queue.empty());
		assertEquals(0, queue.size());
	}
	
	@Test
	void testEmptyFalseQueue() {
		Queue<Object> queue = new Queue<Object>();
		queue.offer(1);
		
		assertFalse(queue.empty());
		assertEquals(1, queue.size());
	}
	
	@Test
	void testPeekQueue() {
		Queue<Object> queue = new Queue<Object>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		assertFalse(queue.empty());
		assertEquals(1, queue.peek());
	}
	
	@Test
	void testPeekExceptionQueue() {
		String message = "";
		
		Queue<Object> queue = new Queue<Object>(3);
		queue.offer(1);
		queue.pop();

		queue.offer(2);
		queue.pop();

		queue.offer(3);
		queue.pop();
		
		try {
			queue.peek();
		} catch (EmptyListException e) {
			message = e.getMessage();
		}
		
		assertEquals("The list is empty.", message);
	}
	
	@Test
	void testPopQueue()  {
		Queue<Object> queue = new Queue<Object>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		assertEquals(3, queue.size());
		assertEquals(1, queue.pop());
		assertEquals(2, queue.size());
		
		assertEquals(2, queue.pop());
		assertEquals(1, queue.size());
		
		assertEquals(3, queue.pop());
		assertEquals(0, queue.size());
		
		assertTrue(queue.empty());
	}
	
	@Test
	void testPopExceptionQueue() {
		String message = "";
		
		Queue<Object> queue = new Queue<Object>(3);
		
		try {
			queue.pop();
		} catch (EmptyListException e) {
			message = e.getMessage();
		}
		
		assertEquals("The list is empty.", message);
	}
	
	@Test
	void testSizeLimitExceptionQueue()  {
		String message = "";
		
		Queue<Object> queue = new Queue<Object>(3);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		try {
			queue.offer(4);
		} catch (SizeLimitListException e) {
			message = e.getMessage();
		}
		
		assertEquals("Exceeded size limit.", message);
	}
	
	@Test
	void testSizeQueue() {
		Queue<Object> queue = new Queue<Object>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		
		assertFalse(queue.empty());
		assertEquals(5, queue.size());
	}

	
	@Test
	void testGetQueueElements() {
		Queue<Object> queue = new Queue<Object>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		
		List<Object> listElements = queue.getElements();
		assertFalse(listElements.isEmpty());
		assertEquals(5, listElements.size());
		assertEquals(1, listElements.get(0));
		assertEquals(2, listElements.get(1));
		assertEquals(3, listElements.get(2));
		assertEquals(4, listElements.get(3));
		assertEquals(5, listElements.get(4));
	}

}
