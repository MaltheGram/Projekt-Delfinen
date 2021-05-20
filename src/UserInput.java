/*
 * @author Mark "Massive Legend" Larsen
 * spiced up @author Malthe
 * 20/05/2021 10.41
 *
 * DAT21V2-Projekt-Delfinen
 *
 */
public class UserInput {
    public static Boolean isYes(String str) {
        return (str.equalsIgnoreCase("yes") ||
                str.equalsIgnoreCase("ye") ||
                str.equalsIgnoreCase("y") ||
                str.equalsIgnoreCase("") ||
                str.equalsIgnoreCase("ja") ||
                str.equalsIgnoreCase("ok") ||
                str.equalsIgnoreCase("jep")
        );
    }

    public static Boolean isNo(String str) {
        return ( str.toLowerCase().contains("No") ||
                str.toLowerCase().contains("x") ||
                str.toLowerCase().contains("stop") ||
                str.isBlank() ||
                str.isEmpty()
        );
    }
}
