/**
    @author Simon Gredal
 */

package Member;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemberList implements Serializable {

    private final Map<String, Member> members = new HashMap<>();

    public void addNewMember(Member member) {
        this.members.put(member.getMemberId(), member);
    }

    public void addNewMembers(Map<String, Member> members) {
        this.members.putAll(members);
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

    public Collection<Member> getOverdueMembers() {
        return Collections.unmodifiableCollection(
                this.members.values()
                        .stream()
                        .filter(member -> member.getMembership().isOverdue())
                        .toList()
        );
    }

    public void removeMember(String memberID) {
        this.members.remove(memberID);
    }

    @Override public String toString() {
        return members.toString();
    }

}
