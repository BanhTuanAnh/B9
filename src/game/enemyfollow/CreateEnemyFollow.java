package game.enemyfollow;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;

import java.util.Random;

public class CreateEnemyFollow extends GameObject {
    private Random random;
    private FrameCounter frameCounter;
    public CreateEnemyFollow(){
        random=new Random();
        frameCounter=new FrameCounter(100);
    }
    public void run(){
        super.run();
        if (this.frameCounter.run()) {
            EnemyFollow enemyFollow = new EnemyFollow();
            enemyFollow.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            enemyFollow.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
            GameObjectManager.instance.add(enemyFollow);
            this.frameCounter.reset();
        }

    }
}
