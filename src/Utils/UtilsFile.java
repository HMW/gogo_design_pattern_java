package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilsFile {

  // FIXME hard coded file name
  private static final String FILE_NAME = "temp.ggm";

  public static void write(String text) throws IOException {
    Path path = Paths.get(FILE_NAME);
    byte[] strToBytes = text.getBytes();
    Files.write(path, strToBytes);
  }

  public static String read() throws IOException {
    Path path = Paths.get(FILE_NAME);
    List<String> resultList = Files.readAllLines(path);
    StringBuilder resultBuilder = new StringBuilder();
    for (String str : resultList) {
      if (resultBuilder.length() != 0) {
        resultBuilder.append("\n");
      }
      resultBuilder.append(str);
    }

    return resultBuilder.toString();
  }

}
