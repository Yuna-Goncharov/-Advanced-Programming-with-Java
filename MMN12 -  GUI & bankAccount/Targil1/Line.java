public class Line{

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private String distance;

    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        calculateDistance();
    }

    private void calculateDistance() {
        double px = endX - startX;
        double py = endY - startY;
        if (px == 0 && py == 0) {
            this.distance = "";
        } else {
            this.distance = String.valueOf(Math.sqrt(px * px + py * py));
        }
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public String getDistance() {
        return distance;
    }
}
