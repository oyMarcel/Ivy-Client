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
/*    */ public class ModPing
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 15 */     return font.getStringWidth("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo((Minecraft.getMinecraft()).thePlayer.getUniqueID()).getResponseTime());
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 20 */     return font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 25 */     if (Client.ModPing)
/* 26 */       if (!Client.ChromaText) {
/*    */         
/* 28 */         GlStateManager.pushMatrix();
/* 29 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Ping" + Client.KlammerFarbe + "] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo((Minecraft.getMinecraft()).thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/* 30 */         GlStateManager.popMatrix();
/*    */       }
/*    */       else {
/*    */         
/* 34 */         ChromaText.drawChromaString("[Ping] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo((Minecraft.getMinecraft()).thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }
