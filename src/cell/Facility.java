package cell;
/**
 * @file	facility.java
 * @author	Harum Lokawati
 * @date	March 2017
 * @version VZ03
 * 
 * @brief	the header file containing class declaration facility
 */

/**
 * @class	Facility
 * @brief	acstract class of Facility as one of Cell type
 */
public abstract class Facility extends Cell{
   /**
    * @brief default construstor
    * construct Cell
    */
    public Facility()
    {
        super();
    }
   /**
    * pure virtual function getter for type
    * @return String 
    */
    abstract public String GetType();
   /**
    * name getter and this will return "facility"
    * @return String
    */
    public String GetName()
    {
        return "Facility";
    }
};
