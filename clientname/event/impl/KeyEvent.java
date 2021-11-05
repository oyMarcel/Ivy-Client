/*    */ package clientname.event.impl;
/*    */ 
/*    */ import clientname.event.EventCancelable;
/*    */ 
/*    */ public class KeyEvent
/*    */   extends EventCancelable {
/*    */   private final int key;
/*    */   
/*    */   public KeyEvent(int key) {
/* 10 */     this.key = key;
/*    */   }
/*    */   
/*    */   public int getKey() {
/* 14 */     return this.key;
/*    */   }
/*    */ }
