import java.util.ArrayList;
import java.util.List;

public enum Instruction {
  incPointer('>'),
  decPointer('<'),
  inc('+'),
  dec('-'),
  putchar('.'),
  getchar(','),
  startloop('['),
  endloop(']');

  public final char sourceToken;

  private Instruction(char sourceToken) {
    this.sourceToken = sourceToken;
  }

  public static Instruction[] parse(String source) {
    List<Instruction> instructions = new ArrayList<Instruction>(source.length());

    for (int i = 0; i < source.length(); i++) {
      char srcChar = source.charAt(i);
      Instruction instruction = parse(srcChar);
      if(instruction != null) instructions.add(instruction);
    }
    return instructions.toArray(new Instruction[instructions.size()]);
  }

  private static Instruction parse(char srcChar) {
    for (Instruction instruction : values()) {
      if (instruction.sourceToken == srcChar) { return instruction; }
    }
    return null;
  }

}
