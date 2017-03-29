package zoo;
import animal.Animal;
import location.Location;
import java.util.Random;


/**
 * class Cage contains animals and locations to form cage for zoo
 * @author	    Harum Lokawati
 * @since	      March 2017
 * @version     VZ03
 * 	
 */

public class Cage{
    private Animal[] Animals;       ///< array of Animal* in Cage
    private int  NAnimal;        ///< number of Animal in Cage
    private final String habitat;         ///< habitat of the Cage
    private final Integer size;           ///< size of Cage
    private Location[] area;        ///< array of Location of Cage
    /**
     * default construstor this will set size, NAnimal, Animals, and area to 0 and habitat to ""
     * @
     */
    public Cage()
    {
        this.habitat="";
        this.size=0;
        this.NAnimal=0;
        this.area= new Location[0];
        this.Animals=new Animal[0];
    }
    public Cage CopyCage()
    {
      Cage copy = new Cage(this.GetHabitat(),this.GetSize());
      copy.NAnimal = this.NAnimal;
      for(int i = 0;i< copy.size; i++)
      {
        copy.area[i] = this.area[i];
      }
      for(int i = 0;i< copy.NAnimal; i++)
      {
        copy.Animals[i]=this.Animals[i];
      }
      return copy;
    }
    /**
     * construstor with parameter, this will set NAnimal to 0, size to _size, habitat to hab, Animals and area
     * @param habitat
     * @param size
	 */
    public Cage(String hab, int size)
    {
        this.habitat=hab;
        this.size=size;
        this.NAnimal=0;
        this.area= new Location[size];
        this.Animals=new Animal[size*2/3];
    }
    /**
     * getter for size
     * @return Integer
     */
    public Integer GetSize()
    {
        return this.size;
    }
    /**
     * getter area
     * @return Location[]
     */
    public Location[] GetArea()
    {
        return this.area;
    }
    /**
     * cage attribute animals Movement manager
     * this will change animal in cage position
     * @return Nothing
     */
    public void MovementManager()
    {
        for(int i = 0; i < NAnimal; i++)
        {
            Random rand = new Random();
            int n = rand.nextInt(4);
            boolean Moved = false;
            int count = 0;
            while ((!Moved) && (count <= 4))
            {
                Location m = Move(this.Animals[i], n);
                if((IsInCage(m) && (!IsThereAnimal(m))))
                {
                    Animals[i].SetXY(m.x , m.y);
                    Moved = true;
                }
                count++;
                n = (n + 1) % 4;
            }
        }
    }
    /**
     * function to get location after animal A Move 
     * this will return location for 1:Move up, 2:Move right, 3:Move down, 4:Move left
     * @return Location
     */
    public Location Move(Animal A,int i)
    {
        Location L1 = new Location(A.GetX() , A.GetY());
        switch (i) {
            case 0:
                L1.y -= 1;
                break;
            case 1:
                L1.x += 1;
                break;
            case 2:
                L1.y += 1;
                break;
            case 3:
                L1.x -= 1;
                break;
            default:
                break;
        }
        return L1;
    }
    /**
     * this will check if there's animal in location L
     * @param L
     * @return boolean
     */
    public boolean IsThereAnimal(Location L)
    {
        boolean found = false;
        int i=0;
        while (!found && (i < this.NAnimal))
        {
            if((Animals[i].GetX() == L.x) && (Animals[i].GetY() == L.y))
            {
                found = true;
            }
            i++;
        }
        return found;
    }
    /**
     * check location in cage 
     * this will check if location L is inside cage
     * @param L
     * @return boolean
     */
    public boolean IsInCage(Location L)
    {
        boolean found = false;
        int i = 0;
        while(!found && (i < this.size))
        {
            if((this.area[i].x == L.x) && (this.area[i].y == L.y))
            {
                found = true;
            }
            i++;
        }
        return found;
    }
    /**
     * void to add animal to cage
     * @param A
     */
    public void AddAnimal(Animal A)
    {
        if(this.NAnimal < (this.size*2/3))
        {
            boolean ok = true;
            if(!A.IsTame() )
            {
                int j = 0;
                while( ok && (j < this.NAnimal))
                {
                    if(!this.Animals[j].GetSpecies().equals(A.GetSpecies()))
                    {
                        ok = false;
                    }
                    j++;
                }
            }
            if(ok)
            {
                this.Animals[this.NAnimal] = A;
                int count = 0;
                Random rand = new Random();
                int n = rand.nextInt(size);
                boolean found = false;
                while((count < size) && (!found))
                {
                    if(!IsThereAnimal(this.area[n]))
                    {
                        Animals[NAnimal].SetX(area[n].x);
                        Animals[NAnimal].SetY(area[n].y);
                        found = true;
                    }
                    n = (n + 1) % size;
                }
                NAnimal++;
            }
        }
    }
    /**
     * getter for Animals
     * @return Animal[]
     */
    public Animal[] GetAnimals()
    {
        return Animals;
    }
    /**
     * getter for NAnimal
     * @return Integer
     */
    public int GetNAnimal()
    {
        return NAnimal;
    }
    /**
     * getter for habitat
     * @return String
     */
    public String GetHabitat()
    {
        return habitat;
    }
};
