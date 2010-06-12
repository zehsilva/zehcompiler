.source Teste.java
.class public Teste
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 9
ldc2_w 30.0 
dstore_1 
ldc2_w 15.0 
dload_1 
ldc2_w 12.0 
dmul 
dadd 
dstore_3 
ldc2_w 90.0 
dload_1 
ldc2_w 10.0 
dsub 
dload_3 
ldc2_w 15.0 
dmul 
ldc2_w 20.0 
dadd 
dmul 
ldc2_w 16.0 
dadd 
ddiv 
dstore 7 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 7 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 7 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
dload_3 
dadd 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
dload_3 
dadd 
invokevirtual java/io/PrintStream/println(D)V 
return
.end method
