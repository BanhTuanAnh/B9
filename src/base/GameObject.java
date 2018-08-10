package base;

import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import game.player.BulletPlayer;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {

    public Vector2D position;

    public Renderer renderer;

    public boolean isAlive=true;

    public List<Attribute> attributes;

    public GameObject() {
        attributes=new ArrayList<>();
        this.position = new Vector2D();
    }
    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
    }

    public void render(Graphics graphics) {
        if (this.renderer != null)
            this.renderer.render(graphics, this.position);
    }

}
