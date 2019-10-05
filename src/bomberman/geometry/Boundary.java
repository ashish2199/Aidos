package bomberman.geometry;
import javafx.geometry.Point2D;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;

public class Boundary {
    private double minX;
    private double minY;
    private double width;
    private double height;

    public Boundary() {
        minX = 0;
        minY = 0;
        width = 0;
        height = 0;
    }

    public Boundary(double minX, double minY, double width, double height) {
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
    }

    public Boundary(Rectangle2D r) {
        minX = r.getMinX();
        minY = r.getMinY();
        width = r.getWidth();
        height = r.getHeight();
    }

    public boolean contains(double x, double y) {
        return getRectangle2D().contains(x, y);
    }

    public boolean contains(Point2D point) {
        return getRectangle2D().contains(point);
    }

    public boolean contains(double x, double y, double w, double h) {
        return getRectangle2D().contains(x, y, w, h);
    }

    public boolean contains(Boundary r) {
        return getRectangle2D().contains(r.getRectangle2D());
    }

    public boolean contains(Rectangle2D r) {
        return getRectangle2D().contains(r);
    }

    public Boundary copy() {
        return new Boundary(minX, minY, width, height);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public Point2D getCenter() {
        return new Point2D(minX + width / 2, minY + height / 2);
    }

    public double getCenterX() {
        return minX + width / 2;
    }

    public double getCenterY() {
        return minY + height / 2;
    }

    // MAYBE getMinMax
    public Point2D[] getCorners() {
        return new Point2D[] {
            new Point2D(minX,           minY),
            new Point2D(minX + width,   minY),
            new Point2D(minX,           minY + height),
            new Point2D(minX + width,   minY + height)
        };
    }

    public double getHeight() {
        return height;
    }

    public Point2D getMin() {
        return new Point2D(minX, minY);
    }

    public Boundary getMin(double x, double y) {
        return new Boundary(x, y, width, height);
    }

    public double getWidth() {
        return width;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxX() {
        return minX + width;
    }

    public double getMaxY() {
        return minY + height;
    }

    public Rectangle2D getRectangle2D() {
        return new Rectangle2D(minX, minY, width, height);
    }

    public Dimension2D getSize() {
        return new Dimension2D(width, height);
    }

    public int hashCode() {
        return getRectangle2D().hashCode();
    }

    public boolean intersects(double x, double y, double w, double h) {
        return getRectangle2D().intersects(x, y, w, h);
    }

    public boolean intersects(Boundary r) {
        return getRectangle2D().intersects(r.getRectangle2D());
    }

    public boolean intersects(Rectangle2D r) {
        return getRectangle2D().intersects(r);
    }

    public Boundary inflate(double x, double y) {
        Boundary boundary = copy();
        if(x != 0) {
            boundary.minX -= (x - (x % 2)) / 2;
            boundary.width += x;
        }

        if(y != 0) {
            boundary.minY -= (y - (y % 2)) / 2;
            boundary.height += y;
        }

        return boundary;
    }

    public Boundary move(double x, double y) {
        return new Boundary(minX + x, minY + y, width, height);
    }

    public void setCenter(double centerX, double centerY) {
        minX = centerX - width / 2;
        minY = centerY - height / 2;
    }

    public void setCenter(Point2D point) {
        minX = point.getX() - width / 2;
        minY = point.getY() - height / 2;
    }

    public void setCenterX(double centerX) {
        minX = centerX - width / 2;
    }

    public void setCenterY(double centerY) {
        minY = centerY - height / 2;
    }

    public void setMin(double minX, double minY) {
        this.minX = minX;
        this.minY = minY;
    }

    public void setMin(Point2D point) {
        minX = point.getX();
        minY = point.getY();
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public void setMax(double maxX, double maxY) {
        minX = maxX - width;
        minY = maxY - height;
    }

    public void setMax(Point2D point) {
        minX = point.getX() - width;
        minY = point.getY() - height;
    }

    public void setMaxX(double maxX) {
        minX = maxX - width;
    }

    public void setMaxY(double maxY) {
        minX = maxY - height;
    }

    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(Dimension2D point) {
        width = point.getWidth();
        height = point.getHeight();
    }

    public void translate(double x, double y) {
        minX += x;
        minY += y;
    }

    public void translate(Point2D point) {
        minX += point.getX();
        minY += point.getY();
    }

    public void translateX(double x) {
        minX += x;
    }

    public void translateY(double y) {
        minY += y;
    }

    public String toString() {
        return "Boundary(" + minX + ", " + minY + ", " + width + ", " + height + ")";
    }
}
