package ru.netology.persons;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(Integer age) {
        if(age != null) {
            if (age >= 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Возраст указан неверно: " + age);
            }
        }
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, age);
        if (name == null || surname == null) {
            throw new IllegalStateException("Обязательные поля не заполнены");
        }
        person.setAddress(address);
        return person;
    }
}
