package in.himanshugawari.java.javaprogrammingmasterclass.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author himanshu
 *
 */

public class StreamExamples {
	public static void main(String[] args) {
		List<String> someBigNumbers = Arrays.asList("N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "g64", "I26",
				"I17", "I29", "O71");

		// General Method
		List<String> gNumbers = new ArrayList<String>();
		someBigNumbers.forEach(number -> {
			if (number.toUpperCase().startsWith("G")) {
				gNumbers.add(number);
				// System.out.println(number);
			}
		});
		gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
		gNumbers.forEach((String s) -> System.out.println(s));
		System.out.println();

		// Using Streams
		someBigNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted()
				.forEach(System.out::println);

		System.out.println();

		someBigNumbers.stream().sorted().forEach(System.out::println);

		System.out.println();

		System.out.println("----------------");
		someBigNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted()
				.forEach(System.out::println);

		System.out.println("-------------------");

		Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
		Stream<String> inNumberStream = Stream.of("N40", "N26", "I26", "I17", "I29", "O71");
		Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
		// System.out.println(concatStream.count());
		// System.out.println(concatStream.distinct().count());
		System.out.println(concatStream.distinct().peek(System.out::println).count());

		System.out.println();

		System.out.println("--------------------------");
		Employee john = new Employee("John Doe", 30);
		Employee jane = new Employee("Jane Deer", 25);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);

		Department hr = new Department("Human Resources");
		hr.addEmployee(jane);
		hr.addEmployee(jack);
		hr.addEmployee(snow);
		Department accounting = new Department("Accounting");
		accounting.addEmployee(john);

		List<Department> departments = new ArrayList<>();
		departments.add(hr);
		departments.add(accounting);

		departments.stream().flatMap(d -> d.getEmployees().stream()).forEach(System.out::println);

		System.out.println("----------------");
		List<String> sortedGNumbers = someBigNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G"))
				.sorted().collect(Collectors.toList());
		for (String s : sortedGNumbers) {
			System.out.println(s);
		}

		System.out.println("----------------");
		List<String> sortedGNumbers1 = someBigNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G"))
				.sorted().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		for (String s : sortedGNumbers1) {
			System.out.println(s);
		}

		System.out.println("----------------");
		Map<Integer, List<Employee>> groupedByAge = departments.stream()
				.flatMap(department -> department.getEmployees().stream())
				.collect(Collectors.groupingBy(employee -> employee.getAge()));
		for (Entry<Integer, List<Employee>> s : groupedByAge.entrySet()) {
			System.out.println(s.getKey() + " : " + s.getValue());
		}

		System.out.println("\nYoungest Employee ");

		departments.stream().flatMap(d -> d.getEmployees().stream())
				.reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2).ifPresent(System.out::println);

		System.out.println("\n------------");
		Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST").filter(s -> {
			System.out.println(s);
			return s.length() == 3;
		}).count();
	}
}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
}

class Department {
	private String name;
	private List<Employee> employees;

	public Department(String name) {
		super();
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", employees=" + employees + "]";
	}
}
