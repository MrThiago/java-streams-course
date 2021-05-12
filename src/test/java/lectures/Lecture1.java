package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import com.sun.tools.javac.util.Log;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    for (Person p : people){
      if(p.getAge() <= 18){
        System.out.println("name: " + p.getFirstName() + " age: " + p.getAge());
      }
    }
    // 2. Then change implementation to find first 10 people
    for(int i=0; i < people.size(); i++){
      if(i == 10) break;
      System.out.println("For Loop name: " + people.get(i).getFirstName() + " age: " + people.get(i).getAge());
    }
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    List<Person> people = MockData.getPeople();
    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() <= 18)
        .limit(10)
        .collect(Collectors.toList());
    youngPeople.forEach(System.out::println);


  }
}
