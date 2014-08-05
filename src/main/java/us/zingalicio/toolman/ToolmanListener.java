package us.zingalicio.toolman;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ToolmanListener
  implements Listener
{
  Toolman plugin;

  public ToolmanListener(Toolman plugin)
  {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();

    if ((event.hasItem()) && (event.getItem().hasItemMeta()) && 
      (event.getItem().getType() == Material.EMERALD) && (event.getItem().getItemMeta().hasLore() && event.getItem().getItemMeta().getLore().get(0).equalsIgnoreCase(ChatColor.GOLD + "Bona fide!")))
    {
      if (event.getClickedBlock() == null)
      {
        if (this.plugin.delayFinished(player))
        {
          this.plugin.getToolManager().onRangedUse(player, event.getItem(), event.getAction());
          this.plugin.startDelay(player);
        }
        event.setCancelled(true);
      }
      else if (this.plugin.getToolManager().onCloseUse(event.getClickedBlock(), event.getBlockFace(), 
        player, event.getItem(), event.getAction()))
      {
        this.plugin.startDelay(player);
        event.setCancelled(true);
      }
    }

    if ((event.getClickedBlock() == null) || (event.getClickedBlock().getType() != Material.DRAGON_EGG))
      return;
    event.setCancelled(true);
  }
}