import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;

public class IOTest {

  private ByteArrayOutputStream outputStream;
  private IO io;

  @BeforeMethod
  public void setUp() throws Exception {
    outputStream = new ByteArrayOutputStream();
    io = new IO(new MockInputStream(), outputStream);
  }

  @Test
  public void testWrite() {
    Memory memory = new Memory(new int[] {'A', 'B', 'C'});
    io.writeChar(memory);
    memory.incPointer();
    io.writeChar(memory);
    memory.incPointer();
    io.writeChar(memory);

    assertEquals(outputStream.toString(), "ABC");
  }

  private static class MockInputStream extends InputStream {

    @Override
    public int read() throws IOException {
      return 0;
    }
  }
}
