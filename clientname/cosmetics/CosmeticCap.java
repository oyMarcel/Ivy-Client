/*     */ package clientname.cosmetics;
/*     */ 
/*     */ import clientname.Client;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ public class CosmeticCap
/*     */   extends Cosmetic
/*     */ {
/*     */   ModelRenderer Cap1;
/*     */   ModelRenderer Cap2;
/*     */   ModelRenderer Cap3;
/*     */   ModelRenderer Cap4;
/*     */   ModelRenderer Cap5;
/*     */   ModelRenderer Cap6;
/*     */   ModelRenderer cap7;
/*     */   
/*     */   public CosmeticCap(RenderPlayer player) {
/*  28 */     super(player);
/*  29 */     this.textureWidth = 64;
/*  30 */     this.textureHeight = 32;
/*     */     
/*  32 */     this.Cap1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  33 */     this.Cap1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 11);
/*  34 */     this.Cap1.setRotationPoint(-4.0F, -9.0F, -7.0F);
/*  35 */     this.Cap1.setTextureSize(64, 32);
/*  36 */     this.Cap1.mirror = true;
/*  37 */     this.Cap2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  38 */     this.Cap2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1);
/*  39 */     this.Cap2.setRotationPoint(-4.0F, -9.0F, -8.0F);
/*  40 */     this.Cap2.setTextureSize(64, 32);
/*  41 */     this.Cap2.mirror = true;
/*  42 */     this.Cap3 = new ModelRenderer((ModelBase)this, 0, 0);
/*  43 */     this.Cap3.addBox(0.0F, 0.0F, 0.0F, 8, 3, 1);
/*  44 */     this.Cap3.setRotationPoint(-4.0F, -12.0F, -4.0F);
/*  45 */     this.Cap3.setTextureSize(64, 32);
/*  46 */     this.Cap3.mirror = true;
/*  47 */     this.Cap4 = new ModelRenderer((ModelBase)this, 0, 0);
/*  48 */     this.Cap4.addBox(0.0F, 0.0F, 0.0F, 8, 3, 1);
/*  49 */     this.Cap4.setRotationPoint(-4.0F, -12.0F, 3.0F);
/*  50 */     this.Cap4.setTextureSize(64, 32);
/*  51 */     this.Cap4.mirror = true;
/*  52 */     this.Cap5 = new ModelRenderer((ModelBase)this, 0, 0);
/*  53 */     this.Cap5.addBox(0.0F, 0.0F, 0.0F, 1, 3, 6);
/*  54 */     this.Cap5.setRotationPoint(-4.0F, -12.0F, -3.0F);
/*  55 */     this.Cap5.setTextureSize(64, 32);
/*  56 */     this.Cap5.mirror = true;
/*  57 */     this.Cap6 = new ModelRenderer((ModelBase)this, 0, 0);
/*  58 */     this.Cap6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 6);
/*  59 */     this.Cap6.setRotationPoint(3.0F, -12.0F, -3.0F);
/*  60 */     this.Cap6.setTextureSize(64, 32);
/*  61 */     this.Cap6.mirror = true;
/*  62 */     this.cap7 = new ModelRenderer((ModelBase)this, 0, 0);
/*  63 */     this.cap7.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
/*  64 */     this.cap7.setRotationPoint(-3.0F, -12.0F, -3.0F);
/*  65 */     this.cap7.setTextureSize(64, 32);
/*  66 */     this.cap7.mirror = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/*  73 */     if (Client.CosmeticCap) {
/*  74 */       GlStateManager.pushMatrix();
/*  75 */       float f = partialTicks;
/*     */       
/*  77 */       float f1 = getFirstRotationX(player, f);
/*  78 */       float f2 = getSecondRotationX(player, f);
/*     */       
/*  80 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  81 */       setRotationAngles(limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, (Entity)player);
/*  82 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("cap.png"));
/*  83 */       GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
/*  84 */       GlStateManager.rotate(f2, 1.0F, 0.0F, 0.0F);
/*  85 */       GlStateManager.disableLighting();
/*     */       
/*  87 */       if (player.isSneaking()) {
/*  88 */         GlStateManager.translate(0.0D, 0.26D, -0.047D);
/*     */       }
/*     */ 
/*     */       
/*  92 */       this.Cap1.render(scale);
/*  93 */       this.Cap2.render(scale);
/*  94 */       this.Cap3.render(scale);
/*  95 */       this.Cap4.render(scale);
/*  96 */       this.Cap5.render(scale);
/*  97 */       this.Cap6.render(scale);
/*  98 */       this.cap7.render(scale);
/*  99 */       GlStateManager.popMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float getFirstRotationX(AbstractClientPlayer Player, float partialTicks) {
/* 106 */     float f = interpolateRotation(Player.prevRenderYawOffset, Player.renderYawOffset, partialTicks);
/* 107 */     float f1 = interpolateRotation(Player.prevRotationYawHead, Player.rotationYawHead, partialTicks);
/* 108 */     float f2 = f1 - f;
/*     */     
/* 110 */     if (Player.isRiding() && Player.ridingEntity instanceof EntityLivingBase) {
/*     */       
/* 112 */       EntityLivingBase entitylivingbase = (EntityLivingBase)Player.ridingEntity;
/* 113 */       f = interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
/* 114 */       f2 = f1 - f;
/* 115 */       float f3 = MathHelper.wrapAngleTo180_float(f2);
/*     */       
/* 117 */       if (f3 < -85.0F)
/*     */       {
/* 119 */         f3 = -85.0F;
/*     */       }
/*     */       
/* 122 */       if (f3 >= 85.0F)
/*     */       {
/* 124 */         f3 = 85.0F;
/*     */       }
/*     */       
/* 127 */       f = f1 - f3;
/*     */       
/* 129 */       if (f3 * f3 > 2500.0F)
/*     */       {
/* 131 */         float f4 = f + f3 * 0.2F;
/*     */       }
/*     */     } 
/*     */     
/* 135 */     return f2;
/*     */   }
/*     */ 
/*     */   
/*     */   private float getSecondRotationX(AbstractClientPlayer Player, float partialTicks) {
/* 140 */     return Player.prevRotationPitch + (Player.rotationPitch - Player.prevRotationPitch) * partialTicks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float interpolateRotation(float par1, float par2, float par3) {
/*     */     float f;
/* 147 */     for (f = par2 - par1; f < -180.0F; f += 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     while (f >= 180.0F)
/*     */     {
/* 154 */       f -= 360.0F;
/*     */     }
/*     */     
/* 157 */     return par1 + par3 * f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 162 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\cosmetics\CosmeticCap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */