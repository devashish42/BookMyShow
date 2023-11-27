package bms.models;

public class User {
    public String name;

    public City city;

    public String address;


    private User(String name, City city, String address){
        this.name = name;
        this.city = city;
        this.address = address;
    }


    public static User createUser(String name, City city, String address){
        return new User(name, city, address);

    }
}
