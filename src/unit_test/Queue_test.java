package unit_test;

import static org.junit.Assert.*;

import org.junit.Test;

import queue.Queue;

public class Queue_test {

  @Test
  public void testGetElementCount() {
    Queue<Integer> test = new Queue<Integer>();
    
    for(int i = -5;i < 6;i++){
      test.Enqueue(i);
    }
    assertEquals(11,test.GetElementCount());
    
    for(int i = 0;i < 3;i++){
      test.Dequeue();
    }
    assertEquals(8,test.GetElementCount());
    
    for(int i = 0;i < 8;i++){
      test.Dequeue();
    }
    assertEquals(0,test.GetElementCount());
    
    test.Dequeue();
    assertEquals(0,test.GetElementCount());
  }

  @Test
  public void testEnqueueDequeue() {
    Queue<Integer> test = new Queue<Integer>();
    
    assertNull("Dequeuing empty queue results in non null value",test.Dequeue());
    
    test.Enqueue(0);
    assertEquals(Integer.valueOf(0),test.Dequeue());
    
    for(int i = -5;i < 6;i++){
      test.Enqueue(i);
    }
    assertEquals(Integer.valueOf(-5),test.Dequeue());
    assertEquals(Integer.valueOf(-4),test.Dequeue());
    assertEquals(Integer.valueOf(-3),test.Dequeue());
    
    while(test.GetElementCount() != 0){
      test.Dequeue();
    }
    assertNull(test.Dequeue());
  }

  @Test
  public void testSearch() {
    Queue<Integer> test = new Queue<Integer>();
    assertFalse(test.Search(Integer.valueOf(3)));
    
    
    for(int i = -5;i < 6;i++){
      test.Enqueue(i);
    }
    assertTrue(test.Search(Integer.valueOf(0)));
    assertTrue(test.Search(Integer.valueOf(-4)));
    assertTrue(test.Search(Integer.valueOf(4)));
    
    assertFalse(test.Search(Integer.valueOf(6)));
    assertFalse(test.Search(Integer.valueOf(-6)));
    
    test.Dequeue();
    test.Dequeue();
    
    assertTrue(test.Search(Integer.valueOf(0)));
    assertTrue(test.Search(Integer.valueOf(4)));
    
    assertFalse(test.Search(Integer.valueOf(-4)));
    assertFalse(test.Search(Integer.valueOf(6)));
    assertFalse(test.Search(Integer.valueOf(-6)));
    
    
  }

  @Test
  public void testPeek() {
    Queue<Integer> test = new Queue<Integer>();
    assertNull(test.Peek(3));
    
    for(int i = -5;i < 6;i++){
      test.Enqueue(i);
    }
    
    assertEquals(Integer.valueOf(-3),test.Peek(2));
    assertEquals(Integer.valueOf(0),test.Peek(5));
    assertEquals(Integer.valueOf(4),test.Peek(9));
    assertNull(test.Peek(11));
    
    test.Dequeue();
    test.Dequeue();
    
    assertEquals(Integer.valueOf(-1),test.Peek(2));
    assertEquals(Integer.valueOf(2),test.Peek(5));
    assertNull("Peeking beyond element_count result in non null values",test.Peek(9));
  }
}
