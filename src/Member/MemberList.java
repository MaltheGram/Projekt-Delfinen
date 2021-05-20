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

    /**
     * Watch out! Might return null.
     */
    public static Member getMemberByID(String memberID) {
        return members.getOrDefault(memberID, null);
    }

    public static Collection<Member> getAllMembers() {
        return Collections.unmodifiableCollection(
                members.values()
        );
    }

 /*   public static Collection<Member> getOverdueMembers() {
        return Collections.unmodifiableCollection(
                members.values()
                        .stream()
                        .filter(member -> member.getMembership().isOverdue())
                        .toList()
        );
    }*/




}
