/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cell;

/**
 * @file	LandHabitat.java
 * @author	Harum Lokawati
 * @date	March 2017
 * @version     VZ03
 * @brief	the header file containing class declaration LandHabitat
 */
public class LandHabitat {
    protected int x;
    protected int y;
    /**
     * default construstor
     * this will construct Habitat
     */
    public LandHabitat()
    {
        x = 0;
        y = 0;
    }
    public LandHabitat(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
       /**
	 * @brief fuction to print 
	 * this will return "l"
         */
    public void Render()
    {
        System.out.print('^');
    }
    /**
     * @brief type getter 
     * this will return "LandHabitat"
     * @return char*
     */
    public  String GetType()
    {
        return "LandHabitat";
    }
    /**
     * name getter
     * this will return "Habitat"
     * @return String
     */
    public String GetName()
    {
        return "Habitat";
    }
    /**
     * @brief getter for X value
     * @return int
     */
    public int GetX()
    {
        return x;
    }
	  /**
	   * @brief getter for Y value
	   * @return int
	   */
    public int GetY()
    {
        return y;
    }
	  /**
	   * @brief setter for X value
	   * @param _x
	   */
    public void SetX(int _x)
    {
        this.x=_x;
    }
	  /**
	   * @brief setter for Y value
	   * @param _y
	   */
    public void SetY(int _y)
    {
        this.y=_y;
    }
	  
	    /**
	   * @brief setter for X and Y value simultaneously
	   * @param _x
	   * @param _y
	   */
    public void SetXY(int _x,int _y)
    {
        this.x=_x;
        this.y=_y;
    }
};
