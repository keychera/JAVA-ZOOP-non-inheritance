package cell;
/**
 *
 * Class Exit
 * public class Exit of Cell as a component of the zoo
 * @author	Harum Lokawati
 * @since	March 2017
 * @version     VZ03
 * 
 */
public class Exit{
    protected int x;
    protected int y;
    /**
    * @brief default constructor
    * construct Exit
    */
    public Exit()
    {
       x = 0;
       y = 0;
    }
    public Exit(int _x, int _y)
    {
        x = _x;
        y = _y;
    }   
   /**
    * @brief fuction to print 
    * this will return "@"
    * @return void
    */
     public void Render()
     {
         System.out.print('@');
     }
   /**
    * @brief function of type getter
    * this will return "Exit"
    * @return char*
    */
     public String GetType()
     {
         return "Exit";
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
     * @brief getter for    X value
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
