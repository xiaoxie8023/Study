package org.example.springboot;

/**
 * program: SpringBoot
 * <p>
 * description:
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-09 13:52
 **/
public class UserInfo {
    private String name;
    private int age;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

}
