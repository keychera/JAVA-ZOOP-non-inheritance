package cell;
import renderable.*;
import location.*;
/**
 *
 * Class Cell
 * abstract class of Cell as a component of the zoo
 * @author	Harum Lokawati
 * @since	March 2017
 * @version     VZ03
 * 
 */
public abstract class Cell extends Renderable implements ILocation {
    protected int x;
    protected int y;
    /**
     * default constructor
     * construct Renderable and Location
     */
    public Cell()
    {
        super();
        x=0;
        y=0;
    }
    /**
     * constructor with parameter ,construct Cell and set Location(x,y)
     * @param _x 
     * @param _y 
     */
    public Cell(int _x, int _y)
    {
       this.x=_x;
       this.y=_y;
    }
    /**
     * pure virtual for name getter
     * @return String
     */

    public abstract String GetName();
    /**
     * pure virtual for type getter
     * @return String
     */
    public abstract String GetType();
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
