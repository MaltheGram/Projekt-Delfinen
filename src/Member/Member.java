

/**
 * @author Malthe
 * 18/05/2021 13.26
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

        package Member;

        import Membership.Membership;

        import Service.MemberIdGenerator;

        import java.io.Serializable;
        import java.time.LocalDate;

public class Member implements Serializable {
    private LocalDate birthDate;
    private String name;
    private String address;
    private Membership membership;
    private String phoneNumber;
    private boolean isActiveMember;
    private final String memberId = new MemberIdGenerator().toString();



    public Member(String name, LocalDate birthDate, String address, String phoneNumber, boolean isActiveMember){
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.isActiveMember = isActiveMember;
        //this.membership = new Membership();
        this.phoneNumber = phoneNumber;

    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    public Membership getMembership() {
        return membership;
    }

    public boolean isActiveMember() {
        return isActiveMember;
    }

    public void setActiveMember(boolean isActiveMember) {
        this.isActiveMember = isActiveMember;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {

        return name + "," + birthDate + "," + address + "," + isActiveMember + "," + membership +"," + phoneNumber + ", " + getMemberId();
    }
}