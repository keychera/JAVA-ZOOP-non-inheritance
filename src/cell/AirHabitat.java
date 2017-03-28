package cell;
/**
 *
 * Class AirHabitat
 * public class AirHabitat of Cell as a component of the zoo
 * @author	Harum Lokawati
 * @since	March 2017
 * @version     VZ03
 * 
 */
public class AirHabitat{
    protected int x;
    protected int y;
    /**
     * default construstor 
     * this will construct Habitat
     * @
     */
    public AirHabitat()
    {
        x = 0;
        y = 0;
    }
    public AirHabitat(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
    /**
     * this will return "a"
     * fuction to print 
     * @see Renderable
     */
    public void Render()
    {
        System.out.print("*");
    }
    /**
     * type getter 
     * @return String "AirHabitat"
     */
    public String GetType()
    {
        return "AirHabitat";
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
