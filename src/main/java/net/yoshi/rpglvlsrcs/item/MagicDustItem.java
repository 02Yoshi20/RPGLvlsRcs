
package net.yoshi.rpglvlsrcs.item;

import net.yoshi.rpglvlsrcs.procedures.MagicDustFoodEatenProcedure;
import net.yoshi.rpglvlsrcs.itemgroup.RPGLvlsRcsItemGroup;
import net.yoshi.rpglvlsrcs.RpgLvlsRcsModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

@RpgLvlsRcsModElements.ModElement.Tag
public class MagicDustItem extends RpgLvlsRcsModElements.ModElement {
	@ObjectHolder("rpg_lvls_rcs:magic_dust")
	public static final Item block = null;
	public MagicDustItem(RpgLvlsRcsModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(RPGLvlsRcsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("magic_dust");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				MagicDustFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
