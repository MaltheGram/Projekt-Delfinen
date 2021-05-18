package Member;

import Service.MemberIdGenerator;

public class Member {

    private String birthDate;
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isActiveMember;
    private MemberIdGenerator memberIdGenerator;



    public Member(String name, String birthDate, String address, String phoneNumber, boolean isActiveMember, MemberIdGenerator memberIdGenerator){
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.isActiveMember = isActiveMember;
        this.phoneNumber = phoneNumber;
        this.memberIdGenerator = memberIdGenerator;
    }


    public MemberIdGenerator getMemberIdGenerator() {
        return memberIdGenerator;
    }

    public void setMemberIdGenerator(MemberIdGenerator memberIdGenerator) {
        this.memberIdGenerator = memberIdGenerator;
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
        return "Member data:\n" + "BirthDate: " + birthDate + "\nName: " + name + "\nAddress: " + address + "\nMember id: " + memberIdGenerator + "\nActive member: " + isActiveMember;
    }
}
