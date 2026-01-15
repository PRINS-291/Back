package prins.idea;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveAndReadJsonOfClass {
    public static void main(String[] args) {
        // 创建数据对象
        Person person = new Person("John", 30);
        Car car = new Car("666",person);

        // 创建 ObjectMapper 实例
        ObjectMapper objectMapper = new ObjectMapper();

        //保存
        try {
            // 将对象写入 JSON 文件
            objectMapper.writeValue(new File("car.json"), car);
            System.out.println("数据已保存为 JSON 文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //读取
        try {
            // 从 JSON 文件读取并将其转换为 Java 对象
            Car car2 = objectMapper.readValue(new File("car.json"), Car.class);

            // 打印读取的对象
            System.out.println("Name: " + car2.id);
            System.out.println("Age: " + car2.person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    public String name;
    public int age;

    // 无参构造函数；；很重要 反序列化要用
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Car{
    public String id;
    public Person person;

    public Car(){}

    public Car(String id,Person person){
        this.id=id;
        this.person=person;
    }
}
