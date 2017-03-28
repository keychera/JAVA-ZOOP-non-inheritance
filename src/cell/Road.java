package cell;
/**
 * @class	Road
 * @brief	class to define Facility as Road
 */
public class Road extends Facility{
   /**
    * @brief default constructor
    * construct Facility
    */
    public Road()
    {
        super();
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
};
