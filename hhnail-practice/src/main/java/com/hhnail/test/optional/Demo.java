package com.hhnail.test.optional;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo {

    public static void main(String[] args) {
        Integer num = null;
        System.out.println(10 < num);
        System.out.println(num > 10);
    }

    public Student getStudent() {
        System.out.println("新student");
        return new Student(2L, "李四", 20);
    }


    @Test
    public void test01() {
        Student student = new Student(1L, "zhangsan", 19);
        // Student student = null;
        Optional.ofNullable(student).map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        }).ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }


    @Test
    public void test02() {
        Student student = new Student(1L, "zhangsan", 19);
        // Student student = null;
        Optional.ofNullable(student)
                .map(student1 -> student1.getName())
                .ifPresent(s -> System.out.println(s));
    }

    @Test
    public void test03() {
        // Student student = new Student(1L, "zhangsan", 19);
        Student student = null;
        Optional<Student> optionalStudent = Optional.ofNullable(student);

        /**
         * orElse vs orElseGet
         * 相同点：这里视频造成了误解。orElse和orElseGet的返回值都是原来optional里的对象，而不是里面新创建的对象
         *
         * 不同点：有点类似懒汉式和饿汉式
         * orElse是饿汉式，无论原student是不是null，都执行
         * orElseGet是懒汉式，只有student是null，才执行
         *
         */
        Student student1 = optionalStudent.orElse(getStudent());
        System.out.println(student1);


        System.out.println("==========================华丽的分割线=============================");


        Student student2 = optionalStudent.orElseGet(this::getStudent);
        System.out.println(student2);

    }


    @Test
    public void test04() {
        // Student student = new Student(1L, "zhangsan", 19);
        Student student = new Student(1L, "zhangsan", null);
        Optional<Student> optionalStudent = Optional.ofNullable(student);
        optionalStudent
                .map(student1 -> student1.getAge())
                .filter(age -> age > 10)
                .ifPresent(age -> System.out.println(age));

        System.out.println("======================华丽的分隔线======================");


        // Student student = new Student(1L, "zhangsan", 19);
        Student student2 = new Student(1L, "zhangsan", null);
        Optional<Student> optionalStudent2 = Optional.ofNullable(student2);
        optionalStudent2
                // 这个可能会报错。他只能判断student是不是null，不能判断age是不是null
                .filter(student1 -> student1.getAge() > 10)
                .ifPresent(age -> System.out.println(age));

    }


    @Test
    public void beforeJava8() {
        List<Student> list = new ArrayList<>();
        for (Student student : list) {
            if (student != null) {
                if (student.getAge() > 18) {
                    Long id = student.getId();
                    if (id != null && id > 1000) {
                        System.out.println(student);
                    }
                }
            }

        }
    }

    @Test
    public void whenJava8() {
        List<Student> list = new ArrayList<>();
        for (Student student : list) {
            Optional<Student> studentOptional = Optional.ofNullable(student);
            Long id = studentOptional.filter(student1 -> student1.getAge() > 18)
                    .map(Student::getId)
                    .orElse(-1L);
            if (id > 1000) {
                System.out.println(student);
            }
        }
    }
}
