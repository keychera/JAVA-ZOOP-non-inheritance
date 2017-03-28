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
public class AirHabitat extends Habitat{
    /**
     * default construstor 
     * this will construct Habitat
     * @
     */
    public AirHabitat()
    {
        super();
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
};
