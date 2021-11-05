/*     */ package clientname;
/*     */ 
/*     */ import clientname.event.EventManager;
/*     */ import clientname.event.EventTarget;
/*     */ import clientname.event.impl.ClientTickEvent;
/*     */ import clientname.gui.SplashProgress;
/*     */ import clientname.gui.gui.GUIToggle;
/*     */ import clientname.gui.hud.HUDManager;
/*     */ import clientname.mods.ModInstances;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Client
/*     */ {
/*  20 */   private static final Client INSTANCE = new Client();
/*     */ 
/*     */   
/*     */   public static final Client getInstance() {
/*  24 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HUDManager getHudManager() {
/*  30 */     return this.hudManager;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean ChromaText = false;
/*     */ 
/*     */   
/*     */   public static boolean LeftHand = false;
/*     */ 
/*     */   
/*     */   public static boolean WidePlayer = false;
/*     */ 
/*     */   
/*     */   public static boolean DynamicFOV = false;
/*     */ 
/*     */   
/*     */   public static boolean CosmeticGhostWings = false;
/*     */ 
/*     */   
/*     */   public static boolean CosmeticCap = false;
/*     */ 
/*     */   
/*  53 */   public static String ClientName = "Ivy Client";
/*     */   
/*  55 */   public static String mainColor = "green";
/*     */   
/*  57 */   public static String DiscordID = "869217822956453988";
/*     */   
/*  59 */   public static int FPSBoost = 2;
/*     */ 
/*     */   
/*     */   public static boolean LogoButtons = true;
/*     */   
/*  64 */   public static int guiToggleClientName = 55;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color getSplashColor() {
/*  71 */     if (mainColor == "pink") {
/*  72 */       return new Color(255, 85, 255);
/*     */     }
/*     */     
/*  75 */     if (mainColor == "blue") {
/*  76 */       return new Color(85, 85, 255);
/*     */     }
/*  78 */     if (mainColor == "red") {
/*  79 */       return new Color(255, 85, 85);
/*     */     }
/*  81 */     if (mainColor == "pink") {
/*  82 */       return new Color(255, 85, 255);
/*     */     }
/*  84 */     if (mainColor == "green") {
/*  85 */       return new Color(85, 255, 85);
/*     */     }
/*  87 */     if (mainColor == "cyan")
/*  88 */       return new Color(85, 255, 255); 
/*  89 */     if (mainColor == "orange") {
/*  90 */       return new Color(255, 170, 0);
/*     */     }
/*  92 */     if (mainColor == "gold") {
/*  93 */       return new Color(255, 170, 0);
/*     */     }
/*  95 */     if (mainColor == "brown") {
/*  96 */       return new Color(255, 170, 0);
/*     */     }
/*  98 */     if (mainColor == "white") {
/*  99 */       return new Color(255, 255, 255);
/*     */     }
/* 101 */     if (mainColor == "yellow") {
/* 102 */       return new Color(255, 255, 85);
/*     */     }
/*     */     
/* 105 */     return new Color(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getConfigScreenColor() {
/* 110 */     if (mainColor == "pink") {
/* 111 */       return -43521;
/*     */     }
/*     */     
/* 114 */     if (mainColor == "blue") {
/* 115 */       return -11184641;
/*     */     }
/* 117 */     if (mainColor == "red") {
/* 118 */       return -43691;
/*     */     }
/* 120 */     if (mainColor == "pink") {
/* 121 */       return -43521;
/*     */     }
/* 123 */     if (mainColor == "green") {
/* 124 */       return -11141291;
/*     */     }
/* 126 */     if (mainColor == "cyan") {
/* 127 */       return -11141121;
/*     */     }
/* 129 */     if (mainColor == "orange") {
/* 130 */       return -22016;
/*     */     }
/* 132 */     if (mainColor == "gold") {
/* 133 */       return -22016;
/*     */     }
/* 135 */     if (mainColor == "brown") {
/* 136 */       return -22016;
/*     */     }
/* 138 */     if (mainColor == "white") {
/* 139 */       return -1;
/*     */     }
/* 141 */     if (mainColor == "yellow") {
/* 142 */       return -171;
/*     */     }
/*     */     
/* 145 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getModFarbe() {
/* 150 */     if (mainColor == "pink") {
/* 151 */       return "§d";
/*     */     }
/*     */     
/* 154 */     if (mainColor == "blue") {
/* 155 */       return "§9";
/*     */     }
/* 157 */     if (mainColor == "red") {
/* 158 */       return "§c";
/*     */     }
/* 160 */     if (mainColor == "pink") {
/* 161 */       return "§d";
/*     */     }
/* 163 */     if (mainColor == "green") {
/* 164 */       return "§a";
/*     */     }
/* 166 */     if (mainColor == "cyan") {
/* 167 */       return "§b";
/*     */     }
/* 169 */     if (mainColor == "orange") {
/* 170 */       return "§6";
/*     */     }
/* 172 */     if (mainColor == "gold") {
/* 173 */       return "§6";
/*     */     }
/* 175 */     if (mainColor == "brown") {
/* 176 */       return "§6";
/*     */     }
/* 178 */     if (mainColor == "white") {
/* 179 */       return "§f";
/*     */     }
/* 181 */     if (mainColor == "yellow") {
/* 182 */       return "§e";
/*     */     }
/*     */     
/* 185 */     return "0000000000";
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getButtonHover() {
/* 190 */     if (mainColor == "pink") {
/* 191 */       return 16733695;
/*     */     }
/*     */     
/* 194 */     if (mainColor == "blue") {
/* 195 */       return 5592575;
/*     */     }
/* 197 */     if (mainColor == "red") {
/* 198 */       return 16733525;
/*     */     }
/* 200 */     if (mainColor == "pink") {
/* 201 */       return 16733695;
/*     */     }
/* 203 */     if (mainColor == "green") {
/* 204 */       return 5635925;
/*     */     }
/* 206 */     if (mainColor == "cyan") {
/* 207 */       return 5636095;
/*     */     }
/* 209 */     if (mainColor == "orange") {
/* 210 */       return 16755200;
/*     */     }
/* 212 */     if (mainColor == "gold") {
/* 213 */       return 16755200;
/*     */     }
/* 215 */     if (mainColor == "brown") {
/* 216 */       return 16755200;
/*     */     }
/* 218 */     if (mainColor == "white") {
/* 219 */       return 16777215;
/*     */     }
/* 221 */     if (mainColor == "yellow") {
/* 222 */       return 16777045;
/*     */     }
/*     */     
/* 225 */     return 0;
/*     */   }
/*     */ 
/*     */   
/* 229 */   public static int ConfigScreenColor = getConfigScreenColor();
/*     */   
/* 231 */   public static Color SplashColor = getSplashColor();
/*     */   
/* 233 */   public static String ModFarbe = getModFarbe();
/*     */   
/* 235 */   public static int ButtonHover = getButtonHover();
/*     */   
/* 237 */   public static String KlammerFarbe = "§f";
/*     */   
/*     */   public static boolean CosmeticHat;
/*     */   
/*     */   public static boolean CosmeticWitchHat;
/*     */   public static boolean DiamondHead;
/*     */   public static boolean ChatBackground;
/*     */   public static boolean BetterAnimations;
/*     */   public static boolean ItemPhysics;
/*     */   public static boolean ToggleSprint;
/*     */   public static boolean CosmeticWings;
/*     */   public static boolean CosmeticHalo;
/*     */   public static boolean CosmeticCape;
/*     */   public static boolean CosmeticCape2;
/*     */   public static boolean CosmeticCape3;
/*     */   public static boolean CosmeticCape4;
/*     */   public static boolean ModBiom = true;
/*     */   public static boolean ModFPS = true;
/*     */   public static boolean ModPing = true;
/*     */   public static boolean ModPotionstatus = true;
/*     */   public static boolean ModTimeShow = true;
/*     */   public static boolean ModPosition = true;
/*     */   public static boolean ModArmorStatus = true;
/*     */   public static boolean ModKeystrokes = true;
/*     */   public static boolean ModItemViewer = true;
/* 262 */   public static String Background = "background.png";
/*     */   
/* 264 */   public static String Cape = "cape.png";
/*     */   
/* 266 */   public static String SplashScreen = "splash.png";
/*     */   
/* 268 */   public static String Logo = "tollerzitronens-01.jpeg";
/*     */   
/* 270 */   private DiscordRP discordRP = new DiscordRP();
/*     */   
/*     */   private HUDManager hudManager;
/*     */   
/* 274 */   int scrollTotal = 4;
/*     */   
/*     */   private static boolean prevIsKeyDown = false;
/*     */   
/* 278 */   private static float savedFOV = 0.0F;
/*     */   
/*     */   public void init() {
/* 281 */     SplashProgress.setProgress(1, String.valueOf(ClientName) + " - Discord Initialisation");
/* 282 */     FileManager.init();
/* 283 */     this.discordRP.start();
/* 284 */     EventManager.register(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/* 289 */     this.hudManager = HUDManager.getInstance();
/* 290 */     ModInstances.register(this.hudManager);
/*     */   }
/*     */   
/*     */   public void shutdown() {
/* 294 */     this.discordRP.shutdown();
/*     */   }
/*     */   
/*     */   public DiscordRP getDiscordRP() {
/* 298 */     return this.discordRP;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onTick(ClientTickEvent e) {
/* 303 */     if ((Minecraft.getMinecraft()).gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
/* 304 */       this.hudManager.openConfigScreen();
/*     */     }
/* 306 */     if ((Minecraft.getMinecraft()).gameSettings.CLIENT_GUI_MOD_SETTINGS.isPressed()) {
/* 307 */       Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GUIToggle(null));
/*     */     }
/* 309 */     boolean isKeyDown = (Minecraft.getMinecraft()).gameSettings.ZOOM.isKeyDown();
/* 310 */     if (prevIsKeyDown != isKeyDown) {
/* 311 */       if (isKeyDown) {
/* 312 */         savedFOV = (Minecraft.getMinecraft()).gameSettings.fovSetting;
/* 313 */         (Minecraft.getMinecraft()).gameSettings.fovSetting = 30.0F;
/* 314 */         (Minecraft.getMinecraft()).gameSettings.smoothCamera = true;
/*     */       } else {
/* 316 */         (Minecraft.getMinecraft()).gameSettings.fovSetting = savedFOV;
/* 317 */         (Minecraft.getMinecraft()).gameSettings.smoothCamera = false;
/*     */       } 
/*     */     }
/* 320 */     prevIsKeyDown = isKeyDown;
/*     */   }
/*     */ }
