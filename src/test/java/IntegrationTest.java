import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.testng.Assert.assertEquals;

public class IntegrationTest {

  @Test
  public void helloWorldGibtHelloWorldAus() throws IOException {
    String program = loadSource("helloWorld.bf");
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    BFInterpreter bfInterpreter = new BFInterpreter();
    bfInterpreter.outputStream = output;
    bfInterpreter.source = program;

    bfInterpreter.execute();

    String outputString = output.toString("ASCII");
    System.out.println(outputString);
    System.out.flush();
    assertEquals(outputString, "Hello World!\n\r");
  }

  private String loadSource(String filename) throws IOException {
    InputStream sourcestream = getClass().getResourceAsStream(filename);
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
