/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModArmorStatus
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 18 */     return 64;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 23 */     return 64;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 28 */     if (Client.ModArmorStatus) {
/* 29 */       for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; i++) {
/* 30 */         ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
/* 31 */         renderItemStack(pos, i, itemStack);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 39 */     renderItemStack(pos, 3, new ItemStack((Item)Items.chainmail_helmet));
/* 40 */     renderItemStack(pos, 2, new ItemStack((Item)Items.chainmail_chestplate));
/* 41 */     renderItemStack(pos, 1, new ItemStack((Item)Items.chainmail_leggings));
/* 42 */     renderItemStack(pos, 0, new ItemStack((Item)Items.chainmail_boots));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
/* 48 */     if (is == null) {
/*    */       return;
/*    */     }
/*    */     
/* 52 */     GL11.glPushMatrix();
/* 53 */     int yAdd = -16 * i + 48;
/*    */     
/* 55 */     if (is.getItem().isDamageable()) {
/* 56 */       double damage = (is.getMaxDamage() - is.getItemDamage()) / is.getMaxDamage() * 100.0D;
/*    */       
/* 58 */       font.drawString(String.format("%.2f%%", new Object[] { Double.valueOf(damage) }), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 63 */     RenderHelper.enableGUIStandardItemLighting();
/* 64 */     this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
/* 65 */     GL11.glPopMatrix();
/*    */   }
/*    */ }
