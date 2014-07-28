package us.zingalicio.toolman;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import us.zingalicio.toolman.tools.Breaker;
import us.zingalicio.toolman.tools.Chopper;
import us.zingalicio.toolman.tools.Digger;
import us.zingalicio.toolman.tools.Maghammer;
import us.zingalicio.toolman.tools.Paintbrush;
import us.zingalicio.toolman.tools.Pliers;
import us.zingalicio.toolman.tools.Replicator;
import us.zingalicio.toolman.tools.Wrench;
import us.zingalicio.zinglib.plugin.ZingPlugin;

public final class Toolman extends ZingPlugin
{
	private ToolmanListener listener;
	private ToolManager toolManager;
	private Map<Player, Boolean> delayMap = new HashMap<Player, Boolean>();

	public Toolman()
	{
		super();
	}
	
	public ToolManager getToolManager()
	{
		return this.toolManager;
	}

	public ToolmanListener getListener()
	{
		return this.listener;
	}
	
	public YamlConfiguration getMaterials()
	{
		return this.materials;
	}
	
	public YamlConfiguration getConfig()
	{
		return this.config;
	}

	public void onEnable()
	{		
		this.listener = new ToolmanListener(this);
		this.toolManager = new ToolManager(this);
		registerTools();
		
		Bukkit.getPluginManager().registerEvents(this.listener, this);
	}

	private void registerTools()
	{
		this.toolManager.registerTool(new Breaker(this));
		this.toolManager.registerTool(new Chopper(this));
		this.toolManager.registerTool(new Digger(this));
		this.toolManager.registerTool(new Maghammer(this));
		this.toolManager.registerTool(new Paintbrush(this));
		this.toolManager.registerTool(new Pliers(this));
		this.toolManager.registerTool(new Replicator(this));
		this.toolManager.registerTool(new Wrench(this));
	}
	
	public void startDelay(Player player)
	{
		this.delayMap.put(player, Boolean.valueOf(false));
		ResetDelayTask resetDelay = new ResetDelayTask(this, player);
		resetDelay.runTaskLater(this, 5L);
	}

	public void endDelay(Player player)
	{
		this.delayMap.put(player, Boolean.valueOf(true));
	}

	public boolean delayFinished(Player player)
	{
		if (this.delayMap.containsKey(player))
		{
			return ((Boolean)this.delayMap.get(player).booleanValue());
		}

		return true;
	}
}