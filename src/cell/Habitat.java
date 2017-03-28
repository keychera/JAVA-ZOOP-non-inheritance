package cell;
/**
 * @file	habitat.h
 * @author	Harum Lokawati
 * @date	March 2017
 * @version VZ03
 * 
 * @brief	the header file containing class declaration Habitat
 */

/**
 * @class	Habitat
 * @brief	acstract class of Habitat as one of Cell
 */
public abstract class Habitat extends Cell{
    /**
	 * @brief default construstor
	 * this will construct Cell
	 */
    public Habitat()
    {
        super();
    }
        /**
	 * @brief name getter
	 * this will return "habitat"
         * @return char*
		 */
    public String GetName()
    {
        return "Habitat";
    }
        /**
	 * @brief pure virtual function for type getter
	 */
    public abstract String GetType();
};
