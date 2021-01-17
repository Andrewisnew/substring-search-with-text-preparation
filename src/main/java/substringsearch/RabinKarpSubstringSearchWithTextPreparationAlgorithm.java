package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.util.Random;

public class RabinKarpSubstringSearchWithTextPreparationAlgorithm extends AbstractSubstringSearchWithTextPreparationAlgorithm {
    private int m;
    private long q;
    private static final int R = 256;

    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + key.charAt(j)) % q;
        return h;
    }

    private long hash(String key, int m, int i) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + key.charAt(i + j)) % q;
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
        int[] possibleResults = getPossibleResults(pattern.charAt(0));
        long patHash = hash(pattern, m);
        long start = System.currentTimeMillis();
        int n = text.length();
        if (n < m) return Result.of(-1, System.currentTimeMillis() - start);

        for (int k = 0, i; k < possibleResults.length; k++) {
            i = possibleResults[k];
            long txtHash = hash(text, m, i);
            if ((patHash == txtHash) && check(text, pattern, i))
                return Result.of(i, System.currentTimeMillis() - start);
        }
        return Result.of(-1, System.currentTimeMillis() - start);
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
