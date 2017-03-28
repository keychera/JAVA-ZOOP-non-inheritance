package pathfinder;

import java.util.concurrent.ThreadLocalRandom;

import queue.Queue;

public class PathFinder {  
  private Queue<Path> main_queue;
  private Queue<Path> sub_queue;
  private Path area[];
  private int area_width;
  private int area_length;
  private Path route[];
  private int route_distance;
  
  public PathFinder(Path area[],int area_width,int area_length){
    this.area = area;
    this.area_width = area_width;
    this.area_length = area_length;
    main_queue = new Queue<Path>();
    sub_queue = new Queue<Path>();
    
    Path startLoc[] = CollectLabel(PathLabel.START);
    Path finishLoc[] = CollectLabel(PathLabel.FINISH);
    
    int nRandom = ThreadLocalRandom.current().nextInt(0, CountLabel(PathLabel.START));
    Path choosenStart = startLoc[nRandom];
    int mRandom = ThreadLocalRandom.current().nextInt(0, CountLabel(PathLabel.FINISH));
    Path choosenFinish = finishLoc[mRandom];
    
    choosenFinish.label = 0;
    main_queue.Enqueue(choosenFinish);
    Path isStartFound;
    
    //SAMPLE ALGORITHM FROM https://en.wikipedia.org/wiki/Pathfinding
    
    //traversing adjacent location from exit to give counters to location
    int level,iteration = 0;
    do{
      iteration++;
      
      Path check = main_queue.Peek(iteration-1);
      level = check.label + 1;
      
      Path c1 = new Path(check.x,check.y+1,level);
      Path c2 = new Path(check.x+1,check.y,level);
      Path c3 = new Path(check.x-1,check.y,level);
      Path c4 = new Path(check.x,check.y-1,level);
      if (c1.y < area_length)  sub_queue.Enqueue(c1);
      if (c2.x < area_width) sub_queue.Enqueue(c2);
      if (c3.x >= 0) sub_queue.Enqueue(c3);
      if (c4.y >= 0) sub_queue.Enqueue(c4);
      
      int num = sub_queue.GetElementCount();
      
      for(int i = 0; i < num;i++){
        Path checking = sub_queue.Dequeue();
        
        Path specificLoc = SearchSpecificLocation(checking.x,checking.y);
        if (specificLoc.label == PathLabel.ROAD.GetValue() || specificLoc.label == PathLabel.START.GetValue()){
          boolean isOnMain = false;
          int traverse = 0;
          while (traverse <= level) {
            Path searchMain = new Path(checking.x,checking.y,traverse);
            isOnMain |= main_queue.Search(searchMain);
            traverse++;
          }
          if (!isOnMain)
            main_queue.Enqueue(checking);
        }
      }
      isStartFound = new Path(choosenStart.x,choosenStart.y,level);
      
    } while (!main_queue.Search(isStartFound) && (iteration < area_width*area_length*4));
    
    //traversing main queue to get the route
    
    route_distance = level + 1;
    route = new Path [route_distance];
    iteration = level;
    Path start = main_queue.PeekTail();
    Queue<Path> traverse_queue = new Queue<Path>();
    do{
      route[level-iteration] = new Path();
      route[level-iteration].x = start.x;
      route[level-iteration].y = start.y;
      int c1 = -1;
      for(int i = iteration; i >= 0; i--){
        Path key = new Path(start.x,start.y+1,i);
        if (main_queue.IdxSearch(key) != -1) 
          c1 = main_queue.IdxSearch(key);
      }
      int c2 = -1;
      for(int i = iteration; i >= 0; i--){
        Path key = new Path(start.x+1,start.y,i);
        if (main_queue.IdxSearch(key) != -1) 
          c2 = main_queue.IdxSearch(key);
      }
      int c3 = -1;
      for(int i = iteration; i >= 0; i--){
        Path key = new Path(start.x-1,start.y,i);
        if (main_queue.IdxSearch(key) != -1) 
          c3 = main_queue.IdxSearch(key);
      }
      int c4 = -1;
      for(int i = iteration; i >= 0; i--){
        Path key = new Path(start.x,start.y-1,i);
        if (main_queue.IdxSearch(key) != -1) 
          c4 = main_queue.IdxSearch(key);
      }
      
      if (c1 >= 0)  traverse_queue.Enqueue(main_queue.Peek(c1));
      if (c2 >= 0) traverse_queue.Enqueue(main_queue.Peek(c2));
      if (c3 >= 0) traverse_queue.Enqueue(main_queue.Peek(c3));
      if (c4 >= 0) traverse_queue.Enqueue(main_queue.Peek(c4));
      
      start = traverse_queue.Dequeue();
      for(int i = 1;i < traverse_queue.GetElementCount();i++){
        Path check = traverse_queue.Dequeue();
        if (start.IsMoreThan(check))
          start = check;
      }
      iteration--;
    }while (iteration > 0);
    
    route[0] = startLoc[nRandom];
    route[level] = finishLoc[mRandom];
  }
  
  public Path[] getRoute() {
    return route;
  }
  

  public int getRouteDistance() {
    return route_distance;
  }

  private Path SearchSpecificLocation(int x, int y) {
    Path specificLoc = new Path();
    int iteration = -1;
    do {
      iteration++;
      specificLoc = area[iteration];      
    } while(!specificLoc.IsEqualTo(x,y) && (iteration < area_width * area_length));    
    return specificLoc;
  }

  private int CountLabel(PathLabel label) {
    int count = 0;
    for(int i = 0;i < area_width * area_length;i++){
      if (area[i].IsEqualTo(label.GetValue()))
        count++;
    }
    return count;
  }

  private Path[] CollectLabel(PathLabel label) {
    Path collection[] = new Path [CountLabel(label)];
    int count = 0;
    for(int i = 0;i < area_width * area_length;i++){
      if (area[i].IsEqualTo(label.GetValue())){
        collection[count] = area[i];
        count++;
      }
    }
    return collection;
  }
}
