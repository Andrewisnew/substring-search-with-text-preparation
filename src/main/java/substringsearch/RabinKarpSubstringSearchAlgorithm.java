package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.util.Random;

public class RabinKarpSubstringSearchAlgorithm extends AbstractSubstringSearchAlgorithm {
    private int m;
    private long q;
    private static final int R = 256;

    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + key.charAt(j)) % q;
        return h;
    }

    private boolean check(String txt, String pattern, int i) {
        for (int j = 0; j < m; j++)
            if (pattern.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

    @Override
    protected Result searchImpl(@Nonnull String pattern) {
        m = pattern.length();
        q = longRandomPrime();

        long RM = 1;
        for (int i = 1; i <= m - 1; i++)
            RM = (R * RM) % q;
        long patHash = hash(pattern, m);
        long start = System.currentTimeMillis();
        int n = text.length();
        if (n < m) return Result.of(-1, System.currentTimeMillis() - start);
        long txtHash = hash(text, m);
        if ((patHash == txtHash) && check(text, pattern, 0))
            return Result.of(0, System.currentTimeMillis() - start);
        for (int i = m; i < n; i++) {
            txtHash = (txtHash + q - RM * text.charAt(i - m) % q) % q;
            txtHash = (txtHash * R + text.charAt(i)) % q;
            int offset = i - m + 1;
            if ((patHash == txtHash) && check(text, pattern, offset))
                return Result.of(offset, System.currentTimeMillis() - start);
        }
        return Result.of(-1, System.currentTimeMillis() - start);
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
