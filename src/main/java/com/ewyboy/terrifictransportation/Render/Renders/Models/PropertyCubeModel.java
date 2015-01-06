package com.ewyboy.terrifictransportation.Render.Renders.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PropertyCubeModel extends ModelBase {

    //fields
    ModelRenderer Box;
    ModelRenderer Leg01;
    ModelRenderer Leg02;
    ModelRenderer Leg03;
    ModelRenderer Leg04;
    ModelRenderer Shape1;

    public PropertyCubeModel()
    {
        textureWidth = 128;
        textureHeight = 128;

        Box = new ModelRenderer(this, 0, 0);
        Box.addBox(-6F, -6F, -6F, 12, 12, 12);
        Box.setRotationPoint(0F, 17F, 0F);
        Box.setTextureSize(128, 128);
        Box.setTextureOffset(0,0);
        Box.mirror = true;
        setRotation(Box, 0F, 0F, 0F);
        Leg01 = new ModelRenderer(this, 0, 0);
        Leg01.addBox(-0.5F, -7F, -0.5F, 2, 14, 1);
        Leg01.setRotationPoint(5F, 17F, 6F);
        Leg01.setTextureSize(128, 128);
        Leg01.mirror = true;
        setRotation(Leg01, 0F, 0F, 0F);
        Leg02 = new ModelRenderer(this, 0, 0);
        Leg02.addBox(-0.5F, -7F, -0.5F, 1, 14, 1);
        Leg02.setRotationPoint(6F, 17F, -6F);
        Leg02.setTextureSize(128, 128);
        Leg02.mirror = true;
        setRotation(Leg02, 0F, 0F, 0F);
        Leg03 = new ModelRenderer(this, 0, 0);
        Leg03.addBox(-0.5F, -7F, -0.5F, 1, 14, 1);
        Leg03.setRotationPoint(-6F, 17F, -6F);
        Leg03.setTextureSize(128, 128);
        Leg03.mirror = true;
        setRotation(Leg03, 0F, 0F, 0F);
        Leg04 = new ModelRenderer(this, 0, 0);
        Leg04.addBox(-0.5F, -7F, -0.5F, 2, 14, 1);
        Leg04.setRotationPoint(-6F, 17F, 6F);
        Leg04.setTextureSize(128, 128);
        Leg04.mirror = true;
        setRotation(Leg04, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(-6F, 0F, -0.5F, 12, 2, 1);
        Shape1.setRotationPoint(0F, 10F, 6F);
        Shape1.setTextureSize(128, 128);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Box.render(f5);
        Leg01.render(f5);
        Leg02.render(f5);
        Leg03.render(f5);
        Leg04.render(f5);
        Shape1.render(f5);
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