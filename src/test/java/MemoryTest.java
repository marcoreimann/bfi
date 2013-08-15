import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MemoryTest {

  private Memory memory;

  @BeforeMethod
  public void setup(){
    memory = new Memory(5);
  }

  @Test
  public void testIncValue() {
    memory.incValue();
    memory.incValue();
    assertEquals(memory.currentDataValue(), 2);
  }

  @Test
  public void testDecValue() {
    memory.decValue();
    memory.decValue();
    assertEquals(memory.currentDataValue(), (byte) 0xfe);
  }

  @Test
  public void testIncPointer() {
    memory = new Memory(new int[] {1, 2});
    memory.incPointer();
    assertEquals(memory.currentDataValue(), 2);
  }

  @Test
  public void testDecPointer() {
    memory = new Memory(new int[] {1, 2});
    memory.incPointer();
    memory.decPointer();
    assertEquals(memory.currentDataValue(), 1);
  }
}
