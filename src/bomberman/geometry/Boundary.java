package bomberman.geometry;
import javafx.geometry.Point2D;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;

public class Boundary extends Rectangle2D {
    public Boundary() {
        super(0,0,0,0);
    }

    public Boundary(double minX, double minY, double width, double height) {
        super(minX, minY, width, height);
    }

    public Boundary copy() {
        return new Boundary(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public Point2D getCenter() {
        return new Point2D(getMinX() + getWidth() / 2, getMinY() + getHeight() / 2);
    }

    public double getCenterX() {
        return getMinX() + getWidth() / 2;
    }

    public double getCenterY() {
        return getMinY() + getHeight() / 2;
    }

    // MAYBE getMinMax
    public Point2D[] getCorners() {
        return new Point2D[] {
            new Point2D(getMinX(), getMinY()),
            new Point2D(getMaxX(), getMinY()),
            new Point2D(getMinX(), getMaxY()),
            new Point2D(getMaxX(), getMaxY())
        };
    }

    public Point2D getMin() {
        return new Point2D(getMinX(), getMinY());
    }

    public Dimension2D getSize() {
        return new Dimension2D(getWidth(), getHeight());
    }

    public Boundary inflate(double x, double y) {
        double mx = getMinX();
        double my = getMinY();
        double width = getWidth();
        double height = getHeight();

        if(x != 0) {
            mx -= (x - (x % 2)) / 2;
            width += x;
        }

        if(y != 0) {
            my -= (y - (y % 2)) / 2;
            height += y;
        }

        return new Boundary(mx, my, width, height);
    }

    public Boundary setCenter(double centerX, double centerY) {
        return setMin(centerX - getWidth() / 2, centerY - getHeight() / 2);
    }

    public Boundary setCenter(Point2D point) {
        return setMin(point.getX() - getWidth() / 2, point.getY() - getHeight() / 2);
    }

    public Boundary setCenterX(double centerX) {
        return setMin(centerX - getWidth() / 2, getMinY());
    }

    public Boundary setCenterY(double centerY) {
        return setMin(getMinX(), centerY - getHeight() / 2);
    }

    public Boundary setMin(double minX, double minY) {
        return new Boundary(minX, minY, getWidth(), getHeight());
    }

    public Boundary setMin(Point2D point) {
        return new Boundary(point.getX(), point.getY(), getWidth(), getHeight());
    }

    public Boundary setMinX(double minX) {
        return new Boundary(minX, getMinY(), getWidth(), getHeight());
    }

    public Boundary setMinY(double minY) {
        return new Boundary(getMinX(), minY, getWidth(), getHeight());
    }

    public Boundary setMax(double maxX, double maxY) {
        return new Boundary(maxX - getWidth(), maxY - getHeight(), getWidth(), getHeight());
    }

    public Boundary setMax(Point2D point) {
        return new Boundary(point.getX() - getWidth(), point.getY() - getHeight(), getWidth(), getHeight());
    }

    public Boundary setMaxX(double maxX) {
        return new Boundary(maxX - getWidth(), getMinY(), getWidth(), getHeight());
    }

    public Boundary setMaxY(double maxY) {
        return new Boundary(getMinX(), maxY - getHeight(), getWidth(), getHeight());
    }

    public Boundary setSize(double width, double height) {
        return new Boundary(getMinX(), getMinY(), width, height);
    }

    public Boundary setSize(Dimension2D point) {
        return new Boundary(getMinX(), getMinY(), point.getWidth(), point.getHeight());
    }

    public Boundary translate(double x, double y) {
        return setMin(getMinX() + x, getMinY() + y);
    }

    public Boundary translate(Point2D p) {
        return setMin(getMinX() + p.getX(), getMinY() + p.getY());
    }

    public Boundary translateX(double x) {
        return setMinX(getMinX() + x);
    }

    public Boundary translateY(double y) {
        return setMinY(getMinY() + y);
    }
}
