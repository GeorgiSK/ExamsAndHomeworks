package problem_01;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception{
        Class person = Class.forName("Person");
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}


class Person {
    String name;
    String age;
}