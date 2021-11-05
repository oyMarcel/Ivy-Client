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

/*     */ public class GuiOtherMods
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
/*     */   public GuiOtherMods(GuiScreen p_i1055_1_) {
/*  59 */     this.field_146598_a = p_i1055_1_;
/*     */   }
  
/*     */   public void initGui() {
/*  74 */     if (Client.ToggleSprint) {
/*  75 */       this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/*  76 */             I18n.format("Toggle Sprint: ON", new Object[0])));
/*     */     } else {
/*  78 */       this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/*  79 */             I18n.format("Toggle Sprint: OFF", new Object[0])));
/*     */     } 
/*     */ 
/*     */     
/*  83 */     if (Client.ItemPhysics) {
/*  84 */       this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/*  85 */             I18n.format("ItemPhysics: OFF", new Object[0])));
/*     */     } else {
/*  87 */       this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/*  88 */             I18n.format("ItemPhysics: ON", new Object[0])));
/*     */     } 
/*     */     
/*  91 */     if (Client.BetterAnimations) {
/*  92 */       this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/*  93 */             I18n.format("1.7 Animations: OFF", new Object[0])));
/*     */     } else {
/*  95 */       this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/*  96 */             I18n.format("1.7 Animations: ON", new Object[0])));
/*     */     } 
/*     */     
/*  99 */     if (Client.ChatBackground) {
/* 100 */       this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 101 */             I18n.format("ChatBackground: OFF", new Object[0])));
/*     */     } else {
/* 103 */       this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 104 */             I18n.format("ChatBackground: ON", new Object[0])));
/*     */     } 
/*     */ 
/*     */     
/* 108 */     if (Client.ChromaText) {
/* 109 */       this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 110 */             I18n.format("Chroma Mods: ON", new Object[0])));
/*     */     } else {
/* 112 */       this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 113 */             I18n.format("Chroma Mods: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 116 */     if (Client.LeftHand) {
/* 117 */       this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 118 */             I18n.format("Left Hand: ON", new Object[0])));
/*     */     } else {
/* 120 */       this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 121 */             I18n.format("Left Hand: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 124 */     if (Client.DynamicFOV) {
/* 125 */       this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 126 */             I18n.format("Dynamic FOV: ON", new Object[0])));
/*     */     } else {
/* 128 */       this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 129 */             I18n.format("Dynamic FOV: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 132 */     this.buttonList.add(new GuiButton(1022, this.width / 2 - 91, this.height / 2 + 78, 180, 20, 
/* 133 */           I18n.format("Back", new Object[0])));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_146595_g() {
/* 141 */     this.field_146597_g.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + " " + 
/* 142 */       I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
/* 143 */     this.field_146596_f.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
/*     */     
/* 145 */     if (this.field_146600_i) {
/* 146 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 147 */         I18n.format("options.on", new Object[0]);
/*     */     } else {
/* 149 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 150 */         I18n.format("options.off", new Object[0]);
/*     */     } 
/*     */   }
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/*     */     boolean flag, flag1;
/* 155 */     switch (button.id) {
/*     */       case 0:
/* 157 */         this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
/*     */ 
/*     */       
/*     */       case 1:
/* 161 */         flag = this.mc.isIntegratedServerRunning();
/* 162 */         flag1 = this.mc.func_181540_al();
/* 163 */         button.enabled = false;
/* 164 */         this.mc.theWorld.sendQuittingDisconnectingPacket();
/* 165 */         this.mc.loadWorld(null);
/*     */         
/* 167 */         if (flag) {
/* 168 */           this.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
/* 169 */         } else if (flag1) {
/* 170 */           RealmsBridge realmsbridge = new RealmsBridge();
/* 171 */           realmsbridge.switchToRealms((GuiScreen)new GuiMainMenu());
/*     */         } else {
/* 173 */           this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
/*     */         } 
/*     */ 
/*     */       
/*     */       default:
/*     */         return;
/*     */ 
/*     */       
/*     */       case 4:
/* 182 */         this.mc.displayGuiScreen(null);
/* 183 */         this.mc.setIngameFocus();
/*     */ 
/*     */       
/*     */       case 5:
/* 187 */         this.mc.displayGuiScreen((GuiScreen)new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
/*     */ 
/*     */       
/*     */       case 6:
/* 191 */         this.mc.displayGuiScreen((GuiScreen)new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
/*     */       
/*     */       case 7:
/* 194 */         this.mc.displayGuiScreen((GuiScreen)new GuiShareToLan(this));
/*     */ 
/*     */ 
/*     */       
/*     */       case 8:
/* 199 */         this.mc.displayGuiScreen(new GuiOtherMods(this));
/*     */       
/*     */       case 1005:
/* 202 */         Client.ToggleSprint = !Client.ToggleSprint;
/*     */         
/* 204 */         if (Client.ToggleSprint) {
/* 205 */           this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/* 206 */                 I18n.format("Toggle Sprint: ON", new Object[0])));
/*     */         } else {
/* 208 */           this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/* 209 */                 I18n.format("Toggle Sprint: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1006:
/* 213 */         Client.ItemPhysics = !Client.ItemPhysics;
/* 214 */         if (Client.ItemPhysics) {
/* 215 */           this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/* 216 */                 I18n.format("ItemPhysics: OFF", new Object[0])));
/*     */         } else {
/* 218 */           this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/* 219 */                 I18n.format("ItemPhysics: ON", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1007:
/* 223 */         Client.BetterAnimations = !Client.BetterAnimations;
/* 224 */         if (Client.BetterAnimations) {
/* 225 */           this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/* 226 */                 I18n.format("1.7 Animations: OFF", new Object[0])));
/*     */         } else {
/* 228 */           this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/* 229 */                 I18n.format("1.7 Animations: ON", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1008:
/* 233 */         Client.ChatBackground = !Client.ChatBackground;
/* 234 */         if (Client.ChatBackground) {
/* 235 */           this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 236 */                 I18n.format("ChatBackground: OFF", new Object[0])));
/*     */         } else {
/* 238 */           this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 239 */                 I18n.format("ChatBackground: ON", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 1009:
/* 244 */         Client.ChromaText = !Client.ChromaText;
/* 245 */         if (Client.ChromaText) {
/* 246 */           this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 247 */                 I18n.format("Chroma Mods: ON", new Object[0])));
/*     */         } else {
/* 249 */           this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 250 */                 I18n.format("Chroma Mods: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1010:
/* 254 */         Client.LeftHand = !Client.LeftHand;
/* 255 */         if (Client.LeftHand) {
/* 256 */           this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 257 */                 I18n.format("Left Hand: ON", new Object[0])));
/*     */         } else {
/* 259 */           this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 260 */                 I18n.format("Left Hand: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1011:
/* 264 */         Client.DynamicFOV = !Client.DynamicFOV;
/* 265 */         if (Client.DynamicFOV) {
/* 266 */           this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 267 */                 I18n.format("Dynamic FOV: ON", new Object[0])));
/*     */         } else {
/* 269 */           this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 270 */                 I18n.format("Dynamic FOV: OFF", new Object[0])));
/*     */         } 
/*     */       case 1022:
/*     */         break;
/*     */     } 
/* 275 */     this.mc.displayGuiScreen(new GUIToggle(this));
/*     */   }
  
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 286 */     drawDefaultBackground();
/* 287 */     drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Ingame Mods", this.width / 2 - 32, this.height / 2 - 120, -1);
/* 288 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }
