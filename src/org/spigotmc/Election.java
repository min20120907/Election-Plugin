/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spigotmc;


import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.ChatColor;
/**
 *
 * @author min20120907
 */
public class Election extends JavaPlugin{
       
    @Override
    public void onEnable() {
               
    getLogger().info("The plugin is starting");
    this.getCommand("election").setExecutor(new command1());
    }

    @Override
    public void onDisable() {
            // invoke on disable.

    
    }

 public class command1 implements CommandExecutor {

    // This method is called, when somebody uses our command
       @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            ////////////////////////////////////////////////////////////////////
             Player player = (Player) sender;
             ConsoleCommandSender console = getServer().getConsoleSender();         //proclaim the console as console command sender
             String command = "gms "+player.getName();      //you will get 64 apples 
             getServer().dispatchCommand(console, command);//execute the command
             String command1 = "minecraft:tp "+player.getName()+" -371 65 -638";      //you will get 64 apples 
             getServer().dispatchCommand(console, command1);//execute the command
             ///////////////////////////////////////////////////////////////////
             
            ItemStack paper = new ItemStack(Material.PAPER);
            ItemMeta isMeta= paper.getItemMeta();
            isMeta.setDisplayName("Polling Vote"); //you can even set color
            paper.setItemMeta(isMeta);
            paper.addUnsafeEnchantment( Enchantment.DIG_SPEED, 1);
            paper.setAmount(1);
            player.getInventory().addItem(paper);
            ///////////////////////////////////////////////////////////////////
            player.sendMessage(ChatColor.WHITE+"please do /fertig after you finish election");       //show the message of command
            ///////////////////////////////////////////////////////////////////
            					
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
       
    
 }


}

