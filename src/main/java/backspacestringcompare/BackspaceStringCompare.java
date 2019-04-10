package backspacestringcompare;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1;
        int t = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while(s >= 0 || t >= 0) {
            while (s >= 0) {
                if (S.charAt(s) == '#') {
                    skipS++;
                    s--;
                } else if (skipS > 0) {
                    s--;
                    skipS--;
                } else {
                    break;
                }
            }
            while (t >= 0) {
                if (T.charAt(t) == '#') {
                    skipT++;
                    t--;
                } else if (skipT > 0) {
                    t--;
                    skipT--;
                } else {
                    break;
                }
            }
            if (s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)) {
                return false;
            }
            if ((s >= 0) != (t >= 0)) {
                return false;
            }
            s--;
            t--;

        }
        return true;
    }
}
