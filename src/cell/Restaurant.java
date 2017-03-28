package cell;
/**
 * @class	Restaurant
 * @brief	class to define Facility as Restaurant
 */
public class Restaurant{
    protected int x;
    protected int y;
   /**
    * @brief default constructor
    * construct Facility
    */
    public Restaurant()
    {
        x = 0;
        y = 0;
    }
    public Restaurant(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
        /**
	* @brief fuction to print 
	* this will return "R"
	*/
    public void Render()
    {
        System.out.print('R');
    }
        /**
	* @brief function of type getter
	* this will return "Restaurant"
        * @return char*
		 */
    public String GetType()
    {
        return "Restaurant";
    }
    /**
     * name getter
     * this will return "Facility"
     * @return String
     */
    public String GetName()
    {
        return "Facility";
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
