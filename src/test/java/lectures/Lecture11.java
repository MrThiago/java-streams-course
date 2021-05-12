package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    StringBuilder newNames = new StringBuilder();
    int index = 0;

    for (String name : names){
      if(index == names.size() -1){
        newNames.append(name);
      } else {
        newNames.append(name).append(",");
      }

      index++;
    }

    System.out.println(newNames);

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String join = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining(", "));

    System.out.println(join);
  }
}
