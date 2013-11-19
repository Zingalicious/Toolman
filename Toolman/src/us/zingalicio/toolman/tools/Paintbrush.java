package us.zingalicio.toolman.tools;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import us.zingalicio.toolman.AbstractTool;
import us.zingalicio.toolman.Toolman;
import us.zingalicio.toolman.util.SoundUtil;

public class Paintbrush extends AbstractTool
{
  Toolman plugin;
  SoundUtil soundUtil;

  public Paintbrush(Toolman plugin)
  {
    this.plugin = plugin;
    this.toolName = "Paintbrush";
    this.soundUtil = plugin.soundUtil;
  }

  @SuppressWarnings("deprecation")
public void onRangedUse(Player player, ItemStack item, Action action)
  {
    Block targetBlock = player.getTargetBlock(null, this.plugin.getToolManager().getRange());

    if ((action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK))
    {
      List<String> newLore = new ArrayList<String>();

      String fullName = getName(targetBlock);

      newLore.add(fullName);
      newLore.add(targetBlock.getTypeId() + ":" + targetBlock.getData());

      if (item.getItemMeta().hasLore())
      {
        List<?> lore = item.getItemMeta().getLore();

        if (lore.equals(newLore))
        {
          player.sendMessage(ChatColor.GOLD + "[Toolman] Paint was already " + ChatColor.YELLOW + fullName);
        }
        else
        {
          ItemMeta itemMeta = item.getItemMeta();
          itemMeta.setLore(newLore);

          player.getWorld().playSound(player.getLocation(), Sound.LAVA_POP, 0.1F, 0.031F);
          item.setItemMeta(itemMeta);
          player.sendMessage(ChatColor.GOLD + "[Toolman] Paint is now " + ChatColor.YELLOW + fullName);
        }
      }
      else
      {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(newLore);

        item.setItemMeta(itemMeta);
        player.sendMessage(ChatColor.GOLD + "[Toolman] Paint is now " + ChatColor.YELLOW + fullName);
      }

    }
    else if (item.getItemMeta().hasLore())
    {
      if (player.isSneaking())
      {
        List<?> lore = item.getItemMeta().getLore();
        String fullData = (String)lore.get(1);
        String[] splitData = fullData.split(":");

        List<String> rawData = new ArrayList<String>();

        for (String s : splitData)
        {
          rawData.add(s);
        }

        int id = Integer.parseInt((String)rawData.get(0));
        byte data = Byte.parseByte((String)rawData.get(1));

        int oldMat = targetBlock.getTypeId();
        Byte oldData = Byte.valueOf(targetBlock.getData());

        if ((id != oldMat) || (data != oldData.byteValue()))
        {
          changeBlock(Boolean.valueOf(false), targetBlock, id, data, player, item, this.soundUtil);
        }
      }
    }
  }

  @SuppressWarnings("deprecation")
public void onCloseUse(Block block, BlockFace blockFace, Player player, ItemStack item, Action action)
  {
    if ((action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK))
    {
      List<String> newLore = new ArrayList<String>();

      String fullName = getName(block);

      newLore.add(fullName);
      newLore.add(block.getTypeId() + ":" + block.getData());

      if (item.getItemMeta().hasLore())
      {
        List<?> lore = item.getItemMeta().getLore();

        if (lore.equals(newLore))
        {
          player.sendMessage(ChatColor.GOLD + "[Toolman] Paint was already " + ChatColor.YELLOW + fullName);
        }
        else
        {
          ItemMeta itemMeta = item.getItemMeta();
          itemMeta.setLore(newLore);

          player.getWorld().playSound(player.getLocation(), Sound.LAVA_POP, 0.1F, 0.031F);
          item.setItemMeta(itemMeta);
          player.sendMessage(ChatColor.GOLD + "[Toolman] Paint is now " + ChatColor.YELLOW + fullName);
        }
      }
      else
      {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(newLore);

        item.setItemMeta(itemMeta);
        player.sendMessage(ChatColor.GOLD + "[Toolman] Paint is now " + ChatColor.YELLOW + fullName);
      }

    }
    else if (item.getItemMeta().hasLore())
    {
      List<?> lore = item.getItemMeta().getLore();
      String fullData = (String)lore.get(1);
      String[] splitData = fullData.split(":");

      List<String> rawData = new ArrayList<String>();

      for (String s : splitData)
      {
        rawData.add(s);
      }

      int id = Integer.parseInt((String)rawData.get(0));
      byte data = Byte.parseByte((String)rawData.get(1));

      if ((block.getTypeId() != id) || (block.getData() != data))
      {
        changeBlock(Boolean.valueOf(false), block, id, data, player, item, this.soundUtil);
      }
    }
  }

  @SuppressWarnings("deprecation")
private String getName(Block block)
  {
    if (this.plugin.getConfig().contains("names." + block.getTypeId() + "." + block.getData()))
    {
      String name = this.plugin.getConfig().getString("names." + block.getTypeId() + "." + block.getData());
      return name;
    }

    String[] fullNameSplit = block.getState().getData().toString().split("[(]");
    List<String> fullNameList = new ArrayList<String>();

    for (String s : fullNameSplit)
    {
      fullNameList.add(s);
    }

    String fullName = (String)fullNameList.get(0);
    String[] splitName = fullName.split("_| ");

    String name = "";

    for (String s : splitName)
    {
      name = name + s.replace(s.substring(1), s.substring(1).toLowerCase());
      name = name + " ";
    }
    name.trim();
    return name;
  }
}