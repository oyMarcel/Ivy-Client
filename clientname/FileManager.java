/*    */ package clientname;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ 
/*    */ 
/*    */ public class FileManager
/*    */ {
/* 14 */   private static Gson gson = new Gson();
/*    */   
/* 16 */   private static File ROOT_DIR = new File("Vorkss Client");
/* 17 */   static File MODS_DIR = new File(ROOT_DIR, "Mods");
/*    */ 
/*    */   
/*    */   public static void init() {
/* 21 */     if (!ROOT_DIR.exists()) ROOT_DIR.mkdirs(); 
/* 22 */     if (!MODS_DIR.exists()) MODS_DIR.mkdirs(); 
/*    */   }
/*    */   
/*    */   public static Gson getGson() {
/* 26 */     return gson;
/*    */   }
/*    */   
/*    */   public static File getModsDirectory() {
/* 30 */     return MODS_DIR;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean writeJsonToFile(File file, Object obj) {
/*    */     try {
/* 37 */       if (!file.exists()) {
/* 38 */         file.createNewFile();
/*    */       }
/*    */       
/* 41 */       FileOutputStream outputStream = new FileOutputStream(file);
/* 42 */       outputStream.write(gson.toJson(obj).getBytes());
/* 43 */       outputStream.flush();
/* 44 */       outputStream.close();
/* 45 */       return true;
/*    */     
/*    */     }
/* 48 */     catch (IOException e) {
/* 49 */       e.printStackTrace();
/* 50 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> T readFromJson(File file, Class<T> c) {
/*    */     try {
/* 58 */       FileInputStream fileInputStream = new FileInputStream(file);
/* 59 */       InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/* 60 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
/*    */       
/* 62 */       StringBuilder builder = new StringBuilder();
/*    */       
/*    */       String line;
/* 65 */       while ((line = bufferedReader.readLine()) != null) {
/* 66 */         builder.append(line);
/*    */       }
/*    */       
/* 69 */       bufferedReader.close();
/* 70 */       inputStreamReader.close();
/* 71 */       fileInputStream.close();
/*    */       
/* 73 */       return (T)gson.fromJson(builder.toString(), c);
/*    */     
/*    */     }
/* 76 */     catch (IOException e) {
/* 77 */       e.printStackTrace();
/* 78 */       return null;
/*    */     } 
/*    */   }
/*    */ }
