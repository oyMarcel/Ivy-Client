/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.ChromaText;
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ 
/*    */ public class ModTimeShow
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 16 */     return font.getStringWidth("Time: AA:AA:AA AA ");
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 21 */     return font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 26 */     if (Client.ModTimeShow)
/* 27 */       if (!Client.ChromaText) {
/* 28 */         String pattern = "hh:mm:ss a ";
/* 29 */         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
/* 30 */         String time = simpleDateFormat.format(new Date());
/*    */         
/* 32 */         GlStateManager.pushMatrix();
/* 33 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Time" + Client.KlammerFarbe + "] " + time, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/* 34 */         GlStateManager.popMatrix();
/*    */       } else {
/*    */         
/* 37 */         String pattern = "hh:mm:ss a ";
/* 38 */         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
/* 39 */         String time = simpleDateFormat.format(new Date());
/* 40 */         ChromaText.drawChromaString("[Time] " + time, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\mods\impl\ModTimeShow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */