package bomberman.entity.boundedbox;

import bomberman.constants.GlobalConstants;
import javafx.geometry.Rectangle2D;

public class RectBoundedBox {

    int x;
    int y;
    int width;
    int height;
    Rectangle2D boundary;

    public RectBoundedBox(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        width=w;
        height=h;
        boundary = new Rectangle2D(x, y, width, height);
    }

    public Rectangle2D getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle2D boundaryRect){
        boundary = boundaryRect;
    }

    public boolean checkCollision(RectBoundedBox b) {
        return b.getBoundary().intersects(getBoundary());
    }

    public void setPosition(int x, int y, double reductionPercent) {
    	this.x = x+(int)(GlobalConstants.PLAYER_WIDTH*reductionPercent);
    	this.y = y+(int)(GlobalConstants.PLAYER_HEIGHT*reductionPercent);
    	boundary = new Rectangle2D(this.x, this.y, width, height);
    }

}
