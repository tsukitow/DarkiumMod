
package net.mcreator.darkium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.darkium.item.SkyhotiumIngotItem;
import net.mcreator.darkium.DarkiumModElements;

@DarkiumModElements.ModElement.Tag
public class SkyhotiumItemGroup extends DarkiumModElements.ModElement {
	public SkyhotiumItemGroup(DarkiumModElements instance) {
		super(instance, 74);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabskyhotium") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SkyhotiumIngotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
