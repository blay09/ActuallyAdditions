package ellpeck.actuallyadditions.blocks;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ellpeck.actuallyadditions.tile.TileEntityFishingNet;
import ellpeck.actuallyadditions.util.BlockUtil;
import ellpeck.actuallyadditions.util.INameableItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockFishingNet extends BlockContainerBase implements INameableItem{

    public BlockFishingNet(){
        super(Material.wood);
        this.setHarvestLevel("axe", 0);
        this.setHardness(1.0F);
        this.setStepSound(soundTypeWood);
        this.setBlockBounds(0F, 0F, 0F, 1F, 1F/16F, 1F);
    }

    @Override
    public String getOredictName(){
        return this.getName();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2){
        return new TileEntityFishingNet();
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg){
        this.blockIcon = Blocks.planks.getIcon(0, 0);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public int getRenderType(){
        return RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public String getName(){
        return "blockFishingNet";
    }

    public static class TheItemBlock extends ItemBlock{

        private Block theBlock;

        public TheItemBlock(Block block){
            super(block);
            this.theBlock = block;
            this.setHasSubtypes(false);
            this.setMaxDamage(0);
        }

        @Override
        public EnumRarity getRarity(ItemStack stack){
            return EnumRarity.uncommon;
        }

        @Override
        public String getUnlocalizedName(ItemStack stack){
            return this.getUnlocalizedName();
        }

        @Override
        @SuppressWarnings("unchecked")
        @SideOnly(Side.CLIENT)
        public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
            BlockUtil.addStandardInformation(theBlock, list);
        }

        @Override
        public int getMetadata(int meta){
            return meta;
        }
    }
}
