/*     */ package clientname;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScaledResolution
/*     */ {
/*     */   private final double scaledWidthD;
/*     */   private final double scaledHeightD;
/*     */   private int scaledWidth;
/*     */   private int scaledHeight;
/*     */   private int heigt;
/*     */   private int scaleFactor;
/*     */   Minecraft minecraft;
/*     */   
/*     */   public ScaledResolution(Minecraft minecraft) {
/*  19 */     this.minecraft = minecraft;
/*  20 */     this.scaledWidth = minecraft.displayWidth;
/*  21 */     this.scaledHeight = minecraft.displayHeight;
/*  22 */     this.scaleFactor = 1;
/*  23 */     int i = 3;
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
/*  34 */     this.scaledWidthD = this.scaledWidth / this.scaleFactor;
/*  35 */     this.scaledHeightD = this.scaledHeight / this.scaleFactor;
/*  36 */     this.scaledWidth = MathHelper.ceiling_double_int(this.scaledWidthD);
/*  37 */     this.scaledHeight = MathHelper.ceiling_double_int(this.scaledHeightD);
/*     */   }
/*     */   
/*     */   public ScaledResolution(Minecraft minecraft, int displayWidth, int displayHeight) {
/*  41 */     this.scaledWidth = displayWidth;
/*  42 */     this.scaledHeight = displayHeight;
/*  43 */     this.scaleFactor = 1;
/*  44 */     boolean flag = minecraft.isUnicode();
/*  45 */     int i = 3;
/*     */     
/*  47 */     if (i == 0)
/*     */     {
/*  49 */       i = 1000;
/*     */     }
/*     */     
/*  52 */     while (this.scaleFactor < i && this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240)
/*     */     {
/*  54 */       this.scaleFactor++;
/*     */     }
/*     */     
/*  57 */     if (flag && this.scaleFactor % 2 != 0 && this.scaleFactor != 1)
/*     */     {
/*  59 */       this.scaleFactor--;
/*     */     }
/*     */     
/*  62 */     this.scaledWidthD = this.scaledWidth / this.scaleFactor;
/*  63 */     this.scaledHeightD = this.scaledHeight / this.scaleFactor;
/*  64 */     this.scaledWidth = MathHelper.ceiling_double_int(this.scaledWidthD);
/*  65 */     this.scaledHeight = MathHelper.ceiling_double_int(this.scaledHeightD);
/*     */   }
/*     */   
/*     */   public int getCenterX() {
/*  69 */     return this.minecraft.displayWidth / 2 * this.scaleFactor;
/*     */   }
/*     */   
/*     */   public int getCenterY() {
/*  73 */     return this.minecraft.displayHeight / 2 * this.scaleFactor;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getScale() {
/*  78 */     double scale = 640.0D / this.scaledHeightD;
/*  79 */     return scale;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScaledWidth() {
/*  84 */     return this.scaledWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScaledHeight() {
/*  89 */     return this.scaledHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getScaledWidth_double() {
/*  94 */     return this.scaledWidthD;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getScaledHeight_double() {
/*  99 */     return this.scaledHeightD;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScaleFactor() {
/* 104 */     return this.scaleFactor;
/*     */   }
/*     */ }
