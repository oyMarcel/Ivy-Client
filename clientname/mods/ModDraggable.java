/*    */ package clientname.mods;
/*    */ 
/*    */ import clientname.FileManager;
/*    */ import clientname.gui.hud.IRenderer;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ModDraggable
/*    */   extends Mod
/*    */   implements IRenderer
/*    */ {
/* 14 */   protected ScreenPosition pos = loadPositionFromFile();
/*    */ 
/*    */ 
/*    */   
/*    */   public ScreenPosition load() {
/* 19 */     return this.pos;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(ScreenPosition pos) {
/* 24 */     this.pos = pos;
/* 25 */     savePositionToFile();
/*    */   }
/*    */   
/*    */   private File getFolder() {
/* 29 */     File folder = new File(FileManager.getModsDirectory(), getClass().getSimpleName());
/* 30 */     if (!folder.exists()) {
/* 31 */       folder.mkdirs();
/*    */     }
/* 33 */     return folder;
/*    */   }
/*    */   
/*    */   private void savePositionToFile() {
/* 37 */     FileManager.writeJsonToFile(new File(getFolder(), "pos.json"), this.pos);
/*    */   }
/*    */   
/*    */   private ScreenPosition loadPositionFromFile() {
/* 41 */     ScreenPosition loaded = (ScreenPosition)FileManager.readFromJson(new File(getFolder(), "pos.json"), ScreenPosition.class);
/*    */     
/* 43 */     if (loaded == null) {
/* 44 */       loaded = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/* 45 */       this.pos = loaded;
/* 46 */       savePositionToFile();
/*    */     } 
/*    */     
/* 49 */     return loaded;
/*    */   }
/*    */   
/*    */   public final int getLineOffset(ScreenPosition pos, int lineNum) {
/* 53 */     return pos.getAbsoluteY() + getLineOffset(lineNum);
/*    */   }
/*    */   
/*    */   private int getLineOffset(int lineNum) {
/* 57 */     return (font.FONT_HEIGHT + 3) * lineNum;
/*    */   }
/*    */ }
