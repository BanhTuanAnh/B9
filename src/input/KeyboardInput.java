package input;

import base.Vector2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput  implements KeyListener {
    public static KeyboardInput instance=new KeyboardInput();
    public boolean isLeft;
    public boolean isRight;
    public boolean isDown;
    public boolean isUp;
    private KeyboardInput(){

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN) isDown=true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) isLeft=true;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) isRight=true;
        if(e.getKeyCode()==KeyEvent.VK_UP) isUp=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN) isDown=false;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) isLeft=false;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) isRight=false;
        if(e.getKeyCode()==KeyEvent.VK_UP) isUp=false;
    }

}

