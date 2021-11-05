/*     */ package clientname.cosmetics;
/*     */ 
/*     */ import clientname.cosmetics.util.CosmeticBase;
/*     */ import clientname.cosmetics.util.CosmeticModelBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticCrystalWings
/*     */   extends CosmeticBase
/*     */ {
/*     */   private CrytsalWingsModel crytsalWingsModel;
/*     */   
/*     */   public CosmeticCrystalWings(RenderPlayer playerRenderer) {
/*  24 */     super(playerRenderer);
/*  25 */     this.crytsalWingsModel = new CrytsalWingsModel(playerRenderer);
/*     */   }
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/*  29 */     this.crytsalWingsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, headPitch, headPitch, scale);
/*     */   }
/*     */   
/*     */   public class CrytsalWingsModel
/*     */     extends CosmeticModelBase {
/*     */     private ModelRenderer model;
/*  35 */     ResourceLocation resourceLocation = new ResourceLocation("crystalwings.png");
/*     */     
/*     */     public CrytsalWingsModel(RenderPlayer player) {
/*  38 */       super(player);
/*  39 */       int i = 30;
/*  40 */       int j = 24;
/*  41 */       this.model = (new ModelRenderer((ModelBase)this)).setTextureSize(i, j).setTextureOffset(0, 8);
/*  42 */       this.model.setRotationPoint(-0.0F, 1.0F, 0.0F);
/*  43 */       this.model.addBox(0.0F, -3.0F, 0.0F, 14, 7, 1);
/*  44 */       this.model.isHidden = true;
/*  45 */       ModelRenderer modelrenderer = (new ModelRenderer((ModelBase)this)).setTextureSize(i, j).setTextureOffset(0, 16);
/*  46 */       modelrenderer.setRotationPoint(-0.0F, 0.0F, 0.2F);
/*  47 */       modelrenderer.addBox(0.0F, -3.0F, 0.0F, 14, 7, 1);
/*  48 */       this.model.addChild(modelrenderer);
/*  49 */       ModelRenderer modelrenderer1 = (new ModelRenderer((ModelBase)this)).setTextureSize(i, j).setTextureOffset(0, 0);
/*  50 */       modelrenderer1.setRotationPoint(-0.0F, 0.0F, 0.2F);
/*  51 */       modelrenderer1.addBox(0.0F, -3.0F, 0.0F, 14, 7, 1);
/*  52 */       modelrenderer.addChild(modelrenderer1);
/*     */     }
/*     */     
/*     */     public void render(Entity entityIn, float p_78088_2_, float walkingSpeed, float tickValue, float p_78088_5_, float p_78088_6_, float scale) {
/*  56 */       float f = (float)Math.cos((tickValue / 10.0F)) / 20.0F - 0.03F - walkingSpeed / 20.0F;
/*  57 */       ModelRenderer modelrenderer = this.model.childModels.get(0);
/*  58 */       ModelRenderer modelrenderer1 = modelrenderer.childModels.get(0);
/*  59 */       this.model.rotateAngleZ = f * 3.0F;
/*  60 */       modelrenderer.rotateAngleZ = f / 2.0F;
/*  61 */       modelrenderer1.rotateAngleZ = f / 2.0F;
/*  62 */       this.model.rotateAngleY = -0.3F - walkingSpeed / 3.0F;
/*  63 */       this.model.rotateAngleX = 0.3F;
/*  64 */       GlStateManager.pushMatrix();
/*  65 */       GlStateManager.scale(1.6D, 1.6D, 1.0D);
/*  66 */       GlStateManager.translate(0.0D, 0.05000000074505806D, 0.05000000074505806D);
/*  67 */       if (entityIn.isSneaking()) {
/*  68 */         GlStateManager.translate(0.0D, 0.07999999821186066D, 0.029999999329447746D);
/*  69 */         GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
/*  70 */         this.model.rotateAngleZ = 0.8F;
/*  71 */         modelrenderer.rotateAngleZ = 0.0F;
/*  72 */         modelrenderer1.rotateAngleZ = 0.0F;
/*     */       } else {
/*  74 */         RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/*  75 */         if (rendermanager != null)
/*  76 */           GlStateManager.rotate(rendermanager.playerViewX / 3.0F, 1.0F, 0.0F, 0.0F); 
/*     */       } 
/*  78 */       this.model.isHidden = false;
/*  79 */       for (int i = -1; i <= 1; i += 2) {
/*  80 */         GlStateManager.pushMatrix();
/*  81 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.3F);
/*  82 */         GlStateManager.depthMask(false);
/*  83 */         GlStateManager.enableBlend();
/*  84 */         GlStateManager.blendFunc(770, 771);
/*  85 */         GlStateManager.alphaFunc(516, 0.003921569F);
/*  86 */         GlStateManager.disableLighting();
/*     */ 
/*     */         
/*  89 */         GlStateManager.color(0.0F, 0.0F, 0.0F);
/*     */         
/*  91 */         Minecraft.getMinecraft().getTextureManager().bindTexture(this.resourceLocation);
/*  92 */         if (i == 1)
/*  93 */           GlStateManager.scale(-1.0F, 1.0F, 1.0F); 
/*  94 */         GlStateManager.translate(0.05D, 0.0D, 0.0D);
/*  95 */         this.model.render(scale);
/*  96 */         GlStateManager.disableBlend();
/*  97 */         GlStateManager.alphaFunc(516, 0.1F);
/*  98 */         GlStateManager.popMatrix();
/*  99 */         GlStateManager.depthMask(true);
/*     */       } 
/* 101 */       this.model.isHidden = true;
/* 102 */       GlStateManager.popMatrix();
/*     */     }
/*     */   }
/*     */ }

