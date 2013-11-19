package us.zingalicio.toolman.util;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SquareMaker
{
  public ArrayList<Block> getSquare(Block block, int radius)
  {
    ArrayList<Block> blocksInSquare = new ArrayList<Block>();

    double centreX = block.getX();
    double centreY = block.getY();
    double centreZ = block.getZ();

    World world = block.getWorld();

    for (double iX = -radius; iX < 1.0D; iX += 1.0D)
    {
      for (double iZ = -radius; iZ < 1.0D; iZ += 1.0D)
      {
        Location blockLoc0 = new Location(world, centreX - iX, centreY, centreZ - iZ);
        Location blockLoc1 = new Location(world, centreX + iX, centreY, centreZ - iZ);
        Location blockLoc2 = new Location(world, centreX - iX, centreY, centreZ + iZ);
        Location blockLoc3 = new Location(world, centreX + iX, centreY, centreZ + iZ);

        blocksInSquare.add(blockLoc0.getBlock());
        blocksInSquare.add(blockLoc1.getBlock());
        blocksInSquare.add(blockLoc2.getBlock());
        blocksInSquare.add(blockLoc3.getBlock());
      }
    }
    return blocksInSquare;
  }
}