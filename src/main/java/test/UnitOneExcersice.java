package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UnitOneExcersice {

	public static void main(String [] args) {
		List<Person> myList = Arrays.asList(
				new Person("Charles", "Dicksonson", 35),
				new Person("Dharles", "Cicksonson", 35),
				new Person("Pharles", "Micksonson", 35),
				new Person("Mharles", "Nicksonson", 35),
				new Person("Jharles", "Gicksonson", 35));
		UnitOneExcersice excersice = new UnitOneExcersice();
		PersonInterface sortedList = excersice.sortThePersons(myList);
		myList = sortedList.sortPersons(myList);
		System.out.println(myList.toString());
		
		Predicate<Person> p = (person) -> person.getLastName().startsWith("C");
		Consumer<Person> c = (person) -> System.out.println(person.toString());
		for(Person eachPerson : myList) {
			if(p.test(eachPerson)) {
				c.accept(eachPerson);
			}
		}
	}
	
	//Sort list by Last name
	public PersonInterface sortThePersons(List<Person> listToSort) {
		PersonInterface pInterface = y -> {
			Collections.sort(y, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
			return y;
		};
		return pInterface;
	}
	//Method to print all elements in the list
	
	
	
	//Method to print all elements in the list with last name by C
}
