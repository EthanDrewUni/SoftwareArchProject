package Model;
public class Name {
    private String firstName;
    private String surname;

    public Name(String first, String sur)
    {
        firstName = first;
        surname = sur;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFullName() {
        return firstName + " " + surname;
    }

    public String getInitials(){
        String initials = "";
        initials += firstName.charAt(0);
        initials += surname.charAt(0);
        return initials;
    }
}
