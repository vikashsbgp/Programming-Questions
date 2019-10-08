package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ManageForeignExchange {

    public static HashMap<Long, Long> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        ManageForeignExchange mfe = new ManageForeignExchange();
        System.out.print(mfe.getMaximumExchangeMoney(N));
    }

    public long getMaximumExchangeMoney(long N) {

        if (N <= 11)
            return N;
        else {

            if (hashMap.containsKey(N))
                return hashMap.get(N);
            else {
                Long tmp = getMaximumExchangeMoney(N / 2) + getMaximumExchangeMoney(N / 3) + getMaximumExchangeMoney(N / 4);
                hashMap.put(N, tmp);
                return hashMap.get(N);
            }

        }

    }

}
