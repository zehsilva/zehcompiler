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
.limit locals 10
ldc2_w 30.0 
dstore_2 
ldc2_w 15.0 
dload_2 
ldc2_w 12.0 
dmul 
dadd 
dstore 4 
ldc2_w 90.0 
dload_2 
ldc2_w 10.0 
dsub 
dload 4 
ldc2_w 15.0 
dmul 
ldc2_w 20.0 
dadd 
dmul 
ldc2_w 16.0 
dadd 
ddiv 
dstore 8 
ldc "x" 
astore_1 
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload_1 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_2 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 4 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 8 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_2 
dload 4 
dadd 
invokevirtual java/io/PrintStream/println(D)V 
return
.end method
