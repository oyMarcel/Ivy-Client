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

/*     */ public class GUIToggle
/*     */   extends GuiScreen
/*     */ {
/*     */   private GuiScreen guiscreen;
/*     */   private boolean clear;
/*     */   private final GuiScreen field_146598_a;
/*  44 */   private static String Cape = "Cape";
/*  45 */   private static String Wings = "Wings";
/*  46 */   private static String ToggleSprint = "Toggle Sprint";
/*  47 */   private static String Halo = "Halo";
/*  48 */   private static String FPS = "FPS";
/*  49 */   private static String Keystrokes = "Keystrokes";
/*  50 */   private static String Ping = "Ping";
/*  51 */   private static String ArmorStatus = "Armor Status";
/*  52 */   private static String Time = "Time";
/*  53 */   private static String PotionStatus = "Potion Status";
/*  54 */   private static String ModPosition = "ModPosition";
/*     */   
/*     */   private GuiButton field_146596_f;
/*     */   
/*     */   private GuiButton field_146597_g;
/*     */   
/*  60 */   private String field_146599_h = "survival";
/*     */   private boolean field_146600_i;
/*     */   
/*     */   public GUIToggle(GuiScreen p_i1055_1_) {
/*  64 */     this.field_146598_a = p_i1055_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void openConfigScreen() {
/*  69 */     this.mc.displayGuiScreen(new GUIToggle(this));
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
/*  81 */     this.buttonList.add(new GuiButton(2001, this.width / 2 - 125, this.height / 2 - 90, 250, 20, 
/*  82 */           I18n.format("Ingame Mods", new Object[0])));
/*     */ 
/*     */     
/*  85 */     this.buttonList.add(new GuiButton(2002, this.width / 2 - 125, this.height / 2 - 65, 250, 20, 
/*  86 */           I18n.format("Cosmetics", new Object[0])));
/*     */     
/*  88 */     this.buttonList.add(new GuiButton(2004, this.width / 2 - 125, this.height / 2 - 40, 250, 20, 
/*  89 */           I18n.format("Other Mods", new Object[0])));
/*     */     
/*  91 */     this.buttonList.add(new GuiButton(2003, this.width / 2 - 75, this.height / 2 - 15, 150, 20, 
/*  92 */           I18n.format("Customize Modposition", new Object[0])));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_146595_g() {
/* 163 */     this.field_146597_g.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + " " + 
/* 164 */       I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
/* 165 */     this.field_146596_f.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
/*     */     
/* 167 */     if (this.field_146600_i) {
/* 168 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 169 */         I18n.format("options.on", new Object[0]);
/*     */     } else {
/* 171 */       this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + 
/* 172 */         I18n.format("options.off", new Object[0]);
/*     */     } 
/*     */   }
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/*     */     boolean flag, flag1;
/* 177 */     switch (button.id) {
/*     */       case 0:
/* 179 */         this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
/*     */ 
/*     */       
/*     */       case 1:
/* 183 */         flag = this.mc.isIntegratedServerRunning();
/* 184 */         flag1 = this.mc.func_181540_al();
/* 185 */         button.enabled = false;
/* 186 */         this.mc.theWorld.sendQuittingDisconnectingPacket();
/* 187 */         this.mc.loadWorld(null);
/*     */         
/* 189 */         if (flag) {
/* 190 */           this.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
/* 191 */         } else if (flag1) {
/* 192 */           RealmsBridge realmsbridge = new RealmsBridge();
/* 193 */           realmsbridge.switchToRealms((GuiScreen)new GuiMainMenu());
/*     */         } else {
/* 195 */           this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
/*     */         } 
/*     */ 
/*     */       
/*     */       default:
/*     */         return;
/*     */ 
/*     */       
/*     */       case 4:
/* 204 */         this.mc.displayGuiScreen(null);
/* 205 */         this.mc.setIngameFocus();
/*     */ 
/*     */       
/*     */       case 5:
/* 209 */         this.mc.displayGuiScreen((GuiScreen)new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
/*     */ 
/*     */       
/*     */       case 6:
/* 213 */         this.mc.displayGuiScreen((GuiScreen)new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
/*     */       
/*     */       case 7:
/* 216 */         this.mc.displayGuiScreen((GuiScreen)new GuiShareToLan(this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1001:
/* 228 */         Client.CosmeticWings = !Client.CosmeticWings;
/*     */       
/*     */       case 1002:
/* 231 */         Client.ToggleSprint = !Client.ToggleSprint;
/*     */       
/*     */       case 1003:
/* 234 */         Client.CosmeticCape = !Client.CosmeticCape;
/*     */       
/*     */       case 1004:
/* 237 */         Client.CosmeticHalo = !Client.CosmeticHalo;
/*     */       
/*     */       case 8:
/* 240 */         this.mc.displayGuiScreen(new GUIToggle(this));
/*     */       
/*     */       case 1005:
/* 243 */         Client.ModFPS = !Client.ModFPS;
/*     */       
/*     */       case 1006:
/* 246 */         Client.ModKeystrokes = !Client.ModKeystrokes;
/*     */       
/*     */       case 1007:
/* 249 */         Client.ModPing = !Client.ModPing;
/*     */       
/*     */       case 1008:
/* 252 */         Client.ModArmorStatus = !Client.ModArmorStatus;
/*     */       
/*     */       case 1009:
/* 255 */         Client.ModTimeShow = !Client.ModTimeShow;
/*     */       
/*     */       case 1010:
/* 258 */         Client.ModPotionstatus = !Client.ModPotionstatus;
/*     */       
/*     */       case 1011:
/* 261 */         Client.ModPosition = !Client.ModPosition;
/*     */       
/*     */       case 1012:
/* 264 */         Client.ItemPhysics = !Client.ItemPhysics;
/*     */       
/*     */       case 1013:
/* 267 */         Client.BetterAnimations = !Client.BetterAnimations;
/*     */       
/*     */       case 1014:
/* 270 */         Client.DiamondHead = !Client.DiamondHead;
/*     */       
/*     */       case 1015:
/* 273 */         Client.ChatBackground = !Client.ChatBackground;
/*     */       
/*     */       case 1016:
/* 276 */         Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
/*     */       
/*     */       case 1017:
/* 279 */         Client.ChromaText = !Client.ChromaText;
/*     */       
/*     */       case 1018:
/* 282 */         Client.LeftHand = !Client.LeftHand;
/*     */       
/*     */       case 1019:
/* 285 */         Client.WidePlayer = !Client.WidePlayer;
/*     */       
/*     */       case 1020:
/* 288 */         Client.DynamicFOV = !Client.DynamicFOV;
/*     */       
/*     */       case 1021:
/* 291 */         Client.ModBiom = !Client.ModBiom;
/*     */       
/*     */       case 2001:
/* 294 */         this.mc.displayGuiScreen(new GuiIngameMods(this));
/*     */       
/*     */       case 2002:
/* 297 */         this.mc.displayGuiScreen(new GuiCosmetics(this));
/*     */       
/*     */       case 2004:
/* 300 */         this.mc.displayGuiScreen(new GuiOtherMods(this));
/*     */       case 2003:
/*     */         break;
/* 303 */     }  if (this.guiscreen instanceof GuiMainMenu) {
/* 304 */       Client.getInstance().getHudManager().openConfigScreenPaused();
/*     */     }
/* 306 */     Client.getInstance().getHudManager().openConfigScreen();
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
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 319 */     drawDefaultBackground();
/*     */     
/* 321 */     drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + Client.ClientName + " Settings", this.width / 2 - Client.guiToggleClientName, 
/* 322 */         this.height / 2 - 130, -1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 328 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }
