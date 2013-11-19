package us.zingalicio.toolman.tools;

import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import us.zingalicio.toolman.AbstractTool;
import us.zingalicio.toolman.Toolman;
import us.zingalicio.toolman.util.SoundUtil;

public class Wrench extends AbstractTool
{
  Toolman plugin;
  SoundUtil soundUtil;

  public Wrench(Toolman plugin)
  {
    this.plugin = plugin;
    this.toolName = "Wrench";
    this.soundUtil = plugin.soundUtil;
  }

  @SuppressWarnings("deprecation")
public void onRangedUse(Player player, ItemStack item, Action action)
  {
    if (player.isSneaking())
    {
      Block targetBlock = player.getTargetBlock(null, this.plugin.getToolManager().getRange());
      if (targetBlock.getType() != Material.AIR)
      {
        FileConfiguration config = this.plugin.getConfig();

        if (config.contains("values." + targetBlock.getTypeId()))
        {
          String values = config.getString("values." + targetBlock.getTypeId());

          String[] stringValueList = values.split(",");
          ArrayList<Byte> valueList = new ArrayList<Byte>();

          byte targetData = targetBlock.getData();

          for (String s : stringValueList)
          {
            valueList.add(Byte.valueOf(Byte.parseByte(s)));
          }

          int valueLength = valueList.size();

          if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK))
          {
            if (valueList.contains(Byte.valueOf(targetData)))
            {
              if (targetData != ((Byte)valueList.get(0)).byteValue())
              {
                int currentValue = 0;
                for (Iterator<Byte> i = valueList.iterator(); i.hasNext(); ) 
                { 
                  byte b = i.next().byteValue();

                  if (b == targetData)
                  {
                    changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(currentValue - 1)).byteValue(), player, item, this.soundUtil);
                    return;
                  }
                  currentValue++;
                }
              }
              else
              {
                changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(valueLength - 1)).byteValue(), player, item, this.soundUtil);
              }

            }
            else
            {
              changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, this.soundUtil);
            }

          }
          else if (valueList.contains(Byte.valueOf(targetData)))
          {
            if (targetData != ((Byte)valueList.get(valueLength - 1)).byteValue())
            {
              int currentValue = 0;
              for (Iterator<Byte> i = valueList.iterator(); i.hasNext(); ) { byte b = i.next().byteValue();

                if (b == targetData)
                {
                  changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(currentValue + 1)).byteValue(), player, item, this.soundUtil);
                  return;
                }
                currentValue++;
              }
            }
            else
            {
              changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, this.soundUtil);
            }

          }
          else
          {
            changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, this.soundUtil);
            return;
          }
        }

        return;
      }
      player.sendMessage(ChatColor.GOLD + "[Toolman] Block out of range.");
      return;
    }
  }

  @SuppressWarnings("deprecation")
public void onCloseUse(Block block, BlockFace blockFace, Player player, ItemStack item, Action action)
  {
    byte targetData = block.getData();

    FileConfiguration config = this.plugin.getConfig();

    if (player.isSneaking())
    {
      if ((action == Action.RIGHT_CLICK_BLOCK) || (action == Action.RIGHT_CLICK_AIR))
      {
        if (block.getData() != 0)
        {
          changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)(targetData - 1), player, item, this.soundUtil);
          return;
        }

        changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)15, player, item, this.soundUtil);
        return;
      }

      if (block.getData() != 15)
      {
        changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)(targetData + 1), player, item, this.soundUtil);
        return;
      }

      changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)0, player, item, this.soundUtil);
      return;
    }

    if (config.contains("values." + block.getTypeId()))
    {
      String values = config.getString("values." + block.getTypeId());

      String[] stringValueList = values.split(",");
      ArrayList<Byte> valueList = new ArrayList<>();

      for (String s : stringValueList)
      {
        valueList.add(Byte.valueOf(Byte.parseByte(s)));
      }

      int valueLength = valueList.size();

      if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK))
      {
        if (valueList.contains(Byte.valueOf(targetData)))
        {
          if (targetData != ((Byte)valueList.get(0)).byteValue())
          {
            int currentValue = 0;
            for (Iterator<Byte> i = valueList.iterator(); i.hasNext(); ) 
            { 
              byte b = i.next().byteValue();

              if (b == targetData)
              {
                changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(currentValue - 1)).byteValue(), player, item, this.soundUtil);
                return;
              }
              currentValue++;
            }
          }
          else
          {
            changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)(valueLength - 1), player, item, this.soundUtil);
          }

        }
        else
        {
          changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, this.soundUtil);
        }

      }
      else if (valueList.contains(Byte.valueOf(targetData)))
      {
        if (targetData != ((Byte)valueList.get(valueLength - 1)).byteValue())
        {
          int currentValue = 0;
          for (Iterator<Byte> i = valueList.iterator(); i.hasNext(); ) { byte b = i.next().byteValue();

            if (b == targetData)
            {
              changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(currentValue + 1)).byteValue(), player, item, this.soundUtil);
              return;
            }
            currentValue++;
          }
        }
        else
        {
          changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, this.soundUtil);
        }

      }
      else
      {
        changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, this.soundUtil);
        return;
      }
    }
  }
}