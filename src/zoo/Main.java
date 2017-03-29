/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.util.Scanner;
import animal.Animal;
import cell.Cell;
import location.Location;
import tour.Tour;

/**
 *
 * @author Harum Lokawati
 */
public class Main {

  private static Scanner reader;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    /*map test 
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
    /*
    iteration = 0;
    for(int j = 0;j < length;j++){
      for(int i = 0;i < width;i++){
        cells[iteration].Render();
        System.out.print(" ");
        iteration++;
      }
      System.out.println();
    }*/
    zoo = new Zoo(6,6);
    zoo.InitializeZoo(cells);
    zoo.MakeCage();
    
    Tour tour;
    tour = new Tour(zoo,width,length);
    
    //MENU
    
    int n = 0;
    boolean isTouring = false;
    boolean isTracing = false;
    boolean isShowingZoo = false;
    boolean isLoadingZoo = false;
    boolean isWrongInput = false;
    boolean isGoodBye = false;
    boolean isRestartingRoute = false;
    boolean isTracingWholeRoute = false;
    while (n >= 0){
      if (!isTouring) {
        System.out.println("\tThe Zoo");
        System.out.println("=======================");
        System.out.println("inputs for commands");
        System.out.println("  1 -> Show Zoo");
        System.out.println("  2 -> Load Zoo");
        System.out.println("  3 -> Start Tour");
        System.out.println(" -1 -> Exit App");
        if (isShowingZoo){
          zoo.Print(-1,-1);
          isShowingZoo = false;
        }
        if (isLoadingZoo){
          System.out.println("Not implemented");
          isLoadingZoo = false;
        }
        if (isGoodBye) {
          System.out.println("Good bye!");
          isGoodBye = false;
        }
      } else {
        System.out.println("\tThe Zoo");
        System.out.println("=======================");
        System.out.println("inputs for commands");
        System.out.println("  1 -> Move one step");
        System.out.println("  2 -> Move Along the remaining route");
        System.out.println("  3 -> Restart Tour");
        System.out.println("  4 -> Exit Tour");
        if (isRestartingRoute) tour.RestartRoute();
        Location tourPosition = new Location(tour.GetRoute()[tour.GetRoutePointer()]);
        zoo.Print(tourPosition.x,tourPosition.y);
        if (isTracing) {
          if (tour.GetRoutePointer() < tour.GetRouteDistance() - 1) {
            tour.TraceRoute();
            isTracing = false;
          } else {
            System.out.println("The tour ends");
            isTouring = false;
          }
        }
        if (isRestartingRoute) {
          System.out.println("The tour position is restarted");
          isRestartingRoute = false;
        }
        if (isTracingWholeRoute) {
          tour.TraceWholeRoute();
          isTracingWholeRoute = false;
        }
      }
      if (isWrongInput) {
        System.out.println("Wrong input");
        isWrongInput = false;
      }
      reader = new Scanner(System.in);
      n = reader.nextInt();
      clearScreen();
      if (!isTouring) {
        switch(n) {
          case 1 :
            isShowingZoo = true;
            break;
          case 2 :
            isLoadingZoo = true; 
            break;
          case 3:
            isTouring = true;
            break;
          case -1:
            isGoodBye = true;
          default:
            isWrongInput = true;
        }
      } else {
        switch(n) {
          case 1 :
            isTracing = true;
            break;
          case 2 :
            isTracingWholeRoute = true;
            break;
          case 3:
            isRestartingRoute = true;
            break;
          case 4:
            isTouring = false;
            break;
          default:
            isWrongInput = true;
        }
      }
    }
  }
  
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
}
