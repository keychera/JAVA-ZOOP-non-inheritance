package cell;
/**
 * @class	WaterHabitat
 * @brief	class to define Habitat as WaterHabitat
 */
public class WaterHabitat{
    protected int x;
    protected int y;
        /**
	 * default constructor
	 * this will construct Habitat
         * @
	 */
      public WaterHabitat()
      {
          x = 0;
          y = 0;
      }
      public WaterHabitat(int x, int y)
      {
          this.x = x;
          this.y = y;
      }
        /**
	 * function to print 
	 * this will return "~"
         * @
	 */
      public void Render()
      {
          System.out.print('~');
      }
        /**
	 * type getter 
	 * this will return "WaterHabitat"
         * @return String
	 */
      public String GetType()
      {
          return "WaterHabitat";
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
