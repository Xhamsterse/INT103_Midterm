
public class Student {

    private Long studentId;
    private String studentName;
    private String studentSurname;
    private String studentFaculty;

    public Student(Student student) {
            this(student.studentId, student.studentName, student.studentSurname, student.studentFaculty);
    }

    public Student(long studentId, String studentName, String studentSurname, String studentFaculty) {
        this.studentId = studentId;
        this.studentName = studentName == null ? "Unknown" : studentName;
        this.studentSurname = studentSurname == null ? "Unknown" : studentSurname;
        this.studentFaculty = studentFaculty == null ? "Unknown " : studentFaculty;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    private boolean equals(Student student) {
        return student !=null && this.studentId == student.studentId;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\nName: " + studentName + "\nSurname: " + studentSurname + "\nFaculty: " + studentFaculty;
    }

}
