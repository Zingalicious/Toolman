package us.zingalicio.toolman;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import us.zingalicio.handlefish.ZingPlugin;
import us.zingalicio.toolman.util.SoundUtil;

public abstract class AbstractTool
  implements Tool
{
  public String toolName = "Default Tool";

  public String getName()
  {
    return this.toolName;
  }

  public void onRangedUse(Player player, ItemStack item, Action action)
  {
    player.sendMessage("Ranged " + item.getItemMeta().getDisplayName());
  }

  public void onCloseUse(Block targetBlock, BlockFace blockFace, Player player, ItemStack item, Action action)
  {
    player.sendMessage("Close " + item.getItemMeta().getDisplayName());
  }

  @SuppressWarnings("deprecation")
public void updateBlockChange(Block changedBlock)
  {
    int horizon = (Bukkit.getViewDistance() + 1) * 16;
    int horSqr = (int)Math.pow(horizon, 2.0D);
    for (Player player : Bukkit.getOnlinePlayers())
    {
      if ((changedBlock.getLocation().getWorld().equals(player.getWorld())) && 
        (changedBlock.getLocation().distanceSquared(player.getLocation()) < horSqr))
      {
        player.sendBlockChange(changedBlock.getLocation(), changedBlock.getType(), changedBlock.getData());
      }
    }
  }

  @SuppressWarnings("deprecation")
  public void breakBlock(Boolean physics, Block block, Player player, ZingPlugin plugin)
  {
    BlockBreakEvent breakEvent = new BlockBreakEvent(block, player);
    Bukkit.getPluginManager().callEvent(breakEvent);
    block.getWorld().playSound(block.getLocation(), SoundUtil.getSound(block.getType(), plugin), 1.0F, 1.0F);
    block.setTypeId(0, physics.booleanValue());
    if (!physics.booleanValue())
    {
      updateBlockChange(block);
    }
  }

  @SuppressWarnings("deprecation")
  public void changeBlock(Boolean physics, Block block, Material mat, byte data, Player player, ItemStack item, ZingPlugin plugin)
  {
    BlockBreakEvent breakEvent = new BlockBreakEvent(block, player);
    Bukkit.getPluginManager().callEvent(breakEvent);
    block.getWorld().playSound(block.getLocation(), SoundUtil.getSound(block.getType(), plugin), 0.2F, 1.0F);

    block.setTypeId(mat.getId(), physics.booleanValue());
    block.setData(data, physics.booleanValue());

    block.getWorld().playSound(block.getLocation(), SoundUtil.getSound(block.getType(), plugin), 1.0F, 1.0F);

    BlockPlaceEvent placeEvent = new BlockPlaceEvent(block, block.getState(), block, item, player, true);
    Bukkit.getPluginManager().callEvent(placeEvent);

    if (!physics.booleanValue())
    {
      updateBlockChange(block);
    }
  }

  @SuppressWarnings("deprecation")
  public void placeBlock(Boolean physics, Block block, Material mat, byte data, Player player, ItemStack item, ZingPlugin plugin)
  {
    block.setTypeId(mat.getId(), physics.booleanValue());
    block.setData(data, physics.booleanValue());

    block.getWorld().playSound(block.getLocation(), SoundUtil.getSound(block.getType(), plugin), 1.0F, 1.0F);

    BlockPlaceEvent placeEvent = new BlockPlaceEvent(block, block.getState(), block, item, player, true);
    Bukkit.getPluginManager().callEvent(placeEvent);

    if (!physics.booleanValue())
    {
      updateBlockChange(block);
    }
  }
}