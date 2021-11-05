/*    */ package clientname;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class ModToggle
/*    */ {
/*    */   public static File getFolder(String mod) {
/*  8 */     File file = new File(FileManager.MODS_DIR, mod);
/*  9 */     file.mkdirs();
/* 10 */     return file;
/*    */   }
/*    */   
/*    */   public static void saveIsEnabledToFile(String mod, Boolean b) {
/* 14 */     FileManager.writeJsonToFile(new File(getFolder(mod), "Enabled.json"), b);
/*    */   }
/*    */   public static Boolean loadEnabledFromFile(String mod) {
/* 17 */     Boolean b = FileManager.<Boolean>readFromJson(new File(getFolder(mod), "Enabled.json"), Boolean.class);
/*    */     
/* 19 */     if (b == null) {
/* 20 */       b = Boolean.valueOf(false);
/* 21 */       saveIsEnabledToFile(mod, b);
/*    */     } 
/* 23 */     return b;
/*    */   }
/*    */ }
