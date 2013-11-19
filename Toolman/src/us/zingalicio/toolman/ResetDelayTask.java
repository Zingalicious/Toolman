package us.zingalicio.toolman;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ResetDelayTask extends BukkitRunnable
{
  private final Toolman plugin;
  private final Player player;

  public ResetDelayTask(Toolman plugin, Player player)
  {
    this.plugin = plugin;
    this.player = player;
  }

  public void run()
  {
    this.plugin.endDelay(this.player);
  }
}