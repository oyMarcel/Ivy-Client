/*     */ package clientname.gui.hud;
/*     */ 
/*     */ import clientname.Client;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Predicate;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;

/*     */ public class HUDConfigScreen
/*     */   extends GuiScreen
/*     */ {
/*  25 */   private final HashMap<IRenderer, ScreenPosition> renderers = new HashMap<>();
/*     */   
/*  27 */   private Optional<IRenderer> selectedRenderer = Optional.empty();
/*     */   
/*     */   private int prevX;
/*     */   private int prevY;
/*     */   private boolean clear;
/*     */   
/*     */   public HUDConfigScreen(HUDManager api, boolean clear) {
/*  34 */     this.clear = clear;
/*     */     
/*  36 */     Collection<IRenderer> registeredRenderers = api.getRegisteredRenderers();
/*     */     
/*  38 */     for (IRenderer ren : registeredRenderers) {
/*  39 */       if (!ren.isEnabled()) {
/*     */         continue;
/*     */       }
/*     */       
/*  43 */       ScreenPosition pos = ren.load();
/*     */ 
/*     */ 
/*     */       
/*  47 */       if (pos == null) {
/*  48 */         pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/*     */       }
/*     */       
/*  51 */       adjustBounds(ren, pos);
/*  52 */       this.renderers.put(ren, pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  60 */     drawDefaultBackground();
/*     */     
/*  62 */     float zBackup = zLevel;
/*  63 */     zLevel = 200.0F;
/*     */     
/*  65 */     drawHollowRect(0, 0, this.width - 1, this.height - 1, Client.ConfigScreenColor);
/*     */ 
/*     */     
/*  68 */     for (IRenderer renderer : this.renderers.keySet()) {
/*     */       
/*  70 */       ScreenPosition pos = this.renderers.get(renderer);
/*     */ 
/*     */       
/*  73 */       renderer.renderDummy(pos);
/*     */     } 
     
/*  82 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*  83 */     zLevel = zBackup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawHollowRect(int x, int y, int w, int h, int color) {
/*  90 */     drawHorizontalLine(x, x + w, y, color);
/*  91 */     drawHorizontalLine(x, x + w, y + h, color);
/*     */     
/*  93 */     drawVerticalLine(x, y + h, y, color);
/*  94 */     drawVerticalLine(x + w, y + h, y, color);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void keyTyped(char typedChar, int keyCode) throws IOException {
/*  99 */     if (keyCode == 1) {
/* 100 */       this.renderers.entrySet().forEach(entry -> ((IRenderer)entry.getKey()).save(entry.getValue()));
/*     */ 
/*     */       
/* 103 */       this.mc.displayGuiScreen(null);
/*     */     } 
/* 105 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClickMove(int x, int y, int button, long time) {
/* 110 */     if (this.selectedRenderer.isPresent()) {
/* 111 */       moveSelectedRenderBy(x - this.prevX, y - this.prevY);
/*     */     }
/*     */     
/* 114 */     this.prevX = x;
/* 115 */     this.prevY = y;
/* 116 */     super.mouseClickMove(x, y, button, time);
/*     */   }
/*     */   
/*     */   private void moveSelectedRenderBy(int offsetX, int offsetY) {
/* 120 */     IRenderer renderer = this.selectedRenderer.get();
/* 121 */     ScreenPosition pos = this.renderers.get(renderer);
/*     */     
/* 123 */     pos.setAbsolute(pos.getAbsoluteX() + offsetX, pos.getAbsoluteY() + offsetY);
/*     */     
/* 125 */     adjustBounds(renderer, pos);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 131 */     for (IRenderer renderer : this.renderers.keySet()) {
/* 132 */       renderer.save(this.renderers.get(renderer));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void adjustBounds(IRenderer renderer, ScreenPosition pos) {
/* 144 */     ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
/*     */     
/* 146 */     int screenWidth = res.getScaledWidth();
/* 147 */     int screenHeight = res.getScaledHeight();
/*     */     
/* 149 */     int absoluteX = Math.max(0, Math.min(pos.getAbsoluteX(), Math.max(screenWidth - renderer.getWidth(), 0)));
/* 150 */     int absoluteY = Math.max(0, Math.min(pos.getAbsoluteY(), Math.max(screenHeight - renderer.getHeight(), 0)));
/*     */     
/* 152 */     pos.setAbsolute(absoluteX, absoluteY);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int x, int y, int mobuttonuseButton) throws IOException {
/* 157 */     this.prevX = x;
/* 158 */     this.prevY = y;
/*     */     
/* 160 */     loadMouseOver(x, y);
/* 161 */     super.mouseClicked(x, y, mobuttonuseButton);
/*     */   }
/*     */   
/*     */   private void loadMouseOver(int x, int y) {
/* 165 */     this.selectedRenderer = this.renderers.keySet().stream().filter(new MouseOverFinder(x, y)).findFirst();
/*     */   }
/*     */   
/*     */   private class MouseOverFinder implements Predicate<IRenderer> {
/*     */     private int mouseX;
/*     */     private int mouseY;
/*     */     
/*     */     public MouseOverFinder(int x, int y) {
/* 173 */       this.mouseX = x;
/* 174 */       this.mouseY = y;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean test(IRenderer renderer) {
/* 180 */       ScreenPosition pos = (ScreenPosition)HUDConfigScreen.this.renderers.get(renderer);
/*     */       
/* 182 */       int absoluteX = pos.getAbsoluteX();
/* 183 */       int absoluteY = pos.getAbsoluteY();
/*     */       
/* 185 */       if (this.mouseX >= absoluteX && this.mouseX <= absoluteX + renderer.getWidth())
/*     */       {
/* 187 */         if (this.mouseY >= absoluteY && this.mouseY <= absoluteY + renderer.getHeight())
/*     */         {
/* 189 */           return true;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 195 */       return false;
/*     */     }
/*     */   }
/*     */ }
