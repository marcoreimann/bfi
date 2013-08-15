import java.io.InputStream;
import java.io.OutputStream;

public class BFInterpreter {

  String source;
  OutputStream outputStream;
  InputStream inputStream;

  public void execute() {
    Program program = new Program(512);
    program.setInstructions(Instruction.parse(source));
    program.io = new IO(inputStream, outputStream);

    program.execute();
  }
}
