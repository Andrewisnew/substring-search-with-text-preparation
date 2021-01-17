package entity;

public class Result {
    private final int index;
    private final long time;

    private Result(int index, long time) {
        this.index = index;
        this.time = time;
    }

    public static Result of(int index, long time) {
        return new Result(index, time);
    }

    public int getIndex() {
        return index;
    }

    public long getTime() {
        return time;
    }
}
