.source Xor.java
.class public Xor
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
ldc 1
istore_3 
new java/util/Scanner 
dup  
getstatic java/lang/System/in Ljava/io/InputStream;  
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
dup  
invokevirtual java/util/Scanner/nextDouble()D  
dstore 4 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 4 
invokevirtual java/io/PrintStream/println(D)V 
FOR0:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR2:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR3  
pop 
goto FOR1 
ITERATOR3: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_2 
FOR4:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR6:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR7  
pop 
goto FOR5 
ITERATOR7: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_3 
getstatic java/lang/System/out Ljava/io/PrintStream; 
iload_2 
invokestatic java/lang/Integer/toString(I)Ljava/lang/String; 
ldc " xor " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
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
ldc " = " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
iload_2 
iload_3 
dup2 
swap 
ifeq NOT8  
ldc 0 
goto NOT9 
NOT8:  
ldc 1 
NOT9: 
ifeq AND10  
goto AND11 
AND10:  
pop 
ldc 0 
AND11: 
dup_x2 
pop 
ifeq NOT12  
ldc 0 
goto NOT13 
NOT12:  
ldc 1 
NOT13: 
ifeq AND14  
goto AND15 
AND14:  
pop 
ldc 0 
AND15: 
ifne OR16  
goto OR17 
OR16:  
pop 
ldc 1 
OR17: 
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
goto ITERATOR6 
FOR5:  
goto ITERATOR2 
FOR1:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "" 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
FOR18:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR20:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR21  
pop 
goto FOR19 
ITERATOR21: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_2 
FOR22:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR24:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR25  
pop 
goto FOR23 
ITERATOR25: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_3 
getstatic java/lang/System/out Ljava/io/PrintStream; 
iload_2 
invokestatic java/lang/Integer/toString(I)Ljava/lang/String; 
ldc " or " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
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
ldc " = " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
iload_2 
iload_3 
ifne OR26  
goto OR27 
OR26:  
pop 
ldc 1 
OR27: 
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
goto ITERATOR24 
FOR23:  
goto ITERATOR20 
FOR19:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "" 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
FOR28:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR30:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR31  
pop 
goto FOR29 
ITERATOR31: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_2 
FOR32:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR34:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR35  
pop 
goto FOR33 
ITERATOR35: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_3 
getstatic java/lang/System/out Ljava/io/PrintStream; 
iload_2 
invokestatic java/lang/Integer/toString(I)Ljava/lang/String; 
ldc " and " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
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
ldc " = " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
iload_2 
iload_3 
;;tipo1=i tipo2=i 
ifeq AND36  
goto AND37 
AND36:  
pop 
ldc 0 
AND37: 
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
goto ITERATOR34 
FOR33:  
goto ITERATOR30 
FOR29:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "" 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
FOR38:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR40:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR41  
pop 
goto FOR39 
ITERATOR41: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_2 
FOR42:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR44:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR45  
pop 
goto FOR43 
ITERATOR45: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_3 
getstatic java/lang/System/out Ljava/io/PrintStream; 
iload_2 
invokestatic java/lang/Integer/toString(I)Ljava/lang/String; 
ldc " nand " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
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
ldc " = " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
iload_2 
iload_3 
ifeq AND46  
goto AND47 
AND46:  
pop 
ldc 0 
AND47: 
ifeq NOT48  
ldc 0 
goto NOT49 
NOT48:  
ldc 1 
NOT49: 
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
goto ITERATOR44 
FOR43:  
goto ITERATOR40 
FOR39:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "" 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
FOR50:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR52:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR53  
pop 
goto FOR51 
ITERATOR53: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_2 
FOR54:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 0
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 1
new java/lang/Integer  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Integer/<init>(I)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
ldc 0 
invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; 
ITERATOR56:   
dup  
checkcast java/util/ListIterator 
invokeinterface java/util/ListIterator/hasNext()Z 1  
ifne ITERATOR57  
pop 
goto FOR55 
ITERATOR57: 
dup  
invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 
checkcast java/lang/Integer 
invokevirtual java/lang/Integer/intValue()I  
istore_3 
getstatic java/lang/System/out Ljava/io/PrintStream; 
iload_2 
invokestatic java/lang/Integer/toString(I)Ljava/lang/String; 
ldc " nor " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
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
ldc " = " 
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
iload_2 
iload_3 
ifne OR58  
goto OR59 
OR58:  
pop 
ldc 1 
OR59: 
ifeq NOT60  
ldc 0 
goto NOT61 
NOT60:  
ldc 1 
NOT61: 
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
goto ITERATOR56 
FOR55:  
goto ITERATOR52 
FOR51:  
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "" 
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
return
.end method
