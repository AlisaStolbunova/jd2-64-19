package bean;

import lombok.Data;

import java.util.List;

@Data
public class Person {

    private Long id;
    private String name;
    private String surname;

    private PersonInfo personInfo;

    private Department department;

    private List<Meeting> meetings;

    public void init(){
        System.out.println("init method of Person");
    }

    public void destroy(){
        System.out.println("destroy method of Person");
    }
}
