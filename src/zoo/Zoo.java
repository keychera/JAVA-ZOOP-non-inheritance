package zoo;

import animal.Animal;
import animal_list.*;
import cell.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Random;
import location.Location;

/**
 * @file	zoo.h
 * @author	Harum Lokawati
 * @since	March 2017
 */

public class Zoo {
    public static final int DEFSIZE = 10;
    private Cell[] Cells;   ///< array of Cell*
    private Cage[] Cages;   ///< array of Cage*
    private int NCages;     ///< number of cage
    private int width;      ///< zoo width
    private int length;     ///< zoo length
   /**
    * default construstor
    * this will set width and legth to DEFSIZE and make new Cells and Cages
    */
    public Zoo()
    {
        this.width = DEFSIZE;
        this.length = DEFSIZE;
        this.Cells = new Cell[width * length];
        this.NCages = 0;
        this.Cages = new Cage[DEFSIZE];
    }
    /**
     * @brief construstor with parameter
     * this will set width to w, legth to l and make new Cells and Cages
     * @param w
     * @param l
     */
    public Zoo(int w, int l)
    {
        this.width = w;
        this.length = l;
        this.Cells = new Cell[width * length];
        this.NCages = 0;
        this.Cages = new Cage[DEFSIZE];
    }
    
    /**
     * addition by kevin erdiza
     * for unit testing without external file 
     */
    public void InitializeZoo(Cell cells[]){
      Cells = cells;
    }
        
    /**
     * map reader and initialize
     * this will read txt file and initialize all its Cells
     * @param filename
     * @return Nothing.
     */
    public void ReadZoo(String filename) throws FileNotFoundException, IOException
    {
        int panjang;
        int i = 0;
        int j = 0;
        int templength = 0;
        RandomAccessFile raf = new RandomAccessFile("map.txt","r");
        raf.seek(0);
        panjang = (int) raf.length();
        raf.close();
        Cells = new Cell[panjang];
        File f = new File("map.txt");
        BufferedReader reader;
        reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(f),
                            Charset.forName("UTF-8")));
        try {
            int c;
            while((c = reader.read()) != -1) {
              char character = (char) c;
              if(c == '\n')
              {
                  i++;
                  if(i == 1)
                  {
                      templength = j;
                  }
              }else
              {
                  switch (c) {
                      case 'a':
                          Cells[j] = new AirHabitat();
                          break;
                      case 'w':
                          Cells[j] = new WaterHabitat();
                          break;
                      case 'l':
                          Cells[j] = new LandHabitat();
                          break;
                      case 'R':
                          Cells[j] = new Restaurant();
                          break;
                      case 'P':
                          Cells[j] = new Park();
                          break;
                      case 'E':
                          Cells[j] = new Entrance();
                          break;
                      case '@':
                          Cells[j] = new Exit();
                          break;
                      default:
                          Cells[j] = new Road();
                          break;
                  }
                  j++;
              }
            }
        }finally {
            if(reader != null)
            {
                reader.close();
            }
        }
        this.length = templength ;
        this.width = i;
        for(i = 0; i < j; i++)
        {
            Cells[i].SetXY(i % this.length, i / this.length);
        }
    }
    
    /**
     * @brief width getter
     * this will return width of the zoo
     * @return int
     */
    public int GetWidth()
    {
        return this.width;
    }
    /**
     * length getter, this will return length of the zoo
     * @return int
     */
    public int GetLength()
    {
        return this.length;
    }
    /**
     * Cells getter, this will return array of Cell[]
     * @return Cell[]
     */
    public Cell[] GetCells()
    {
        return this.Cells;
    }
    /**
     * @brief Cages getter
     * this will return array of Cage*
     * @return Cage[]
     */
    public Cage[] GetCages()
    {
        return this.Cages;
    }
    /**
     * Number of Cages getter
     * this will return NCages of the zoo
     * @return int
     */
    public int GetNCages()
    {
        return this.NCages;
    }
    /**
     * Cell getter, this will return Cell in location(x,y) in the zoo
     * @return Cell
     */
    public Cell AccessCell(int x,int y)
    {
        int i = 0;
        boolean found = false;
        while ((i < width*length) && !found)
        {
            if((Cells[i].GetX() == x) && (Cells[i].GetY() == y))
            {
                found = true;
            }else
            {
                i++;
            }
        }
        if (i != width * length)
        {
            return Cells[i];
        }else
        {
            return null;
        }
    }
    /**
     * cage maker
     * this will make cage from cells that has been inserted into zoo 
     * @return Nothing.
     */
    public void MakeCage()
    {
        NCages = 0;
        boolean[] check = new boolean[width * length];
        for (int i = 0; i < (width * length); i++)
        {
            check[i] = false;
        }
        int count = 0;
        while (count < (width * length))
        {
            if (!check[count] && (Cells[count].GetName().equals("Habitat")))
            {
                int[] queue = new int[width * length];
                int i = 0;
                int checked = 0;
                String name = Cells[count].GetType();
                queue[i] = count;
                check[queue[i]] = true;
                while ((checked <= i) && (checked < width * length))
                {
                    if ((queue[checked] + 1 >= 0) && (queue[checked] + 1 < (width*length)) && (!check[queue[checked] + 1]))
                    {
                        if(Cells[queue[checked] + 1].GetType().equals(name))
                        {
                            i++;
                            queue[i] = queue[checked] + 1;
                            check[queue[i]] =true;
                        }
                    }
                    if ((queue[checked] - 1 >= 0) && (queue[checked] - 1 < (width*length)) && (!check[queue[checked] - 1]))
                    {
                        if(Cells[queue[checked] - 1].GetType().equals(name))
                        {
                            i++;
                            queue[i] = queue[checked] - 1;
                            check[queue[i]] =true;
                        }
                    }
                    if ((queue[checked] + length >= 0) && (queue[checked] + length < (width*length)) && (!check[queue[checked] + length]))
                    {
                        if(Cells[queue[checked] + length].GetType().equals(name))
                        {
                            i++;
                            queue[i] = queue[checked] + length;
                            check[queue[i]] =true;
                        }
                    }
                    if ((queue[checked] - length >= 0) && (queue[checked] - length < (width*length)) && (!check[queue[checked] - length]))
                    {
                        if(Cells[queue[checked] - length].GetType().equals(name))
                        {
                            i++;
                            queue[i] = queue[checked] - length;
                            check[queue[i]] =true;
                        }
                    }
                    checked++;
                }
                NCages++;
                //menyimpan cage baru di C
                Cage C = new Cage(name, i + 1);
                for(int ar = 0; ar < (i + 1); ar++){
                    Location L = new Location((queue[ar] / length),(queue[ar] % length));
                    C.GetArea()[ar] = L;
                }
                //membuat array temp untuk menyimpan cage lama
                Cage[] temp = new Cage[NCages];
                System.arraycopy(Cages, 0, temp, 0, NCages - 1); 
                //menginisialisasi ukuran baru dan memaskkan temp ke cages
                Cages = new Cage[NCages];
                System.arraycopy(temp, 0, Cages, 0, NCages);
            }
            check[count] = true;
            count++;
        }
    }
    /**
     * Read Animals from external file and put it in cages of the zoo
     * @param x
     * @param y
     * @return int
     */
    public void ReadAnimal(String filename) throws IOException
    {
        File f = new File("animal.txt");
        BufferedReader reader;
        reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(f),
                        Charset.forName("UTF-8")));
	char hewan;
	int n_hewan;
          do {
            hewan = reader.readLine().charAt(0);
            n_hewan = ((int) reader.readLine().charAt(1) - 48);
            Animal A;
            for(int i = 1; i <= n_hewan; i++)
            {
                if(hewan == 'c')
                {
                  A = new Cat();
                }else if(hewan == 'C')
                {
                  A = new Cheetah();
                }else if(hewan == 'L')
                {
                  A = new Lion();
                }else if(hewan == 'l')
                {
                  A = new Leopard();
                }else if(hewan == 'T')
                {
                  A = new Tiger();
                }else if(hewan == 'B')
                {
                  A = new Beluga();
                }else if(hewan == 'N')
                {
                  A = new Narwhal();
                }else if(hewan == 'D')
                {
                  A = new Dolphin();
                }else if(hewan == 'O')
                {
                  A = new Orca();
                }else if(hewan == 'd')
                {
                  A = new Damselfish();
                }else if(hewan == 'c')
                {
                  A = new Coyote();
                }else if(hewan =='W')
                {
                  A = new Wolf();
                }else if(hewan =='F')
                {
                  A = new RedFox();
                }else if(hewan == 'f')
                {
                  A = new ArcticFox();
                }else if(hewan == 'K')
                {
                  A = new Komodo();
                }else if(hewan =='b')
                {
                  A = new Biawak();
                }else if(hewan == 'J')
                {
                  A = new BadakJawa();
                }else if(hewan == 'S')
                {
                  A = new BadakSumatra();
                }else if(hewan == 'E')
                {
                  A = new BaldEagle();
                }else if(hewan == 'e')
                {
                  A = new GoldenEagle();
                }else if(hewan == 'R')
                {
                  A = new RedKite();
                }else if(hewan == 'k')
                {
                  A = new BlackKite();
                }else
                {
                  A = new Axolotl();
                }
                AddAnimaltoZoo(A);
          }
        }while (reader!=null);
      reader.close();
    }
    public void AddAnimaltoZoo(Animal A)
    {
            if(A.IsLand())
            {
                boolean found = false;
                Random rand = new Random();
                int i = rand.nextInt(NCages);
                int count = 0;
                while((count < NCages) && (!found))
                {
                    if((Cages[i].GetHabitat().equals("LandHabitat")) && (Cages[i].GetNAnimal() < (Cages[i].GetSize()*2/3)))
                    {
                        found = true;
                    }else
                    {
                        i = (i + 1) % NCages;
                    }
                    count++;
                }
                if(count < NCages)
                {
                    Cages[i].AddAnimal(A);
                }
            }else if(A.IsWater())
            {
                boolean found = false;
                Random rand = new Random();
                int i = rand.nextInt(NCages);
                int count = 0;
                while((count < NCages) && (!found))
                {
                    if((Cages[i].GetHabitat().equals("WaterHabitat")) && (Cages[i].GetNAnimal() < (Cages[i].GetSize()*2/3)))
                    {
                        found = true;
                    }else
                    {
                        i = (i + 1) % NCages;
                    }
                    count++;
                }
                if(count < NCages)
                {
                    Cages[i].AddAnimal(A);
                }
            }else
            {
                boolean found = false;
                Random rand = new Random();
                int i = rand.nextInt(NCages);
                int count = 0;
                while((count < NCages) && (!found))
                {
                    if((Cages[i].GetHabitat().equals("AirHabitat")) && (Cages[i].GetNAnimal() < (Cages[i].GetSize()*2/3)))
                    {
                        found = true;
                    }else
                    {
                        i = (i + 1) % NCages;
                    }
                    count++;
                }
                if(count < NCages)
                {
                    Cages[i].AddAnimal(A);
                }
            }
    }
    /**
     * @brief Cage Index getter 
     * this will return index of cage that contains location(x,y)
     * @param x
     * @param y
     * @return int
     */
    public int GetIndexCage(int x,int y)
    {
        Location L = new Location(x,y);
        boolean found = false;
        int i = 0;
        while ((!found) && (i < NCages))
        {
            if(Cages[i].IsInCage(L))
            {
                found = true;
            }else
            {
                i++;
            }
        }
        return i;
    }
    /**
     * this will print element zoo in location(x,y)
     * @param x
     * @param y
     */
    public void Print(int x, int y)
    {
      for (int i = 0; i < width; i++)
        {
          for (int j = 0; j < length; j++)
          {
              if((j == x)&& (i == y)){
                System.out.print('Y');
              }else if (Cells[i*length+j].GetName().equals("Habitat"))
              {
                int indeks = GetIndexCage(i,j);
                int iAn = -1;
                if (Cages[indeks].GetNAnimal() > 0)
                {
                  for (int k = 0; k < Cages[indeks].GetNAnimal(); k++)
                  {
                    if(((Cages[indeks].GetAnimals()[k]).GetX() == i) && ((Cages[indeks].GetAnimals()[k]).GetY() == j))
                    {
                      iAn = k;
                    }
                }
                //cout<<"ada animal"<<endl;
              }
              //cout<<"done";
              if(iAn != (-1))//ada animal
              {
                Cages[indeks].GetAnimals()[iAn].Render();
              }else
              {
                Cells[i * length + j].Render();
              }
            }else
            {
              //cout<<"non";
              Cells[i * length + j].Render();
            }
            System.out.print(' ');
          }
          System.out.print('\n');
        }
    }

    public int CalculateFoodForCage(Cage c){
      Animal[] animal = c.GetAnimals();
      int animalNum = c.GetNAnimal();
      int out = 0;
      for(int i = 0; i < animalNum;i++)
        out += (animal[i].GetWeight() / 10 );
      return out;
    }

    public int CalculateFoodForAll(){
      int out = 0;
      for(int i = 0; i < NCages;i++)
        out += CalculateFoodForCage(Cages[i]);
      return out;
    }

};
