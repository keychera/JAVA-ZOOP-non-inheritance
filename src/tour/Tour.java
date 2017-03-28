package tour;
import animal.Animal;
import cell.Cell;
import location.Location;
import pathfinder.*;
import zoo.Cage;
import zoo.Zoo;

public class Tour{
  Zoo zoo_ref;
  Cell cells[];
  Location route[];
  int route_distance;
  int route_pointer;
  static final String DIRECTIONS[] = {"south","east","west","north"};
  
  public Tour(Zoo zoo_ref,int width,int length) {
    this.zoo_ref = zoo_ref;
    this.cells = zoo_ref.GetCells();
    Path areaForPathFinding[] = new Path [width * length];
    for(int i = 0;i < width * length;i++){
      int label;
      switch (cells[i].GetType()) {
        case "Road" : label = PathLabel.ROAD.GetValue();break;
        case "Entrance" : label = PathLabel.START.GetValue();break;
        case "Exit" : label = PathLabel.FINISH.GetValue();break;
        default:
          label = PathLabel.WALL.GetValue();
      }
      areaForPathFinding[i] = new Path(cells[i].GetX(),cells[i].GetY(),label);
    }
    
    PathFinder findingMachine = new PathFinder(areaForPathFinding,width,length);
    Path route_found[] = findingMachine.getRoute();
    route_distance = findingMachine.getRouteDistance();
    
    route = new Location [route_distance];
    for(int i = 0;i < route_distance;i++){
      route[i] = new Location();
      route[i].x = route_found[i].x;
      route[i].y = route_found[i].y;
    }
    route_pointer = 0;
  }

  public int InteractAroundRoute(Location r,int dir) {
    int out = 0;
    Cell interacted = null;
    switch(dir) {
      case 1:
        interacted = AccessCell(r.x,r.y+1);
        break;
      case 2:
        interacted = AccessCell(r.x+1,r.y);
        break;
      case 3:
        interacted = AccessCell(r.x-1,r.y);
        break;
      case 4:
        interacted = AccessCell(r.x,r.y-1);
        break;
    }
    if (interacted != null){
      if (interacted.GetType().equals("Exit")) {
        out = -1;
      } else
      if (interacted.GetType().equals("LandHabitat")) {
        out = 1;
      } else
      if (interacted.GetType().equals("WaterHabitat")) {
        out = 2;
      } else
      if (interacted.GetType().equals("AirHabitat")) {
        out = 3;
      } else
      if (interacted.GetType().equals("Restaurant")) {
        out = 4;
      } else
      if (interacted.GetType().equals("Park")) {
        out = 5;
      } else {
        out = 0;
      }
    }
    if (out != -1)
      System.out.print("On the ");
      System.out.print(DIRECTIONS[dir-1]);
      System.out.print("ern side, there is ");
      switch (out) {
        case 0:
          System.out.println("nothing, Ladies and Gentlemen!");
          break;
        case 1:
          System.out.println("a wide land habitat for land animals!");
          System.out.println("Let's hear them sing!");
          InteractWithHabitat(interacted);
          break;
        case 2:
          System.out.println("an enormous water habitat for fish and water mammals!");
          System.out.println("Let's listen to them swim!");
          InteractWithHabitat(interacted);
          break;
        case 3:
          System.out.println("a wide air habitat for birds!");
          System.out.println("Let's see them dance!");
          InteractWithHabitat(interacted);
          break;
        case 4:
          System.out.println("a Restaurant, for y'all who are hungry right now!");
          break;
        case 5:
          System.out.println("a Park, fresh and green, Ladies and Gentlemen!");
          break;
      }
    return out;
  }
  
  private Cell AccessCell(int x, int y) {
    int i = 0;
    Cell out;
    boolean found;
    do {
      out = cells[i];
      found = (out.GetX() == x && out.GetY() == y);
      i++;
    } while (!found && out != null);
    
    return out;
  }

  public void InteractWithHabitat(Cell c) {
    int index = zoo_ref.GetIndexCage(c.GetX(), c.GetY());
    if (index < zoo_ref.GetNCages()){
      Cage cage = zoo_ref.GetCages()[index];
      Animal[] animals = cage.GetAnimals();
      int animalNum = cage.GetNAnimal();
      for(int i = 0;i < animalNum;i++){
        System.out.print(animals[i].GetGenus());
        System.out.print(" ");
        System.out.print(animals[i].GetSpecies());
        System.out.print(" : ");
        System.out.println(animals[i].Interact());
      }
    }
  }
  
  public void RestartRoute() {
    route_pointer = 0;
  }
  
  public void TraceRoute() {
    route_pointer++;
    System.out.println("The tour continues ...");
    System.out.print("current position : (");
    System.out.print(route[route_pointer].x);
    System.out.print(",");
    System.out.print(route[route_pointer].y);
    System.out.println(")");
    if (route_pointer == route_distance-1) {
      System.out.print("\t Now here is the Exit! Thank you for your visit Lady and Madam");
    } else {
      if (route[route_pointer].x > 0) InteractAroundRoute(route[route_pointer],1);
      InteractAroundRoute(route[route_pointer],2);
      InteractAroundRoute(route[route_pointer],3);
      InteractAroundRoute(route[route_pointer],4);
    }
    System.out.println();
  }
   
  public void TraceWholeRoute() {
    while(route_pointer < route_distance-1)
      TraceRoute();
  }
  
  public int GetRouteDistance() {
    return route_distance;
  }
 
  public int GetRoutePointer() {
    return route_pointer;
  }
  
  public void PrintRoute() {
    for(int i = 0;i < route_distance;i++){
      System.out.print(route[i].x);
      System.out.print(",");
      System.out.print(route[i].y);
      System.out.println();
    }
  }
}
