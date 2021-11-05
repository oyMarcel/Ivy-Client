/*    */ package clientname.cosmetics.util;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnimatedResourceLocation
/*    */ {
/*    */   private String location;
/*    */   protected int frames;
/*    */   protected int fpt;
/* 13 */   protected int currentTick = 0;
/* 14 */   protected int currentFrame = 0;
/*    */   
/*    */   protected ResourceLocation[] textures;
/*    */   
/*    */   public AnimatedResourceLocation(String location, int frames, int fpt) {
/* 19 */     this.location = location;
/* 20 */     this.frames = frames;
/* 21 */     this.fpt = fpt;
/* 22 */     this.textures = new ResourceLocation[frames];
/*    */     
/* 24 */     for (int i = 0; i < frames; i++) {
/* 25 */       this.textures[i] = new ResourceLocation(String.valueOf(location) + "/" + i + ".png");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 31 */     if (this.currentTick > this.fpt) {
/* 32 */       this.currentTick = 0;
/* 33 */       this.currentFrame++;
/* 34 */       if (this.currentFrame > this.frames - 1) {
/* 35 */         this.currentFrame = 0;
/*    */       }
/*    */     } 
/* 38 */     this.currentTick++;
/*    */   }
/*    */   
/*    */   public void setCurrentFrame(int currentFrame) {
/* 42 */     this.currentFrame = currentFrame;
/*    */   }
/*    */   
/*    */   public int getFrames() {
/* 46 */     return this.frames;
/*    */   }
/*    */   
/*    */   public ResourceLocation getTexture() {
/* 50 */     return this.textures[this.currentFrame];
/*    */   }
/*    */   
/*    */   public int getCurrentFrame() {
/* 54 */     return this.currentFrame;
/*    */   }
/*    */ }

