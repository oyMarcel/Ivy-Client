/*     */ package clientname.cosmetics;
/*     */ 
/*     */ import clientname.Client;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticWings
/*     */   extends Cosmetic
/*     */ {
/*     */   private ModelRenderer wing;
/*     */   private ModelRenderer wingTip;
/*     */   private RenderPlayer playerRenderer;
/*     */   
/*     */   public CosmeticWings(RenderPlayer player) {
/*  25 */     super(player);
/*     */     
/*  27 */     this.playerRenderer = player;
/*  28 */     this.textureWidth = 256;
/*  29 */     this.textureHeight = 256;
/*  30 */     setTextureOffset("wing.skin", -56, 88);
/*  31 */     setTextureOffset("wing.bone", 112, 88);
/*  32 */     setTextureOffset("wingtip.skin", -56, 144);
/*  33 */     setTextureOffset("wingtip.bone", 112, 136);
/*     */     
/*  35 */     this.wing = new ModelRenderer((ModelBase)this, "wing");
/*  36 */     this.wing.setTextureSize(256, 256);
/*  37 */     this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
/*  38 */     this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
/*  39 */     this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  40 */     this.wing.isHidden = true;
/*  41 */     this.wingTip = new ModelRenderer((ModelBase)this, "wingtip");
/*  42 */     this.wingTip.setTextureSize(256, 256);
/*  43 */     this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
/*  44 */     this.wingTip.isHidden = true;
/*  45 */     this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
/*  46 */     this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  47 */     this.wing.addChild(this.wingTip);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldCombineTextures() {
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/*  59 */     if (player.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && 
/*  60 */       Client.CosmeticWings) {
/*  61 */       GlStateManager.pushMatrix();
/*  62 */       float f1 = ageInTicks / 75.0F;
/*  63 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("wings.png"));
/*     */       
/*  65 */       GlStateManager.disableLighting();
/*  66 */       GlStateManager.scale(0.16D, 0.16D, 0.16D);
/*  67 */       GlStateManager.translate(0.0D, -0.3D, 1.1D);
/*  68 */       GlStateManager.rotate(50.0F, -50.0F, 0.0F, 0.0F);
/*  69 */       GlStateManager.blendFunc(1, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  75 */       if (player.isSneaking()) {
/*  76 */         GlStateManager.translate(0.0F, 0.142F, 1.2F);
/*     */       }
/*     */       
/*  79 */       for (int i = 0; i < 2; i++) {
/*     */         
/*  81 */         float f6 = f1 * 9.141593F * 1.2F;
/*     */         
/*  83 */         this.wing.rotateAngleX = 0.125F - (float)Math.cos(f6) * 0.2F;
/*  84 */         this.wing.rotateAngleY = 0.25F;
/*  85 */         this.wing.rotateAngleZ = (float)(Math.sin(f6) + 1.225D) * 0.45F;
/*  86 */         this.wingTip.rotateAngleZ = -((float)(Math.sin((f6 + 2.0F)) + 0.5D)) * 0.95F;
/*  87 */         this.wing.isHidden = false;
/*  88 */         this.wingTip.isHidden = false;
/*  89 */         this.wing.render(scale);
/*     */         
/*  91 */         this.wing.isHidden = true;
/*  92 */         this.wingTip.isHidden = true;
/*  93 */         if (i == 0) {
/*  94 */           GlStateManager.scale(-1.0F, 1.0F, 1.0F);
/*     */         }
/*     */       } 
/*     */       
/*  98 */       GlStateManager.blendFunc(0, 0);
/*  99 */       GlStateManager.disableBlend();
/* 100 */       GlStateManager.popMatrix();
/*     */     } 
/*     */   }
/*     */ }
