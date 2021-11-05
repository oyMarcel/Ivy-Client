/*     */ package clientname.mods.impl;
/*     */ 
/*     */ import clientname.Client;
/*     */ import clientname.gui.hud.ScreenPosition;
/*     */ import clientname.mods.ModDraggable;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModKeystrokes
/*     */   extends ModDraggable
/*     */ {
/*     */   private KeystrokesMode mode;
/*     */   private List<Long> clicksLMB;
/*     */   private boolean wasPressedLMB;
/*     */   private long lastPressedLMB;
/*     */   private List<Long> clicksRMB;
/*     */   private boolean wasPressedRMB;
/*     */   private long lastPressedRMB;
/*     */   
/*     */   public enum KeystrokesMode
/*     */   {
/*     */     WASD((String)new ModKeystrokes.Key[] { ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3() }),
/*     */     WASD_Mouse((String)new ModKeystrokes.Key[] { ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3(), ModKeystrokes.Key.access$4(), ModKeystrokes.Key.access$5() }),
/*     */     WASD_SPRINT((String)new ModKeystrokes.Key[] { ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3(), new ModKeystrokes.Key("Sprint", (Minecraft.getMinecraft()).gameSettings.keyBindSprint, 1, 41, 58, 18) }),
/*     */     WASD_SPRINT_MOUSE((String)new ModKeystrokes.Key[] { ModKeystrokes.Key.access$0(), ModKeystrokes.Key.access$1(), ModKeystrokes.Key.access$2(), ModKeystrokes.Key.access$3(), ModKeystrokes.Key.access$4(), ModKeystrokes.Key.access$5(), ModKeystrokes.Key.access$6(), ModKeystrokes.Key.access$7() });
/*     */     private int width = 0;
/*     */     private int height = 0;
/*     */     private final ModKeystrokes.Key[] keys;
/*     */     
/*     */     KeystrokesMode(ModKeystrokes.Key... keysIn) {
/*     */       this.keys = keysIn;
/*     */       byte b;
/*     */       int i;
/*     */       ModKeystrokes.Key[] arrayOfKey;
/*     */       for (i = (arrayOfKey = this.keys).length, b = 0; b < i; ) {
/*     */         ModKeystrokes.Key key = arrayOfKey[b];
/*     */         this.width = Math.max(this.width, key.getX() + key.getWidth());
/*     */         this.height = Math.max(this.height, key.getY() + key.getHeight());
/*     */         b++;
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public ModKeystrokes.Key[] getKeys() {
/*     */       return this.keys;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Key
/*     */   {
/*     */     private static final Key W = new Key("W", (Minecraft.getMinecraft()).gameSettings.keyBindForward, 21, 1, 18, 18);
/*     */     private static final Key A = new Key("A", (Minecraft.getMinecraft()).gameSettings.keyBindLeft, 1, 21, 18, 18);
/*     */     private static final Key S = new Key("S", (Minecraft.getMinecraft()).gameSettings.keyBindBack, 21, 21, 18, 18);
/*     */     private static final Key D = new Key("D", (Minecraft.getMinecraft()).gameSettings.keyBindRight, 41, 21, 18, 18);
/*     */     private static final Key LMB = new Key("LMB", (Minecraft.getMinecraft()).gameSettings.keyBindAttack, 1, 41, 28, 18);
/*     */     private static final Key RMB = new Key("RMB", (Minecraft.getMinecraft()).gameSettings.keyBindUseItem, 31, 41, 28, 18);
/*     */     private static final Key LMBCPS = new Key("0", (Minecraft.getMinecraft()).gameSettings.keyBindAttack, 1, 61, 28, 18);
/*     */     private static final Key RMBCPS = new Key("0", (Minecraft.getMinecraft()).gameSettings.keyBindUseItem, 31, 61, 28, 18);
/*     */     private final String name;
/*     */     private final KeyBinding keyBind;
/*     */     private final int x;
/*     */     private final int y;
/*     */     private final int width;
/*     */     private final int height;
/*     */     
/*     */     public Key(String name, KeyBinding keyBind, int x, int y, int width, int height) {
/*     */       this.name = name;
/*     */       this.keyBind = keyBind;
/*     */       this.x = x;
/*     */       this.y = y;
/*     */       this.width = width;
/*     */       this.height = height;
/*     */     }
/*     */     
/*     */     public boolean isDown() {
/*     */       return this.keyBind.isKeyDown();
/*     */     }
/*     */     
/*     */     public int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public String getName() {
/*     */       return this.name;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public int getX() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public int getY() {
/*     */       return this.y;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setMode(KeystrokesMode mode) {
/*     */     this.mode = mode;
/*     */   }
/*     */   
/*     */   public ModKeystrokes() {
/* 118 */     this.mode = KeystrokesMode.WASD_SPRINT_MOUSE;
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
/* 134 */     this.clicksLMB = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     this.clicksRMB = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPSRMB() {
/* 149 */     long time = System.currentTimeMillis();
/* 150 */     this.clicksRMB.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/* 151 */     return this.clicksRMB.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/* 157 */     GL11.glPushMatrix();
/* 158 */     if (Client.ModKeystrokes) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       boolean pressedLMB = Mouse.isButtonDown(0);
/* 165 */       if (pressedLMB != this.wasPressedLMB) {
/* 166 */         this.lastPressedLMB = System.currentTimeMillis();
/* 167 */         this.wasPressedLMB = pressedLMB;
/* 168 */         if (pressedLMB) {
/* 169 */           this.clicksLMB.add(Long.valueOf(this.lastPressedLMB));
/*     */         }
/*     */       } 
/* 172 */       Gui.drawRect(pos.getAbsoluteX() + Key.LMBCPS.getX(), pos.getAbsoluteY() + Key.LMBCPS.getY(), 
/* 173 */           pos.getAbsoluteX() + Key.LMBCPS.getX() + Key.LMBCPS.getWidth(), 
/* 174 */           pos.getAbsoluteY() + Key.LMBCPS.getY() + Key.LMBCPS.getHeight(), (
/* 175 */           new Color(0, 0, 0, 142)).getRGB());
/*     */       
/* 177 */       font.drawString((new StringBuilder(String.valueOf(getCPSLMB()))).toString(), 
/* 178 */           pos.getAbsoluteX() + Key.LMBCPS.getX() + Key.LMBCPS.getWidth() / 2 - font.getStringWidth("000") / 2, 
/* 179 */           pos.getAbsoluteY() + Key.LMBCPS.getY() + Key.LMBCPS.getHeight() / 2 - 4, 
/* 180 */           -1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       boolean pressedRMB = Mouse.isButtonDown(1);
/* 187 */       if (pressedRMB != this.wasPressedRMB) {
/* 188 */         this.lastPressedRMB = System.currentTimeMillis();
/* 189 */         this.wasPressedRMB = pressedRMB;
/* 190 */         if (pressedRMB) {
/* 191 */           this.clicksRMB.add(Long.valueOf(this.lastPressedRMB));
/*     */         }
/*     */       } 
/* 194 */       Gui.drawRect(pos.getAbsoluteX() + Key.RMBCPS.getX(), pos.getAbsoluteY() + Key.RMBCPS.getY(), 
/* 195 */           pos.getAbsoluteX() + Key.RMBCPS.getX() + Key.RMBCPS.getWidth(), 
/* 196 */           pos.getAbsoluteY() + Key.RMBCPS.getY() + Key.RMBCPS.getHeight(), (
/* 197 */           new Color(0, 0, 0, 142)).getRGB());
/*     */       
/* 199 */       font.drawString((new StringBuilder(String.valueOf(getCPSRMB()))).toString(), 
/* 200 */           pos.getAbsoluteX() + Key.RMBCPS.getX() + Key.RMBCPS.getWidth() / 2 - font.getStringWidth("000") / 2, 
/* 201 */           pos.getAbsoluteY() + Key.RMBCPS.getY() + Key.RMBCPS.getHeight() / 2 - 4, 
/* 202 */           -1);
/*     */       
/*     */       byte b;
/*     */       
/*     */       int i;
/*     */       Key[] arrayOfKey;
/* 208 */       for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) { Key key = arrayOfKey[b];
/*     */         
/* 210 */         if (key != Key.LMBCPS && key != Key.RMBCPS) {
/* 211 */           int textWidth = font.getStringWidth(key.getName());
/*     */           
/* 213 */           Gui.drawRect(pos.getAbsoluteX() + key.getX(), pos.getAbsoluteY() + key.getY(), 
/* 214 */               pos.getAbsoluteX() + key.getX() + key.getWidth(), 
/* 215 */               pos.getAbsoluteY() + key.getY() + key.getHeight(), 
/* 216 */               key.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 102)).getRGB());
/*     */           
/* 218 */           font.drawString(key.getName(), pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, 
/* 219 */               pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, 
/* 220 */               key.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
/*     */         } 
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/*     */     
/* 227 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*     */     return this.mode.getWidth();
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*     */     return this.mode.getHeight();
/*     */   }
/*     */   
/*     */   private int getCPSLMB() {
/*     */     long time = System.currentTimeMillis();
/*     */     this.clicksLMB.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/*     */     return this.clicksLMB.size();
/*     */   }
/*     */ }
