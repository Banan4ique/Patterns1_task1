package ru.netology;

import java.util.OptionalInt;

import static java.util.Objects.hash;

public class Person {

    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        if(age != null) {
            if (age >= 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Возраст указан неверно: " + age);
            }
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname);
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age += 1;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return hash(name, surname, age, address);
    }
}
