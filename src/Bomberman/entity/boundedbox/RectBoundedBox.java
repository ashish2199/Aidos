package bomberman.entity.boundedbox;

import javafx.geometry.Rectangle2D;

public class RectBoundedBox {

    int x;
    int y;
    int width;
    int height;
    Rectangle2D boundary;
    
    public void RectBoundedBox(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        this.width=w;
        this.height=h;
        boundary = new Rectangle2D(x, y, width, height);
    }
    
    public Rectangle2D getBoundary() {
        return boundary;
    }

    public boolean checkCollision(RectBoundedBox b) {
        return b.getBoundary().intersects(getBoundary());
    }

}
