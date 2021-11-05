/*     */ package clientname.gui.gui;
/*     */ 
/*     */ import clientname.Client;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiMainMenu;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiOptions;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiShareToLan;
/*     */ import net.minecraft.client.gui.achievement.GuiAchievements;
/*     */ import net.minecraft.client.gui.achievement.GuiStats;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.realms.RealmsBridge;

/*     */ public class GuiCosmetics
/*     */   extends GuiScreen
/*     */ {
/*     */   private final GuiScreen field_146598_a;
/*  39 */   private static String Cape = "Cape";
/*  40 */   private static String Wings = "Wings";
/*  41 */   private static String ToggleSprint = "Toggle Sprint";
/*  42 */   private static String Halo = "Halo";
/*  43 */   private static String FPS = "FPS";
/*  44 */   private static String Keystrokes = "Keystrokes";
/*  45 */   private static String Ping = "Ping";
/*  46 */   private static String ArmorStatus = "Armor Status";
/*  47 */   private static String Time = "Time";
/*  48 */   private static String PotionStatus = "Potion Status";
/*  49 */   private static String ModPosition = "ModPosition";
/*     */   
/*     */   private GuiButton field_146596_f;
/*     */   
/*     */   private GuiButton field_146597_g;
/*     */   
/*  55 */   private String field_146599_h = "survival";
/*     */   private boolean field_146600_i;
/*     */   
/*     */   public GuiCosmetics(GuiScreen p_i1055_1_) {
/*  59 */     this.field_146598_a = p_i1055_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  71 */     if (Client.CosmeticHalo) {
/*  72 */       this.buttonList.add(new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/*  73 */             I18n.format("Halo: ON", new Object[0])));
/*     */     } else {
/*  75 */       this.buttonList.add(new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/*  76 */             I18n.format("Halo: OFF", new Object[0])));
/*     */     } 
/*     */     
/*  79 */     if (Client.DiamondHead) {
/*  80 */       this.buttonList.add(new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/*  81 */             I18n.format("DiamondHead: ON", new Object[0])));
/*     */     } else {
/*  83 */       this.buttonList.add(new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/*  84 */             I18n.format("DiamondHead: OFF", new Object[0])));
/*     */     } 
/*  86 */     if (Client.CosmeticWitchHat) {
/*  87 */       this.buttonList.add(new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/*  88 */             I18n.format("WitchHat: ON", new Object[0])));
/*     */     } else {
/*  90 */       this.buttonList.add(new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/*  91 */             I18n.format("WitchHat: OFF", new Object[0])));
/*     */     } 
/*     */     
/*  94 */     if (Client.CosmeticCape) {
/*  95 */       this.buttonList.add(new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/*  96 */             I18n.format("Cape: ON", new Object[0])));
/*     */     } else {
/*  98 */       this.buttonList.add(new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/*  99 */             I18n.format("Cape: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 102 */     if (Client.CosmeticWings) {
/* 103 */       this.buttonList.add(new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 104 */             I18n.format("Wings: ON", new Object[0])));
/*     */     } else {
/* 106 */       this.buttonList.add(new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 107 */             I18n.format("Wings: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 110 */     if (Client.CosmeticGhostWings) {
/* 111 */       this.buttonList.add(new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 112 */             I18n.format("Ghost Wings: ON", new Object[0])));
/*     */     } else {
/* 114 */       this.buttonList.add(new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 115 */             I18n.format("Ghost Wings: OFF", new Object[0])));
/*     */     } 
/*     */ 
/*     */     
/* 119 */     if (Client.CosmeticCap) {
/* 120 */       this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 121 */             I18n.format("Cap: ON", new Object[0])));
/*     */     } else {
/* 123 */       this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 124 */             I18n.format("Cap: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 127 */     if (Client.CosmeticHat) {
/* 128 */       this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 129 */             I18n.format("Hat: ON", new Object[0])));
/*     */     } else {
/* 131 */       this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 132 */             I18n.format("Hat: OFF", new Object[0])));
/*     */     } 
   
/* 159 */     this.buttonList.add(new GuiButton(8, this.width / 2 - 91, this.height / 2 + 102, 180, 20, 
/* 160 */           I18n.format("Back", new Object[0])));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_146595_g() {
/* 166 */     this.field_146597_g.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + " " + 
/* 167 */       I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
/* 168 */     this.field_146596_f.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
/*     */     
/* 170 */     if (this.field_146600_i) {
/* 171 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 172 */         I18n.format("options.on", new Object[0]);
/*     */     } else {
/* 174 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 175 */         I18n.format("options.off", new Object[0]);
/*     */     } 
/*     */   }
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/*     */     boolean flag, flag1;
/* 180 */     switch (button.id) {
/*     */       case 0:
/* 182 */         this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
/*     */ 
/*     */       
/*     */       case 1:
/* 186 */         flag = this.mc.isIntegratedServerRunning();
/* 187 */         flag1 = this.mc.func_181540_al();
/* 188 */         button.enabled = false;
/* 189 */         this.mc.theWorld.sendQuittingDisconnectingPacket();
/* 190 */         this.mc.loadWorld(null);
/*     */         
/* 192 */         if (flag) {
/* 193 */           this.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
/* 194 */         } else if (flag1) {
/* 195 */           RealmsBridge realmsbridge = new RealmsBridge();
/* 196 */           realmsbridge.switchToRealms((GuiScreen)new GuiMainMenu());
/*     */         } else {
/* 198 */           this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
/*     */         } 
/*     */ 
/*     */       
/*     */       default:
/*     */         return;
/*     */ 
/*     */       
/*     */       case 4:
/* 207 */         this.mc.displayGuiScreen(null);
/* 208 */         this.mc.setIngameFocus();
/*     */ 
/*     */       
/*     */       case 5:
/* 212 */         this.mc.displayGuiScreen((GuiScreen)new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
/*     */ 
/*     */       
/*     */       case 6:
/* 216 */         this.mc.displayGuiScreen((GuiScreen)new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
/*     */       
/*     */       case 7:
/* 219 */         this.mc.displayGuiScreen((GuiScreen)new GuiShareToLan(this));
/*     */ 
/*     */       
/*     */       case 1001:
/* 223 */         Client.CosmeticWings = !Client.CosmeticWings;
/* 224 */         if (Client.CosmeticWings) {
/* 225 */           this.buttonList.set(4, new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 226 */                 I18n.format("Wings: ON", new Object[0])));
/*     */         } else {
/* 228 */           this.buttonList.set(4, new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 229 */                 I18n.format("Wings: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1003:
/* 235 */         Client.CosmeticCape = !Client.CosmeticCape;
/*     */         
/* 237 */         if (Client.CosmeticCape) {
/* 238 */           this.buttonList.set(3, new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 239 */                 I18n.format("Cape: ON", new Object[0])));
/*     */         } else {
/* 241 */           this.buttonList.set(3, new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 242 */                 I18n.format("Cape: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1004:
/* 246 */         Client.CosmeticHalo = !Client.CosmeticHalo;
/*     */         
/* 248 */         if (Client.CosmeticHalo) {
/* 249 */           this.buttonList.set(0, new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/* 250 */                 I18n.format("Halo: ON", new Object[0])));
/*     */         } else {
/* 252 */           this.buttonList.set(0, new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/* 253 */                 I18n.format("Halo: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 8:
/* 258 */         this.mc.displayGuiScreen(new GUIToggle(this));
/*     */ 
/*     */       
/*     */       case 1014:
/* 262 */         Client.DiamondHead = !Client.DiamondHead;
/*     */         
/* 264 */         if (Client.DiamondHead) {
/* 265 */           this.buttonList.set(1, new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/* 266 */                 I18n.format("DiamondHead: ON", new Object[0])));
/*     */         } else {
/* 268 */           this.buttonList.set(1, new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/* 269 */                 I18n.format("DiamondHead: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1016:
/* 273 */         Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
/*     */         
/* 275 */         if (Client.CosmeticWitchHat) {
/* 276 */           this.buttonList.set(2, new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/* 277 */                 I18n.format("WitchHat: ON", new Object[0])));
/*     */         } else {
/* 279 */           this.buttonList.set(2, new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/* 280 */                 I18n.format("WitchHat: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1002:
/* 284 */         Client.CosmeticGhostWings = !Client.CosmeticGhostWings;
/* 285 */         if (Client.CosmeticGhostWings) {
/* 286 */           this.buttonList.set(5, new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 287 */                 I18n.format("Ghost Wings: ON", new Object[0])));
/*     */         } else {
/* 289 */           this.buttonList.set(5, new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 290 */                 I18n.format("Ghost Wings: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1005:
/* 294 */         Client.CosmeticCap = !Client.CosmeticCap;
/* 295 */         if (Client.CosmeticCap) {
/* 296 */           this.buttonList.set(6, new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 297 */                 I18n.format("Cap: ON", new Object[0])));
/*     */         } else {
/* 299 */           this.buttonList.set(6, new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 300 */                 I18n.format("Cap: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1006:
/* 306 */         Client.CosmeticHat = !Client.CosmeticHat;
/* 307 */         if (Client.CosmeticHat) {
/* 308 */           this.buttonList.set(7, new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 309 */                 I18n.format("Hat: ON", new Object[0])));
/*     */         } else {
/* 311 */           this.buttonList.set(7, new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 312 */                 I18n.format("Hat: OFF", new Object[0])));
/*     */         } 
     
/*     */       case 1022:
/*     */         break;
/*     */     } 
    
/* 354 */     this.mc.displayGuiScreen(new GUIToggle(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 364 */     drawDefaultBackground();
/*     */ 
/*     */     
/* 367 */     drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Cosmetics", this.width / 2 - 23, this.height / 2 - 120, -1);
/* 368 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }

