package Base;

import GameCharacter.Enemy.Enemy;
import GameCharacter.Player.BulletPlayer;
import GameCharacter.Player.Player;
import physics.BoxCollider;

import java.awt.*;
import java.util.ArrayList;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private ArrayList<GameObject> list = new ArrayList<>();
    private ArrayList<GameObject> tempList = new ArrayList<>();

    private GameObjectManager() {
//        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    //Only run those alive: isAlive in gameobject
    public void runAll() {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

    //For now only consider the case 1 bullet collides 1 enemy
    //Later 1 bullet collides 2 enemies
    //Condition: 1/Is an Enemy   2/BoxCollider   3/checkCollision
    public Enemy checkCollision (BulletPlayer bulletPlayer) {
        return (Enemy) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject ->
                { BoxCollider other = ((Enemy) gameObject).boxCollider;
                return bulletPlayer.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }
}