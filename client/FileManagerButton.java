/*    */ package client;
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
/*    */ public class FileManagerButton
/*    */ {
/* 14 */   private static Gson gson = new Gson();
/*    */   
/* 16 */   private static File ROOT_DIR = new File("client");
/* 17 */   public static File TOGGLE_DIR = new File(ROOT_DIR, "Toggle");
/*    */   
/*    */   public static void init() {
/* 20 */     if (!ROOT_DIR.exists()) ROOT_DIR.mkdirs(); 
/* 21 */     if (!TOGGLE_DIR.exists()) TOGGLE_DIR.mkdirs(); 
/*    */   }
/*    */   
/*    */   public static Gson getGson() {
/* 25 */     return gson;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean writeJsonToFile(File file, Object obj) {
/*    */     try {
/* 31 */       if (!file.exists()) {
/* 32 */         file.createNewFile();
/*    */       }
/*    */       
/* 35 */       FileOutputStream outputStream = new FileOutputStream(file);
/* 36 */       outputStream.write(gson.toJson(obj).getBytes());
/* 37 */       outputStream.flush();
/* 38 */       outputStream.close();
/* 39 */       return true;
/*    */     }
/* 41 */     catch (IOException e) {
/* 42 */       e.printStackTrace();
/* 43 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> T readFromJson(File file, Class<T> c) {
/*    */     try {
/* 52 */       FileInputStream fileInputStream = new FileInputStream(file);
/* 53 */       InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/* 54 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
/*    */       
/* 56 */       StringBuilder builder = new StringBuilder();
/*    */       
/*    */       String line;
/* 59 */       while ((line = bufferedReader.readLine()) != null) {
/* 60 */         builder.append(line);
/*    */       }
/*    */       
/* 63 */       bufferedReader.close();
/* 64 */       inputStreamReader.close();
/* 65 */       fileInputStream.close();
/*    */       
/* 67 */       return (T)gson.fromJson(builder.toString(), c);
/*    */     
/*    */     }
/* 70 */     catch (IOException e) {
/* 71 */       e.printStackTrace();
/* 72 */       return null;
/*    */     } 
/*    */   }
/*    */ }
