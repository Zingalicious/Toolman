package us.zingalicio.toolman.tools;

import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import us.zingalicio.toolman.AbstractTool;
import us.zingalicio.toolman.Toolman;

public class Wrench extends AbstractTool
{
	Toolman plugin;

	public Wrench(Toolman plugin)
	{
		this.plugin = plugin;
		this.toolName = "Wrench";
	}

	@SuppressWarnings("deprecation")
public void onRangedUse(Player player, ItemStack item, Action action)
	{
		if (player.isSneaking())
		{
			Block targetBlock = player.getTargetBlock(null, this.plugin.getToolManager().getRange());
			if (targetBlock.getType() != Material.AIR)
			{
				YamlConfiguration materials = this.plugin.getMaterials();
				List<Byte> valueList;

				if ((valueList = materials.getByteList("blocks." + targetBlock.getType().name() + ".scroll")) != null)
				{
					int valueLength = valueList.size();
						
					if(valueLength == 0)
					{
						return;
					}
						
					byte targetData = targetBlock.getData();

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
										changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(currentValue - 1)).byteValue(), player, item, plugin);
										return;
									}
									currentValue++;
								}
							}
							else
							{
								changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(valueLength - 1)).byteValue(), player, item, plugin);
							}

						}
						else
						{
							changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, plugin);
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
									changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(currentValue + 1)).byteValue(), player, item, plugin);
									return;
								}
								currentValue++;
							}
						}
						else
						{
							changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, plugin);
						}

					}
					else
					{
						changeBlock(Boolean.valueOf(false), targetBlock, targetBlock.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, plugin);
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

		YamlConfiguration materials = this.plugin.getMaterials();

		if (player.isSneaking())
		{
			if ((action == Action.RIGHT_CLICK_BLOCK) || (action == Action.RIGHT_CLICK_AIR))
			{
				if (block.getData() != 0)
				{
					changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)(targetData - 1), player, item, plugin);
					return;
				}

				changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)15, player, item, plugin);
				return;
			}

			if (block.getData() != 15)
			{
				changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)(targetData + 1), player, item, plugin);
				return;
			}

			changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)0, player, item, plugin);
			return;
		}
		
		List<Byte> valueList;

		if ((valueList = materials.getByteList("blocks." + block.getType().name() + ".scroll")) != null)
		{
			int valueLength = valueList.size();

			if(valueLength == 0)
			{
				return;
			}

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
								changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(currentValue - 1)).byteValue(), player, item, plugin);
								return;
							}
							currentValue++;
						}
					}
					else
					{
						changeBlock(Boolean.valueOf(false), block, block.getTypeId(), (byte)(valueLength - 1), player, item, plugin);
					}

				}
				else
				{
					changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, plugin);
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
							changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(currentValue + 1)).byteValue(), player, item, plugin);
							return;
						}
						currentValue++;
					}
				}
				else
				{
					changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, plugin);
				}

			}
			else
			{
				changeBlock(Boolean.valueOf(false), block, block.getTypeId(), ((Byte)valueList.get(0)).byteValue(), player, item, plugin);
				return;
			}
		}
	}
}