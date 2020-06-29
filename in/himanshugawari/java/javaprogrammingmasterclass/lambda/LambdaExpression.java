package in.himanshugawari.java.javaprogrammingmasterclass.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author himanshu
 *
 */
public class LambdaExpression {
	public static void main(String[] args) {

		// General
		new Thread(new CodeToRun1()).start();
		new Thread(new CodeToRun2()).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Printing from Runnable Anonymous Inner Type");
			}
		}).start();

		CodeToRun1 c1 = new CodeToRun1();
		Thread t1 = new Thread(c1);
		t1.setName("t1");
		t1.start();

		CodeToRun2 c2 = new CodeToRun2();
		Thread t2 = new Thread(c2);
		t2.setName("t2");
		t2.start();

		Thread t3 = new CodeToRun2();
		t3.setName("t3");
		t3.start();

		Thread t4 = new Thread(new CodeToRun1());
		t4.setName("t4");
		t4.start();

		System.out.println();
		System.out.println("-------------------------");

		// Lambda
		new Thread(() -> System.out.println(
				Thread.currentThread().getName() + " Printing from Runnable Anonymous Inner Type using LAMBDA"))
						.start();

		new Thread(() -> {
			System.out.println("Line1");
			System.out.println("Line2");
			System.out.println("Line3");
			System.out.println("Line4");
			System.out.println("Line5");
		}).start();

		Employee john = new Employee("John Doe", 30);
		Employee tim = new Employee("Tim Bulk", 21);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);

		List<Employee> employees = new ArrayList<>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);

		System.out.println("---Using General Method--------");
		System.out.println("----Before Sorting----------");
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}

		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				return employee1.getName().compareTo(employee2.getName());
			}
		});

		System.out.println("----After Sorting----------");
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}

		System.out.println("------Using Lambda method---------");
		employees.removeAll(employees);
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);

		System.out.println("----Before Sorting----------");
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}

		Collections.sort(employees,
				(Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));
//      OR
//		Collections.sort(employees,
//				(employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

		System.out.println("----After Sorting----------");
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}

		System.out.println();
		System.out.println("--printing sillyString using anonymous inner type---");
		String sillyString = doStringStuff(new UpperConcat() {

			@Override
			public String upperAndConcat(String s1, String s2) {
				return s1.toUpperCase() + s2.toUpperCase();
			}
		}, employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString);

		System.out.println();
		System.out.println("--printing sillyString1 using lambda---");
		// UpperConcat uc=(String s1, String s2)->s1.toUpperCase()+s2.toUpperCase();
		// OR
		// UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
		// OR
		UpperConcat uc = (s1, s2) -> {
			String result = s1.toUpperCase() + s2.toUpperCase();
			return result;
		};
		String sillyString1 = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString1);
		System.out.println();

		System.out.println("--------AnotherClass example--------");
		AnotherClass anotherClass = new AnotherClass();
		String s = anotherClass.doSomething();
		System.out.println(s);
		System.out.println();

		String s1 = anotherClass.doSomethingLambda();
		System.out.println(s1);
		System.out.println();
		
		String s2=anotherClass.doSomethingold();
		System.out.println(s2);
		System.out.println();
	}

	public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}

}

class CodeToRun1 implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Printing from CodeToRun1 implements Runnable");
	}
}

class CodeToRun2 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Printing from CodeToRun2 extends Thread");
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
		// return "Employee [name=" + name + ", age=" + age + "]";
		return "Employee {name=" + name + ", age=" + age + "}";
	}
}

interface UpperConcat {
	String upperAndConcat(String s1, String s2);
}

class AnotherClass {

	// General
	public String doSomething() {
		System.out.println("The AnotherClass class's name is : " + getClass().getSimpleName());
		return LambdaExpression.doStringStuff(new UpperConcat() {

			@Override
			public String upperAndConcat(String s1, String s2) {
				System.out.println("The anonymous class's name is : " + getClass().getSimpleName());
				return s1.toUpperCase() + s2.toUpperCase();
			}
		}, "String1", "String2");
	}

	// Lambda
	public String doSomethingLambda() {
		UpperConcat uc = (s1, s2) -> {
			System.out.println("The lambda class's name is : " + getClass().getSimpleName());
			String result = s1.toUpperCase() + s2.toUpperCase();
			return result;
		};
		System.out.println("The AnotherClass class's name is : " + getClass().getSimpleName());
		return LambdaExpression.doStringStuff(uc, "String1", "String2");
	}

	// old method
	public String doSomethingold() {
		int i=0;
		{
			UpperConcat uc = new UpperConcat() {

				@Override
				public String upperAndConcat(String s1, String s2) {
					System.out.println("The anonymous class's name is : " + getClass().getSimpleName());
					return s1.toUpperCase() + s2.toUpperCase();
				}
			};
			System.out.println("The AnotherClass class's name is : " + getClass().getSimpleName());
			i++;
			System.out.println("i = "+i);
			return LambdaExpression.doStringStuff(uc, "String1", "String2");
		}
	}
}
