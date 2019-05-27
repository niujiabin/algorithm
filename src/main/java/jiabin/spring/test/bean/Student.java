package jiabin.spring.test.bean;

public class Student {

    private String name;
    private Integer age;
    private Animal animal;

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Student setAnimal(Animal animal) {
        this.animal = animal;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
