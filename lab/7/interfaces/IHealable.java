package interfaces;
import entity.Player;

@FunctionalInterface
public interface IHealable {
  void heal (Player player, int amount);
}
