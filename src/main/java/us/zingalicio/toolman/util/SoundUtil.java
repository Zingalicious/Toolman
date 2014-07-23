package us.zingalicio.toolman.util;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.Sound;

import us.zingalicio.toolman.Toolman;

public class SoundUtil
{
	Toolman plugin;
	Map<Material, Sound> soundList = new HashMap<Material, Sound>();

	public SoundUtil(Toolman plugin)
	{
		this.plugin = plugin;
		this.soundList.put(Material.ACTIVATOR_RAIL, Sound.DIG_WOOD);
		this.soundList.put(Material.ANVIL, Sound.ANVIL_BREAK);
		this.soundList.put(Material.BEACON, Sound.GLASS);
		this.soundList.put(Material.BED_BLOCK, Sound.DIG_WOOD);
		this.soundList.put(Material.BEDROCK, Sound.DIG_STONE);
		this.soundList.put(Material.BIRCH_WOOD_STAIRS, Sound.DIG_WOOD);
		this.soundList.put(Material.BOOKSHELF, Sound.DIG_WOOD);
		this.soundList.put(Material.BREWING_STAND, Sound.DIG_STONE);
		this.soundList.put(Material.BRICK, Sound.DIG_STONE);
		this.soundList.put(Material.BRICK_STAIRS, Sound.DIG_STONE);
		this.soundList.put(Material.BROWN_MUSHROOM, Sound.DIG_GRASS);
		this.soundList.put(Material.BURNING_FURNACE, Sound.DIG_STONE);
		this.soundList.put(Material.CACTUS, Sound.DIG_GRASS);
		this.soundList.put(Material.CAKE_BLOCK, Sound.DIG_WOOL);
		this.soundList.put(Material.CARPET, Sound.DIG_WOOL);
		this.soundList.put(Material.CARROT, Sound.DIG_GRASS);
		this.soundList.put(Material.CAULDRON, Sound.DIG_STONE);
		this.soundList.put(Material.CHEST, Sound.DIG_WOOD);
		this.soundList.put(Material.CLAY, Sound.DIG_GRAVEL);
		this.soundList.put(Material.COAL_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.COAL_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.COBBLE_WALL, Sound.DIG_STONE);
		this.soundList.put(Material.COBBLESTONE, Sound.DIG_STONE);
		this.soundList.put(Material.COBBLESTONE_STAIRS, Sound.DIG_STONE);
		this.soundList.put(Material.COCOA, Sound.DIG_WOOD);
		this.soundList.put(Material.COMMAND, Sound.DIG_STONE);
		this.soundList.put(Material.CROPS, Sound.DIG_GRASS);
		this.soundList.put(Material.DAYLIGHT_DETECTOR, Sound.DIG_STONE);
		this.soundList.put(Material.DEAD_BUSH, Sound.DIG_GRASS);
		this.soundList.put(Material.DETECTOR_RAIL, Sound.DIG_WOOD);
		this.soundList.put(Material.DIAMOND_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.DIAMOND_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.DIODE_BLOCK_OFF, Sound.DIG_STONE);
		this.soundList.put(Material.DIODE_BLOCK_ON, Sound.DIG_STONE);
		this.soundList.put(Material.DIRT, Sound.DIG_GRAVEL);
		this.soundList.put(Material.DISPENSER, Sound.DIG_STONE);
		this.soundList.put(Material.DOUBLE_STEP, Sound.DIG_STONE);
		this.soundList.put(Material.DRAGON_EGG, Sound.DIG_STONE);
		this.soundList.put(Material.DROPPER, Sound.DIG_STONE);
		this.soundList.put(Material.EMERALD_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.EMERALD_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.ENCHANTMENT_TABLE, Sound.DIG_STONE);
		this.soundList.put(Material.ENDER_CHEST, Sound.DIG_STONE);
		this.soundList.put(Material.ENDER_PORTAL, Sound.GLASS);
		this.soundList.put(Material.ENDER_PORTAL_FRAME, Sound.DIG_STONE);
		this.soundList.put(Material.ENDER_STONE, Sound.DIG_STONE);
		this.soundList.put(Material.FENCE, Sound.DIG_WOOD);
		this.soundList.put(Material.FENCE_GATE, Sound.DIG_WOOD);
		this.soundList.put(Material.FIRE, Sound.FIZZ);
		this.soundList.put(Material.FLOWER_POT, Sound.DIG_STONE);
		this.soundList.put(Material.FURNACE, Sound.DIG_STONE);
		this.soundList.put(Material.GLASS, Sound.GLASS);
		this.soundList.put(Material.GLOWING_REDSTONE_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.GLOWSTONE, Sound.GLASS);
		this.soundList.put(Material.GOLD_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.GOLD_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.GRASS, Sound.DIG_GRASS);
		this.soundList.put(Material.GRAVEL, Sound.DIG_GRAVEL);
		this.soundList.put(Material.HARD_CLAY, Sound.DIG_STONE);
		this.soundList.put(Material.HAY_BLOCK, Sound.DIG_GRASS);
		this.soundList.put(Material.HOPPER, Sound.DIG_STONE);
		this.soundList.put(Material.HUGE_MUSHROOM_1, Sound.DIG_WOOD);
		this.soundList.put(Material.HUGE_MUSHROOM_2, Sound.DIG_WOOD);
		this.soundList.put(Material.ICE, Sound.GLASS);
		this.soundList.put(Material.IRON_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.IRON_DOOR_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.IRON_FENCE, Sound.DIG_STONE);
		this.soundList.put(Material.IRON_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.IRON_PLATE, Sound.DIG_STONE);
		this.soundList.put(Material.ITEM_FRAME, Sound.DIG_WOOD);
		this.soundList.put(Material.JACK_O_LANTERN, Sound.DIG_WOOD);
		this.soundList.put(Material.JUKEBOX, Sound.DIG_WOOD);
		this.soundList.put(Material.JUNGLE_WOOD_STAIRS, Sound.DIG_WOOD);
		this.soundList.put(Material.LADDER, Sound.DIG_WOOD);
		this.soundList.put(Material.LAPIS_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.LAPIS_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.LAVA, Sound.FIZZ);
		this.soundList.put(Material.LEAVES, Sound.DIG_GRASS);
		this.soundList.put(Material.LEVER, Sound.DIG_WOOD);
		this.soundList.put(Material.LOCKED_CHEST, Sound.DIG_WOOD);
		this.soundList.put(Material.LOG, Sound.DIG_WOOD);
		this.soundList.put(Material.LONG_GRASS, Sound.DIG_GRASS);
		this.soundList.put(Material.MELON_BLOCK, Sound.DIG_WOOD);
		this.soundList.put(Material.MELON_STEM, Sound.DIG_WOOD);
		this.soundList.put(Material.MOB_SPAWNER, Sound.DIG_STONE);
		this.soundList.put(Material.MONSTER_EGGS, Sound.DIG_STONE);
		this.soundList.put(Material.MOSSY_COBBLESTONE, Sound.DIG_STONE);
		this.soundList.put(Material.MYCEL, Sound.DIG_GRASS);
		this.soundList.put(Material.NETHER_BRICK, Sound.DIG_STONE);
		this.soundList.put(Material.NETHER_BRICK_STAIRS, Sound.DIG_STONE);
		this.soundList.put(Material.NETHER_FENCE, Sound.DIG_STONE);
		this.soundList.put(Material.NETHER_STALK, Sound.DIG_GRASS);
		this.soundList.put(Material.NETHERRACK, Sound.DIG_STONE);
		this.soundList.put(Material.NOTE_BLOCK, Sound.DIG_WOOD);
		this.soundList.put(Material.OBSIDIAN, Sound.DIG_STONE);
		this.soundList.put(Material.PISTON_BASE, Sound.DIG_WOOD);
		this.soundList.put(Material.PISTON_MOVING_PIECE, Sound.DIG_WOOD);
		this.soundList.put(Material.PISTON_EXTENSION, Sound.DIG_WOOD);
		this.soundList.put(Material.PISTON_STICKY_BASE, Sound.DIG_WOOD);
		this.soundList.put(Material.PORTAL, Sound.GLASS);
		this.soundList.put(Material.POTATO, Sound.DIG_GRASS);
		this.soundList.put(Material.POWERED_RAIL, Sound.DIG_WOOD);
		this.soundList.put(Material.PUMPKIN, Sound.DIG_WOOD);
		this.soundList.put(Material.PUMPKIN_STEM, Sound.DIG_WOOD);
		this.soundList.put(Material.QUARTZ_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.QUARTZ_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.QUARTZ_STAIRS, Sound.DIG_STONE);
		this.soundList.put(Material.RAILS, Sound.DIG_WOOD);
		this.soundList.put(Material.RED_MUSHROOM, Sound.DIG_GRASS);
		this.soundList.put(Material.RED_ROSE, Sound.DIG_GRASS);
		this.soundList.put(Material.REDSTONE_BLOCK, Sound.DIG_STONE);
		this.soundList.put(Material.REDSTONE_COMPARATOR_OFF, Sound.DIG_STONE);
		this.soundList.put(Material.REDSTONE_COMPARATOR_ON, Sound.DIG_STONE);
		this.soundList.put(Material.REDSTONE_LAMP_OFF, Sound.GLASS);
		this.soundList.put(Material.REDSTONE_LAMP_ON, Sound.GLASS);
		this.soundList.put(Material.REDSTONE_ORE, Sound.DIG_STONE);
		this.soundList.put(Material.REDSTONE_TORCH_OFF, Sound.DIG_WOOD);
		this.soundList.put(Material.REDSTONE_TORCH_ON, Sound.DIG_WOOD);
		this.soundList.put(Material.REDSTONE_WIRE, Sound.DIG_STONE);
		this.soundList.put(Material.SAND, Sound.DIG_SAND);
		this.soundList.put(Material.SANDSTONE, Sound.DIG_STONE);
		this.soundList.put(Material.SANDSTONE_STAIRS, Sound.DIG_STONE);
		this.soundList.put(Material.SAPLING, Sound.DIG_WOOD);
		this.soundList.put(Material.SIGN_POST, Sound.DIG_WOOD);
		this.soundList.put(Material.SKULL, Sound.DIG_STONE);
		this.soundList.put(Material.SMOOTH_BRICK, Sound.DIG_STONE);
		this.soundList.put(Material.SMOOTH_STAIRS, Sound.DIG_STONE);
		this.soundList.put(Material.SNOW, Sound.DIG_SNOW);
		this.soundList.put(Material.SNOW_BLOCK, Sound.DIG_SNOW);
		this.soundList.put(Material.SOIL, Sound.DIG_GRAVEL);
		this.soundList.put(Material.SOUL_SAND, Sound.DIG_GRAVEL);
		this.soundList.put(Material.SPONGE, Sound.DIG_GRAVEL);
		this.soundList.put(Material.SPRUCE_WOOD_STAIRS, Sound.DIG_WOOD);
		this.soundList.put(Material.STAINED_CLAY, Sound.DIG_STONE);
		this.soundList.put(Material.STATIONARY_LAVA, Sound.FIZZ);
		this.soundList.put(Material.STATIONARY_WATER, Sound.SPLASH);
		this.soundList.put(Material.STEP, Sound.DIG_STONE);
		this.soundList.put(Material.STONE, Sound.DIG_STONE);
		this.soundList.put(Material.STONE_BUTTON, Sound.DIG_STONE);
		this.soundList.put(Material.STONE_PLATE, Sound.DIG_STONE);
		this.soundList.put(Material.SUGAR_CANE_BLOCK, Sound.DIG_WOOD);
		this.soundList.put(Material.THIN_GLASS, Sound.GLASS);
		this.soundList.put(Material.TNT, Sound.DIG_STONE);
		this.soundList.put(Material.TORCH, Sound.DIG_WOOD);
		this.soundList.put(Material.TRAP_DOOR, Sound.DIG_STONE);
		this.soundList.put(Material.TRAPPED_CHEST, Sound.DIG_WOOD);
		this.soundList.put(Material.TRIPWIRE, Sound.DIG_STONE);
		this.soundList.put(Material.TRIPWIRE_HOOK, Sound.DIG_WOOD);
		this.soundList.put(Material.VINE, Sound.DIG_GRASS);
		this.soundList.put(Material.WALL_SIGN, Sound.DIG_WOOD);
		this.soundList.put(Material.WATER, Sound.SPLASH);
		this.soundList.put(Material.WATER_LILY, Sound.DIG_GRASS);
		this.soundList.put(Material.WEB, Sound.DIG_WOOL);
		this.soundList.put(Material.WOOD, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOD_BUTTON, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOD_DOOR, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOD_DOUBLE_STEP, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOD_PLATE, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOD_STAIRS, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOD_STEP, Sound.DIG_WOOD);
		this.soundList.put(Material.WOODEN_DOOR, Sound.DIG_WOOD);
		this.soundList.put(Material.WOOL, Sound.DIG_WOOL);
		this.soundList.put(Material.YELLOW_FLOWER, Sound.DIG_GRASS);
	}

	public Sound getSound(Material material)
	{
		if (this.soundList.containsKey(material))
		{
			return (Sound)this.soundList.get(material);
		}
		return Sound.DIG_STONE;
	}
}