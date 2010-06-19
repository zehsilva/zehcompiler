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
.limit stack 18
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
WHILE0:  
iload_3 
ldc 5
isub  
ifle LABLE2  
ldc 0 
goto LABLE3 
LABLE2: 
ldc 1 
LABLE3: 
ifeq WHILE1  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "y = " 
iload_3 
invokestatic java/lang/Integer/toString(I)Ljava/lang/String; 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
iload_3 
ldc 1
iadd 
istore_3 
goto WHILE0  
WHILE1:  
return
.end method
