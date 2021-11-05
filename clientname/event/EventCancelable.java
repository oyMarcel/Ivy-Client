/*    */ package clientname.event;
/*    */ 
/*    */ public class EventCancelable
/*    */   extends Event {
/*    */   private boolean cancelled = false;
/*    */   
/*    */   public boolean isCancelled() {
/*  8 */     return this.cancelled;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancelled) {
/* 12 */     this.cancelled = cancelled;
/*    */   }
/*    */ }
