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
/*     */ 
/*     */ public class CosmeticHat
/*     */   extends Cosmetic
/*     */ {
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape2;
/*     */   
/*     */   public CosmeticHat(RenderPlayer player) {
/*  24 */     super(player);
/*  25 */     this.textureWidth = 64;
/*  26 */     this.textureHeight = 32;
/*     */ 
/*     */     
/*  29 */     this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  30 */     this.Shape1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10);
/*  31 */     this.Shape1.setRotationPoint(-5.0F, -9.0F, -5.0F);
/*  32 */     this.Shape1.setTextureSize(64, 32);
/*  33 */     this.Shape1.mirror = true;
/*  34 */     this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  35 */     this.Shape2.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8);
/*  36 */     this.Shape2.setRotationPoint(-4.0F, -14.0F, -4.0F);
/*  37 */     this.Shape2.setTextureSize(64, 32);
/*  38 */     this.Shape2.mirror = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/*  45 */     if (Client.CosmeticHat) {
/*  46 */       GlStateManager.pushMatrix();
/*  47 */       float f = partialTicks;
/*     */       
/*  49 */       float f1 = getFirstRotationX(player, f);
/*  50 */       float f2 = getSecondRotationX(player, f);
/*     */       
/*  52 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  53 */       setRotationAngles(limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, (Entity)player);
/*  54 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("cap.png"));
/*  55 */       GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
/*  56 */       GlStateManager.rotate(f2, 1.0F, 0.0F, 0.0F);
/*  57 */       GlStateManager.disableLighting();
/*     */       
/*  59 */       if (player.isSneaking()) {
/*  60 */         GlStateManager.translate(0.0D, 0.26D, -0.047D);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  65 */       this.Shape1.render(scale);
/*  66 */       this.Shape2.render(scale);
/*  67 */       GlStateManager.popMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float getFirstRotationX(AbstractClientPlayer Player, float partialTicks) {
/*  75 */     float f = interpolateRotation(Player.prevRenderYawOffset, Player.renderYawOffset, partialTicks);
/*  76 */     float f1 = interpolateRotation(Player.prevRotationYawHead, Player.rotationYawHead, partialTicks);
/*  77 */     float f2 = f1 - f;
/*     */     
/*  79 */     if (Player.isRiding() && Player.ridingEntity instanceof EntityLivingBase) {
/*     */       
/*  81 */       EntityLivingBase entitylivingbase = (EntityLivingBase)Player.ridingEntity;
/*  82 */       f = interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
/*  83 */       f2 = f1 - f;
/*  84 */       float f3 = MathHelper.wrapAngleTo180_float(f2);
/*     */       
/*  86 */       if (f3 < -85.0F)
/*     */       {
/*  88 */         f3 = -85.0F;
/*     */       }
/*     */       
/*  91 */       if (f3 >= 85.0F)
/*     */       {
/*  93 */         f3 = 85.0F;
/*     */       }
/*     */       
/*  96 */       f = f1 - f3;
/*     */       
/*  98 */       if (f3 * f3 > 2500.0F)
/*     */       {
/* 100 */         float f4 = f + f3 * 0.2F;
/*     */       }
/*     */     } 
/*     */     
/* 104 */     return f2;
/*     */   }
/*     */ 
/*     */   
/*     */   private float getSecondRotationX(AbstractClientPlayer Player, float partialTicks) {
/* 109 */     return Player.prevRotationPitch + (Player.rotationPitch - Player.prevRotationPitch) * partialTicks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float interpolateRotation(float par1, float par2, float par3) {
/*     */     float f;
/* 116 */     for (f = par2 - par1; f < -180.0F; f += 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     while (f >= 180.0F)
/*     */     {
/* 123 */       f -= 360.0F;
/*     */     }
/*     */     
/* 126 */     return par1 + par3 * f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 131 */     super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */   }
/*     */ }
