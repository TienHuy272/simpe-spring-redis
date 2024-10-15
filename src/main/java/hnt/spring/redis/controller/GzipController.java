package hnt.spring.redis.controller;

import hnt.spring.redis.dto.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class GzipController {

    @GetMapping("/employees")
    public List<Employee> getLargeResponse() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        List<String> departments = Arrays.asList("HR", "Finance", "Engineering", "Sales", "Marketing");
        List<String> skills = Arrays.asList("Java", "Spring Boot", "SQL", "Kafka", "MongoDB");

        return IntStream.rangeClosed(1, 100000)
                .mapToObj(i -> new Employee(
                        i,
                        "emp" + i,
                        String.valueOf(new Random().nextLong(1000000000L)),
                        "address" + i,
                        genders.get(new Random().nextInt(genders.size())),
                        departments.get(new Random().nextInt(departments.size())),
                        skills.get(new Random().nextInt(skills.size()))
                ))
                .collect(Collectors.toList());
    }
}
