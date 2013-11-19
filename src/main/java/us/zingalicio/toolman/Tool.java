package us.zingalicio.toolman;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public abstract interface Tool
{
  public abstract String getName();

  public abstract void onRangedUse(Player paramPlayer, ItemStack paramItemStack, Action paramAction);

  public abstract void onCloseUse(Block paramBlock, BlockFace paramBlockFace, Player paramPlayer, ItemStack paramItemStack, Action paramAction);
}