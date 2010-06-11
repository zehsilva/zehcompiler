.source Exemplo04.java 
.class public Exemplo04 
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
 
;em Java:  y = 15 +
;obedece o formato p
ldc2_w 15.0 
dload_1 
ldc2_w 12.0 
dmul 
dadd 
; ' y ' possui referênci
dstore_3 
 
;em Java:  z = 90 /
;em posfixo:  90 x 1
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
; ' z ' possui referênci
dstore 7 
 
return 
.end method 

