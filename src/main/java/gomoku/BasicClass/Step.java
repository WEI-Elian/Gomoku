package gomoku.BasicClass;

import java.io.Serializable;

public class Step implements Serializable {

    private int x;
    private int y;

    private long time;

    public Step(int x, int y, long time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
