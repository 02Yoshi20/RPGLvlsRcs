
package net.yoshi.rpglvlsrcs.item;

import net.yoshi.rpglvlsrcs.itemgroup.RPGLvlsRcsItemGroup;
import net.yoshi.rpglvlsrcs.RpgLvlsRcsModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@RpgLvlsRcsModElements.ModElement.Tag
public class InfusedDustItem extends RpgLvlsRcsModElements.ModElement {
	@ObjectHolder("rpg_lvls_rcs:infused_dust")
	public static final Item block = null;
	public InfusedDustItem(RpgLvlsRcsModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RPGLvlsRcsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("infused_dust");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
