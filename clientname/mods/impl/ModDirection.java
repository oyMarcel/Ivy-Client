/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ModDirection
/*    */   extends ModDraggable {
/*    */   protected static ScaledResolution scaledResolution;
/* 13 */   public static String markerColor = "c";
/* 14 */   public static int compassIndex = 0;
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 18 */     return 102;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 23 */     return 15;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 29 */     int direction = MathHelper.floor_double((this.mc.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 0xFF;
/* 30 */     int yBase = getY(1, 12);
/* 31 */     int xBase = getX(65);
/*    */     
/* 33 */     this.mc.getTextureManager().bindTexture(new ResourceLocation("Direction.png"));
/* 34 */     if (direction < 128) {
/* 35 */       Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, compassIndex * 24, 100, 13);
/*    */     } else {
/* 37 */       Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, compassIndex * 24 + 12, 100, 13);
/*    */     } 
/*    */     
/* 40 */     this.mc.fontRendererObj.drawString("§" + markerColor.toLowerCase() + "|§r", pos.getAbsoluteX() + xBase - 16, pos.getAbsoluteY() + yBase - 7, 16777215);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 47 */     int direction = MathHelper.floor_double((this.mc.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 0xFF;
/* 48 */     int yBase = getY(1, 12);
/* 49 */     int xBase = getX(65);
/*    */     
/* 51 */     this.mc.getTextureManager().bindTexture(new ResourceLocation("Direction.png"));
/* 52 */     if (direction < 128) {
/* 53 */       Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, compassIndex * 24, 100, 13);
/*    */     } else {
/* 55 */       Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, compassIndex * 24 + 12, 100, 13);
/*    */     } 
/*    */     
/* 58 */     this.mc.fontRendererObj.drawString("§" + markerColor.toLowerCase() + "|§r", pos.getAbsoluteX() + xBase - 16, pos.getAbsoluteY() + yBase - 7, 16777215);
/*    */   }
/*    */ 
/*    */   
/*    */   private static int getX(int width) {
/* 63 */     return width;
/*    */   }
/*    */   
/*    */   private static int getY(int rowCount, int height) {
/* 67 */     return height;
/*    */   }
/*    */   
/*    */   public enum Direction {
/* 71 */     S,
/* 72 */     SW,
/* 73 */     W,
/* 74 */     NW,
/* 75 */     N,
/* 76 */     NE,
/* 77 */     E,
/* 78 */     SE;
/*    */   }
/*    */ }
