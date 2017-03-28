/**
 * @file	location.h
 * @author	Kevin Erdiza
 * @date	March 2017
 * @version VZ03
 * 
 * @brief	the header file containing class declaration for Location interface
 */
package location;
/**
 * @class	Location
 * @brief	class interface for objects that has 2 dimensional int location value
 */

public class Location {
  public int x;
  public int y;
  
  public Location(){
    this.x = 0;
    this.y = 0;
  }
  
  public Location(int x,int y){
    this.x = x;
    this.y = y;
  }
}