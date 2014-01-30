package pgn.lobby.bow;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

	

	
	  final java.util.HashMap<Long, Long> shows = new java.util.HashMap<Long, Long>();
      final java.util.List<org.bukkit.FireworkEffect.Type> types = new java.util.ArrayList<org.bukkit.FireworkEffect.Type>(java.util.Arrays.asList(org.bukkit.FireworkEffect.Type.BALL, org.bukkit.FireworkEffect.Type.BALL_LARGE, org.bukkit.FireworkEffect.Type.BURST, org.bukkit.FireworkEffect.Type.STAR, org.bukkit.FireworkEffect.Type.CREEPER));
      final java.util.List<org.bukkit.Color> colours = new java.util.ArrayList<org.bukkit.Color>(java.util.Arrays.asList(org.bukkit.Color.AQUA, org.bukkit.Color.BLACK, org.bukkit.Color.BLUE, org.bukkit.Color.FUCHSIA, org.bukkit.Color.GRAY, org.bukkit.Color.GREEN, org.bukkit.Color.LIME, org.bukkit.Color.MAROON, org.bukkit.Color.NAVY, org.bukkit.Color.OLIVE, org.bukkit.Color.ORANGE, org.bukkit.Color.PURPLE, org.bukkit.Color.RED, org.bukkit.Color.SILVER, org.bukkit.Color.TEAL, org.bukkit.Color.WHITE, org.bukkit.Color.YELLOW));	
	
	   
      
      
    @Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		
	  }
	
	
	
	

	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args ) {
		Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("vipbow")){
        	if (player.hasPermission("network.vip")) {	
    			Bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
    			player.getInventory().addItem(new ItemStack[] { Bow });
    			player.getInventory().addItem(new ItemStack[] { Arrow });
    			player.sendMessage(ChatColor.DARK_PURPLE + "Here is your vip bow!");
                }
        }
        
	
	return false;
}


	
	ItemStack Bow = new ItemStack(Material.BOW);
	{
		ItemMeta itemmeta = Bow.getItemMeta();
		ArrayList<String> im = new ArrayList<String>();
		itemmeta.setDisplayName(ChatColor.GOLD + "Vip Bow");
		im.add(ChatColor.GRAY + "Fireworks V");
		itemmeta.setLore(im);
		Bow.setItemMeta(itemmeta);
	}
	ItemStack Arrow = new ItemStack(Material.ARROW, 1);
	{
		ItemMeta itemmeta = Arrow.getItemMeta();
		ArrayList<String> im = new ArrayList<String>();
		itemmeta.setDisplayName(ChatColor.GOLD + "Vip Arrow");
		itemmeta.setLore(im);
		Arrow.setItemMeta(itemmeta);
	}


	  @EventHandler public void onBowShoot(EntityShootBowEvent event) {
	  FireworkMeta fireworkMeta = (FireworkMeta) (new ItemStack(
	  Material.FIREWORK)).getItemMeta(); Firework firework = (Firework) event
	  .getProjectile() .getLocation() .getWorld()
	 .spawnEntity(event.getProjectile().getLocation(), EntityType.FIREWORK);
	 
	  fireworkMeta.addEffect(FireworkEffect.builder().with(Type.BURST)
	  .withColor(Color.RED).withColor(Color.WHITE)
	  .withColor(Color.BLUE).withColor(Color.PURPLE).withTrail() .build());
	  firework.setFireworkMeta(fireworkMeta);
       event.getProjectile().setPassenger(firework); }
	  


	
	  
	  
}
