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
ldc2_w 1.0 
dstore_2 
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
new java/util/Scanner 
dup  
getstatic java/lang/System/in Ljava/io/InputStream;  
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
dup  
dup  
invokevirtual java/util/Scanner/nextDouble()D  
dstore_2 
invokevirtual java/util/Scanner/nextLine()Ljava/lang/String; 
astore_1 
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload_1 
ldc "y" 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
ldc "12" 
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
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_2 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_2 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
aload_1 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 4 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_2 
ldc2_w 3.0 
dadd 
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_2 
ldc2_w 0.0 
ldc2_w 1.0 
dsub 
invokestatic java/lang/Math/pow(DD)D 
invokevirtual java/io/PrintStream/println(D)V 
return
.end method
