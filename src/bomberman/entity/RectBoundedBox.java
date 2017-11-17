package bomberman.entity;

import javafx.geometry.Rectangle2D;

public class RectBoundedBox {

    int x;
    int y;
    int width;
    int height;
    
    public void RectBoundedBox(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        this.width=w;
        this.height=h;
    }
    
    public Rectangle2D getBoundary() {
        return new Rectangle2D(x, y, width, height);
    }

    public boolean checkCollision(RectBoundedBox b) {
        return b.getBoundary().intersects(getBoundary());
    }
}
