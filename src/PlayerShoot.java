import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements PlayerAttack {

    public List<BulletPlayer> bulletPlayers;
    private int countBullet = 0;

    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
    }

    @Override
    public void run(Player player) {

        if( this.countBullet == 50) {

            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
            this.bulletPlayers.add(bulletPlayer);
            this.countBullet = 0;

        } else {
            this.countBullet += 1;
        }

        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }
}
