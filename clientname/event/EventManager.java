/*     */ package clientname.event;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public class EventManager
/*     */ {
/*  12 */   private static final Map<Class<? extends Event>, ArrayList<EventData>> REGISTRY_MAP = new HashMap<>();
/*     */ 
/*     */   
/*     */   private static void sortListValue(Class<? extends Event> clazz) {
/*  16 */     ArrayList<EventData> flexableArray = new ArrayList<>(); byte b; int i;
/*     */     byte[] arrayOfByte;
/*  18 */     for (i = (arrayOfByte = EventPriority.VALUE_ARRAY).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/*  19 */       for (EventData methodData : REGISTRY_MAP.get(clazz)) {
/*  20 */         if (methodData.priority == b1) {
/*  21 */           flexableArray.add(methodData);
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */     
/*  26 */     REGISTRY_MAP.put(clazz, flexableArray);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isMethodBad(Method method) {
/*  31 */     return !((method.getParameterTypes()).length == 1 && method.isAnnotationPresent((Class)EventTarget.class));
/*     */   }
/*     */   
/*     */   private static boolean isMethodBad(Method method, Class<? extends Event> clazz) {
/*  35 */     return !(!isMethodBad(method) && !method.getParameterTypes()[0].equals(clazz));
/*     */   }
/*     */   
/*     */   public static ArrayList<EventData> get(Class<? extends Event> clazz) {
/*  39 */     return REGISTRY_MAP.get(clazz);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void cleanMap(boolean removeOnlyEmptyValues) {
/*  44 */     Iterator<Map.Entry<Class<? extends Event>, ArrayList<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();
/*     */     
/*  46 */     while (iterator.hasNext()) {
/*  47 */       if (!removeOnlyEmptyValues || ((ArrayList)((Map.Entry)iterator.next()).getValue()).isEmpty()) {
/*  48 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unregister(Object o, Class<? extends Event> clazz) {
/*  55 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  56 */       for (EventData methodData : REGISTRY_MAP.get(clazz)) {
/*  57 */         if (methodData.source.equals(o)) {
/*  58 */           ((ArrayList)REGISTRY_MAP.get(clazz)).remove(methodData);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  63 */     cleanMap(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregister(Object o) {
/*  69 */     for (ArrayList<EventData> flexableArray : REGISTRY_MAP.values()) {
/*     */       
/*  71 */       for (int i = flexableArray.size() - 1; i >= 0; i--) {
/*     */         
/*  73 */         if (((EventData)flexableArray.get(i)).source.equals(o)) {
/*  74 */           flexableArray.remove(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  81 */     cleanMap(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register(Method method, Object o) {
/*  87 */     Class<?> clazz = method.getParameterTypes()[0];
/*     */     
/*  89 */     EventData methodData = new EventData(o, method, ((EventTarget)method.<EventTarget>getAnnotation(EventTarget.class)).value());
/*     */     
/*  91 */     if (!methodData.target.isAccessible()) {
/*  92 */       methodData.target.setAccessible(true);
/*     */     }
/*     */     
/*  95 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*     */       
/*  97 */       if (!((ArrayList)REGISTRY_MAP.get(clazz)).contains(methodData)) {
/*  98 */         ((ArrayList<EventData>)REGISTRY_MAP.get(clazz)).add(methodData);
/*  99 */         sortListValue((Class)clazz);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 104 */       REGISTRY_MAP.put(clazz, new ArrayList<EventData>(methodData)
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register(Object o, Class<? extends Event> clazz) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/* 117 */     for (i = (arrayOfMethod = o.getClass().getMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/* 118 */       if (!isMethodBad(method, clazz))
/* 119 */         register(method, o); 
/*     */       b++; }
/*     */   
/*     */   } public static void register(Object o) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/* 126 */     for (i = (arrayOfMethod = o.getClass().getMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/* 127 */       if (!isMethodBad(method))
/* 128 */         register(method, o); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ }
