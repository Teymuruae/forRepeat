package tests;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Jav {

    @Test
    void test1(){
        List<String> list = new ArrayList<String>(){{
            add("privet");
            add("ok");
            add("hi");
            add("hello");
        }};

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i,  String.valueOf(list.get(i).length()));
//        }

   List <Integer> list2 = list.stream().map(x -> x.length()).collect(Collectors.toList());
   System.out.println(list2);
    }

    @Test
    void test2(){
        int a [] = new int[]{1,4,5,6,8,7,9,12};

        a = Arrays.stream(a).map(x -> {
            if (x % 3 ==0){
                x = x/3;
            }
            return x;
        }).toArray();
//        Arrays.stream(a).forEach(System.out::println);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Students st = new Students("Ivan", 33);
        Students st1 = new Students("Eva", 32);
        Students st2 = new Students("Anton", 23);
        Students st3 = new Students("Inna", 20);

        List <Students> list = new ArrayList<>(){{
           add(st);
           add(st2);
           add(st3);
           add(st1);
        }};
        list = list.stream().filter(x -> x.age >25).collect(Collectors.toList());
        System.out.println(list);
    }

}

class Students{
    String name;
    int age;

    public Students(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
