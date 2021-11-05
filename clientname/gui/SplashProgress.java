/*     */ package clientname.gui;
/*     */ 
/*     */ import clientname.Client;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SplashProgress
/*     */ {
/*     */   private static final int MAX = 7;
/*  19 */   private static int PROGRESS = 0;
/*  20 */   private static String CURRENT = "";
/*     */   private static ResourceLocation splash;
/*     */   private static UnicodeFontRenderer ufr;
/*     */   
/*     */   public static void update() {
/*  25 */     if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
/*     */       return;
/*     */     }
/*  28 */     drawSplash(Minecraft.getMinecraft().getTextureManager());
/*     */   }
/*     */   
/*     */   public static void setProgress(int givenProgress, String givenText) {
/*  32 */     PROGRESS = givenProgress;
/*  33 */     CURRENT = givenText;
/*  34 */     update();
/*     */   }
/*     */   
/*     */   public static void drawSplash(TextureManager tm) {
/*  38 */     ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
/*  39 */     int scaleFactor = scaledResolution.getScaleFactor();
/*     */     
/*  41 */     Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
/*  42 */     framebuffer.bindFramebuffer(false);
/*     */     
/*  44 */     GlStateManager.matrixMode(5889);
/*  45 */     GlStateManager.loadIdentity();
/*  46 */     GlStateManager.ortho(0.0D, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
/*  47 */     GlStateManager.matrixMode(5888);
/*  48 */     GlStateManager.loadIdentity();
/*  49 */     GlStateManager.translate(0.0F, 0.0F, -2000.0F);
/*  50 */     GlStateManager.disableLighting();
/*  51 */     GlStateManager.disableFog();
/*  52 */     GlStateManager.disableDepth();
/*  53 */     GlStateManager.enableTexture2D();
/*     */     
/*  55 */     if (splash == null) {
/*  56 */       splash = new ResourceLocation(Client.SplashScreen);
/*     */     }
/*     */     
/*  59 */     tm.bindTexture(splash);
/*     */     
/*  61 */     GlStateManager.resetColor();
/*  62 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  64 */     Gui.drawScaledCustomSizeModalRect(0, 0, 0.0F, 0.0F, 1920, 1080, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 1920.0F, 1080.0F);
/*  65 */     drawProgress();
/*  66 */     framebuffer.unbindFramebuffer();
/*  67 */     framebuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);
/*     */     
/*  69 */     GlStateManager.enableAlpha();
/*  70 */     GlStateManager.alphaFunc(352, 0.1F);
/*     */     
/*  72 */     Minecraft.getMinecraft().updateDisplay();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void drawProgress() {
/*  77 */     if ((Minecraft.getMinecraft()).gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
/*     */       return;
/*     */     }
/*     */     
/*  81 */     if (ufr == null) {
/*  82 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*  84 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/*     */     
/*  86 */     double nProgress = PROGRESS;
/*  87 */     double calc = nProgress / 7.0D * sr.getScaledWidth();
/*     */     
/*  89 */     Gui.drawRect(0, sr.getScaledHeight() - 35, sr.getScaledWidth(), sr.getScaledHeight(), (new Color(0, 0, 0, 50)).getRGB());
/*     */     
/*  91 */     GlStateManager.resetColor();
/*  92 */     resetTextureState();
/*     */     
/*  94 */     ufr.drawString(CURRENT, 20.0F, (sr.getScaledHeight() - 25), -1);
/*     */     
/*  96 */     String step = String.valueOf(PROGRESS) + "/" + '\007';
/*     */     
/*  98 */     ufr.drawString(step, (sr.getScaledWidth() - 20 - ufr.getStringWidth(step)), (sr.getScaledHeight() - 25), -505290241);
/*     */     
/* 100 */     GlStateManager.resetColor();
/* 101 */     resetTextureState();
/*     */     
/* 103 */     Gui.drawRect(0, sr.getScaledHeight() - 2, (int)calc, sr.getScaledHeight(), Client.SplashColor.getRGB());
/* 104 */     Gui.drawRect(0, sr.getScaledHeight() - 2, sr.getScaledWidth(), sr.getScaledHeight(), (new Color(255, 170, 0, 10)).getRGB());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void resetTextureState() {
/* 110 */     (GlStateManager.textureState[GlStateManager.activeTextureUnit]).textureName = -1;
/*     */   }
/*     */ }
