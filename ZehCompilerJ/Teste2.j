.source Teste2.java
.class public Teste2
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
.limit locals 8
new java/util/Scanner 
dup  
getstatic java/lang/System/in Ljava/io/InputStream;  
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
dup  
invokevirtual java/util/Scanner/nextDouble()D  
dstore_1 
ldc 1
i2d 
dstore 5 
ldc 1
i2d 
dstore_3 
WHILE0:  
dload_3 
dload_1 
dcmpg 
ifle LABLE2  
ldc 0 
goto LABLE3 
LABLE2: 
ldc 1 
LABLE3: 
ifeq WHILE1  
dload 5 
dload_3 
dmul 
dstore 5 
dload_3 
ldc 1
i2d 
dadd 
dstore_3 
goto WHILE0  
WHILE1:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Fatorial de " 
dload_1 
invokestatic java/lang/Double/toString(D)Ljava/lang/String; 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
ldc "!= " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
dload 5 
invokestatic java/lang/Double/toString(D)Ljava/lang/String; 
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
return
.end method
