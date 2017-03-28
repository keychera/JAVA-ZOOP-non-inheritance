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
public class Exit extends Road{
   /**
    * @brief default constructor
    * construct Road
    */
     public Exit()
     {
         super();
     }
   /**
    * @brief fuction to print 
    * this will return "@"
    * @return void
    */
     @Override
     public void Render()
     {
         System.out.print('@');
     }
   /**
    * @brief function of type getter
    * this will return "Exit"
    * @return char*
		 */
     @Override
     public String GetType()
     {
         return "Exit";
     }
};
