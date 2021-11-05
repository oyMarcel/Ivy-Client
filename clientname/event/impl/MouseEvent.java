/*    */ package clientname.event.impl;
/*    */ 
/*    */ import clientname.event.EventCancelable;
/*    */ import org.lwjgl.input.Mouse;
 
/*    */ public class MouseEvent
/*    */   extends EventCancelable
/*    */ {
/* 20 */   public final int x = Mouse.getEventX();
/* 21 */   public final int y = Mouse.getEventY();
/* 22 */   public final int dx = Mouse.getEventDX();
/* 23 */   public final int dy = Mouse.getEventDY();
/* 24 */   public final int dwheel = Mouse.getEventDWheel();
/* 25 */   public final int button = Mouse.getEventButton();
/* 26 */   public final boolean buttonstate = Mouse.getEventButtonState();
/* 27 */   public final long nanoseconds = Mouse.getEventNanoseconds();
/*    */ }
