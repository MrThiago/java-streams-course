package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> carPredicate = car -> car.getPrice() < 2000;

    List<Car> collectFiltered = cars.stream()
        .filter(carPredicate)
        .collect(Collectors.toList());

    collectFiltered.forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    List<PersonDTO> dtos = people.stream()
        //.map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
        .map(PersonDTO::map)
        .collect(Collectors.toList());

    dtos.forEach(System.out::println);
    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());
  }

  @Test
  public void averageCarPrice() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    // calculate average of car prices
    double average = cars.stream()
        //.mapToDouble(i -> i.getPrice())
        .mapToDouble(Car::getPrice)// Method Reference
        .average()
        .orElse(0);

    System.out.println(average);

  }

  @Test
  public void test() throws Exception {

  }
}



