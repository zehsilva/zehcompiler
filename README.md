# zehcompiler

A linguagem tenta combinar algumas características que eu achei interessantes de outras linguagens que eu já programei. Inicialmente não projetei uma linguagem com muitas funcionalidades - ela atende a um conjunto mínimo de características pré-determinadas pelo professor - mas espero poder complementá-la mesmo depois do final do semestre.

A proposta da disciplina é que o código-objeto gerado pelo nosso compilador rode em uma máquina virtual Java (JVM), bem como na web - uma proposta deveras interessante.

Descricao dos componentes: [https://github.com/zehsilva/zehcompiler/blob/master/description.md]

----

Exemplos:
```
vars: real n2,n,a,b,fib;
read(n)
n2=n
fib=1;
b=1;
a=1;
while(n2>1)
{
    a=fib
    fib=fib+b;
    b=a;
    n2=n2-1;
}end
print("Fib(".$(n).")=".$(fib))
```
----

** Gramática do ZEL
```
inicio := corpo <EOF>
corpo := decl cmds
decl := <VAR_DECL><DOISP> (vartype eoc)*
vartype := type <VAR>(<ATRIB> literal)? (<VIRG> <VAR>(<ATRIB> literal)?)*
type := <TP_LIST>?(<TP_INT>|< TP_CHAR>|<TP_REAL>)|<TP_STRING>
eoc := <EOL>|<PNTVIRG>
cmds := (if | while | foreach | atrib | entrada | saida | eoc)*

--------------------------------Atribuição e Expressões------------------------------------
atrib := (<VAR><ATRIB>)+ expr eol

expr := expr_and ((<OR>|<XOR>|<NOR>) expr_and)*
expr_and := expr_bool ((<AND>|<NAND>) expr_bool)*
expr_bool := expr_in | expr_rel
expr_in := expr_mod (<IN> (list|termo_concat))
expr_rel := expr_mod (<OPER_REL> expr_mod)*
expr_mod := expr_soma (<MOD>expr_soma)*
expr_soma := expr_mult (<PLUS>expr_mult|<MINUS>expr_mult)*
expr_mult := expr_pow (<MULT>expr_pow|<DIV>expr_pow)*
expr_pow := termo_not (<EXP> expr_pow)?
termo_not -:= <NOT>* termo_concat
termo_concat := termo (<PNT> termo)*
termo := (<PLUS>|<MINUS>)? (<VAR>|simple_literal|<ABREPAR> expr <FECHAPAR>)|<STRING>|(<ARROBA>|< DOLLAR>)<ABREPAR> expr <FECHAPAR>

------------------------------Literais e Constantes-----------------------------------------
literal := simple_literal|list_literal|<STRING>
simple_literal := <NUM_REAL>|<NUM_INT>|<CHAR>
list_literal :=  <ABRERET> list_literal_elems <FECHARET>
list_literal_elems := list_literal_elem (<VIRG>list_literal_elem)*
list_literal_elem := (simple_literal|<STRING>) (<TO> simple_literal <STEP> simple_literal)?

------------------------------if,while e foreach---------------------------------------------
if :=     <IF><ABREPAR>expr<FECHAPAR>
        <IDENT>corpo<DEDENT>
        (<ELSE><IDENT>corpo<DEDENT>)?
        <FI>

while :=  <WHILE><ABREPAR>expr<FECHAPAR>
        <IDENT>corpo<DEDENT>
        <END>

for :=  <FOREACH><ABREPAR> <VAR> <IN> list <FECHAPAR>
        <IDENT>corpo<DEDENT>
        <END>
--------------------------------list-------------------------------------------------------
list := <ABRERET> list_elems <FECHARET>
list_elems := list_elem (<VIRG>list_lelem)*
list_elem := expr (<TO> expr <STEP> expr)?
----------------------------------Entrada e Saida------------------------------------------
entrada :=    <READ>
                <ABREPAR>
                    (<STRING><VIRG>)?(<VAR><VIRG>)+
                <FECHAPAR>
saida :=        <PRINT>
                <ABREPAR>
                    expr(<VIRG>expr)?
                <FECHAPAR>
```

