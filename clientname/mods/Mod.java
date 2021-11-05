/*    */ package clientname.mods;
/*    */ 
/*    */ import clientname.Client;
/*    */ import clientname.event.EventManager;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ 
/*    */ 
/*    */ public class Mod
/*    */ {
/*    */   private boolean isEnabled = true;
/*    */   protected final Minecraft mc;
/*    */   protected static FontRenderer font;
/*    */   protected final Client client;
/*    */   
/*    */   public Mod() {
/* 17 */     this.mc = Minecraft.getMinecraft();
/* 18 */     font = this.mc.fontRendererObj;
/* 19 */     this.client = Client.getInstance();
/*    */     
/* 21 */     setEnabled(this.isEnabled);
/*    */   }
/*    */   
/*    */   private void setEnabled(boolean isEnabled) {
/* 25 */     this.isEnabled = isEnabled;
/*    */     
/* 27 */     if (isEnabled) {
/* 28 */       EventManager.register(this);
/*    */     } else {
/*    */       
/* 31 */       EventManager.unregister(this);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 37 */     return this.isEnabled;
/*    */   }
/*    */ }
