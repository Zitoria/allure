package net.zitoria.allure.enchants.tools;

import net.zitoria.allure.util.EnchantRarity;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import pw.hyr.allure.models.AllureEnchant;
import net.zitoria.allure.util.annotation.Enchant;
import net.zitoria.allure.util.annotation.Description;
import pw.hyr.allure.utility.EnchantUtil;

/**
* @author Hyronical
*/
@Enchant(id = "blossom", display = "Blossom", maxLevel = 4, rarity = EnchantRarity.RARE, treasure = true, target = EnchantmentTarget.TOOL)
@Description(desc = "Drops more flowers when broken")
public class BlossomEnchant extends AllureEnchant {

    @Override
    public void onBlockBreak(@NotNull final Player player, @NotNull final Block block, final int level, @NotNull final BlockBreakEvent event) {
        
        // Give enchantment a chance of execution
        if (!EnchantUtil.passedChance(level))
            return;
        
        // Check if the block broken is that of a flower
        if (!Tag.SMALL_FLOWERS.getValues().contains(block.getType()))
            return;
      
        // Drop an added bonus of flowers based on the level
        for (ItemStack is : block.getDrops()) {
               is.setAmount(is.getAmount() + level);
               block.getWorld().dropItemNaturally(block.getLocation(), is);
        }
        
    }
}
