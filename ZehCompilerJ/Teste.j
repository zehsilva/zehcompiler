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
.limit locals 8
ldc 2
i2d 
dstore 5 
ldc 1
istore 4 
FOR0:  
new java/util/LinkedList  
dup 
invokespecial java/util/LinkedList/<init>()V  
dup 
ldc 49 
new java/lang/Character  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Character/<init>(C)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 50 
new java/lang/Character  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Character/<init>(C)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 51 
new java/lang/Character  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Character/<init>(C)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 97 
new java/lang/Character  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Character/<init>(C)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 98 
new java/lang/Character  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Character/<init>(C)V  
invokevirtual java/util/LinkedList/add(Ljava/lang/Object;)Z  
pop  
dup 
ldc 99 
new java/lang/Character  
dup  
dup2_x1  
pop2  
invokespecial java/lang/Character/<init>(C)V  
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
checkcast java/lang/Character 
invokevirtual java/lang/Character/charValue()C  
istore_1 
ldc "z" 
invokestatic  javax/swing/JOptionPane/showInputDialog(Ljava/lang/Object;)Ljava/lang/String;
invokestatic  java/lang/Double/parseDouble(Ljava/lang/String;)D 
dstore 5 
aconst_null 
iload_1 
dload 5 
invokestatic java/lang/Double/toString(D)Ljava/lang/String; 
swap ;;convertetipo s c
new java/lang/StringBuffer 
dup 
invokespecial java/lang/StringBuffer/<init>()V 
swap 
invokevirtual java/lang/StringBuffer/append(C)Ljava/lang/StringBuffer; 
invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String; 
swap ;;convertetipo s c
swap 
new java/lang/StringBuilder 
dup  
invokespecial java/lang/StringBuilder/<init>()V 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
swap 
invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; 
invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
invokestatic  javax/swing/JOptionPane/showMessageDialog(Ljava/awt/Component;Ljava/lang/Object;)V
goto ITERATOR2 
FOR1:  
return
.end method
