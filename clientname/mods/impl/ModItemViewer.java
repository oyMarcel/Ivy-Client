/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModItemViewer
/*    */   extends ModDraggable
/*    */ {
/*    */   private ScreenPosition pos;
/*    */   
/*    */   public int getWidth() {
/* 19 */     return 40;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 25 */     return 17;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 30 */     if (Client.ModItemViewer) {
/* 31 */       renderItemStack(pos, 3, this.mc.thePlayer.getCurrentEquippedItem());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 37 */     if (Client.ModItemViewer) {
/* 38 */       renderItemStack(pos, 3, new ItemStack(Items.golden_sword));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
/* 47 */     if (is == null) {
/*    */       return;
/*    */     }
/*    */     
/* 51 */     GL11.glPushMatrix();
/* 52 */     int yAdd = -16 * i + 48;
/*    */     
/* 54 */     if (is.getItem().isDamageable()) {
/* 55 */       double damage = (is.getMaxDamage() - is.getItemDamage()) / is.getMaxDamage() * 100.0D;
/* 56 */       font.drawString(String.format("%.2f%%", new Object[] { Double.valueOf(damage) }), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, 16777215);
/*    */     } 
/*    */     
/* 59 */     RenderHelper.enableGUIStandardItemLighting();
/* 60 */     this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
/* 61 */     GL11.glPopMatrix();
/*    */   }
/*    */ }
