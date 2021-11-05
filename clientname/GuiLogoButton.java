/*    */ package clientname;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 

/*    */ public class GuiLogoButton
/*    */   extends GuiButtonScope
/*    */ {
/*    */   ScaledResolution scaledResolution;
/*    */   ResourceLocation location;
/*    */   boolean isHead;
/*    */   
/*    */   public GuiLogoButton(int buttonId, ScaledResolution scaledResolution, int x, int y, int widthIn, int heightIn, ResourceLocation location, boolean isHead) {
/* 28 */     super(buttonId, x, y, widthIn, heightIn, "");
/* 29 */     this.scaledResolution = scaledResolution;
/* 30 */     this.location = location;
/* 31 */     this.isHead = isHead;
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 36 */     if (this.visible) {
/* 37 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 38 */       boolean flag = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 39 */       int i = 106;
/*    */       
/* 41 */       if (flag)
/*    */       {
/* 43 */         i += this.height;
/*    */       }
/*    */       
/* 46 */       mc.getTextureManager().bindTexture(this.location);
/* 47 */       if (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height) {
/* 48 */         if (this.isHead) {
/* 49 */           GL11.glPushMatrix();
/* 50 */           GL11.glScissor(0, (int)(575.0D / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor(), (int)(62.0D / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor() + 2, 100);
/* 51 */           GL11.glEnable(3089);
/*    */         } 
/* 53 */         Gui.drawScaledCustomSizeModalRect(this.xPosition - 10, this.yPosition - 10, -5.0F, -5.0F, this.width + 10, this.height + 10, this.width + 10, this.height + 10, (this.width + 10), (this.height + 10));
/*    */       } else {
/* 55 */         if (this.isHead) {
/* 56 */           GL11.glPushMatrix();
/* 57 */           GL11.glScissor(0, (int)(580.0D / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor(), (int)(60.0D / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor() + 2, 100);
/* 58 */           GL11.glEnable(3089);
/*    */         } 
/* 60 */         Gui.drawScaledCustomSizeModalRect(this.xPosition, this.yPosition, 0.0F, 0.0F, this.width, this.height, this.width, this.height, this.width, this.height);
/*    */       } 
/* 62 */       if (this.isHead) {
/* 63 */         GL11.glDisable(3089);
/* 64 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }