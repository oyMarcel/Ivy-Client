/*    */ package clientname.cosmetics;
/*    */ 
/*    */ import clientname.Client;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class CosmeticGhostWings
/*    */   extends Cosmetic {
/*    */   private ModelRenderer wing;
/*    */   private ModelRenderer wingTip;
/*    */   private RenderPlayer playerRenderer;
/*    */   
/*    */   public CosmeticGhostWings(RenderPlayer player) {
/* 19 */     super(player);
/*    */     
/* 21 */     this.playerRenderer = player;
/* 22 */     this.textureWidth = 256;
/* 23 */     this.textureHeight = 256;
/* 24 */     setTextureOffset("wing.skin", -56, 88);
/* 25 */     setTextureOffset("wing.bone", 112, 88);
/* 26 */     setTextureOffset("wingtip.skin", -56, 144);
/* 27 */     setTextureOffset("wingtip.bone", 112, 136);
/*    */     
/* 29 */     this.wing = new ModelRenderer((ModelBase)this, "wing");
/* 30 */     this.wing.setTextureSize(256, 256);
/* 31 */     this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
/* 32 */     this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
/* 33 */     this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/* 34 */     this.wing.isHidden = true;
/* 35 */     this.wingTip = new ModelRenderer((ModelBase)this, "wingtip");
/* 36 */     this.wingTip.setTextureSize(256, 256);
/* 37 */     this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
/* 38 */     this.wingTip.isHidden = true;
/* 39 */     this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
/* 40 */     this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/* 41 */     this.wing.addChild(this.wingTip);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldCombineTextures() {
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 53 */     if (player.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && 
/* 54 */       Client.CosmeticGhostWings) {
/* 55 */       GlStateManager.pushMatrix();
/* 56 */       float f1 = ageInTicks / 75.0F;
/* 57 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("wings.png"));
/*    */ 
/*    */       
/* 60 */       GlStateManager.scale(0.16D, 0.16D, 0.16D);
/* 61 */       GlStateManager.translate(0.0D, -0.3D, 1.1D);
/* 62 */       GlStateManager.rotate(50.0F, -50.0F, 0.0F, 0.0F);
/* 63 */       GlStateManager.blendFunc(1, 1);
/* 64 */       GlStateManager.enableBlend();
/* 65 */       GlStateManager.enableLighting();
/* 66 */       GlStateManager.disableLighting();
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 71 */       if (player.isSneaking()) {
/* 72 */         GlStateManager.translate(0.0F, 0.142F, 1.2F);
/*    */       }
/*    */       
/* 75 */       for (int i = 0; i < 2; i++) {
/*    */         
/* 77 */         float f6 = f1 * 9.141593F * 1.2F;
/*    */         
/* 79 */         this.wing.rotateAngleX = 0.125F - (float)Math.cos(f6) * 0.2F;
/* 80 */         this.wing.rotateAngleY = 0.25F;
/* 81 */         this.wing.rotateAngleZ = (float)(Math.sin(f6) + 1.225D) * 0.45F;
/* 82 */         this.wingTip.rotateAngleZ = -((float)(Math.sin((f6 + 2.0F)) + 0.5D)) * 0.95F;
/* 83 */         this.wing.isHidden = false;
/* 84 */         this.wingTip.isHidden = false;
/* 85 */         this.wing.render(scale);
/*    */         
/* 87 */         this.wing.isHidden = true;
/* 88 */         this.wingTip.isHidden = true;
/* 89 */         if (i == 0) {
/* 90 */           GlStateManager.scale(-1.0F, 1.0F, 1.0F);
/*    */         }
/*    */       } 
/*    */       
/* 94 */       GlStateManager.blendFunc(0, 0);
/* 95 */       GlStateManager.disableBlend();
/* 96 */       GlStateManager.popMatrix();
/*    */     } 
/*    */   }
/*    */ }

