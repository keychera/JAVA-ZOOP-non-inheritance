/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.util.Scanner;
import cell.AirHabitat;
import cell.Cell;
import cell.Entrance;
import cell.Exit;
import cell.LandHabitat;
import cell.Road;
import cell.WaterHabitat;
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
            cells[iteration] = new Exit();
          } else 
          if (i == 0 && j == 4){
            cells[iteration] = new Entrance();
          } else
          if ((i == 1 && j == 1) || (i == 2 && j == 1) || (i == 3 && j == 1) || (i == 4 && j == 1)
              || (i == 4 && j == 2) || (i == 4 && j == 3) || (i == 3 && j == 3) || (i == 3 && j ==4 )
              || (i == 2 && j ==4 ) || (i == 1 && j ==4 ) || (i == 1 && j ==3)) {
            cells[iteration] = new Road();
          } else {
            if (j >= 4) {
              cells[iteration] = new LandHabitat();
            } else 
            if (j == 0 || i == 0 || i == 5) {
              cells[iteration] = new WaterHabitat();
            } else {
              cells[iteration] = new AirHabitat();
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
      reader = new Scanner(System.in);
      int n = reader.nextInt();
      if(n==1)
      {
        zoo.Print(-1,-1);
      }else
      {
        zoo.Print(1,1);
      }
    }
}
