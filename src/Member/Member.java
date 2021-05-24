/**
 * @author Malthe
 * 18/05/2021 13.26
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Member;

import Service.MemberIdGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Member implements Serializable {
    private LocalDate birthDate;
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isActiveMember;
    private final String memberId = new MemberIdGenerator().toString();

    public Member(String name, LocalDate birthDate, String address, String phoneNumber, boolean isActiveMember){
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.isActiveMember = isActiveMember;
        this.phoneNumber = phoneNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public Integer getAge() {
        // running .normalized() so we don't get weird stuff like Period of 0 years+3000 days
        return Period.between(this.birthDate, LocalDate.now())
                .normalized()
                .getYears();
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
        return String.format(" %-10s %-15s %-20s %-10s %-10s %-15s\n", name, birthDate, address, isActiveMember, phoneNumber, getMemberId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return isActiveMember == member.isActiveMember && Objects.equals(birthDate, member.birthDate) && Objects.equals(name, member.name) && Objects.equals(address, member.address) && Objects.equals(phoneNumber, member.phoneNumber) && Objects.equals(memberId, member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, name, address, phoneNumber, isActiveMember, memberId);
    }
}