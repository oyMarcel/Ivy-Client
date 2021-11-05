/*     */ package clientname.mods.impl;
/*     */ 
/*     */ import clientname.event.EventTarget;
/*     */ import clientname.event.impl.KeyEvent;
/*     */ import clientname.gui.hud.ScreenPosition;
/*     */ import clientname.mods.ModDraggable;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.Display;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModPerspective
/*     */   extends ModDraggable
/*     */ {
/*     */   private boolean returnOnRelease = true;
/*     */   public static boolean perspectiveToggled = false;
/*  20 */   private float cameraYaw = 0.0F;
/*  21 */   private float cameraPitch = 0.0F;
/*  22 */   private int previousPerspective = 0;
/*     */   
/*     */   @EventTarget
/*     */   public void keyboardEvent(KeyEvent e) {
/*  26 */     if (e.getKey() == this.mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode())
/*     */     {
/*     */ 
/*     */       
/*  30 */       if (Keyboard.getEventKeyState()) {
/*  31 */         perspectiveToggled = !perspectiveToggled;
/*     */         
/*  33 */         this.cameraYaw = this.mc.thePlayer.rotationYaw;
/*  34 */         this.cameraPitch = this.mc.thePlayer.rotationPitch;
/*     */         
/*  36 */         if (perspectiveToggled) {
/*  37 */           this.previousPerspective = this.mc.gameSettings.thirdPersonView;
/*  38 */           this.mc.gameSettings.thirdPersonView = 1;
/*     */         } else {
/*     */           
/*  41 */           this.mc.gameSettings.thirdPersonView = this.previousPerspective;
/*     */         }
/*     */       
/*  44 */       } else if (this.returnOnRelease) {
/*  45 */         perspectiveToggled = false;
/*  46 */         this.mc.gameSettings.thirdPersonView = this.previousPerspective;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  52 */     if (Keyboard.getEventKey() == this.mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
/*  53 */       perspectiveToggled = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getCameraYaw() {
/*  61 */     return perspectiveToggled ? this.cameraYaw : this.mc.thePlayer.rotationYaw;
/*     */   }
/*     */   public float getCameraPitch() {
/*  64 */     return perspectiveToggled ? this.cameraPitch : this.mc.thePlayer.rotationPitch;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean overrideMouse() {
/*  69 */     if (this.mc.inGameHasFocus && Display.isActive()) {
/*     */       
/*  71 */       if (!perspectiveToggled) {
/*  72 */         return true;
/*     */       }
/*     */       
/*  75 */       this.mc.mouseHelper.mouseXYChange();
/*  76 */       float f1 = this.mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
/*  77 */       float f2 = f1 * f1 * f1 * 8.0F;
/*  78 */       float f3 = this.mc.mouseHelper.deltaX * f2;
/*  79 */       float f4 = this.mc.mouseHelper.deltaY * f2;
/*     */       
/*  81 */       this.cameraYaw += f3 * 0.15F;
/*  82 */       this.cameraPitch += f4 * 0.15F;
/*     */       
/*  84 */       if (this.cameraPitch > 90.0F) this.cameraPitch = 90.0F; 
/*  85 */       if (this.cameraPitch < -90.0F) this.cameraPitch = -90.0F;
/*     */     
/*     */     } 
/*  88 */     if (this.cameraYaw < -90.0F) {
/*  89 */       this.cameraYaw = -90.0F;
/*     */     }
/*     */     
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 100 */     return font.getStringWidth("");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 105 */     return font.FONT_HEIGHT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/* 110 */     if (perspectiveToggled)
/*     */     {
/* 112 */       this.mc.fontRendererObj.drawStringWithShadow("", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*     */     }
/*     */   }
/*     */ }
