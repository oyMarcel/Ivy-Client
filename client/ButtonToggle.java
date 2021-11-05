/*     */ package client;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ButtonToggle
/*     */   extends GuiButton
/*     */ {
/*  18 */   Color off = new Color(-4342339);
/*  19 */   Color on = new Color(-16711936);
/*  20 */   Color c = new Color(-1);
/*     */ 
/*     */   
/*     */   public ButtonToggle(int i, int j, int k, String s) {
/*  24 */     this(i, j, k, 120, 20, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtonToggle(int i, int j, int k, int l, int i1, String s) {
/*  29 */     super(i, j, k, l, i1, s);
/*  30 */     this.enabled = true;
/*  31 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  36 */     byte byte0 = 1;
/*  37 */     if (!this.enabled) {
/*     */       
/*  39 */       byte0 = 0;
/*     */     }
/*  41 */     else if (flag) {
/*     */       
/*  43 */       byte0 = 2;
/*     */     } 
/*  45 */     return byte0;
/*     */   }
/*     */ 
  
/*     */   public void drawButton(Minecraft mc, int mx, int my) {
/*  54 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  55 */     if (load(this.displayString).booleanValue()) {
/*  56 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, this.on);
/*  57 */       drawCircle(this.xPosition + this.width - this.height + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
/*     */     } else {
/*  59 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, this.off);
/*  60 */       drawCircle(this.xPosition + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  67 */     File file = new File(FileManagerButton.TOGGLE_DIR, toggle);
/*  68 */     file.mkdirs();
/*  69 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  73 */     FileManagerButton.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  76 */     Boolean b = FileManagerButton.<Boolean>readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  78 */     if (b == null) {
/*  79 */       b = Boolean.valueOf(false);
/*  80 */       save(toggle, b);
/*     */     } 
/*  82 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  86 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/*  87 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/*  88 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/*  89 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/*  90 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/*  91 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/*  92 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/*  96 */     GL11.glPushMatrix();
/*  97 */     GL11.glEnable(3042);
/*  98 */     GL11.glDisable(3553);
/*  99 */     GL11.glBlendFunc(770, 771);
/* 100 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 102 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 104 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 105 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 107 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 108 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 109 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 112 */     Tessellator.getInstance().draw();
/*     */     
/* 114 */     GL11.glEnable(3553);
/* 115 */     GL11.glDisable(3042);
/* 116 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 120 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }
