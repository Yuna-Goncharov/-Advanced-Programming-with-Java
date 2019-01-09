import java.util.HashSet;
import java.util.Set;

public class Data {
    private Set<Line> lines;
    private int latestX;
    private int latestY;

    public Data() {
        this.lines = new HashSet<>();
        this.latestX = 0;
        this.latestY = 0;
    }

    public void addPoint(int x, int y) {
        Line l;
        if (lines.isEmpty()) {
            l = new Line(x, y, x, y);
        } else {
            l = new Line(latestX, latestY, x, y);
            latestX = x;
            latestY = y;
        }

        lines.add(l);
    }

    public Set<Line> getLines() {
        return lines;
    }
}
