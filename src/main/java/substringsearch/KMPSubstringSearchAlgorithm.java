package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;

public class KMPSubstringSearchAlgorithm extends AbstractSubstringSearchAlgorithm {
    private static final int R = 256;

    @Override
    protected Result searchImpl(@Nonnull String pattern) {
        int[][] dfa;
        int m = pattern.length();

        long start = System.currentTimeMillis();
        dfa = new int[R][m];
        dfa[pattern.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pattern.charAt(j)][j] = j+1;
            x = dfa[pattern.charAt(j)][x];
        }

        int n = text.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if (j == m) return Result.of(i - m, System.currentTimeMillis() - start);
        return Result.of(-1, System.currentTimeMillis() - start);
    }
}

