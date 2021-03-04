package com.algs.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Student{
    private int id;
    public Student(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}

public class ConsumerTest {
    public static void main(String[] args){
//        Consumer
        Consumer<Integer> consumer = i -> System.out.println(i);

        consumer.accept(1024);

        List list = Arrays.asList(6,1,2,3,4,5);

        list.forEach(consumer);

//        Supplier
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        for(int i = 0; i < 100; i++){
            System.out.println(supplier.get());
        }

//        Predicate
        Predicate<Integer> predicate = i -> i > 50;
        for(int i = 0; i < 100; i++){
            System.out.println(predicate.test(supplier.get()));
        }

//        Function
        Function<Student, Integer> function = student -> student.getId();
        for(int i = 0; i < 100; i++){
            System.out.println(function.apply(new Student(supplier.get())));
        }
    }
}
