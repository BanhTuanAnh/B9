package base;

import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class GameObjectManager {//chi can 1 vaf goij bat ky dau
    private List<GameObject>list;
    private List<GameObject>tempList;
    private Player player;
    static public GameObjectManager instance = new GameObjectManager();//design patern single tern
    private GameObjectManager() {
        tempList=new ArrayList<>();
        this.list = new ArrayList<>();
    }
    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }
    public void runAll(){
        this.list.forEach(gameObject ->gameObject.run());
        this.list.addAll(tempList);
        tempList.clear();
    }
//    public Vector2D playerPosition(){
////        for (int i = 0; i <list.size() ; i++) {
////            if(list.get(i).getClass()==Player.class){
////                return list.get(i).position;
////            }
////        }
////        return null;
////        ---------------------------
//
////        for(GameObject gameObject:this.list){
////            if(gameObject instanceof Player)
////                return (Player) gameObject;
////        }
////         ---------------------------
////        return (Player) this.list
////                .stream()
////                .filter(gameObject -> gameObject instanceof Player)
////                .findFirst()
////                .orElse(null);
//
//
//        if(this.player!=null) return player.position;
//            player =(Player) this.list
//                    .stream()
//                    .filter(gameObject -> gameObject instanceof Player)
//                    .findFirst()
//                    .orElse(null);
//            return player.position;
//    }
    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }
    public void renderAll(Graphics graphics){
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }
    public EnemyFollow checkCollisionEnemyFollow(BulletPlayer bulletPlayer){
        return (EnemyFollow)this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof EnemyFollow)
                .filter(gameObject -> {
                    BoxCollider orther = ( (EnemyFollow) gameObject).boxCollider;
                    return  bulletPlayer.boxCollider.checkCollision(orther);
                })
                .findFirst()
                .orElse(null);


    }
    public Enemy checkCollisionEnemy(BulletPlayer bulletPlayer){
        return (Enemy)this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider orther = ( (Enemy) gameObject).boxCollider;
                    return  bulletPlayer.boxCollider.checkCollision(orther);
                })
                .findFirst()
                .orElse(null);


    }
    public Player checkCollisionPlayer(BulletEnemy bulletEnemy){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider orther = ( (Player) gameObject).boxCollider;
                    return  bulletEnemy.boxCollider.checkCollision(orther);
                })
                .findFirst()
                .orElse(null);


    }
    public Player checkCollisionPlayer(EnemyFollow enemyFollow){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider orther = ( (Player) gameObject).boxCollider;
                    return  enemyFollow.boxCollider.checkCollision(orther);
                })
                .findFirst()
                .orElse(null);


    }

}

