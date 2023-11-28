public class Person {
    private Name name;
    private String email;
    private String country;
    private int age;

    public Person(Name pName, String pEmail, String pCountry, int pAge)
    {
        name = pName;
        email = pEmail;
        country = pCountry;
        age = pAge;
    }

    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getAge() {
        return age;
    }
    public void setDateOfBirth(int age) {
        this.age = age;
    }
}
