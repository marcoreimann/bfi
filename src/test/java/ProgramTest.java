import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public class ProgramTest {

  private Program program;

  @BeforeMethod
  public void setUp() throws Exception {
    program = new Program(5);
  }

  @Test
  public void testIncInstructionPointer() {
    program.setInstructions(Instruction.parse(">BÄH."));
    program.incInstructionPointer();
    assertSame(program.currentToken(), '.');
  }


  @Test
  public void testDecInstructionPointer() {
    program.setInstructions(Instruction.parse("[Muh]Bla<"));
    program.incInstructionPointer();
    program.incInstructionPointer();
    assertEquals(program.currentToken(), '<');
    program.decInstructionPointer();
    assertEquals(program.currentToken(), ']');
  }


  @Test
  public void testStartLoopSpringtAnsEndeWennWertNull() {
    program.setInstructions(Instruction.parse("[+Blödel]<"));
    program.startLoop();
    assertEquals(program.currentToken(), ']');
  }

  @Test
  public void testStartLoopBleibtStehenWennWertNichtNull() {
    program.setInstructions(Instruction.parse("[+Sabbel]<"));
    program.memory.incValue();
    program.startLoop();

    assertEquals(program.currentToken(), '[');
  }

  @Test
  public void testEndLoopGehtZuSchleifenAnfangZurueckWennWertNichtNull() {
    program.setInstructions(Instruction.parse("[+Schnubbel]<"));
    program.memory.incValue();
    program.incInstructionPointer();
    program.incInstructionPointer();
    program.endLoop();

    assertEquals(program.currentToken(), '[');
  }

  @Test
  public void testEndLoopBleibtStehenWennWertNull() {
    program.setInstructions(Instruction.parse("[+Dubbel]<"));
    program.incInstructionPointer();
    program.incInstructionPointer();
    program.endLoop();

    assertEquals(program.currentToken(), ']');
  }


}
