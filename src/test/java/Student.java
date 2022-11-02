public class Student {
        //----------- ATTRIBUTES -----------
    private String firstName;
    private String lastname;
    private String email;
    private String phone;
    //---------- CONSTRUCTORS -----------
    public Student() {              //пустой конструктор, создается автоматом и не виден

    }
//........... Конструктор (вместо Setters) .............
    public Student(String firstName, String lastname, String email, String phone) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
//............... Getters and Setters .............
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        //---------- CUSTOM METHODS (Optional)------------
    public String getFullName() {
        return firstName + " " + lastname;
    }
}
