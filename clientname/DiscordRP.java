/*    */ package clientname;
/*    */ 
/*    */ import net.arikia.dev.drpc.DiscordEventHandlers;
/*    */ import net.arikia.dev.drpc.DiscordRPC;
/*    */ import net.arikia.dev.drpc.DiscordRichPresence;
/*    */ import net.arikia.dev.drpc.DiscordUser;
/*    */ import net.arikia.dev.drpc.callbacks.ReadyCallback;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class DiscordRP
/*    */ {
/*    */   private boolean running = true;
/* 13 */   private long created = 0L;
/*    */   
/*    */   private Minecraft mc;
/*    */   
/*    */   public void start() {
/* 18 */     this.created = System.currentTimeMillis();
/*    */     
/* 20 */     DiscordEventHandlers handlers = (new DiscordEventHandlers.Builder()).setReadyEventHandler(new ReadyCallback()
/*    */         {
/*    */           public void apply(DiscordUser user)
/*    */           {
/* 24 */             System.out.println("Willkommen" + user.username + "#" + user.discriminator);
/* 25 */             DiscordRP.this.update("", "");
/*    */           }
/* 28 */         }).build();
/* 29 */     DiscordRPC.discordInitialize(Client.DiscordID, handlers, true);
/*    */     
/* 31 */     (new Thread("Discord RPC Callback")
/*    */       {
/*    */         public void run()
/*    */         {
/* 35 */           while (DiscordRP.this.running) {
/* 36 */             DiscordRPC.discordRunCallbacks();
/*    */           
/*    */           }
/*    */         }
/* 40 */       }).start();
/*    */     
/* 42 */     if (!this.running) {
/* 43 */       this.mc.shutdown();
/*    */     }
/*    */   }
/*    */   
/*    */   public void shutdown() {
/* 48 */     this.running = false;
/* 49 */     DiscordRPC.discordShutdown();
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(String firstLine, String secondLine) {
/* 54 */     DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
/* 55 */     if (b != null) {
/* 56 */       b.setBigImage("large", "");
/* 57 */       b.setDetails(firstLine);
/* 58 */       b.setStartTimestamps(this.created);
/*    */       
/* 60 */       DiscordRPC.discordUpdatePresence(b.build());
/*    */     } else {
/* 62 */       System.exit(0);
/*    */     } 
/*    */   }
/*    */ }

