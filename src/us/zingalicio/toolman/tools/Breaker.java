package us.zingalicio.toolman.tools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import us.zingalicio.toolman.AbstractTool;
import us.zingalicio.toolman.Toolman;
import us.zingalicio.toolman.util.SoundUtil;

public class Breaker extends AbstractTool
{
  Toolman plugin;
  SoundUtil soundUtil;

  public Breaker(Toolman plugin)
  {
    this.plugin = plugin;
    this.toolName = "Breaker";
    this.soundUtil = plugin.soundUtil;
  }

  @SuppressWarnings("deprecation")
public void onRangedUse(Player player, ItemStack item, Action action)
  {
    Block targetBlock = player.getTargetBlock(null, this.plugin.getToolManager().getRange());

    if (player.isSneaking())
    {
      if (targetBlock.getType() != Material.AIR)
      {
        if ((action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK))
        {
          breakBlock(Boolean.valueOf(true), targetBlock, player, this.soundUtil);
          return;
        }

        breakBlock(Boolean.valueOf(false), targetBlock, player, this.soundUtil);
        return;
      }

      player.sendMessage(ChatColor.GOLD + "[Toolman] Block out of range.");
      return;
    }
  }

  public void onCloseUse(Block clickedBlock, BlockFace blockFace, Player player, ItemStack item, Action action)
  {
    if ((action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK))
    {
      breakBlock(Boolean.valueOf(true), clickedBlock, player, this.soundUtil);
      return;
    }

    breakBlock(Boolean.valueOf(false), clickedBlock, player, this.soundUtil);
  }
}