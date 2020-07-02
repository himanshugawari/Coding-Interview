package in.himanshugawari.java.javaprogrammingmasterclass.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author himanshu
 *
 */
public class LambdaExp {
	public static void main(String[] args) {

		Employee1 john = new Employee1("John Doe", 30);
		Employee1 tim = new Employee1("Tim Bulk", 21);
		Employee1 jack = new Employee1("Jack Hill", 40);
		Employee1 snow = new Employee1("Snow White", 22);
		Employee1 red = new Employee1("Red Ridinghood", 35);
		Employee1 charming = new Employee1("Prince Charming", 31);

		List<Employee1> employees = new ArrayList<>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);
		employees.add(red);
		employees.add(charming);

		employees.forEach(employee -> {
			System.out.println(employee.getName());
			System.out.println(employee.getAge());
		});

		System.out.println("Employess over 30 using lambda");
		System.out.println("==============================");
		employees.forEach(employee -> {
			if (employee.getAge() > 30) {
				System.out.println(employee.getName());
				System.out.println(employee.getAge());
			}
		});

		System.out.println("Employess 30 or below using lambda");
		System.out.println("==================================");
		employees.forEach(employee -> {
			if (employee.getAge() <= 30) {
				System.out.println(employee.getName());
				System.out.println(employee.getAge());
			}
		});

		System.out.println("Employess over 30 using advanced for loop");
		System.out.println("=========================================");
		for (Employee1 employee : employees) {
			if (employee.getAge() > 30) {
				System.out.println(employee.getName());
				System.out.println(employee.getAge());
			}
		}

		System.out.println("===========================================================");
		System.out.println("printEmployeesByAge");
		printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
		System.out.println();
		printEmployeesByAge(employees, "Employees 30 or below", employee -> employee.getAge() <= 30);
		System.out.println();
		printEmployeesByAge(employees, "Employees below 25", new Predicate<Employee1>() {
			@Override
			public boolean test(Employee1 employee) {
				return employee.getAge() < 25;
			}
		});
		System.out.println();

		IntPredicate greaterThan15 = i -> i > 15;
		IntPredicate lessThan100 = i -> i < 100;

		System.out.println(greaterThan15.test(10));
		int a = 20;
		System.out.println(greaterThan15.test(a + 5));

		System.out.println(greaterThan15.and(lessThan100).test(50));
		System.out.println();

		Random random = new Random();
		for (int j = 0; j < 10; j++) {
			System.out.println(random.nextInt(1000));
		}
		System.out.println();

		Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
		for (int k = 0; k < 10; k++) {
			System.out.println(randomSupplier.get());
		}
		System.out.println();

		employees.forEach(employee -> {
			String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
			System.out.println("Last Name is : " + lastName);
		});
		System.out.println();

		Function<Employee1, String> getLastName = (Employee1 employee) -> {
			return employee.getName().substring(employee.getName().indexOf(' ') + 1);
		};
		String lastName = getLastName.apply(employees.get(4));
		System.out.println(lastName);
		System.out.println();

		Function<Employee1, String> getFirstName = (Employee1 employee) -> {
			return employee.getName().substring(0, employee.getName().indexOf(' '));
		};
		String firstName = getFirstName.apply(employees.get(4));
		System.out.println(firstName);
		System.out.println();

		Random random1 = new Random();
		for (Employee1 employee : employees) {
			if (random1.nextBoolean()) {
				System.out.println(getName(getFirstName, employee));
			} else {
				System.out.println(getName(getLastName, employee));
			}
		}

	}

	private static String getName(Function<Employee1, String> getName, Employee1 employee) {
		return getName.apply(employee);
	}

	private static void printEmployeesByAge(List<Employee1> employees, String ageText,
			Predicate<Employee1> ageCondition) {
		System.out.println(ageText);
		System.out.println("=========================================");
		for (Employee1 employee : employees) {
			if (ageCondition.test(employee)) {
				System.out.println(employee.getName());
				System.out.println(employee.getAge());
			}
		}
	}
}

class Employee1 {
	private String name;
	private int age;

	public Employee1(String name, int age) {
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
		// return "Employee [name=" + name + ", age=" + age + "]";
		return "Employee {name=" + name + ", age=" + age + "}";
	}
}