package cell;
/**
 * @class	Entrance
 * @brief	class to define Road as Entrance
 */
public class Entrance extends Road{
   /**
    * @brief default constructor
    * construct Road
    */
    public Entrance()
    {
        super();
    }
   /**
    * @brief function of type getter
    * this will return "Entrance"
    * @return char*
    */
    @Override
    public String GetType()
    {
        return "Entrance";
    }
   /**
    * @brief fuction to print 
    * this will return "E"
    * @return void
    */
    @Override
    public void Render()
    {
        System.out.print('E');
    }
};
