/*    */ package clientname.gui.hud;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ public class ScreenPosition
/*    */ {
/*  8 */   private static final Minecraft mc = Minecraft.getMinecraft();
/*    */   private int x;
/*    */   private int y;
/*    */   
/*    */   public ScreenPosition(double x, double y) {
/* 13 */     setRelative(x, y);
/*    */   }
/*    */   
/*    */   public ScreenPosition(int x, int y) {
/* 17 */     setAbsolute(x, y);
/*    */   }
/*    */   
/*    */   public static ScreenPosition fromRelativePosition(double x, double y) {
/* 21 */     return new ScreenPosition(x, y);
/*    */   }
/*    */   
/*    */   public static ScreenPosition fromAbsolute(int x, int y) {
/* 25 */     return new ScreenPosition(x, y);
/*    */   }
/*    */   
/*    */   public int getAbsoluteX() {
/* 29 */     ScreenResolution resolution = new ScreenResolution(mc);
/* 30 */     return this.x;
/*    */   }
/*    */   
/*    */   public int getAbsoluteY() {
/* 34 */     ScreenResolution resolution = new ScreenResolution(mc);
/* 35 */     return this.y;
/*    */   }
/*    */   
/*    */   public double getRelativeX() {
/* 39 */     ScreenResolution res = new ScreenResolution(mc);
/* 40 */     return (int)(this.x / res.getScaledWidth_double());
/*    */   }
/*    */   
/*    */   public double getRelativeY() {
/* 44 */     ScreenResolution res = new ScreenResolution(mc);
/* 45 */     return (int)(this.y / res.getScaledHeight_double());
/*    */   }
/*    */   
/*    */   public void setAbsolute(int x, int y) {
/* 49 */     this.x = x;
/* 50 */     this.y = y;
/*    */   }
/*    */   
/*    */   public void setRelative(double x, double y) {
/* 54 */     ScreenResolution res = new ScreenResolution(mc);
/*    */     
/* 56 */     this.x = (int)(x / res.getScaledWidth());
/* 57 */     this.y = (int)(y / res.getScaledHeight());
/* 58 */     System.err.println(x);
/* 59 */     System.out.println(y);
/*    */   }
/*    */ }
