package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/28.
 * “student. a am I” - > I am a student.”
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) return str;
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i > 0; i--) {
            sb.append(s[i]).append(" ");
        }
        sb.append(s[0]);
        return sb.toString();
    }

}
