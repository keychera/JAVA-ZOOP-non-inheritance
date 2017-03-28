package cell;
/**
 * @class	Road
 * @brief	class to define Facility as Road
 */
public class Road{
    protected int x;
    protected int y;
   /**
    * @brief default constructor
    * construct Facility
    */
    public Road()
    {
         x = 0;
         y = 0;
    }
    public Road(int x, int y)
    {
         this.x = x;
         this.y = y;
    }
   /**
    * @brief virtual function of type getter
    * this will return "Road"
    * @return char*
    */
    public String GetType()
    {
        return "Road";
    }
   /**
    * @brief virtual fuction to print 
    * this will return " "
    * @return void
    */
    public void Render()
    {
        System.out.print(' ');
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
