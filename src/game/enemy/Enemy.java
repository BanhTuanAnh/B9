package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject {

    public Vector2D velocity;

    public BoxCollider boxCollider;

    public EnemyShoot enemyShoot;

    public Enemy() {
        this.renderer = new ImageRenderer("resources-rocket-master/resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        this.boxCollider=new BoxCollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        ((EnemyAttack) this.enemyShoot)
                .bulletEnemies
                .forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
}
