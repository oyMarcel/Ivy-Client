/*    */ package clientname.mods.impl;
/*    */ 
/*    */ import clientname.ChromaText;
/*    */ import clientname.Client;
/*    */ import clientname.gui.hud.ScreenPosition;
/*    */ import clientname.mods.ModDraggable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ 
/*    */ 
/*    */ public class ModBiom
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 16 */     BlockPos blockpos = new BlockPos((this.mc.getRenderViewEntity()).posX, (this.mc.getRenderViewEntity().getEntityBoundingBox()).minY, (this.mc.getRenderViewEntity()).posZ);
/* 17 */     Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
/* 18 */     return font.getStringWidth("Biom" + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 23 */     return font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 29 */     if (Client.ModBiom)
/* 30 */       if (!Client.ChromaText) {
/*    */         
/* 32 */         BlockPos blockpos = new BlockPos((this.mc.getRenderViewEntity()).posX, (this.mc.getRenderViewEntity().getEntityBoundingBox()).minY, (this.mc.getRenderViewEntity()).posZ);
/* 33 */         Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
/* 34 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "Biome" + Client.KlammerFarbe + "] " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*    */       } else {
/* 36 */         BlockPos blockpos = new BlockPos((this.mc.getRenderViewEntity()).posX, (this.mc.getRenderViewEntity().getEntityBoundingBox()).minY, (this.mc.getRenderViewEntity()).posZ);
/* 37 */         Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
/* 38 */         ChromaText.drawChromaString("[Biome] " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
/*    */       }  
/*    */   }
/*    */ }
