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
 
/*     */ 
/*     */ public class GuiIngameMods
/*     */   extends GuiScreen
/*     */ {
/*     */   private final GuiScreen field_146598_a;
/*  40 */   private static String Cape = "Cape";
/*  41 */   private static String Wings = "Wings";
/*  42 */   private static String ToggleSprint = "Toggle Sprint";
/*  43 */   private static String Halo = "Halo";
/*  44 */   private static String FPS = "FPS";
/*  45 */   private static String Keystrokes = "Keystrokes";
/*  46 */   private static String Ping = "Ping";
/*  47 */   private static String ArmorStatus = "Armor Status";
/*  48 */   private static String Time = "Time";
/*  49 */   private static String PotionStatus = "Potion Status";
/*  50 */   private static String ModPosition = "ModPosition";
/*     */   
/*     */   private GuiButton field_146596_f;
/*     */   
/*     */   private GuiButton field_146597_g;
/*     */   
/*  56 */   private String field_146599_h = "survival";
/*     */   private boolean field_146600_i;
/*     */   
/*     */   public GuiIngameMods(GuiScreen p_i1055_1_) {
/*  60 */     this.field_146598_a = p_i1055_1_;
/*     */   } 
/*     */   public void initGui() {
/*  72 */     if (Client.ModFPS) {
/*  73 */       this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/*  74 */             I18n.format("FPS: ON", new Object[0])));
/*  75 */     } else if (!Client.ModFPS) {
/*  76 */       this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/*  77 */             I18n.format("FPS: OFF", new Object[0])));
/*     */     } 
/*  79 */     if (Client.ModKeystrokes) {
/*  80 */       this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/*  81 */             I18n.format("Keystrokes: ON", new Object[0])));
/*  82 */     } else if (!Client.ModKeystrokes) {
/*  83 */       this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/*  84 */             I18n.format("Keystrokes: OFF", new Object[0])));
/*     */     } 
/*     */ 
/*     */     
/*  88 */     if (Client.ModPing) {
/*  89 */       this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/*  90 */             I18n.format("Ping: ON", new Object[0])));
/*  91 */     } else if (!Client.ModPing) {
/*  92 */       this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/*  93 */             I18n.format("Ping: OFF", new Object[0])));
/*     */     } 
/*  95 */     if (Client.ModArmorStatus) {
/*  96 */       this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/*  97 */             I18n.format("ArmorStatus: ON", new Object[0])));
/*     */     } else {
/*  99 */       this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 100 */             I18n.format("ArmorStatus: OFF", new Object[0])));
/*     */     } 
/* 102 */     if (Client.ModTimeShow) {
/* 103 */       this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 104 */             I18n.format("Time: ON", new Object[0])));
/*     */     } else {
/* 106 */       this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 107 */             I18n.format("Time: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 110 */     if (Client.ModPotionstatus) {
/* 111 */       this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 112 */             I18n.format("PotionStatus: ON", new Object[0])));
/*     */     } else {
/* 114 */       this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 115 */             I18n.format("PotionStatus: OFF", new Object[0])));
/*     */     } 
/* 117 */     if (Client.ModPosition) {
/* 118 */       this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 119 */             I18n.format("ModPosition: ON", new Object[0])));
/*     */     } else {
/* 121 */       this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 122 */             I18n.format("ModPosition: OFF", new Object[0])));
/*     */     } 
/* 124 */     if (Client.ModBiom) {
/* 125 */       this.buttonList.add(new GuiButton(1021, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 126 */             I18n.format("Biome: ON", new Object[0])));
/*     */     } else {
/* 128 */       this.buttonList.add(new GuiButton(1021, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 129 */             I18n.format("Biome: OFF", new Object[0])));
/*     */     } 
/*     */     
/* 132 */     this.buttonList.add(new GuiButton(1022, this.width / 2 - 91, this.height / 2 + 104, 180, 20, 
/* 133 */           I18n.format("Back", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_146595_g() {
/* 138 */     this.field_146597_g.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + " " + 
/* 139 */       I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
/* 140 */     this.field_146596_f.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
/*     */     
/* 142 */     if (this.field_146600_i) {
/* 143 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 144 */         I18n.format("options.on", new Object[0]);
/*     */     } else {
/* 146 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 147 */         I18n.format("options.off", new Object[0]);
/*     */     } 
/*     */   }
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/*     */     boolean flag, flag1;
/* 152 */     switch (button.id) {
/*     */       case 0:
/* 154 */         this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
/*     */ 
/*     */       
/*     */       case 1:
/* 158 */         flag = this.mc.isIntegratedServerRunning();
/* 159 */         flag1 = this.mc.func_181540_al();
/* 160 */         button.enabled = false;
/* 161 */         this.mc.theWorld.sendQuittingDisconnectingPacket();
/* 162 */         this.mc.loadWorld(null);
/*     */         
/* 164 */         if (flag) {
/* 165 */           this.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
/* 166 */         } else if (flag1) {
/* 167 */           RealmsBridge realmsbridge = new RealmsBridge();
/* 168 */           realmsbridge.switchToRealms((GuiScreen)new GuiMainMenu());
/*     */         } else {
/* 170 */           this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
/*     */         } 
/*     */ 
/*     */       
/*     */       default:
/*     */         return;
/*     */ 
/*     */       
/*     */       case 4:
/* 179 */         this.mc.displayGuiScreen(null);
/* 180 */         this.mc.setIngameFocus();
/*     */ 
/*     */       
/*     */       case 5:
/* 184 */         this.mc.displayGuiScreen((GuiScreen)new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
/*     */ 
/*     */       
/*     */       case 6:
/* 188 */         this.mc.displayGuiScreen((GuiScreen)new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
/*     */       
/*     */       case 7:
/* 191 */         this.mc.displayGuiScreen((GuiScreen)new GuiShareToLan(this));
/*     */ 
/*     */       
/*     */       case 8:
/* 195 */         this.mc.displayGuiScreen(new GuiIngameMods(this));
/*     */       
/*     */       case 1005:
/* 198 */         Client.ModFPS = !Client.ModFPS;
/*     */         
/* 200 */         if (Client.ModFPS) {
/* 201 */           this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/* 202 */                 I18n.format("FPS: ON", new Object[0])));
/* 203 */         } else if (!Client.ModFPS) {
/* 204 */           this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, 
/* 205 */                 I18n.format("FPS: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 1006:
/* 210 */         Client.ModKeystrokes = !Client.ModKeystrokes;
/*     */         
/* 212 */         if (Client.ModKeystrokes) {
/* 213 */           this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/* 214 */                 I18n.format("Keystrokes: ON", new Object[0])));
/* 215 */         } else if (!Client.ModKeystrokes) {
/* 216 */           this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, 
/* 217 */                 I18n.format("Keystrokes: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 1007:
/* 222 */         Client.ModPing = !Client.ModPing;
/*     */         
/* 224 */         if (Client.ModPing) {
/* 225 */           this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/* 226 */                 I18n.format("Ping: ON", new Object[0])));
/* 227 */         } else if (!Client.ModPing) {
/* 228 */           this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, 
/* 229 */                 I18n.format("Ping: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1008:
/* 233 */         Client.ModArmorStatus = !Client.ModArmorStatus;
/*     */         
/* 235 */         if (Client.ModArmorStatus) {
/* 236 */           this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 237 */                 I18n.format("ArmorStatus: ON", new Object[0])));
/*     */         } else {
/* 239 */           this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, 
/* 240 */                 I18n.format("ArmorStatus: OFF", new Object[0])));
/*     */         } 
/*     */       
/*     */       case 1009:
/* 244 */         Client.ModTimeShow = !Client.ModTimeShow;
/* 245 */         if (Client.ModTimeShow) {
/* 246 */           this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 247 */                 I18n.format("Time: ON", new Object[0])));
/*     */         } else {
/* 249 */           this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, 
/* 250 */                 I18n.format("Time: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 1010:
/* 255 */         Client.ModPotionstatus = !Client.ModPotionstatus;
/* 256 */         if (Client.ModPotionstatus) {
/* 257 */           this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 258 */                 I18n.format("PotionStatus: ON", new Object[0])));
/*     */         } else {
/* 260 */           this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, 
/* 261 */                 I18n.format("PotionStatus: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 1011:
/* 266 */         Client.ModPosition = !Client.ModPosition;
/* 267 */         if (Client.ModPosition) {
/* 268 */           this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 269 */                 I18n.format("ModPosition: ON", new Object[0])));
/*     */         } else {
/* 271 */           this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, 
/* 272 */                 I18n.format("ModPosition: OFF", new Object[0])));
/*     */         } 
/*     */ 
/*     */       
/*     */       case 1021:
/* 277 */         Client.ModBiom = !Client.ModBiom;
/* 278 */         if (Client.ModBiom) {
/* 279 */           this.buttonList.set(7, new GuiButton(1021, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 280 */                 I18n.format("Biome: ON", new Object[0])));
/*     */         } else {
/* 282 */           this.buttonList.set(7, new GuiButton(1021, this.width / 2 - 61, this.height / 2 + 78, 120, 20, 
/* 283 */                 I18n.format("Biome: OFF", new Object[0])));
/*     */         } 
/*     */       case 1022:
/*     */         break;
/* 287 */     }  this.mc.displayGuiScreen(new GUIToggle(this));
/*     */   }
  
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 298 */     drawDefaultBackground();
/*     */     
/* 300 */     drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Ingame Mods", this.width / 2 - 31, this.height / 2 - 120, 
/* 301 */         -1);
/* 302 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }