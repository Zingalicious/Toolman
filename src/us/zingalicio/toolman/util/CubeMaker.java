package us.zingalicio.toolman.util;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class CubeMaker
{
  public ArrayList<Block> getCube(Block block, int radius)
  {
    ArrayList<Block> blocksInCube = new ArrayList<Block>();

    double centreX = block.getX();
    double centreY = block.getY();
    double centreZ = block.getZ();

    World world = block.getWorld();

    for (double iX = -radius; iX < 1.0D; iX += 1.0D)
    {
      for (double iY = -radius; iY < 1.0D; iY += 1.0D)
      {
        for (double iZ = -radius; iZ < 1.0D; iZ += 1.0D)
        {
          Location blockLoc0 = new Location(world, centreX - iX, centreY - iY, centreZ - iZ);
          Location blockLoc1 = new Location(world, centreX + iX, centreY - iY, centreZ - iZ);
          Location blockLoc2 = new Location(world, centreX - iX, centreY + iY, centreZ - iZ);
          Location blockLoc3 = new Location(world, centreX + iX, centreY + iY, centreZ - iZ);
          Location blockLoc4 = new Location(world, centreX - iX, centreY - iY, centreZ + iZ);
          Location blockLoc5 = new Location(world, centreX + iX, centreY - iY, centreZ + iZ);
          Location blockLoc6 = new Location(world, centreX - iX, centreY + iY, centreZ + iZ);
          Location blockLoc7 = new Location(world, centreX + iX, centreY + iY, centreZ + iZ);

          blocksInCube.add(blockLoc0.getBlock());
          blocksInCube.add(blockLoc1.getBlock());
          blocksInCube.add(blockLoc2.getBlock());
          blocksInCube.add(blockLoc3.getBlock());
          blocksInCube.add(blockLoc4.getBlock());
          blocksInCube.add(blockLoc5.getBlock());
          blocksInCube.add(blockLoc6.getBlock());
          blocksInCube.add(blockLoc7.getBlock());
        }
      }
    }

    return blocksInCube;
  }
}