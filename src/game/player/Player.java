package game.player;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    public Vector2D velocity;

    public double angle = 0.0;

    public BoxCollider boxCollider;

    public Player() {
        this.velocity = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
        this.boxCollider=new BoxCollider(15,15);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 7, this.position.y - 7);
        ((PolygonRenderer) this.renderer).angle = this.angle;
    }


}
