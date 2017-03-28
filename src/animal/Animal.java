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
  
  Animal(String AnimalOption,int weight) {
    position = new Location();
    switch(AnimalOption) {
      case "Cat":
        classification = new Classification("Felidae","Felis","Catus");
        dietStatus = new DietStatus(weight,true,false);
        habitatStatus = new HabitatStatus("land");
        interaction = "NYAA";
        render = 'c';
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
