package com.ewyboy.terrifictransportation.Render.Renders.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PropertyCubeModel extends ModelBase {

    //fields
    ModelRenderer Box;
    
    ModelRenderer FrameSide01;
    ModelRenderer FrameSide02;
    ModelRenderer FrameSide03;
    ModelRenderer FrameSide04;

    ModelRenderer FrameTop01;
    ModelRenderer FrameTop02;
    ModelRenderer FrameTop03;
    ModelRenderer FrameTop04;

    ModelRenderer FrameBot01;
    ModelRenderer FrameBot02;
    ModelRenderer FrameBot03;
    ModelRenderer FrameBot04;

    public PropertyCubeModel()
    {
        textureWidth = 128;
        textureHeight = 128;

        Box = new ModelRenderer(this, 0, 104);
        Box.addBox(-6F, -6F, -6F, 12, 12, 12);
        Box.setRotationPoint(0F, 17F, 0F);
        Box.setTextureSize(128, 128);
        Box.mirror = true;
        setRotation(Box, 0F, 0F, 0F);

        FrameSide01 = new ModelRenderer(this, 0, 0);
        FrameSide01.addBox(-0.5F, -7F, -0.5F, 1, 14, 1);
        FrameSide01.setRotationPoint(6F, 17F, 6F);
        FrameSide01.setTextureSize(128, 128);
        FrameSide01.mirror = true;
        setRotation(FrameSide01, 0F, 0F, 0F);

        FrameSide02 = new ModelRenderer(this, 0, 0);
        FrameSide02.addBox(-0.5F, -7F, -0.5F, 1, 14, 1);
        FrameSide02.setRotationPoint(6F, 17F, -6F);
        FrameSide02.setTextureSize(128, 128);
        FrameSide02.mirror = true;
        setRotation(FrameSide02, 0F, 0F, 0F);

        FrameSide03 = new ModelRenderer(this, 0, 0);
        FrameSide03.addBox(-0.5F, -7F, -0.5F, 1, 14, 1);
        FrameSide03.setRotationPoint(-6F, 17F, -6F);
        FrameSide03.setTextureSize(128, 128);
        FrameSide03.mirror = true;
        setRotation(FrameSide03, 0F, 0F, 0F);

        FrameSide04 = new ModelRenderer(this, 0, 0);
        FrameSide04.addBox(-0.5F, -7F, -0.5F, 1, 14, 1);
        FrameSide04.setRotationPoint(-6F, 17F, 6F);
        FrameSide04.setTextureSize(128, 128);
        FrameSide04.mirror = true;
        setRotation(FrameSide04, 0F, 0F, 0F);

        FrameTop01 = new ModelRenderer(this, 70, 112);
        FrameTop01.addBox(-6F, 0F, -0.5F, 12, 1, 1);
        FrameTop01.setRotationPoint(0F, 10F, 6F);
        FrameTop01.setTextureSize(128, 128);
        FrameTop01.mirror = true;
        setRotation(FrameTop01, 0F, 0F, 0F);

        FrameTop02 = new ModelRenderer(this, 70, 112);
        FrameTop02.addBox(-6F, 0F, -0.5F, 12, 1, 1);
        FrameTop02.setRotationPoint(0F, 10F, -6F);
        FrameTop02.setTextureSize(128, 128);
        FrameTop02.mirror = true;
        setRotation(FrameTop02, 0F, 0F, 0F);

        FrameTop03 = new ModelRenderer(this, 70, 112);
        FrameTop03.addBox(-0.5F, 0F, -6F, 1, 1, 12);
        FrameTop03.setRotationPoint(6F, 10F, 0F);
        FrameTop03.setTextureSize(128, 128);
        FrameTop03.mirror = true;
        setRotation(FrameTop03, 0F, 0F, 0F);

        FrameTop04 = new ModelRenderer(this, 70, 112);
        FrameTop04.addBox(-0.5F, 0F, -6F, 1, 1, 12);
        FrameTop04.setRotationPoint(-6F, 10F, 0F);
        FrameTop04.setTextureSize(128, 128);
        FrameTop04.mirror = true;
        setRotation(FrameTop04, 0F, 0F, 0F);

        FrameBot01 = new ModelRenderer(this, 70, 112);
        FrameBot01.addBox(-6F, 0F, -0.5F, 12, 1, 1);
        FrameBot01.setRotationPoint(0F, 23F, 6F);
        FrameBot01.setTextureSize(128, 128);
        FrameBot01.mirror = true;
        setRotation(FrameBot01, 0F, 0F, 0F);

        FrameBot02 = new ModelRenderer(this, 70, 112);
        FrameBot02.addBox(-6F, 0F, -0.5F, 12, 1, 1);
        FrameBot02.setRotationPoint(0F, 23F, -6F);
        FrameBot02.setTextureSize(128, 128);
        FrameBot02.mirror = true;
        setRotation(FrameBot02, 0F, 0F, 0F);

        FrameBot03 = new ModelRenderer(this, 70, 112);
        FrameBot03.addBox(-0.56F, 0F, -6F, 1, 1, 12);
        FrameBot03.setRotationPoint(6F, 23F, 0F);
        FrameBot03.setTextureSize(128, 128);
        FrameBot03.mirror = true;
        setRotation(FrameBot03, 0F, 0F, 0F);

        FrameBot04 = new ModelRenderer(this, 70, 112);
        FrameBot04.addBox(-0.5F, 0F, -6F, 1, 1, 12);
        FrameBot04.setRotationPoint(-6F, 23F, 0F);
        FrameBot04.setTextureSize(128, 128);
        FrameBot04.mirror = true;
        setRotation(FrameBot04, 0F, 0F, 0F);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Box.render(f5);

        FrameSide01.render(f5);
        FrameSide02.render(f5);
        FrameSide03.render(f5);
        FrameSide04.render(f5);

        FrameTop01.render(f5);
        FrameTop02.render(f5);
        FrameTop03.render(f5);
        FrameTop04.render(f5);

        FrameBot01.render(f5);
        FrameBot02.render(f5);
        FrameBot03.render(f5);
        FrameBot04.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) //Add Entity entity here
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity); //Add entity here
    }
}