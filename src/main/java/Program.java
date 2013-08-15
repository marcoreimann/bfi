public class Program {

  Instruction[] instructions;
  private int instructionPointer;
  Memory memory;
  IO io;

  public Program(int size) {
    this.memory = new Memory(size);
  }

  public void execute() {
    while (!isFinished()) {
      executeInstruction();
      incInstructionPointer();
    }
  }

  public void setInstructions(Instruction... instructions) {
    this.instructions = instructions;
  }

  public void executeInstruction() {
    switch (currentInstruction()) {
      case incPointer:
        memory.incPointer();
        break;
      case decPointer:
        memory.decPointer();
        break;
      case inc:
        memory.incValue();
        break;
      case dec:
        memory.decValue();
        break;
      case putchar:
        io.writeChar(memory);
        break;
      case getchar:
        io.readChar(memory);
        break;
      case startloop:
        startLoop();
        break;
      case endloop:
        endLoop();
        break;
      default:
        break; // noop
    }
  }

  char currentToken() {
    return currentInstruction().sourceToken;
  }

  private Instruction currentInstruction() {
    return instructions[instructionPointer];
  }

  boolean isFinished() {
    return instructionPointer >= instructions.length;
  }

  public void decInstructionPointer() {
    instructionPointer--;
  }

  public void incInstructionPointer() {
    instructionPointer++;
  }

  public void startLoop() {
    if (memory.currentDataValue() == 0) {
      jumpAfterLoopEnd();
    }
  }

  public void endLoop() {
    if (memory.currentDataValue() != 0) {
      jumpBackToLoopStart();
    }
  }

  private void jumpAfterLoopEnd() {
    while (currentInstruction() != Instruction.endloop) {
      incInstructionPointer();
    }
  }

  private void jumpBackToLoopStart() {
    while (currentInstruction() != Instruction.startloop) {
      decInstructionPointer();
    }
  }
}
