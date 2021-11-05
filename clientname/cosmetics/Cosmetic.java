/*    */ package clientname.cosmetics;
/*    */ 
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Cosmetic
/*    */   extends ModelBiped
/*    */   implements LayerRenderer<AbstractClientPlayer>
/*    */ {
/*    */   ModelBiped playerModel;
/*    */   
/*    */   public Cosmetic(RenderPlayer player) {
/* 19 */     this.playerModel = (ModelBiped)player.getMainModel();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 25 */     if (player.hasPlayerInfo() && !player.isInvisible()) {
/* 26 */       render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, scale);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldCombineTextures() {
/* 36 */     return false;
/*    */   }
/*    */   private static float Sigmoid(double value) {
/* 39 */     return 1.0F / (1.0F + (float)Math.exp(-value));
/*    */   }
/*    */   
/*    */   public abstract void render(AbstractClientPlayer paramAbstractClientPlayer, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*    */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\cosmetics\Cosmetic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */