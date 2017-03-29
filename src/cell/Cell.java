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
public class Cell{
    protected int x;
    protected int y;
    private String cellName;
    private String cellType;
    private char render;
    /**
     * default constructor
     * construct Renderable and Location
     */
    public Cell(String CellOption)
    {
    	this(CellOption, 0, 0);        
    }
    /**
     * constructor with parameter ,construct Cell and set Location(x,y)
     * @param _x 
     * @param _y 
     */
    public Cell(String CellOption, int _x, int _y)
    {
       this.x=_x;
       this.y=_y;
       switch(CellOption) {
       case "Entrance":
           cellType = "Entrance";
           render = 'E';
           cellName = "Facility";
           break;
        case "Exit":
           cellType = "Exit";
           render = '@';
           cellName = "Facility";
           break;
        case "Park":
           cellType = "Park";
           render = 'p';
           cellName = "Facility";
           break;
        case "Restaurant":
           cellType = "Restaurant";
           render = 'R';
           cellName = "Facility";
           break;
        case "Road":
           cellType = "Road";
           render = ' ';
           cellName = "Facility";
           break;
        case "AirHabitat":
           render = '*';
           cellType = "AirHabitat";
           cellName = "Habitat";
           break;
        case "LandHabitat":
           render = '^';
           cellType = "LandHabitat";
           cellName = "Habitat";
           break;
        case "WaterHabitat":
           render = '~';
           cellType = "WaterHabitat";
           cellName = "Habitat";
           break;
        default:
            cellType = "???";
           render = '?';
           cellName = "???";
       }
    }
    /**
     * pure virtual for name getter
     * @return String
     */

    public String GetName(){
      return cellName;
    }
    /**
     * pure virtual for type getter
     * @return String
     */
    public String GetType(){
      return cellType;
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
    
    public void Render() {
      System.out.print(render);
    }
};
