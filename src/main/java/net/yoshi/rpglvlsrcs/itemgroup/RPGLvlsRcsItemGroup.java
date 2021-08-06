
package net.yoshi.rpglvlsrcs.itemgroup;

import net.yoshi.rpglvlsrcs.item.MagicDustItem;
import net.yoshi.rpglvlsrcs.RpgLvlsRcsModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@RpgLvlsRcsModElements.ModElement.Tag
public class RPGLvlsRcsItemGroup extends RpgLvlsRcsModElements.ModElement {
	public RPGLvlsRcsItemGroup(RpgLvlsRcsModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabrpg_lvls_rcs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MagicDustItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
