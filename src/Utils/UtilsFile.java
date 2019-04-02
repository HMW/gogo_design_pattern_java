package Utils;

import com.sun.istack.internal.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilsFile {

  public static void write(@NotNull String fileName, String text) throws Exception {
    if (null == fileName) {
      throw new Exception("File name should not be null");
    }

    Path path = Paths.get(fileName);
    byte[] strToBytes = text.getBytes();
    Files.write(path, strToBytes);
  }

  public static String read(@NotNull String fileName) throws Exception {
    if (null == fileName) {
      throw new Exception("File name should not be null");
    }

    Path path = Paths.get(fileName);
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
