package game.player;

import base.Attribute;
import base.GameObject;
import base.Vector2D;
import input.KeyboardInput;
import javafx.scene.paint.RadialGradient;

import java.util.Random;
import java.util.Vector;

public class PlayerMove implements Attribute<Player> {
        private Random random=new Random();
        private Vector2D defaultVelocity = new Vector2D(2f, 0);
    private void backToScreen(Vector2D position) {
        if (position.x > 1024) position.set(0, this.random.nextInt(600));
        if (position.x < 0) position.set(1024, this.random.nextInt(600));
        if (position.y > 600) position.set(this.random.nextInt(1024), 0);
        if (position.y < 0) position.set(this.random.nextInt(1024), 600);
    }

    @Override
    public void run(Player gameObject) {
        Vector2D velocity=this.defaultVelocity.copy();

        if(KeyboardInput.instance.isRight){
            gameObject.angle -= 5.0;
        }
        if(KeyboardInput.instance.isUp){
            velocity=this.defaultVelocity.copy().multiply(2.0f);
        }
        if(KeyboardInput.instance.isDown){

        }
        if(KeyboardInput.instance.isLeft){
            gameObject.angle += 5.0;
        }
        gameObject.velocity.set(
                velocity.rotate(gameObject.angle)
        );
        gameObject.position.addUp(gameObject.velocity);
        this.backToScreen(gameObject.position);
    }
}
