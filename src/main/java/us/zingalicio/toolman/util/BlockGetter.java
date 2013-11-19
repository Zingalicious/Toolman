package us.zingalicio.toolman.util;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class BlockGetter
{
  @SuppressWarnings("deprecation")
  public BlockFace getBlockFace(Block block, Player player)
  {
    BlockFace blockFace = null;

    ArrayList<Block> adjacentBlocks = new ArrayList<Block>();
    adjacentBlocks.add(block.getRelative(BlockFace.UP));
    adjacentBlocks.add(block.getRelative(BlockFace.DOWN));
    adjacentBlocks.add(block.getRelative(BlockFace.NORTH));
    adjacentBlocks.add(block.getRelative(BlockFace.SOUTH));
    adjacentBlocks.add(block.getRelative(BlockFace.EAST));
    adjacentBlocks.add(block.getRelative(BlockFace.WEST));

    for (Block b : adjacentBlocks)
    {
      if ((b == null) || (!(player.getLineOfSight(null, (Bukkit.getViewDistance() + 1) * 16).contains(b))))
        continue;
      blockFace = block.getFace(b);
      return blockFace;
    }

    return blockFace;
  }
}