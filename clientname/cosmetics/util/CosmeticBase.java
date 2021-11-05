/*    */ package clientname.cosmetics.util;
/*    */ 
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public abstract class CosmeticBase implements LayerRenderer<AbstractClientPlayer> {
/*    */   protected final RenderPlayer renderPlayer;
/*    */   
/*    */   public CosmeticBase(RenderPlayer player) {
/* 12 */     this.renderPlayer = player;
/*    */   }
/*    */   
/*    */   public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 16 */     if (player.hasPlayerInfo() && !player.isInvisible())
/* 17 */       render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, scale); 
/*    */   }
/*    */   
/*    */   public boolean shouldCombineTextures() {
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   public abstract void render(AbstractClientPlayer paramAbstractClientPlayer, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*    */ }

