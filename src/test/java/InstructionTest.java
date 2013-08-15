import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class InstructionTest {

  @Test
  public void testParse() throws Exception {
    String src = "<>dödö[]";
    Instruction[] instructions = Instruction.parse(src);

    assertNotNull(instructions);
    assertEquals(instructions.length, 4);
    assertEquals(instructions[0], Instruction.decPointer);
    assertEquals(instructions[1], Instruction.incPointer);
    assertEquals(instructions[2], Instruction.startloop);
    assertEquals(instructions[3], Instruction.endloop);

  }
}
