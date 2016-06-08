package android.support.v4.app;

import android.os.*;
import android.util.*;
import java.lang.reflect.*;

class BundleCompatDonut
{
    private static final String TAG = "BundleCompatDonut";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;
    
    public static IBinder getBinder(Bundle ex, final String s) {
        Label_0036: {
            if (BundleCompatDonut.sGetIBinderMethodFetched) {
                break Label_0036;
            }
            while (true) {
                try {
                    (BundleCompatDonut.sGetIBinderMethod = Bundle.class.getMethod("getIBinder", String.class)).setAccessible(true);
                    BundleCompatDonut.sGetIBinderMethodFetched = true;
                    if (BundleCompatDonut.sGetIBinderMethod != null) {
                        final Method method = BundleCompatDonut.sGetIBinderMethod;
                        final InvocationTargetException ex2 = ex;
                        final int n = 1;
                        final Object[] array = new Object[n];
                        final int n2 = 0;
                        final String s2 = s;
                        array[n2] = s2;
                        final Object o = method.invoke(ex2, array);
                        final IBinder binder = (IBinder)o;
                        final IBinder binder2;
                        ex = (InvocationTargetException)(binder2 = binder);
                        return binder2;
                    }
                    goto Label_0090;
                }
                catch (NoSuchMethodException ex3) {
                    Log.i("BundleCompatDonut", "Failed to retrieve getIBinder method", (Throwable)ex3);
                    continue;
                }
                break;
            }
        }
        try {
            final Method method = BundleCompatDonut.sGetIBinderMethod;
            final InvocationTargetException ex2 = ex;
            final int n = 1;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final String s2 = s;
            array[n2] = s2;
            final Object o = method.invoke(ex2, array);
            final IBinder binder = (IBinder)o;
            final IBinder binder2;
            ex = (InvocationTargetException)(binder2 = binder);
            return binder2;
        }
        catch (IllegalArgumentException ex4) {}
        catch (InvocationTargetException ex) {
            goto Label_0077;
        }
        catch (IllegalAccessException ex) {
            goto Label_0077;
        }
    }
    
    public static void putBinder(final Bundle p0, final String p1, final IBinder p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifne            41
        //     6: ldc             Landroid/os/Bundle;.class
        //     8: ldc             "putIBinder"
        //    10: iconst_2       
        //    11: anewarray       Ljava/lang/Class;
        //    14: dup            
        //    15: iconst_0       
        //    16: ldc             Ljava/lang/String;.class
        //    18: aastore        
        //    19: dup            
        //    20: iconst_1       
        //    21: ldc             Landroid/os/IBinder;.class
        //    23: aastore        
        //    24: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    27: putstatic       android/support/v4/app/BundleCompatDonut.sPutIBinderMethod:Ljava/lang/reflect/Method;
        //    30: getstatic       android/support/v4/app/BundleCompatDonut.sPutIBinderMethod:Ljava/lang/reflect/Method;
        //    33: iconst_1       
        //    34: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //    37: iconst_1       
        //    38: putstatic       android/support/v4/app/BundleCompatDonut.sPutIBinderMethodFetched:Z
        //    41: getstatic       android/support/v4/app/BundleCompatDonut.sPutIBinderMethod:Ljava/lang/reflect/Method;
        //    44: ifnull          67
        //    47: getstatic       android/support/v4/app/BundleCompatDonut.sPutIBinderMethod:Ljava/lang/reflect/Method;
        //    50: aload_0        
        //    51: iconst_2       
        //    52: anewarray       Ljava/lang/Object;
        //    55: dup            
        //    56: iconst_0       
        //    57: aload_1        
        //    58: aastore        
        //    59: dup            
        //    60: iconst_1       
        //    61: aload_2        
        //    62: aastore        
        //    63: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    66: pop            
        //    67: return         
        //    68: astore_3       
        //    69: ldc             "BundleCompatDonut"
        //    71: ldc             "Failed to retrieve putIBinder method"
        //    73: aload_3        
        //    74: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    77: pop            
        //    78: goto            37
        //    81: astore_0       
        //    82: ldc             "BundleCompatDonut"
        //    84: ldc             "Failed to invoke putIBinder via reflection"
        //    86: aload_0        
        //    87: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    90: pop            
        //    91: aconst_null    
        //    92: putstatic       android/support/v4/app/BundleCompatDonut.sPutIBinderMethod:Ljava/lang/reflect/Method;
        //    95: return         
        //    96: astore_0       
        //    97: goto            82
        //   100: astore_0       
        //   101: goto            82
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  6      37     68     81     Ljava/lang/NoSuchMethodException;
        //  47     67     96     100    Ljava/lang/reflect/InvocationTargetException;
        //  47     67     100    104    Ljava/lang/IllegalAccessException;
        //  47     67     81     82     Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0067:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:191)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:46)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
