/*    */ package clientname.gui.hud;
/*    */ 
/*    */ public interface IRenderer
/*    */   extends IRenderConfig
/*    */ {
/*    */   int getWidth();
/*    */   
/*    */   int getHeight();
/*    */   
/*    */   void render(ScreenPosition paramScreenPosition);
/*    */   
/*    */   default void renderDummy(ScreenPosition pos) {
/* 13 */     render(pos);
/*    */   }
/*    */   
/*    */   default boolean isEnabled() {
/* 17 */     return true;
/*    */   }
/*    */ }
