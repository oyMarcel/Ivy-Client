/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.ChromaText;
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ 
/*    */ 
/*    */ public class ModToggleSpirnt
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 13 */     return font.getStringWidth("[Sprinting Toggled]");
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 18 */     return font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 23 */     if (Client.ToggleSprint)
/* 24 */       if (!Client.ChromaText) {
/*    */         
/* 26 */         this.mc.fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Sprinting Toggled" + Client.KlammerFarbe + "]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*    */       } else {
/* 28 */         ChromaText.drawChromaString("[Sprinting Toggled]", pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\mods\impl\ModToggleSpirnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */