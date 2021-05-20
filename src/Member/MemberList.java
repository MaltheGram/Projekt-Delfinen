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

    private static final Map<String, Member> members = new HashMap<>();

    public static void addNewMember(Member member) {
        MemberList.members.put(member.getMemberId(), member);
    }

    public static void addNewMembers(Map<String, Member> members) {
        MemberList.members.putAll(members);
    }

    /**
     * Watch out! Might return null.
     */
    public static Member getMemberByID(String memberID) {
        return members.getOrDefault(memberID, null);
    }

    public static Collection<Member> getAllMembers() {
        return Collections.unmodifiableCollection(
                MemberList.members.values()
        );
    }

    public static Collection<Member> getOverdueMembers() {
        return Collections.unmodifiableCollection(
                MemberList.members.values()
                        .stream()
                        .filter(member -> member.getMembership().isOverdue())
                        .toList()
        );
    }

    public static void removeMember(String memberID) {
        MemberList.members.remove(memberID);
    }

}
