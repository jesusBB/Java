package com.mytesting.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Person implements Comparable<Person> {
	String name;
	String city;
	String dni;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Person() {
		super();
	}

	public Person(String name, String city, String dni) {
		super();
		this.name = name;
		this.city = city;
		this.dni = dni;
	}

	public static void addPersonsToList(List<Person> persons) {
		persons.add(new Person("Paco", "Jaen", "1"));
		persons.add(new Person("Jesuli", "Cadiz", "2"));
		persons.add(new Person("Ricardo", "Madrid", "3"));
		persons.add(new Person("Miguel", "Barcelona", "4"));
		persons.add(new Person("Fran", "Madrid", "5"));
	}

	public static void addPersonToSorted(TreeSet<Person> personsTreeSet){
		personsTreeSet.add(new Person("Paco", "Jaen", "1"));
		personsTreeSet.add(new Person("Jesuli", "Cadiz", "2"));
		personsTreeSet.add(new Person("Ricardo", "Tres Cantos", "3"));
		personsTreeSet.add(new Person("Miguel", "Barcelona", "4"));
		personsTreeSet.add(new Person("Fran", "Madrid", "5"));
		personsTreeSet.add(new Person("Miguel", "Pontevedra", "6"));
	}
	
	public static void addPersonToLinkedHashSet(LinkedHashSet<Person> personsTreeSet){
		personsTreeSet.add(new Person("Paco", "Jaen", "1"));
		personsTreeSet.add(new Person("Jesuli", "Cadiz", "2"));
		personsTreeSet.add(new Person("Ricardo", "Tres Cantos", "3"));
		personsTreeSet.add(new Person("Miguel", "Barcelona", "4"));
		personsTreeSet.add(new Person("Fran", "Madrid", "5"));
		personsTreeSet.add(new Person("Miguel", "Cadiz", "6"));
	}
	
	public static void addPersonToHashSet(HashSet<Person> personsTreeSet){
		personsTreeSet.add(new Person("Paco", "Jaen", "1"));
		personsTreeSet.add(new Person("Jesuli", "Cadiz", "2"));
		personsTreeSet.add(new Person("Ricardo", "Tres Cantos", "3"));
		personsTreeSet.add(new Person("Miguel", "Barcelona", "4"));
		personsTreeSet.add(new Person("Fran", "Madrid", "5"));
		personsTreeSet.add(new Person("Miguel", "Cadiz", "6"));
	}
	
	public static void addPersonToQueue(Queue<Person> personsQueue){
		personsQueue.offer(new Person("Paco", "Jaen", "1"));
		personsQueue.offer(new Person("Jesuli", "Cadiz", "2"));
		personsQueue.offer(new Person("Ricardo", "Tres Cantos", "3"));
		personsQueue.offer(new Person("Miguel", "Barcelona", "4"));
		personsQueue.offer(new Person("Fran", "Madrid", "5"));
		personsQueue.offer(new Person("Miguel", "Cadiz", "6"));
	}
	
	@Override
	public String toString() {
		return name + " - " + city + " (" + dni + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public int compareTo(Person o) {
		return this.getDni().compareTo(o.getDni());
	}
	
	
	
}
