public class Name {
    private String firstName;
    private String middleName;
    private String surname;

    public Name(String first, String middle, String sur)
    {
        firstName = first;
        middleName = middle;
        surname = sur;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFullName() {
        if (middleName != null) {
            return firstName + "" + middleName + "" + surname;
        }
        else {
            return firstName + "" + surname;
        }
    }

    public String getInitials(){
        String initials = "";

        initials += firstName.charAt(0);
        if (middleName != null) {
            initials += middleName.charAt(0);
        }
        initials += surname.charAt(0);

        return initials;
    }
}
