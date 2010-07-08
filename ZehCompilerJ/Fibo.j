.source Fibo.java
.class public Fibo
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
.limit locals 7
new java/util/Scanner 
dup  
getstatic java/lang/System/in Ljava/io/InputStream;  
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
dup  
invokevirtual java/util/Scanner/nextInt()I  
istore_2 
iload_2 
istore_1 
ldc 1
istore 5 
ldc 1
istore 4 
ldc 1
istore_3 
WHILE0:  
iload_1 
ldc 1
isub  
ifle LABGT2  
ldc 1 
goto LABGT3 
LABGT2: 
ldc 0 
LABGT3: 
ifeq WHILE1  
iload 5 
istore_3 
iload 5 
iload 4 
iadd 
istore 5 
iload_3 
istore 4 
iload_1 
ldc 1
isub 
istore_1 
goto WHILE0  
WHILE1:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Fib(" 
iload_2 
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
ldc ")=" 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
iload 5 
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
return
.end method
