package unit_test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import animal.*;

public class Animal_test {
  //TODO Complete this unit test after animal_list implementation is complete 
  Animal litten;
  Animal incineroar;
  
  @Before
  public void initialize(){
    litten = new Animal("Cat");
    incineroar = new Animal("Cat",185);
  }

  @Test
  public void testWeight() {
    assertEquals(10,litten.GetWeight());
    assertEquals(185,incineroar.GetWeight());
  }

  
}
