/*     */ package clientname.gui;
/*     */ 
/*     */ import clientname.Client;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontFormatException;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.newdawn.slick.Color;
/*     */ import org.newdawn.slick.UnicodeFont;
/*     */ import org.newdawn.slick.font.effects.ColorEffect;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnicodeFontRenderer
/*     */ {
/*     */   public static UnicodeFontRenderer getFontOnPC(String name, int size) {
/*  27 */     return getFontOnPC(name, size, 0);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontOnPC(String name, int size, int fontType) {
/*  31 */     return getFontOnPC(name, size, fontType, 0.0F);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontOnPC(String name, int size, int fontType, float kerning) {
/*  35 */     return getFontOnPC(name, size, fontType, kerning, 3.0F);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontOnPC(String name, int size, int fontType, float kerning, float antiAliasingFactor) {
/*  39 */     return new UnicodeFontRenderer(new Font(name, fontType, size), kerning, antiAliasingFactor);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontFromAssets(String name, int size) {
/*  43 */     return getFontOnPC(name, size, 0);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontFromAssets(String name, int size, int fontType) {
/*  47 */     return getFontOnPC(name, fontType, size, 0.0F);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontFromAssets(String name, int size, float kerning, int fontType) {
/*  51 */     return getFontFromAssets(name, size, fontType, kerning, 3.0F);
/*     */   }
/*     */   
/*     */   public static UnicodeFontRenderer getFontFromAssets(String name, int size, int fontType, float kerning, float antiAliasingFactor) {
/*  55 */     return new UnicodeFontRenderer(name, fontType, size, kerning, antiAliasingFactor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public final int FONT_HEIGHT = 9;
/*  62 */   private final int[] colorCodes = new int[32];
/*     */   private final float kerning;
/*  64 */   private final Map<String, Float> cachedStringWidth = new HashMap<>();
/*     */   private float antiAliasingFactor;
/*     */   private UnicodeFont unicodeFont;
/*     */   
/*     */   private UnicodeFontRenderer(String fontName, int fontType, float fontSize, float kerning, float antiAliasingFactor) {
/*  69 */     this.antiAliasingFactor = antiAliasingFactor;
/*     */     try {
/*  71 */       this.unicodeFont = new UnicodeFont(getFontByName(fontName).deriveFont(fontSize * this.antiAliasingFactor));
/*  72 */     } catch (FontFormatException|IOException e) {
/*  73 */       e.printStackTrace();
/*     */     } 
/*  75 */     this.kerning = kerning;
/*     */     
/*  77 */     this.unicodeFont.addAsciiGlyphs();
/*  78 */     this.unicodeFont.getEffects().add(new ColorEffect(Color.WHITE));
/*     */     
/*     */     try {
/*  81 */       this.unicodeFont.loadGlyphs();
/*  82 */     } catch (Exception e) {
/*  83 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  86 */     for (int i = 0; i < 32; i++) {
/*  87 */       int shadow = (i >> 3 & 0x1) * 85;
/*  88 */       int red = (i >> 2 & 0x1) * 170 + shadow;
/*  89 */       int green = (i >> 1 & 0x1) * 170 + shadow;
/*  90 */       int blue = (i & 0x1) * 170 + shadow;
/*     */       
/*  92 */       if (i == 6) {
/*  93 */         red += 85;
/*     */       }
/*     */       
/*  96 */       if (i >= 16) {
/*  97 */         red /= 4;
/*  98 */         green /= 4;
/*  99 */         blue /= 4;
/*     */       } 
/*     */       
/* 102 */       this.colorCodes[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */   
/*     */   private UnicodeFontRenderer(Font font, float kerning, float antiAliasingFactor) {
/* 107 */     this.antiAliasingFactor = antiAliasingFactor;
/* 108 */     this.unicodeFont = new UnicodeFont(new Font(font.getName(), font.getStyle(), (int)(font.getSize() * antiAliasingFactor)));
/* 109 */     this.kerning = kerning;
/*     */     
/* 111 */     this.unicodeFont.addAsciiGlyphs();
/* 112 */     this.unicodeFont.getEffects().add(new ColorEffect(Color.WHITE));
/*     */     
/*     */     try {
/* 115 */       this.unicodeFont.loadGlyphs();
/* 116 */     } catch (Exception e) {
/* 117 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 120 */     for (int i = 0; i < 32; i++) {
/* 121 */       int shadow = (i >> 3 & 0x1) * 85;
/* 122 */       int red = (i >> 2 & 0x1) * 170 + shadow;
/* 123 */       int green = (i >> 1 & 0x1) * 170 + shadow;
/* 124 */       int blue = (i & 0x1) * 170 + shadow;
/*     */       
/* 126 */       if (i == 6) {
/* 127 */         red += 85;
/*     */       }
/*     */       
/* 130 */       if (i >= 16) {
/* 131 */         red /= 4;
/* 132 */         green /= 4;
/* 133 */         blue /= 4;
/*     */       } 
/*     */       
/* 136 */       this.colorCodes[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Font getFontByName(String name) throws IOException, FontFormatException {
/* 141 */     return getFontFromInput("/assets/minecraft/clientname/fonts/" + name + ".ttf");
/*     */   }
/*     */   
/*     */   private Font getFontFromInput(String path) throws IOException, FontFormatException {
/* 145 */     return Font.createFont(0, Client.class.getResourceAsStream(path));
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawStringScaled(String text, int givenX, int givenY, int color, double givenScale) {
/* 150 */     GL11.glPushMatrix();
/* 151 */     GL11.glTranslated(givenX, givenY, 0.0D);
/* 152 */     GL11.glScaled(givenScale, givenScale, givenScale);
/* 153 */     drawString(text, 0.0F, 0.0F, color);
/* 154 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public int drawString(String text, float x, float y, int color) {
/* 159 */     if (text == null) {
/* 160 */       return 0;
/*     */     }
/* 162 */     x *= 2.0F;
/* 163 */     y *= 2.0F;
/*     */     
/* 165 */     float originalX = x;
/*     */     
/* 167 */     GL11.glPushMatrix();
/* 168 */     GlStateManager.scale(1.0F / this.antiAliasingFactor, 1.0F / this.antiAliasingFactor, 1.0F / this.antiAliasingFactor);
/* 169 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/* 170 */     x *= this.antiAliasingFactor;
/* 171 */     y *= this.antiAliasingFactor;
/* 172 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 173 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 174 */     float blue = (color & 0xFF) / 255.0F;
/* 175 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 176 */     GlStateManager.color(red, green, blue, alpha);
/*     */     
/* 178 */     boolean blend = GL11.glIsEnabled(3042);
/* 179 */     boolean lighting = GL11.glIsEnabled(2896);
/* 180 */     boolean texture = GL11.glIsEnabled(3553);
/* 181 */     if (!blend)
/* 182 */       GL11.glEnable(3042); 
/* 183 */     if (lighting)
/* 184 */       GL11.glDisable(2896); 
/* 185 */     if (texture) {
/* 186 */       GL11.glDisable(3553);
/*     */     }
/* 188 */     int currentColor = color;
/* 189 */     char[] characters = text.toCharArray();
/*     */     
/* 191 */     int index = 0; byte b; int i; char[] arrayOfChar1;
/* 192 */     for (i = (arrayOfChar1 = characters).length, b = 0; b < i; ) { char c = arrayOfChar1[b];
/* 193 */       if (c == '\r') {
/* 194 */         x = originalX;
/*     */       }
/* 196 */       if (c == '\n') {
/* 197 */         y += getHeight(Character.toString(c)) * 2.0F;
/*     */       }
/* 199 */       if (c != '§' && (index == 0 || index == characters.length - 1 || characters[index - 1] != '§')) {
/*     */         
/* 201 */         this.unicodeFont.drawString(x, y, Character.toString(c), new Color(currentColor));
/* 202 */         x += getWidth(Character.toString(c)) * 2.0F * this.antiAliasingFactor;
/* 203 */       } else if (c == ' ') {
/* 204 */         x += this.unicodeFont.getSpaceWidth();
/* 205 */       } else if (c == '§' && index != characters.length - 1) {
/* 206 */         int codeIndex = "0123456789abcdefg".indexOf(text.charAt(index + 1));
/* 207 */         if (codeIndex < 0)
/*     */           continue; 
/* 209 */         currentColor = this.colorCodes[codeIndex];
/*     */       } 
/*     */       
/* 212 */       index++; continue;
/*     */       b++; }
/*     */     
/* 215 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/* 216 */     if (texture)
/* 217 */       GL11.glEnable(3553); 
/* 218 */     if (lighting)
/* 219 */       GL11.glEnable(2896); 
/* 220 */     if (!blend)
/* 221 */       GL11.glDisable(3042); 
/* 222 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 223 */     GL11.glPopMatrix();
/* 224 */     return (int)x / 2;
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String text, float x, float y, int color) {
/* 228 */     drawString(StringUtils.stripControlCodes(text), x + 0.5F, y + 0.5F, 0);
/* 229 */     return drawString(text, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String text, float x, float y, int color) {
/* 233 */     drawString(text, x - ((int)getWidth(text) / 2), y, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawCenteredTextScaled(String text, int givenX, int givenY, int color, double givenScale) {
/* 238 */     GL11.glPushMatrix();
/* 239 */     GL11.glTranslated(givenX, givenY, 0.0D);
/* 240 */     GL11.glScaled(givenScale, givenScale, givenScale);
/* 241 */     drawCenteredString(text, 0.0F, 0.0F, color);
/* 242 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawCenteredStringWithShadow(String text, float x, float y, int color) {
/* 247 */     drawCenteredString(StringUtils.stripControlCodes(text), x + 0.5F, y + 0.5F, color);
/* 248 */     drawCenteredString(text, x, y, color);
/*     */   }
/*     */   
/*     */   public float getWidth(String s) {
/* 252 */     if (this.cachedStringWidth.size() > 1000)
/* 253 */       this.cachedStringWidth.clear(); 
/* 254 */     return ((Float)this.cachedStringWidth.computeIfAbsent(s, e -> { float width = 0.0F; String str = StringUtils.stripControlCodes(paramString1); char[] arrayOfChar; int i = (arrayOfChar = str.toCharArray()).length; for (byte b = 0; b < i; b++) { char c = arrayOfChar[b]; width += this.unicodeFont.getWidth(Character.toString(c)) + this.kerning; }  return Float.valueOf(width / 2.0F / this.antiAliasingFactor); })).floatValue();
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
/*     */   public int getStringWidth(String text) {
/* 267 */     if (text == null) {
/* 268 */       return 0;
/*     */     }
/* 270 */     int i = 0;
/* 271 */     boolean flag = false;
/*     */     
/* 273 */     for (int j = 0; j < text.length(); j++) {
/* 274 */       char c0 = text.charAt(j);
/* 275 */       float k = getWidth(String.valueOf(c0));
/*     */       
/* 277 */       if (k < 0.0F && j < text.length() - 1) {
/* 278 */         j++;
/* 279 */         c0 = text.charAt(j);
/*     */         
/* 281 */         if (c0 != 'l' && c0 != 'L') {
/* 282 */           if (c0 == 'r' || c0 == 'R') {
/* 283 */             flag = false;
/*     */           }
/*     */         } else {
/* 286 */           flag = true;
/*     */         } 
/*     */         
/* 289 */         k = 0.0F;
/*     */       } 
/*     */       
/* 292 */       i = (int)(i + k);
/*     */       
/* 294 */       if (flag && k > 0.0F) {
/* 295 */         i++;
/*     */       }
/*     */     } 
/*     */     
/* 299 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getCharWidth(char c) {
/* 304 */     return this.unicodeFont.getWidth(String.valueOf(c));
/*     */   }
/*     */   
/*     */   public float getHeight(String s) {
/* 308 */     return this.unicodeFont.getHeight(s) / 2.0F;
/*     */   }
/*     */   
/*     */   public UnicodeFont getFont() {
/* 312 */     return this.unicodeFont;
/*     */   }
/*     */   
/*     */   public String trimStringToWidth(String par1Str, int par2) {
/* 316 */     StringBuilder var4 = new StringBuilder();
/* 317 */     float var5 = 0.0F;
/* 318 */     int var6 = 0;
/* 319 */     int var7 = 1;
/* 320 */     boolean var8 = false;
/* 321 */     boolean var9 = false;
/*     */     
/* 323 */     for (int var10 = var6; var10 >= 0 && var10 < par1Str.length() && var5 < par2; var10 += var7) {
/* 324 */       char var11 = par1Str.charAt(var10);
/* 325 */       float var12 = getCharWidth(var11);
/*     */       
/* 327 */       if (var8) {
/* 328 */         var8 = false;
/*     */         
/* 330 */         if (var11 != 'l' && var11 != 'L') {
/* 331 */           if (var11 == 'r' || var11 == 'R') {
/* 332 */             var9 = false;
/*     */           }
/*     */         } else {
/* 335 */           var9 = true;
/*     */         } 
/* 337 */       } else if (var12 < 0.0F) {
/* 338 */         var8 = true;
/*     */       } else {
/* 340 */         var5 += var12;
/*     */         
/* 342 */         if (var9) {
/* 343 */           var5++;
/*     */         }
/*     */       } 
/*     */       
/* 347 */       if (var5 > par2) {
/*     */         break;
/*     */       }
/* 350 */       var4.append(var11);
/*     */     } 
/*     */ 
/*     */     
/* 354 */     return var4.toString();
/*     */   }
/*     */   
/*     */   public void drawSplitString(ArrayList<String> lines, int x, int y, int color) {
/* 358 */     drawString(
/* 359 */         String.join("\n\r", (Iterable)lines), 
/* 360 */         x, 
/* 361 */         y, 
/* 362 */         color);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> splitString(String text, int wrapWidth) {
/* 367 */     List<String> lines = new ArrayList<>();
/*     */     
/* 369 */     String[] splitText = text.split(" ");
/* 370 */     StringBuilder currentString = new StringBuilder(); byte b; int i;
/*     */     String[] arrayOfString1;
/* 372 */     for (i = (arrayOfString1 = splitText).length, b = 0; b < i; ) { String word = arrayOfString1[b];
/* 373 */       String potential = currentString + " " + word;
/*     */       
/* 375 */       if (getWidth(potential) >= wrapWidth) {
/* 376 */         lines.add(currentString.toString());
/* 377 */         currentString = new StringBuilder();
/*     */       } 
/* 379 */       currentString.append(word).append(" "); b++; }
/*     */     
/* 381 */     lines.add(currentString.toString());
/* 382 */     return lines;
/*     */   }
/*     */ }
