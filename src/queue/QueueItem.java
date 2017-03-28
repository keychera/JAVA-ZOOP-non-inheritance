package queue;

class QueueItem<E> {
  public E item;
  public QueueItem<E> nextItem;
  public QueueItem<E> prevItem;
  
  public QueueItem(){
    this(null);
  }
  
  public QueueItem(E item){
    this(item,null,null);
  }
  
  public QueueItem(E item, QueueItem<E> next, QueueItem<E> prev){
    this.item = item;
    this.nextItem = next;
    this.prevItem = prev;
  }
  
  public void Nullify(){
    this.item = null;
    this.nextItem = null;
    this.prevItem = null;
  }
}
