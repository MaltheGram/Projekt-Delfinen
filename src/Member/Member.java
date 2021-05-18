package Member;

public class Member {

    private String birthDate;
    private String name;
    private String phoneNumber;
    private int memberId;
    private boolean activeMember;


    public Member(String name, String birthDate, String phoneNumber, boolean activeMember, int memberId){
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.activeMember = activeMember;
        this.memberId = memberId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean isActiveMember() {
        return activeMember;
    }

    public void setActiveMember(boolean activeMember) {
        this.activeMember = activeMember;
    }

}
