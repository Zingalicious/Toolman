package us.zingalicio.toolman;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class ToolManager
{
  Toolman plugin;
  String RANGED = "toolman.ranged.";
  String CLOSE = "toolman.close.";

  ArrayList<Tool> registeredTools = new ArrayList<Tool>();

  public ToolManager(Toolman plugin)
  {
    this.plugin = plugin;
  }

  public void registerTool(Tool t)
  {
    this.registeredTools.add(t);
  }

  public void onRangedUse(Player player, ItemStack item, Action action)
  {
    String displayName = item.getItemMeta().getDisplayName();

    if (!(player.hasPermission(this.RANGED + displayName.toLowerCase())))
      return;
    for (Tool t : this.registeredTools)
    {
      if (!(t.getName().equals(displayName)))
        continue;
      t.onRangedUse(player, item, action);
    }
  }

  public boolean onCloseUse(Block clickedBlock, BlockFace blockFace, Player player, ItemStack item, Action action)
  {
    String displayName = item.getItemMeta().getDisplayName();

    if (player.hasPermission(this.CLOSE + displayName.toLowerCase()))
    {
      for (Tool t : this.registeredTools)
      {
        if (!(t.getName().equals(displayName)))
          continue;
        t.onCloseUse(clickedBlock, blockFace, player, item, action);
        return true;
      }
    }

    return false;
  }

  public int getRange()
  {
    return ((Bukkit.getViewDistance() + 1) * 16);
  }
}