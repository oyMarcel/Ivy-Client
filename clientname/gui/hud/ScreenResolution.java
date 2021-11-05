/*     */ package clientname.gui.hud;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class ScreenResolution
/*     */ {
/*     */   private final double scaledWidthD;
/*     */   private final double scaledHeightD;
/*     */   private int scaledWidth;
/*     */   private int scaledHeight;
/*     */   private int scaleFactor;
/*     */   Minecraft minecraft;
/*     */   
/*     */   public ScreenResolution(Minecraft p_i46445_1_) {
/*  17 */     this.minecraft = p_i46445_1_;
/*  18 */     this.scaledWidth = p_i46445_1_.displayWidth;
/*  19 */     this.scaledHeight = p_i46445_1_.displayHeight;
/*  20 */     this.scaleFactor = 1;
/*  21 */     boolean flag = p_i46445_1_.isUnicode();
/*  22 */     int i = p_i46445_1_.gameSettings.guiScale;
/*     */     
/*  24 */     if (i == 0)
/*     */     {
/*  26 */       i = 1000;
/*     */     }
/*     */     
/*  29 */     while (this.scaleFactor < i && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240)
/*     */     {
/*  31 */       this.scaleFactor++;
/*     */     }
/*     */     
/*  34 */     if (flag && this.scaleFactor % 2 != 0 && this.scaleFactor != 1)
/*     */     {
/*  36 */       this.scaleFactor--;
/*     */     }
/*     */     
/*  39 */     this.scaledWidthD = this.scaledWidth / this.scaleFactor;
/*  40 */     this.scaledHeightD = this.scaledHeight / this.scaleFactor;
/*  41 */     this.scaledWidth = MathHelper.ceiling_double_int(this.scaledWidthD);
/*  42 */     this.scaledHeight = MathHelper.ceiling_double_int(this.scaledHeightD);
/*     */   }
/*     */   
/*     */   public int getCenterX() {
/*  46 */     return this.minecraft.displayWidth / 2 * this.scaleFactor;
/*     */   }
/*     */   
/*     */   public int getCenterY() {
/*  50 */     return this.minecraft.displayHeight / 2 * this.scaleFactor;
/*     */   }
/*     */   
/*     */   public ScreenResolution(Minecraft minecraft, int displayWidth, int displayHeight) {
/*  54 */     this.minecraft = minecraft;
/*  55 */     this.scaledWidth = displayWidth;
/*  56 */     this.scaledHeight = displayHeight;
/*  57 */     this.scaleFactor = 1;
/*  58 */     boolean flag = minecraft.isUnicode();
/*  59 */     int i = minecraft.gameSettings.guiScale;
/*     */     
/*  61 */     if (i == 0)
/*     */     {
/*  63 */       i = 1000;
/*     */     }
/*     */     
/*  66 */     while (this.scaleFactor < i && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240)
/*     */     {
/*  68 */       this.scaleFactor++;
/*     */     }
/*     */     
/*  71 */     if (flag && this.scaleFactor % 2 != 0 && this.scaleFactor != 1)
/*     */     {
/*  73 */       this.scaleFactor--;
/*     */     }
/*     */     
/*  76 */     this.scaledWidthD = this.scaledWidth / this.scaleFactor;
/*  77 */     this.scaledHeightD = this.scaledHeight / this.scaleFactor;
/*  78 */     this.scaledWidth = MathHelper.ceiling_double_int(this.scaledWidthD);
/*  79 */     this.scaledHeight = MathHelper.ceiling_double_int(this.scaledHeightD);
/*     */   }
/*     */   
/*     */   public int getWidthScale() {
/*  83 */     return this.scaledWidth / 640;
/*     */   }
/*     */   
/*     */   public int getHeightScale() {
/*  87 */     return this.scaledHeight / 360;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScaledWidth() {
/*  92 */     return this.scaledWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScaledHeight() {
/*  97 */     return this.scaledHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getScaledWidth_double() {
/* 102 */     return this.scaledWidthD;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getScaledHeight_double() {
/* 107 */     return this.scaledHeightD;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScaleFactor() {
/* 112 */     return this.scaleFactor;
/*     */   }
/*     */ }
