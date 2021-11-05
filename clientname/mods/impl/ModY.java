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
/*    */ public class ModY
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
/* 30 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Y" + Client.KlammerFarbe + "] " + (Math.round((Minecraft.getMinecraft()).thePlayer.posY * 1000.0D) / 1000L), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/* 31 */         GlStateManager.popMatrix();
/*    */       } else {
/*    */         
/* 34 */         ChromaText.drawChromaString("[Y] " + (Math.round((Minecraft.getMinecraft()).thePlayer.posY * 1000.0D) / 1000L), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\mods\impl\ModY.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */