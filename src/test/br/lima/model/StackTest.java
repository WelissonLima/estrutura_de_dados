package test.br.lima.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.br.lima.exceptions.EmptyListException;
import main.br.lima.exceptions.SizeLimitListException;
import main.br.lima.model.Queue;
import main.br.lima.model.Stack;

class StackTest {

	@Test
	void testEmptyTrueStack() {
		Stack<Object> stack = new Stack<Object>();
		stack.offer(1);
		stack.pop();

		assertTrue(stack.empty());
		assertEquals(0, stack.size());
	}

	@Test
	void testEmptyFalseStack() {
		Stack<Object> stack = new Stack<Object>();
		stack.offer(1);

		assertFalse(stack.empty());
		assertEquals(1, stack.size());
	}

	@Test
	void testPeekStack() {
		Stack<Object> stack = new Stack<Object>();
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);

		assertFalse(stack.empty());
		assertEquals(3, stack.peek());
	}

	@Test
	void testPeekExceptionStack() {
		String message = "";

		Stack<Object> stack = new Stack<Object>(3);
		stack.offer(1);
		stack.pop();

		stack.offer(2);
		stack.pop();

		stack.offer(3);
		stack.pop();

		try {
			stack.peek();
		} catch (EmptyListException e) {
			message = e.getMessage();
		}

		assertEquals("The list is empty.", message);
	}

	@Test
	void testPopStack() {
		Stack<Object> stack = new Stack<Object>();
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);

		assertEquals(3, stack.size());
		assertEquals(3, stack.pop());
		assertEquals(2, stack.size());

		assertEquals(2, stack.pop());
		assertEquals(1, stack.size());

		assertEquals(1, stack.pop());
		assertEquals(0, stack.size());

		assertTrue(stack.empty());
	}

	@Test
	void testPopExceptionStack() {
		String message = "";

		Stack<Object> stack = new Stack<Object>(3);

		try {
			stack.pop();
		} catch (EmptyListException e) {
			message = e.getMessage();
		}

		assertEquals("The list is empty.", message);
	}

	@Test
	void testMaxSizeStack() {
		String message = "";

		Stack<Object> stack = new Stack<Object>(3);
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);

		try {
			stack.offer(4);
		} catch (SizeLimitListException e) {
			message = e.getMessage();
		}

		assertEquals("Exceeded size limit.", message);
	}

	@Test
	void testSizeStack() {
		Stack<Object> stack = new Stack<Object>();
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);
		stack.offer(4);
		stack.offer(5);

		assertFalse(stack.empty());
		assertEquals(5, stack.size());
	}
	
	@Test
	void testGetQueueElements() {
		Stack<Object> stack = new Stack<Object>();
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);
		stack.offer(4);
		stack.offer(5);
		
		List<Object> listElements = stack.getElements();
		assertFalse(listElements.isEmpty());
		assertEquals(5, listElements.size());
		assertEquals(5, listElements.get(0));
		assertEquals(4, listElements.get(1));
		assertEquals(3, listElements.get(2));
		assertEquals(2, listElements.get(3));
		assertEquals(1, listElements.get(4));
	}
}
