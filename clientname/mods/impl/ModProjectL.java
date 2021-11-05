/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.event.EventTarget;
/*    */ import clientname.event.impl.MouseEvent;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModProjectL
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 16 */     return font.getStringWidth("");
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 21 */     return font.FONT_HEIGHT;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onMouse(MouseEvent event) {
/* 26 */     if (isEnabled() && (event.dx != 0 || event.dy != 0)) {
/* 27 */       EntityPlayerSP entity = (Minecraft.getMinecraft()).thePlayer;
/*    */       
/* 29 */       if (entity != null) {
/* 30 */         entity.prevRenderYawOffset = entity.renderYawOffset;
/* 31 */         entity.prevRotationYawHead = entity.rotationYawHead;
/* 32 */         entity.prevRotationYaw = entity.rotationYaw;
/* 33 */         entity.prevRotationPitch = entity.rotationPitch;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 40 */     font.drawString("", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Mircea\AppData\Roaming\.minecraft\versions\Ivy Client\Ivy Client.jar!\clientname\mods\impl\ModProjectL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */