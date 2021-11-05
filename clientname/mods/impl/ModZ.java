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
/*    */ public class ModZ
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 15 */     return 38;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 20 */     return 10;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 25 */     if (Client.ModPosition)
/* 26 */       if (!Client.ChromaText) {
/*    */ 
/*    */         
/* 29 */         GlStateManager.pushMatrix();
/* 30 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Z" + Client.KlammerFarbe + "] " + (Math.round((Minecraft.getMinecraft()).thePlayer.posZ * 1000.0D) / 1000L), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/* 31 */         GlStateManager.popMatrix();
/*    */       } else {
/*    */         
/* 34 */         ChromaText.drawChromaString("[Z] " + (Math.round((Minecraft.getMinecraft()).thePlayer.posZ * 1000.0D) / 1000L), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }
