package unit_test;

import static org.junit.Assert.*;

import org.junit.*;

import animal.Animal;
import cell.*;
import tour.Tour;
import zoo.Zoo;

public class Tour_test {
  private Zoo zoo;
  private Cell cells[];
  private int width;
  private int length;
  private Tour tour; 
  
  @Before
  public void initialize(){/*map test 
     * W W W W F W
     * W         W
     * W A A A   W
     * W   A     W
     * S       L L
     * L L L L L L
     */
    Zoo zoo;
    Cell cells[];
    int width;
    int length;
    width = 6;
    length = 6;
    cells = new Cell [width * length];
    int iteration = 0;
    for(int j = 0;j < length;j++){
      for(int i = 0;i < width;i++){
        if (i == 4 && j == 0){
          cells[iteration] = new Cell("Exit");
        } else 
        if (i == 0 && j == 4){
          cells[iteration] = new Cell("Entrance");
        } else
        if ((i == 1 && j == 1) || (i == 2 && j == 1) || (i == 3 && j == 1) || (i == 4 && j == 1)
            || (i == 4 && j == 2) || (i == 4 && j == 3) || (i == 3 && j == 3) || (i == 3 && j ==4 )
            || (i == 2 && j ==4 ) || (i == 1 && j ==4 ) || (i == 1 && j ==3)) {
          cells[iteration] = new Cell("Road");
        } else {
          if (j >= 4) {
            cells[iteration] = new Cell("LandHabitat");
          } else 
          if (j == 0 || i == 0 || i == 5) {
            cells[iteration] = new Cell("WaterHabitat");
          } else {
            cells[iteration] = new Cell("AirHabitat");
          }
        }
        cells[iteration].SetX(i);
        cells[iteration].SetY(j);
        iteration++;
      }
    }
    iteration = 0;
    for(int j = 0;j < length;j++){
      for(int i = 0;i < width;i++){
        cells[iteration].Render();
        System.out.print(" ");
        iteration++;
      }
      System.out.println();
    }
    
    zoo = new Zoo(6,6);
    zoo.InitializeZoo(cells);
    zoo.MakeCage();
    Animal neko = new Animal("Cat");
    Animal chesire = new Animal("Cat");
    Animal kucing = new Animal("Cat");
    zoo.AddAnimaltoZoo(neko);
    zoo.AddAnimaltoZoo(chesire);
    zoo.AddAnimaltoZoo(kucing);
    
    tour = new Tour(zoo,width,length);
  }

  @Test
  public void testTourCreation() {
    tour.PrintRoute();
    assertEquals(9,tour.GetRouteDistance());
  }
  
  @Test
  public void testTourUsage() {    
    tour.TraceWholeRoute();
    tour.RestartRoute();
    for(int i = 0;i < tour.GetRouteDistance() / 3;i++)
      tour.TraceRoute();
    System.out.println();
    System.out.println("a deliberate gap by the test...");
    System.out.println();
    tour.TraceWholeRoute();
  }
}
