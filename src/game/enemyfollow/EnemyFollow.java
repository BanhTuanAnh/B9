package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Vector;

public class EnemyFollow extends GameObject {

    public Vector2D velocity;

    public BoxCollider boxCollider;

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/star.png", 20, 20);
        this.boxCollider=new BoxCollider(20,20);
    }
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.update(player.position);
        }

        this.position.addUp(this.velocity);
        player= GameObjectManager.instance.checkCollisionPlayer(this);
        if(player !=null ){
            this.isAlive=false;
            player.isAlive=false;
        }
    }
    public void update(Vector2D position) {
        this.velocity.set(
                position.subtract(this.position).normalized()
            ).multiply(1.5f);
    }
}
