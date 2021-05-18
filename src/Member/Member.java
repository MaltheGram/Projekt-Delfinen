package Member;

public class Member {

    private String birthDate;
    private String name;
    private String address;
    private int memberId;
    private boolean isActiveMember;


    public Member(String name, String birthDate, String phoneNumber, boolean activeMember, int memberId){
        this.name = name;
        this.birthDate = birthDate;
        this.address = phoneNumber;
        this.isActiveMember = activeMember;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean isActiveMember() {
        return isActiveMember;
    }

    public void setActiveMember(boolean activeMember) {
        this.isActiveMember = activeMember;
    }

}
