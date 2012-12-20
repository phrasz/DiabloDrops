package com.modcrafting.diablodrops.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class DiabloifyTome extends ItemStack
{
    public DiabloifyTome()
    {
        super(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) this.getItemMeta();
        meta.setTitle(ChatColor.DARK_RED + "Diablo Tome");
        meta.setAuthor(ChatColor.MAGIC + "BBBBBBBB");
        List<String> pages = new ArrayList<String>();
        pages.add(0, ChatColor.MAGIC + "AAAAA AA AAAA AAAA AAAA");
        meta.setPages(pages);
        this.setItemMeta(meta);
    }

}
