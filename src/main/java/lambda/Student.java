package lambda;

public class Student extends Human {
    private String university;
    private String faculty;
    private String special;

    public Student(String firstName, String lastName, String middletName, int age, Sex sex, String university, String faculty, String special) {
        super(firstName, lastName, middletName, age, sex);
        this.university = university;
        this.faculty = faculty;
        this.special = special;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (!university.equals(student.university)) return false;
        if (!faculty.equals(student.faculty)) return false;
        return special.equals(student.special);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + university.hashCode();
        result = 31 * result + faculty.hashCode();
        result = 31 * result + special.hashCode();
        return result;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecial() {
        return special;
    }
}
