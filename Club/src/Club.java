
public class Club {

    private String fullName, abb;
    private int amount, studentAmount = 0;
    private Student[] members;

    public Club(String fullName, String abb, int amount) {
        this.fullName = fullName;
        this.abb = abb;
        members = new Student[amount];
    }

    public int doesExist(long id) {
        for (int i = 0; i < studentAmount; i++) {
            if (members[i].getStudentId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addMember(Student student) {
        if (student != null) {
            members[studentAmount++] = student;
        }
    }

    public void removeMember(long id) {
        for (int i = doesExist(id); i < studentAmount; i++) {
            if (i == studentAmount - 1) {
                members[i] = null;
            } else {
                members[i] = members[i + 1];
            }
        }
        studentAmount--;
    }
    
    public void editMember(Student student){
        members[doesExist(student.getStudentId())] = student;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isFull() {
        return studentAmount >= members.length;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public Student[] getMembers() {
        return members;
    }

    public String getAbb() {
        return abb;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Club Name: ");
        sb.append(fullName);
        sb.append("\nShortname: ");
        sb.append(abb);
        sb.append("\nAmount of Members: ");
        sb.append(studentAmount + "/" + members.length);
        sb.append("\nStatus: " + (isFull() ? "Close" : "Open"));
        return sb.toString();
    }
}
