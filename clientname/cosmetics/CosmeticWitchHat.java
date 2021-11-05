/*     */ package clientname.cosmetics;
/*     */ 
/*     */ import clientname.Client;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticWitchHat
/*     */   extends Cosmetic
/*     */ {
/*     */   public ModelRenderer witchHat;
/*  20 */   private final ResourceLocation witchTextures = new ResourceLocation("textures/entity/witch.png");
/*     */   
/*     */   public CosmeticWitchHat(RenderPlayer player) {
/*  23 */     super(player);
/*     */ 
/*     */     
/*  26 */     this.witchHat = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  27 */     this.witchHat.setRotationPoint(-5.0F, -10.03125F, -5.0F);
/*  28 */     this.witchHat.setTextureOffset(0, 64).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
/*  29 */     ModelRenderer modelrenderer = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  30 */     modelrenderer.setRotationPoint(1.75F, -4.0F, 2.0F);
/*  31 */     modelrenderer.setTextureOffset(0, 76).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
/*  32 */     modelrenderer.rotateAngleX = -0.05235988F;
/*  33 */     modelrenderer.rotateAngleZ = 0.02617994F;
/*  34 */     this.witchHat.addChild(modelrenderer);
/*  35 */     ModelRenderer modelrenderer1 = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  36 */     modelrenderer1.setRotationPoint(1.75F, -4.0F, 2.0F);
/*  37 */     modelrenderer1.setTextureOffset(0, 87).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
/*  38 */     modelrenderer1.rotateAngleX = -0.10471976F;
/*  39 */     modelrenderer1.rotateAngleZ = 0.05235988F;
/*  40 */     modelrenderer.addChild(modelrenderer1);
/*  41 */     ModelRenderer modelrenderer2 = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  42 */     modelrenderer2.setRotationPoint(1.75F, -2.0F, 2.0F);
/*  43 */     modelrenderer2.setTextureOffset(0, 95).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
/*  44 */     modelrenderer2.rotateAngleX = -0.20943952F;
/*  45 */     modelrenderer2.rotateAngleZ = 0.10471976F;
/*  46 */     modelrenderer1.addChild(modelrenderer2);
/*  47 */     this.witchHat.isHidden = true;
/*  48 */     this.playerModel.bipedHead.addChild(this.witchHat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/*  54 */     if (player.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && 
/*  55 */       Client.CosmeticWitchHat) {
/*  56 */       GlStateManager.pushMatrix();
/*     */       
/*  58 */       float f = partialTicks;
/*     */       
/*  60 */       float f1 = getFirstRotationX(player, f);
/*  61 */       float f2 = getSecondRotationX(player, f);
/*     */       
/*  63 */       Minecraft.getMinecraft().getTextureManager().bindTexture(this.witchTextures);
/*     */ 
/*     */       
/*  66 */       if (player.isSneaking()) {
/*  67 */         GlStateManager.translate(0.0F, 0.27F, 0.0F);
/*     */       }
/*  69 */       GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
/*  70 */       GlStateManager.rotate(f2, 1.0F, 0.0F, 0.0F);
/*  71 */       this.witchHat.isHidden = false;
/*  72 */       this.witchHat.render(scale);
/*  73 */       this.witchHat.isHidden = true;
/*  74 */       GlStateManager.popMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float getFirstRotationX(AbstractClientPlayer Player, float partialTicks) {
/*  81 */     float f = interpolateRotation(Player.prevRenderYawOffset, Player.renderYawOffset, partialTicks);
/*  82 */     float f1 = interpolateRotation(Player.prevRotationYawHead, Player.rotationYawHead, partialTicks);
/*  83 */     float f2 = f1 - f;
/*     */     
/*  85 */     if (Player.isRiding() && Player.ridingEntity instanceof EntityLivingBase) {
/*     */       
/*  87 */       EntityLivingBase entitylivingbase = (EntityLivingBase)Player.ridingEntity;
/*  88 */       f = interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
/*  89 */       f2 = f1 - f;
/*  90 */       float f3 = MathHelper.wrapAngleTo180_float(f2);
/*     */       
/*  92 */       if (f3 < -85.0F)
/*     */       {
/*  94 */         f3 = -85.0F;
/*     */       }
/*     */       
/*  97 */       if (f3 >= 85.0F)
/*     */       {
/*  99 */         f3 = 85.0F;
/*     */       }
/*     */       
/* 102 */       f = f1 - f3;
/*     */       
/* 104 */       if (f3 * f3 > 2500.0F)
/*     */       {
/* 106 */         float f4 = f + f3 * 0.2F;
/*     */       }
/*     */     } 
/*     */     
/* 110 */     return f2;
/*     */   }
/*     */ 
/*     */   
/*     */   private float getSecondRotationX(AbstractClientPlayer Player, float partialTicks) {
/* 115 */     return Player.prevRotationPitch + (Player.rotationPitch - Player.prevRotationPitch) * partialTicks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float interpolateRotation(float par1, float par2, float par3) {
/*     */     float f;
/* 122 */     for (f = par2 - par1; f < -180.0F; f += 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     while (f >= 180.0F)
/*     */     {
/* 129 */       f -= 360.0F;
/*     */     }
/*     */     
/* 132 */     return par1 + par3 * f;
/*     */   }
/*     */ }

