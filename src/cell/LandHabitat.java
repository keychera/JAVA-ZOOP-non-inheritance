/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cell;

/**
 * @file	LandHabitat.java
 * @author	Harum Lokawati
 * @date	March 2017
 * @version     VZ03
 * @brief	the header file containing class declaration LandHabitat
 */
public class LandHabitat extends Habitat {
        /**
	 * default construstor
	 * this will construct Habitat
	 */
    public LandHabitat()
    {
        super();
    }
       /**
	 * @brief fuction to print 
	 * this will return "l"
         */
    public void Render()
    {
        System.out.print('^');
    }
        /**
	 * @brief type getter 
	 * this will return "LandHabitat"
         * @return char*
	 */
    public  String GetType()
    {
        return "LandHabitat";
    }
};
