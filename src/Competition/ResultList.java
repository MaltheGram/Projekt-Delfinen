/**
 * @author Malthe Gram
 * @author Simon Gredal
 * 24/05/2021 22.52
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Competition;

import Member.Member;
import Service.FileControl;

import java.util.*;

public class ResultList {

    private final String filePath;
    private final HashMap<String, List<Result>> results;

    public ResultList(String filePath) {
        this.filePath = filePath;
        this.results = FileControl.readSerializableFromFile(this.filePath, new HashMap<>() );
    }

    public void addNewResult(Member member, Result result) {
        if ( this.results.containsKey(member.getMemberId()) ) {
            this.results.get(member.getMemberId()).add(result);
        } else {
            ArrayList<Result> list = new ArrayList<>();
            list.add(result);
            this.results.put(member.getMemberId(), list );
        }

        FileControl.writeSerializableToFile(this.results, this.filePath);
    }

    public void removeResult(Member member, int result) {
        results.get(member.getMemberId()).remove(result);
        FileControl.writeSerializableToFile(this.results,this.filePath);
    }

    public List<Result> getResultsByID(String memberID) {
        return this.results.getOrDefault(memberID, new ArrayList<>());
    }

    public Collection<List<Result>> getAllResults() {
        return Collections.unmodifiableCollection(
                this.results.values()
        );
    }

    @Override public String toString() {
        return this.results.toString();
    }

}
