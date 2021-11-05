/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.ChromaText;
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModFPS
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 19 */     return 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 24 */     return font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 29 */     if (Client.ModFPS)
/* 30 */       if (!Client.ChromaText) {
/*    */ 
/*    */         
/* 33 */         GlStateManager.pushMatrix();
/* 34 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "FPS" + Client.KlammerFarbe + "] " + Minecraft.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/* 35 */         GlStateManager.popMatrix();
/*    */       } else {
/*    */         
/* 38 */         ChromaText.drawChromaString("[FPS] " + Minecraft.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }
