package queue;

public class Queue<E> {
  private QueueItem<E> head;
  private QueueItem<E> tail;
  private int element_count;
  
  public int GetElementCount() {
    return element_count;
  }
  
  public Queue(){
    head = new QueueItem<E>();
    tail = new QueueItem<E>();
    element_count = 0;
  }
  
  public void Enqueue(E item){
    if (element_count == 0){
      head.item = item;
      tail.item = item;
    } else
    if (element_count == 1){
      tail = new QueueItem<E>(item);
      head.nextItem = tail;
      tail.prevItem = head;
    } else {
      QueueItem<E> newTail = new QueueItem<E> (item,null,tail);
      tail.nextItem = newTail;
      tail = newTail;
    }
    element_count++;
  }
  
  public E Dequeue(){
    if (element_count == 0){
      System.out.println("Queue is empty\n");
    } else
    if (element_count == 1){
      E output = head.item;
      head.Nullify();
      tail.Nullify();
      element_count--;
      return output;
    } else {
      E output = head.item;
      QueueItem<E> newHead = head.nextItem;
      newHead.prevItem = null;
      head = newHead;
      element_count--;
      return output;
    }
    return null;
  }
  
  public boolean Search(E item){
    boolean found = false;
    if (element_count != 0){
      QueueItem<E> traverse = head;
      while ((traverse != null) && (!found)){
        found = (traverse.item.equals(item));
        if (!found) traverse = traverse.nextItem;
      }
    }
    return found;
  }
  
  public E Peek(int idx){
    if (element_count != 0){
      QueueItem<E> checking = head;
      for(int i = 0;i < idx;i++){
        checking = checking.nextItem;
        if (checking == null) return null;
      }
      return checking.item;
    } else {
      return null;
    }
  }

  public E PeekTail() {
    return Peek(element_count - 1);
  }

  public int IdxSearch(E item) {
    int idx = -1;
    if (element_count != 0){
      QueueItem<E> traverse = head;
      boolean found = false;
      while ((traverse != null) && (!found )){
        idx++;
        found = (traverse.item.equals(item));
        if (!found) traverse = traverse.nextItem;
      }
      if (!found) idx = -1;
    }
    return idx;
  }
}
