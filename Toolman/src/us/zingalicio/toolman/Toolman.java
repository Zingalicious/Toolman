/*    */ package us.zingalicio.toolman;
/*    */ 
/*    */ import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import us.zingalicio.toolman.tools.Breaker;
import us.zingalicio.toolman.tools.Chopper;
import us.zingalicio.toolman.tools.Digger;
import us.zingalicio.toolman.tools.Maghammer;
import us.zingalicio.toolman.tools.Paintbrush;
import us.zingalicio.toolman.tools.Pliers;
import us.zingalicio.toolman.tools.Replicator;
import us.zingalicio.toolman.tools.Wrench;
import us.zingalicio.toolman.util.SoundUtil;

public final class Toolman extends JavaPlugin
{
  private final ToolmanListener listener;
  private final ToolManager toolManager;
  public final SoundUtil soundUtil;
  private Map<Player, Boolean> delayMap = new HashMap<Player, Boolean>();

  public Toolman()
  {
    this.listener = new ToolmanListener(this);
    this.toolManager = new ToolManager(this);
    this.soundUtil = new SoundUtil();
  }

  public ToolManager getToolManager()
  {
    return this.toolManager;
  }

  public ToolmanListener getListener()
  {
    return this.listener;
  }

  public void onEnable()
  {
    Bukkit.getPluginManager().registerEvents(this.listener, this);

    this.toolManager.registerTool(new Breaker(this));
    this.toolManager.registerTool(new Chopper(this));
    this.toolManager.registerTool(new Digger(this));
    this.toolManager.registerTool(new Maghammer(this));
    this.toolManager.registerTool(new Paintbrush(this));
    this.toolManager.registerTool(new Pliers(this));
    this.toolManager.registerTool(new Replicator(this));
    this.toolManager.registerTool(new Wrench(this));

    saveDefaultConfig();
    getConfig();
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