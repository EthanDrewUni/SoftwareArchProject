public class Person {
    private Name name;
    private String gender;
    private String country;
    private int age;

    public Person(Name pName, String pGender, String pCountry, int pAge)
    {
        name = pName;
        gender = pGender;
        country = pCountry;
        age = pAge;
    }

    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
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
