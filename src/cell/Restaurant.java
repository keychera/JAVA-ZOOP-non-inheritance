package cell;
/**
 * @class	Restaurant
 * @brief	class to define Facility as Restaurant
 */
public class Restaurant extends Facility{
   /**
    * @brief default constructor
    * construct Facility
    */
    public Restaurant()
    {
        super();
    }
        /**
	* @brief fuction to print 
	* this will return "R"
        * @return void
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
};
