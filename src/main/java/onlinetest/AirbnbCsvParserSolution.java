package onlinetest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AirbnbCsvParserSolution {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String csv = sc.nextLine();
            System.out.println(AirbnbCsvParserSolution.csvParser(csv));
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }

    private static String csvParser(String csv) {
        String[] tmp = csv.split(",");
        Map<String, String> map = new HashMap<>();
        String[] info = new String[]{ "first_name", "last_name", "email", "interests", "notes", "city", "age"};
        int len = tmp.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (tmp[i].charAt(0) != '"') {
                map.put(info[cnt++], tmp[i]);
                continue;
            }
            // "John ""Mo"""
            if (tmp[i].charAt(0) == '"' && tmp[i].charAt(tmp[i].length() - 1) == '"') {
                StringBuilder sb = new StringBuilder();
                Character last = ' ';
                for (int j = 1; j < tmp[i].length(); j++) {
                    Character cur = tmp[i].charAt(j);
                    if (cur != '"') {
                        sb.append(cur);
                        last = cur;
                    } else {
                        if (last == '"') {
                            continue;
                        }
                        sb.append(cur);
                        last = cur;
                    }
                }
                map.put(info[cnt++], sb.toString());
                continue;
            }
            // "cooking, traveling"
            if (tmp[i].charAt(0) == '"') {
                StringBuilder sb = new StringBuilder();

                while (true) {
                    if (tmp[i].charAt(0) == '"') {
                        sb.append(tmp[i].substring(1)).append(",");
                    } else if (tmp[i].charAt(tmp[i].length() - 1) == '"') {
                        sb.append(tmp[i].substring(0, tmp[i].length() - 1));
                        break;
                    } else {
                        sb.append(tmp[i]);
                    }
                    i++;
                }
                map.put(info[cnt++], sb.toString());
            }

        }
        // [first_name], [age] years old, is from [city] and is interested in [interests].
        return map.get("first_name") + ", " + map.get("age") + " years old, is from " + map.get("city") + " and is interested in " + map.get("interests");
    }
}
