package nourl.mythicmetals.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import nourl.mythicmetals.client.models.HelmetModel;
import nourl.mythicmetals.client.models.MythicModelHandler;
import nourl.mythicmetals.misc.RegistryHelper;
import org.jetbrains.annotations.NotNull;

public class MetallurgiumArmor extends HallowedArmor {

    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> model;
    public final ArmorItem.Type type;

    public MetallurgiumArmor(ArmorItem.Type type, Settings settings) {
        this(MythicArmorMaterials.METALLURGIUM, type, settings);
    }

    public MetallurgiumArmor(ArmorMaterial material, ArmorItem.Type type, Settings settings) {
        super(material, type, settings);
        this.type = type;
    }

    @Environment(EnvType.CLIENT)
    public BipedEntityModel<LivingEntity> getArmorModel() {
        if (model == null) {
            model = provideArmorModelForSlot(type.getEquipmentSlot());
        }
        return model;
    }

    @Environment(EnvType.CLIENT)
    protected BipedEntityModel<LivingEntity> provideArmorModelForSlot(EquipmentSlot slot) {
        var models = MinecraftClient.getInstance().getEntityModelLoader();
        var root = models.getModelPart(MythicModelHandler.METALLURGIUM);
        return new HelmetModel(root, slot);
    }

    @NotNull
    @Override
    public final Identifier getArmorTexture(ItemStack stack, EquipmentSlot slot) {
        return RegistryHelper.id("textures/models/metallurgium_model.png");
    }
}
