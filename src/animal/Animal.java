package animal;

import location.*;

public class Animal {
  private Location position;
  private Classification classification;
  private DietStatus dietStatus;
  private HabitatStatus habitatStatus;
  private boolean tame_status;
  private String interaction;
  private char render;
  
  public Animal(String AnimalOption){
    this(AnimalOption,10);
  }
  
  public Animal(String AnimalOption,int weight) {
    position = new Location();
    switch(AnimalOption) {
      case "Cat":
        classification = new Classification("Felidae","Felis","Catus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "NYAA";
        render = 'c';
        break;
      case "Beluga":
        classification = new Classification("Monodontidae","Delphinapterus","leucas");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "SPLASH";
        render = 'B';
        break;
      case "BaldEagle":
        classification = new Classification("Accipitridae","Haliaeetus","leucocephalus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("air");
        interaction = "BAWK";
        render = 'E';
        break;
      case "Biawak":
        classification = new Classification("Varanidae","Varanus","cerambonensis");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "MORE TERRIFYING HSSS";
        render = ('b');
        break;
      case "BlackKite":
        classification = new Classification("Accipitridae","Milvus","migrans");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("air");
        interaction = "dark flip flop";
        render = ('k');
        break;
      case "Cheetah":
        classification = new Classification("Felidae","Acinonyx","jubatus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "*slightly soft* RAWR";
        render = ('C');
        break;
      case "Clownfish":
        classification = new Classification("Pomacentridae","Ocellaris","clownfish");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "lil blub";
        render = ('C');
        break;
      case "Coyote":
        classification = new Classification("Canidae","Canis","latrans");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        tame_status = false;
        interaction = "AGILE RAWR";
        render = ('t');
        break;
      case "Damselfish":
        classification = new Classification("Pomacentridae","Stegastes","variabilis");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "lil *majestic* blub";
        render = ('d');
        break;
      case "Dolphin":
        classification = new Classification("Delphinidae","Delphinus","delphis");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "dolphin's SKREE";
        render = ('D');
        break;
      case "GoldenEagle":
        classification = new Classification("Accipitridae","Aquila","chrysaetos");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("air");
        interaction = "GOLDEN BAWK";
        render = ('e');
        break;
      case "Komodo":
        classification = new Classification("Varanidae","Varanus","komodoensis");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "HSSS";
        render = ('K');
        break;
      case "Leopard":
        classification = new Classification("Felidae","Panthera","pardus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "MAJESTIC RAWR";
        render = ('l');
        break;
      case "Narwhal":
        classification = new Classification("Monodontidae","Monodon","monoceros");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "NARWHAL SPLASH";
        render = ('N');
        break;
      case "Orca":
        classification = new Classification("Delphinidae","Orcinus","orca");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "SPLASHING RAWR";
        render = ('O');
        break;
      case "RedFox":
        classification = new Classification("Canidae","Vulpes","vulpes");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "RAWR with passion";
        render = ('F');
        break;
      case "RedKite":
        classification = new Classification("Accipitridae","Milvus","milvus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("air");
        interaction = "flip flop";
        render = ('R');
        break;
      case "Tiger":
        classification = new Classification("Felidae","Felis","tigris");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "COURAGEOUS RAWR";
        render = ('T');
        break;
      case "Wolf":
        classification = new Classification("Canidae","Canis","lupus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "A STANDARD RAWR";
        render = ('W');
        break;
      case "ArcticFox":
        classification = new Classification("Canidae","Vulpes","lagopus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "ARCTIC RAWR";
        render = ('f');
        break;
      case "Axolotl":
        classification = new Classification("Ambystomatidae","Ambystoma","mexicanum");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("water");
        interaction = "a rare blub";
        render = ('A');
        break;
      case "BadakJawa":
        classification = new Classification("Rhinocerotidae","Rhinoceros","sondaicus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "HMM DON'T MIND ME AND MY ENDANGERED STATUS";
        render = ('J');
        break;
      case "BadakSumatra":
        classification = new Classification("Rhinocerotidae","Dicerorhinus","sumatrensis");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "IM WITH JAWA";
        render = 'S';
        break;
      default:
        classification = new Classification("null","null","null");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("null");
        interaction = "null";
    }
  }
  
  //!!! consider removing interface ILocation
  public int GetX(){
    return position.x;
  }
  
  public int GetY(){
    return position.y;
  }
  
  public void SetX(int x){
    this.position.x = x;
  }
  
  public void SetY(int y){
    this.position.y = y;
  }
  
  public void SetXY(int x, int y){
    this.position.x = x;
    this.position.y = y;
  }
  
  public String GetFamily(){
    return classification.family;
  }
  
  public String GetGenus(){
    return classification.genus;
  }
  
  public String GetSpecies(){
    return classification.species;
  }
  
  public int GetWeight(){
    return dietStatus.weight;
  }
  
  public void SetWeight(int weight){
    this.dietStatus.weight = weight;
  }
  
  public boolean IsCarnivore(){
    return dietStatus.meat_diet && !dietStatus.plant_diet;
  }
  
  public boolean IsHerbivore(){
    return dietStatus.plant_diet && !dietStatus.meat_diet;
  }
  
  public boolean IsOmnivore(){
    return dietStatus.meat_diet && dietStatus.plant_diet;
  }
  
  public boolean IsFlying(){
    return habitatStatus.flying;
  }
  
  public boolean IsLand(){
    return habitatStatus.land;
  }
  
  public boolean IsWater(){
    return habitatStatus.water;
  }
  
  public boolean IsTame(){
    return tame_status;
  }
  
  public String Interact() {
    return interaction;
  }

  public void Render() {
    System.out.print(render);
  }
}
