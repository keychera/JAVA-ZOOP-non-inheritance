package pathfinder;

public class Path {
  public int x;
  public int y;
  public int label;
  
  
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + label;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Path other = (Path) obj;
    if (label != other.label)
      return false;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  public Path(){
    this(0,0,0);
  }
  
  public Path(int x,int y,int counter){
    this.x = x;
    this.y = y;
    this.label = counter;
  }
  
  public boolean IsEqualTo(int x,int y){
    return this.x == x && this.y == y;
  }
  
  public boolean IsEqualTo(int label){
    return this.label == label;
  }
  
  public boolean IsEqualTo(Path p){
    return x == p.x && y == p.y && label == p.label;
  }
  
  public boolean IsMoreThan(Path p){
    return label > p.label;
  }
  
  public boolean IsLessThan(Path p){
    return label < p.label;
  }
  
  public void Print(){
    System.out.print("(");
    System.out.print(x);
    System.out.print(",");
    System.out.print(y);
    System.out.print(":");
    System.out.print(label);
    System.out.println(")");
  }
}
