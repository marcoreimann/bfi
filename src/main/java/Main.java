import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
      BFInterpreter bfInterpreter = new BFInterpreter();
      bfInterpreter.inputStream = System.in;
      bfInterpreter.outputStream = System.out;
      bfInterpreter.source = loadSource(args[0]);
      bfInterpreter.execute();
    }

  public static String loadSource(String filename) throws IOException {
    InputStream sourcestream = new FileInputStream(filename);
    BufferedReader reader = new BufferedReader(new InputStreamReader(sourcestream));
    StringBuffer buffer = new StringBuffer();
    String line;

    while ((line = reader.readLine()) != null) {
      buffer.append(line);
    }
    sourcestream.close();
    return buffer.toString();
  }
}
