/*     */ package clientname.cosmetics;
/*     */ 
/*     */ import clientname.Client;
/*     */ import clientname.cosmetics.util.CosmeticBase;
/*     */ import clientname.cosmetics.util.CosmeticModelBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticHalo
/*     */   extends CosmeticBase
/*     */ {
/*     */   private final HaloRenderer haloModel;
/*     */   
/*     */   public CosmeticHalo(RenderPlayer renderPlayer) {
/*  44 */     super(renderPlayer);
/*  45 */     this.haloModel = new HaloRenderer(renderPlayer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/*  50 */     GL11.glPushMatrix();
/*  51 */     if (player.isSneaking()) {
/*  52 */       GlStateManager.translate(0.0D, 0.225D, 0.0D);
/*     */     }
/*  54 */     if (Client.CosmeticHalo) {
/*  55 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Halo.png"));
/*     */       
/*  57 */       GlStateManager.color(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */       
/*  60 */       this.haloModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*     */     } 
/*     */     
/*  63 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public class HaloRenderer
/*     */     extends CosmeticModelBase
/*     */   {
/*     */     ModelRenderer head;
/*     */     
/*     */     ModelRenderer body;
/*     */     
/*     */     ModelRenderer rightarm;
/*     */     ModelRenderer leftarm;
/*     */     ModelRenderer rightleg;
/*     */     ModelRenderer leftleg;
/*     */     ModelRenderer Shape1;
/*     */     ModelRenderer Shape2;
/*     */     ModelRenderer Shape3;
/*     */     ModelRenderer Shape4;
/*     */     ModelRenderer Shape6;
/*     */     
/*     */     public HaloRenderer(RenderPlayer player) {
/*  85 */       super(player);
/*     */       
/*  87 */       this.textureWidth = 64;
/*  88 */       this.textureHeight = 32;
/*     */       
/*  90 */       this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  91 */       this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
/*  92 */       this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  93 */       this.Shape1.setTextureSize(64, 32);
/*  94 */       this.Shape1.mirror = true;
/*     */       
/*  96 */       this.Shape2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  97 */       this.Shape2.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
/*  98 */       this.Shape2.setRotationPoint(-3.0F, -11.0F, -4.0F);
/*  99 */       this.Shape2.setTextureSize(64, 32);
/* 100 */       this.Shape2.mirror = true;
/*     */       
/* 102 */       this.Shape3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 103 */       this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
/* 104 */       this.Shape3.setRotationPoint(-4.0F, -11.0F, -3.0F);
/* 105 */       this.Shape3.setTextureSize(64, 32);
/* 106 */       this.Shape3.mirror = true;
/*     */       
/* 108 */       this.Shape4 = new ModelRenderer((ModelBase)this, 0, 0);
/* 109 */       this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6);
/* 110 */       this.Shape4.setRotationPoint(3.0F, -11.0F, -3.0F);
/* 111 */       this.Shape4.setTextureSize(64, 32);
/* 112 */       this.Shape4.mirror = true;
/*     */ 
/*     */ 
/*     */       
/* 116 */       this.Shape6 = new ModelRenderer((ModelBase)this, 0, 0);
/* 117 */       this.Shape6.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
/* 118 */       this.Shape6.setRotationPoint(-3.0F, -11.0F, 3.0F);
/* 119 */       this.Shape6.setTextureSize(64, 32);
/* 120 */       this.Shape6.mirror = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 132 */       if (entityIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
/* 133 */         GlStateManager.pushMatrix();
/*     */ 
/*     */ 
/*     */         
/* 137 */         float f1 = ageInTicks / 100.0F;
/* 138 */         float f6 = f1 * 3.1415927F + 1.0F;
/* 139 */         GlStateManager.translate(0.0F, -((float)(Math.sin((f6 + 1.0F)) + 0.5D)) * 0.08F, 0.0F);
/* 140 */         this.Shape1.render(scale);
/* 141 */         this.Shape2.render(scale);
/* 142 */         this.Shape3.render(scale);
/* 143 */         this.Shape4.render(scale);
/*     */         
/* 145 */         this.Shape6.render(scale);
/*     */         
/* 147 */         GlStateManager.popMatrix();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }
