/*    */ package clientname.cosmetics;
/*    */ 
/*    */ import clientname.Client;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EnumPlayerModelParts;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class CosmeticCape3 implements LayerRenderer<AbstractClientPlayer> {
/*    */   private final RenderPlayer playerRenderer;
/*    */   private static final String __08FID = "CL_00002425";
/*    */   
/*    */   public CosmeticCape3(RenderPlayer playerRendererIn) {
/* 19 */     this.playerRenderer = playerRendererIn;
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
/* 24 */     if (Client.CosmeticCape3 && entitylivingbaseIn.hasPlayerInfo() && !entitylivingbaseIn.isInvisible() && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE) && entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
/* 25 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 26 */       this.playerRenderer.bindTexture(new ResourceLocation("Cape3.png"));
/* 27 */       GlStateManager.pushMatrix();
/* 28 */       GlStateManager.translate(0.0F, 0.0F, 0.125F);
/* 29 */       double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * partialTicks - entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * partialTicks;
/* 30 */       double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * partialTicks - entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * partialTicks;
/* 31 */       double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * partialTicks - entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * partialTicks;
/* 32 */       float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
/* 33 */       double d3 = MathHelper.sin(f * 3.1415927F / 180.0F);
/* 34 */       double d4 = -MathHelper.cos(f * 3.1415927F / 180.0F);
/* 35 */       float f1 = (float)d1 * 10.0F;
/* 36 */       f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
/* 37 */       float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
/* 38 */       float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
/* 39 */       if (f2 < 0.0F) {
/* 40 */         f2 = 0.0F;
/*    */       }
/* 42 */       float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
/* 43 */       f1 += MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;
/* 44 */       if (entitylivingbaseIn.isSneaking()) {
/* 45 */         f1 += 25.0F;
/* 46 */         GlStateManager.translate(0.0F, 0.142F, -0.0178F);
/*    */       } 
/* 48 */       GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
/* 49 */       GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
/* 50 */       GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
/* 51 */       GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
/* 52 */       this.playerRenderer.getMainModel().renderCape(0.0625F);
/* 53 */       GlStateManager.popMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldCombineTextures() {
/* 59 */     return false;
/*    */   }
/*    */ }

