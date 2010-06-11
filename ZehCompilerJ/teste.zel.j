.source teste.zel.java
.class public teste.zel
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
.limit locals 11
ldc2_w 10.0 
dstore_6 
ldc2_w 15.0 
dload 6 
ldc2_w 12.0 
dmult 
dadd 
dstore_8 
ldc2_w 90.0 
dload 6 
ldc2_w 10.0 
dsub 
dload 8 
ldc2_w 15.0 
dmult 
ldc2_w 20.0 
dadd 
dmult 
ldc2_w 16.0 
dadd 
ddiv 
dstore_12 
ldc2_w 5.375 
dload_1 
dadd 
dstore_1 
return
.end method
