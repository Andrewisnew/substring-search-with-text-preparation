package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;

public class BrutForceSubstringSearchAlgorithm extends AbstractSubstringSearchAlgorithm {
    @Override
    protected Result searchImpl(@Nonnull String pattern) {
        final long start = System.currentTimeMillis();
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return Result.of(i, System.currentTimeMillis() - start);
            }
        }
        return Result.of(-1, System.currentTimeMillis() - start);
    }
}
