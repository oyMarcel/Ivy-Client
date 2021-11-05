/*     */ package clientname.mods;
/*     */ 
/*     */ import clientname.ModToggle;
/*     */ import clientname.gui.hud.HUDManager;
/*     */ import clientname.gui.hud.IRenderer;
/*     */ import clientname.mods.impl.FovMod;
/*     */ import clientname.mods.impl.ModArmorStatus;
/*     */ import clientname.mods.impl.ModBiom;
/*     */ import clientname.mods.impl.ModClientName;
/*     */ import clientname.mods.impl.ModFPS;
/*     */ import clientname.mods.impl.ModKeystrokes;
/*     */ import clientname.mods.impl.ModPerspective;
/*     */ import clientname.mods.impl.ModPing;
/*     */ import clientname.mods.impl.ModPotionStatus;
/*     */ import clientname.mods.impl.ModProjectL;
/*     */ import clientname.mods.impl.ModTimeShow;
/*     */ import clientname.mods.impl.ModToggleSpirnt;
/*     */ import clientname.mods.impl.ModX;
/*     */ import clientname.mods.impl.ModY;
/*     */ import clientname.mods.impl.ModZ;
/*     */ import net.minecraft.client.Minecraft;

/*     */ public class ModInstances
/*     */ {
/*     */   public static Minecraft mc;
/*     */   private static ModClientName modHelloWorld;
/*     */   private static ModArmorStatus modArmorStatus;
/*     */   private static ModFPS modFPS;
/*     */   private static ModToggleSpirnt modToggleSprint;
/*     */   private static ModKeystrokes modKeystrokes;
/*     */   private static FovMod fovMod;
/*     */   private static ModBiom modBiom;
/*     */   private static ModPing modPing;
/*     */   private static ModTimeShow modTimeShow;
/*     */   private static ModPotionStatus modPotionStatus;
/*     */   private static ModX modX;
/*     */   private static ModProjectL modProjectL;
/*     */   private static ModY modY;
/*     */   private static ModZ modZ;
/*     */   private static ModPerspective modPerspective;
/*     */   
/*     */   public static void register(HUDManager api) {
/*  72 */     modHelloWorld = new ModClientName();
/*  73 */     api.register(new IRenderer[] { (IRenderer)modHelloWorld });
/*     */ 
/*     */ 
/*     */     
/*  77 */     modArmorStatus = new ModArmorStatus();
/*  78 */     api.register(new IRenderer[] { (IRenderer)modArmorStatus });
/*     */     
/*  80 */     modToggleSprint = new ModToggleSpirnt();
/*  81 */     api.register(new IRenderer[] { (IRenderer)modToggleSprint });
/*     */ 
/*     */     
/*  84 */     modFPS = new ModFPS();
/*  85 */     api.register(new IRenderer[] { (IRenderer)modFPS });
/*     */ 
/*     */     
/*  88 */     modX = new ModX();
/*  89 */     api.register(new IRenderer[] { (IRenderer)modX });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     modY = new ModY();
/*  96 */     api.register(new IRenderer[] { (IRenderer)modY });
/*     */     
/*  98 */     modZ = new ModZ();
/*  99 */     api.register(new IRenderer[] { (IRenderer)modZ });
/*     */ 
/*     */     
/* 102 */     modKeystrokes = new ModKeystrokes();
/* 103 */     api.register(new IRenderer[] { (IRenderer)modKeystrokes });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     modPing = new ModPing();
/* 110 */     api.register(new IRenderer[] { (IRenderer)modPing });
/*     */     
/* 112 */     modTimeShow = new ModTimeShow();
/* 113 */     api.register(new IRenderer[] { (IRenderer)modTimeShow });
/*     */ 
/*     */     
/* 116 */     modPotionStatus = new ModPotionStatus();
/* 117 */     api.register(new IRenderer[] { (IRenderer)modPotionStatus });
/*     */     
/* 119 */     modPerspective = new ModPerspective();
/* 120 */     api.register(new IRenderer[] { (IRenderer)modPerspective });
/*     */     
/* 122 */     modProjectL = new ModProjectL();
/* 123 */     api.register(new IRenderer[] { (IRenderer)modProjectL });
/*     */ 
/*     */     
/* 126 */     fovMod = new FovMod();
/* 127 */     api.register(new IRenderer[] { (IRenderer)fovMod });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     if (ModToggle.loadEnabledFromFile("ModBiom").booleanValue()) {
/* 134 */       modBiom = new ModBiom();
/* 135 */       api.register(new IRenderer[] { (IRenderer)modBiom });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ModPerspective getModPerspective() {
/* 142 */     return modPerspective;
/*     */   }
/*     */ }
