/*    */ package clientname.gui.hud;
/*    */ 
/*    */ import clientname.event.EventManager;
/*    */ import clientname.event.EventTarget;
/*    */ import clientname.event.impl.RenderEvent;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.Minecraft;

/*    */ public class HUDManager
/*    */ {
/* 19 */   private static HUDManager instance = null;
/*    */   
/*    */   private static boolean isPaused;
/*    */   
/*    */   public static HUDManager getInstance() {
/* 24 */     if (instance != null) {
/* 25 */       return instance;
/*    */     }
/*    */     
/* 28 */     instance = new HUDManager();
/* 29 */     EventManager.register(instance);
/*    */     
/* 31 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 36 */   private Set<IRenderer> registeredRenderers = Sets.newHashSet();
/* 37 */   private Minecraft mc = Minecraft.getMinecraft(); public void register(IRenderer... renderers) { byte b;
/*    */     int i;
/*    */     IRenderer[] arrayOfIRenderer;
/* 40 */     for (i = (arrayOfIRenderer = renderers).length, b = 0; b < i; ) { IRenderer render = arrayOfIRenderer[b];
/* 41 */       this.registeredRenderers.add(render);
/*    */       b++; }
/*    */      } public void unreister(IRenderer... renderers) { byte b;
/*    */     int i;
/*    */     IRenderer[] arrayOfIRenderer;
/* 46 */     for (i = (arrayOfIRenderer = renderers).length, b = 0; b < i; ) { IRenderer render = arrayOfIRenderer[b];
/* 47 */       this.registeredRenderers.remove(render);
/*    */       b++; }
/*    */      }
/*    */   
/*    */   public Collection<IRenderer> getRegisteredRenderers() {
/* 52 */     return Sets.newHashSet(this.registeredRenderers);
/*    */   }
/*    */   
/*    */   public void openConfigScreen() {
/* 56 */     isPaused = false;
/* 57 */     this.mc.displayGuiScreen(new HUDConfigScreen(this, true));
/*    */   }
/*    */   
/*    */   public void openConfigScreenPaused() {
/* 61 */     isPaused = true;
/* 62 */     this.mc.displayGuiScreen(new HUDConfigScreen(this, false));
/*    */   }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onRender(RenderEvent e) {
/* 68 */     if ((this.mc.currentScreen == null || this.mc.currentScreen instanceof net.minecraft.client.gui.inventory.GuiContainer) && (
/* 69 */       this.mc.currentScreen == null || this.mc.currentScreen instanceof net.minecraft.client.gui.GuiChat)) {
/* 70 */       if (this.mc.gameSettings.showDebugInfo) {
/*    */         return;
/*    */       }
/* 73 */       for (IRenderer renderer : this.registeredRenderers) {
/* 74 */         callRenderer(renderer);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void callRenderer(IRenderer renderer) {
/* 81 */     if (!renderer.isEnabled()) {
/*    */       return;
/*    */     }
/*    */     
/* 85 */     ScreenPosition pos = renderer.load();
/*    */     
/* 87 */     if (pos == null) {
/* 88 */       pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/*    */     }
/*    */     
/* 91 */     renderer.render(pos);
/*    */   }
/*    */ }
