package de.xnonymous.autosell.commands;

import de.xnonymous.autosell.AutoSell;
import de.xnonymous.autosell.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveAutoSellChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        Player target = (Bukkit.getServer().getPlayer(args[0]));
        int amount = 1;
        
        if (args.length > 2) {
            commandSender.sendMessage("Too many arguments!");
            return false;
    } 
        if (args.length < 1) {
            commandSender.sendMessage("Not enough arguments!");
            return false;
    }
        if (target == null) {
            commandSender.sendMessage(args[0] + " is not online!");
            return false;
    }
        if (args[1]) {
            try {
                amount = Integer.parseInt(args[1]);
        }
            catch (NumberFormatException e) {
                commandSender.sendMessage(args[1] + " is not a number");
                return false;
        }
    }

        try {
            target.getInventory().addItem(new ItemBuilder(Material.CHEST, amount).setName("§aAutoSell Chest").toItemStack());
            target.sendMessage(AutoSell.getAutoSell().getPrefix() + "Happy selling!");
        } catch (Exception ignored) {
            player.sendMessage(AutoSell.getAutoSell().getPrefix() + "The inventory of " + args[0] + " is full");
        }

        return false;
    }
}
