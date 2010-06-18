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
.limit stack 100
.limit locals 12
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc 6
ldc2_w 4.0 
dup2_x1
pop2
i2d
dup2_x2
pop2
dsub
invokevirtual java/io/PrintStream/println(D)V 
return
.end method
