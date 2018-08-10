package physic;

import base.Vector2D;

import java.awt.*;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;

    public BoxCollider( int width, int height) {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }
    public boolean checkCollision(BoxCollider orther){
        Rectangle r1=new Rectangle(
                (int) this.position.x,
                (int) this.position.y,
                this.width,
                this.height
        );
        Rectangle r2=new Rectangle(
                (int) orther.position.x,
                (int) orther.position.y,
                orther.width,
                orther.height
        );
        return r1.intersects(r2);
    }
}
