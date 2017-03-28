package pathfinder;

public enum PathLabel  {
  WALL(-1),ROAD(-2),START(-3),FINISH(-4);
  
  private int value;
  
  PathLabel(int value){
    this.value = value;
  }
  
  public int GetValue(){
    return value;
  }
}
