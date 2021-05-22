/**
    @author Simon Gredal
 */

package Member;

import Service.FileControl;

import java.util.*;
import java.util.function.Function;

public class MemberList {

    private final String filePath;
    private final HashMap<String, Member> members;

    public MemberList(String filePath) {
        this.filePath = filePath;
        this.members = FileControl.readSerializableFromFile(this.filePath, new HashMap<String, Member>() );
    }

    public void addNewMember(Member member) {
        this.members.put(member.getMemberId(), member);
        FileControl.writeSerializableToFile(this.members, this.filePath);
    }

    public void addNewMembers(Map<String, Member> members) {
        this.members.putAll(members);
        FileControl.writeSerializableToFile(this.members, this.filePath);
    }

    public void updateMember(Member updatedMember) {
        addNewMember(updatedMember);
    }



    public void removeMember(String memberID) {
        this.members.remove(memberID);
        FileControl.writeSerializableToFile(this.members, this.filePath);
    }

    /**
     * Watch out! Might return null.
     */
    public Member getMemberByID(String memberID) {
        return members.getOrDefault(memberID, null);
    }

    public Collection<Member> getAllMembers() {
        return Collections.unmodifiableCollection(
                this.members.values()
        );
    }

    public <R> Collection<R> getFieldFromAllMembers(Function<Member, R> methodReference) {
        return null;
        //compile error: cannot find symbol method toList() r:60
        /*return Collections.unmodifiableCollection(
                members.values().stream()
                .map(methodReference)
                .toList()
        );*/
    }

    @Override public String toString() {
        return members.toString();
    }

}
