package pw.hyr.allure.Enchants.Tools;

import net.zitoria.allure.util.EnchantRarity;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import pw.hyr.allure.Models.AllureEnchant;
import net.zitoria.allure.util.annotation.ADescription;
import net.zitoria.allure.util.annotation.AEnchant;
import pw.hyr.allure.Utility.EnchantUtil;

@AEnchant(name = "blossom", displayName = "Blossom", maxLevel = 4, rarity = EnchantRarity.RARE, isTreaure = true, target = EnchantmentTarget.TOOL)
@ADescription(desc = "Drops more flowers when broken")
public class BlossomEnchant extends AllureEnchant {

    @Override
    public void onBlockBreak(@NotNull final Player player, @NotNull final Block block, final int level, @NotNull final BlockBreakEvent event) {
        if (EnchantUtil.passedChance(level)) {
            if (Tag.SMALL_FLOWERS.getValues().contains(block.getType())) {
                for (ItemStack is : block.getDrops()) {
                    is.setAmount(is.getAmount() + level);
                    block.getWorld().dropItemNaturally(block.getLocation(), is);
                }
            }
        }
    }
}
