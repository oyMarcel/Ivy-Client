/*     */ package clientname.mods.impl;
/*     */ 
/*     */ import clientname.Client;
/*     */ import clientname.gui.hud.ScreenPosition;
/*     */ import clientname.mods.ModDraggable;
/*     */ import java.util.Collection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModPotionStatus
/*     */   extends ModDraggable
/*     */ {
/*  27 */   private ScreenPosition pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/*     */   
/*     */   protected FontRenderer fontRendererObj;
/*     */   protected float zLevelFloat;
/*     */   
/*     */   public int getWidth() {
/*  33 */     return 101;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  38 */     return 154;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
/*  43 */     float f = 0.00390625F;
/*  44 */     float f1 = 0.00390625F;
/*  45 */     Tessellator tessellator = Tessellator.getInstance();
/*  46 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  47 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
/*  48 */     worldrenderer.pos((x + 0), (y + height), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
/*  49 */     worldrenderer.pos((x + width), (y + height), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
/*  50 */     worldrenderer.pos((x + width), (y + 0), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
/*  51 */     worldrenderer.pos((x + 0), (y + 0), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
/*  52 */     tessellator.draw();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/*  57 */     if (Client.ModPotionstatus) {
/*     */ 
/*     */       
/*  60 */       int offsetX = 21;
/*  61 */       int offsetY = 14;
/*  62 */       int i = 80;
/*  63 */       int i2 = 16;
/*  64 */       Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();
/*     */       
/*  66 */       if (!collection.isEmpty()) {
/*     */         
/*  68 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  69 */         GlStateManager.disableLighting();
/*  70 */         int l = 33;
/*     */ 
/*     */         
/*  73 */         if (collection.size() > 5)
/*     */         {
/*  75 */           l = 132 / (collection.size() - 1);
/*     */         }
/*     */         
/*  78 */         for (PotionEffect potioneffect : this.mc.thePlayer.getActivePotionEffects()) {
/*     */           
/*  80 */           Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
/*  81 */           GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */           
/*  83 */           if (potion.hasStatusIcon()) {
/*     */             
/*  85 */             Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
/*  86 */             int i1 = potion.getStatusIconIndex();
/*  87 */             drawTexturedModalRect(pos.getAbsoluteX() + offsetX - 20, pos.getAbsoluteY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
/*     */           } 
/*     */           
/*  90 */           String s1 = I18n.format(potion.getName(), new Object[0]);
/*  91 */           if (potioneffect.getAmplifier() == 1) {
/*     */             
/*  93 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.2", new Object[0]);
/*     */           }
/*  95 */           else if (potioneffect.getAmplifier() == 2) {
/*     */             
/*  97 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.3", new Object[0]);
/*     */           }
/*  99 */           else if (potioneffect.getAmplifier() == 3) {
/*     */             
/* 101 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.4", new Object[0]);
/*     */           } 
/*     */           
/* 104 */           font.drawString(s1, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 - offsetY), 16777215, true);
/* 105 */           String s = Potion.getDurationString(potioneffect);
/* 106 */           font.drawString(s, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 + 10 - offsetY), 8355711, true);
/* 107 */           i2 += l;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\mods\impl\ModPotionStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */