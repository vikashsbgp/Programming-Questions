package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class SearchString {
    int freq;
    String str;

    SearchString(int freq, String str) {
        this.freq = freq;
        this.str = str;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getStr() {
        return this.str;
    }

    @Override
    public String toString() {
        return "SearchString{" +
                "freq=" + freq +
                ", str='" + str + '\'' +
                '}';
    }
}
public class SearchEngineQuery {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            List<SearchString> ans = new ArrayList<>();
            Map<String, SearchString> hm = new HashMap<>();
            int c = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < c; i++) {

                String tmp = br.readLine().trim();
                if (tmp.split(" ").length != 2) {

                    if (hm.containsKey(tmp)) {
                        hm.get(tmp).freq++;
                    }
                    else
                        hm.put(tmp, new SearchString(1, tmp));

                }
                else {
                    int k = Integer.parseInt(tmp.split(" ")[1]);

                    List<SearchString> list = new ArrayList<>(hm.values());
                    ans.addAll(list);
                    Comparator<SearchString> compareByName = Comparator
                            .comparing(SearchString::getFreq, Collections.reverseOrder())
                            .thenComparing(SearchString::getStr);

                    Collections.sort(ans, compareByName);

                    for (SearchString obj: ans) {
                        if (k-- == 0)
                            break;
                        System.out.println(obj.getStr());
                    }

                }

            }

        }

    }

}
