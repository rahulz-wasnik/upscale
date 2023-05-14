package java8newfeatures.collectors.ex5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
	
	int salary;
	String name;
	int departmentId;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}


public class FilterEmployesByName {

public static void main(String[] args) {

		Employee e1 = new Employee(10, "a", 1);
		Employee e2 = new Employee(12, "a", 1);
		Employee e3 = new Employee(12, "c", 1);

		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Employee e4 = new Employee(10000, "d", 2);
		Employee e5 = new Employee(12000, "d", 2);
		Employee e6 = new Employee(14000, "f", 2);

		list.add(e4);
		list.add(e5);
		list.add(e6);
		
		
		List<Employee> employees = list.stream()
				.sorted(Comparator.comparing(Employee::getName))
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(employees);
	}
}
