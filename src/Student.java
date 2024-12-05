public class Student extends User{
    private String major;

    public Student(String userId, String name, String role, String password, String major){
        super(userId, name, "Talaba", password);
        this.major=major;

    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
