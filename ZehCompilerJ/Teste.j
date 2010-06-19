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
.limit stack 14
.limit locals 5
ldc 2
istore_3 
new java/util/Scanner 
dup  
getstatic java/lang/System/in Ljava/io/InputStream;  
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
dup  
invokevirtual java/util/Scanner/nextInt()I  
istore_3 
iload_3 
ldc 5
isub  
ifge LABGT2  
ldc 1 
goto LABGT3 
LABGT2: 
ldc 0 
LABGT3: 
ifeq IF0  
ldc 3
i2d 
dstore_1 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
ldc 100
i2d 
dadd 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
ldc 0
dup_x2 
pop 
d2i 
swap 
ifne OR4  
goto OR5 
OR4:  
pop 
ldc 1 
OR5: 
ifeq NOT6  
ldc 0 
goto NOT7 
NOT6:  
ldc 1 
NOT7: 
invokevirtual java/io/PrintStream/println(I)V 
goto IF1  
IF0:  
ldc2_w 10.0 
dstore_1 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1 
ldc2_w 78.0 
dcmpg 
ifge LABGT8  
ldc 1 
goto LABGT9 
LABGT8: 
ldc 0 
LABGT9: 
invokevirtual java/io/PrintStream/println(I)V 
IF1:  
return
.end method
