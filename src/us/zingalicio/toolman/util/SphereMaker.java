package us.zingalicio.toolman.util;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SphereMaker
{
  public ArrayList<Block> getSphere(Block block, int radius)
  {
    ArrayList<Block> blocksInSphere = new ArrayList<Block>();

    double centreX = block.getX();
    double centreY = block.getY();
    double centreZ = block.getZ();

    World world = block.getWorld();

    double adjRadius = radius + 0.5D;

    for (double iX = -radius; iX < 1.0D; iX += 1.0D)
    {
      for (double iY = -radius; iY < 1.0D; iY += 1.0D)
      {
        for (double iZ = -radius; iZ < 1.0D; iZ += 1.0D)
        {
          if (Math.pow(iX, 2.0D) + Math.pow(iY, 2.0D) + Math.pow(iZ, 2.0D) <= Math.pow(adjRadius, 2.0D))
          {
            Location blockLoc0 = new Location(world, centreX - iX, centreY - iY, centreZ - iZ);
            Location blockLoc1 = new Location(world, centreX + iX, centreY - iY, centreZ - iZ);
            Location blockLoc2 = new Location(world, centreX - iX, centreY + iY, centreZ - iZ);
            Location blockLoc3 = new Location(world, centreX + iX, centreY + iY, centreZ - iZ);
            Location blockLoc4 = new Location(world, centreX - iX, centreY - iY, centreZ + iZ);
            Location blockLoc5 = new Location(world, centreX + iX, centreY - iY, centreZ + iZ);
            Location blockLoc6 = new Location(world, centreX - iX, centreY + iY, centreZ + iZ);
            Location blockLoc7 = new Location(world, centreX + iX, centreY + iY, centreZ + iZ);

            blocksInSphere.add(blockLoc0.getBlock());
            blocksInSphere.add(blockLoc1.getBlock());
            blocksInSphere.add(blockLoc2.getBlock());
            blocksInSphere.add(blockLoc3.getBlock());
            blocksInSphere.add(blockLoc4.getBlock());
            blocksInSphere.add(blockLoc5.getBlock());
            blocksInSphere.add(blockLoc6.getBlock());
            blocksInSphere.add(blockLoc7.getBlock());
          }
        }
      }
    }
    return blocksInSphere;
  }
}