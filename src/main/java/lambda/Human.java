package lambda;


public class Human {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private Sex sex;

    public enum Sex {MALE, FEMALE};

    public Human(String firstName, String lastName, String middleName, int age, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.sex = sex;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (age != human.age) return false;
        if (!firstName.equals(human.firstName)) return false;
        if (!lastName.equals(human.lastName)) return false;
        if (!middleName.equals(human.middleName)) return false;
        return sex == human.sex;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + age;
        result = 31 * result + sex.hashCode();
        return result;
    }
}
