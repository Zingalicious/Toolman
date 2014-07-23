package us.zingalicio.toolman.tools;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.zingalicio.handlefish.util.NameUtil;
import us.zingalicio.toolman.AbstractTool;
import us.zingalicio.toolman.Toolman;
import us.zingalicio.toolman.util.SoundUtil;

public class Paintbrush extends AbstractTool
{
  Toolman plugin;
  SoundUtil soundUtil;
  YamlConfiguration materials;

  public Paintbrush(Toolman plugin)
  {
    this.plugin = plugin;
    this.toolName = "Paintbrush";
    this.materials = plugin.getMaterials();
  }

  @SuppressWarnings("deprecation")
public void onRangedUse(Player player, ItemStack item, Action action)
  {
    Block targetBlock = player.getTargetBlock(null, this.plugin.getToolManager().getRange());

    if ((action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK))
    {
      List<String> newLore = new ArrayList<String>();

      String fullName = NameUtil.getName(plugin, targetBlock.getType()) + NameUtil.getMaterialName(plugin, targetBlock.getState().getData());

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
          changeBlock(Boolean.valueOf(false), targetBlock, id, data, player, item, plugin);
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

      String fullName = NameUtil.getName(plugin, block.getType()) + NameUtil.getMaterialName(plugin, block.getState().getData());

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
        changeBlock(Boolean.valueOf(false), block, id, data, player, item, plugin);
      }
    }
  }
}