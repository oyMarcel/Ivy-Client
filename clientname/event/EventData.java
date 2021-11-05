/*    */ package clientname.event;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ 
/*    */ public class EventData
/*    */ {
/*    */   public final Object source;
/*    */   public final Method target;
/*    */   public final byte priority;
/*    */   
/*    */   public EventData(Object source, Method target, byte priority) {
/* 13 */     this.source = source;
/* 14 */     this.target = target;
/* 15 */     this.priority = priority;
/*    */   }
/*    */ }
