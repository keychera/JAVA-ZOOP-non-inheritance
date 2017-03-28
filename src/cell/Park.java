package cell;
/**
 *
 * Class Park
 * public class AirHabitat of Cell as a component of the zoo
 * @author	Harum Lokawati
 * @since	March 2017
 * @version     VZ03
 * 
 */
public class Park extends Facility{
   /**
	* @brief default constructor
	* construct Facility
	*/
    public Park()
    {
        super();
    }
        /**
	* @brief fuction to print 
	* this will return "P"
        * @return void
	*/
    public void Render()
    {
        System.out.print('p');
    }
        /**
	* @brief function of type getter
	* this will return "Park"
        * @return char*
	*/
    public String GetType()
    {
        return "Park";
    }
};
