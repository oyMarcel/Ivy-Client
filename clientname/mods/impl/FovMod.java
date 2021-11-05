/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.ChromaText;
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FovMod
/*    */   extends ModDraggable
/*    */ {
/* 17 */   private static float savedFOV = 0.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 23 */     return font.getStringWidth("[DynamicFov On]");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 29 */     return font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 36 */     if (Client.DynamicFOV) {
/* 37 */       if (!Client.ChromaText) {
/* 38 */         font.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "DynamicFov On" + Client.KlammerFarbe + "]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*    */       } else {
/* 40 */         ChromaText.drawChromaString("DynamicFov On", pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       } 
/* 42 */       savedFOV = (Minecraft.getMinecraft()).gameSettings.fovSetting;
/* 43 */       if (this.mc.thePlayer.isSprinting()) {
/* 44 */         (Minecraft.getMinecraft()).gameSettings.fovSetting = savedFOV;
/*    */       }
/* 46 */       else if (this.mc.thePlayer.isPotionActive(1)) {
/* 47 */         (Minecraft.getMinecraft()).gameSettings.fovSetting = savedFOV;
/*    */       }
/* 49 */       else if (this.mc.thePlayer.capabilities.isFlying) {
/* 50 */         (Minecraft.getMinecraft()).gameSettings.fovSetting = savedFOV;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }
