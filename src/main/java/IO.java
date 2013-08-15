import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class IO {
  private InputStream in;
  private OutputStream out;

  IO(InputStream in, OutputStream out) {
    this.in = in;
    this.out = out;
  }

  public void readChar(Memory memory) {
    try {
      memory.setCurrentDataValue((int) (byte) in.read());
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeChar(Memory memory) {
    try {
      int val = memory.currentDataValue();
      out.write(val);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
