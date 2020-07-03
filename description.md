**General Evaluation

 - Legibilidade: o fato da estrutura de bloco ser definida pela tabulação ajuda na manutenção de um código bem
    legível e identado. O fato de não termos expressões booleanas explicitas, pode permitir expressões cujo valor resultante
    não é fácil de perceber ao ler.
    - Redigibilidade: sem grandes problemas.
    - Confiabilidade: aritmética com suporte a reais e inteiros, converter inteiros em reais.
    - Facilidade de aprendizado: a sintaxe é bem parecida com diversas linguagens conhecidas, o que pode facilitar o aprendizado
    - Eficiência: algumas estruturas da linguagem podem afetar a eficiência, como por exemplo as listas, e teste in de pertinência em lista e string
    - Ortogonalidade:
    - Reusabilidade: não existe.
    - Modificabilidade: não tem recursos que facilitam muito a modificabilidade.
    - Portabilidade: pode ser executada em qq plataforma que tenha uma máquina virtual java.
    - Método de implementação: compilada (híbrida  - JVM).
    - Paradigma: estruturado.
    - Amarrações: ....
    - Sistema de Tipos: tipos primitivos: int, real, char e Tipos Compostos: string, list
    - Verificação de tipos: em tempo de compilação e alguns testes em tempo de execução.
    - Variáveis: globais, locais
    - Escopo: estático.
    - Expressões:
    - Comandos: =,if,else,foreach,read, print, while

----

**Language Elements
- Comentário de término de linha:
!! este eh um comentario
- Comentário de várias linhas:!#   comment #!

!#
comentario de varias
linhas
eh assim
#!
- finalização de comando: ";" ou "\n"
- Tipos de variáveis (string,char,int,real, list (homogêneo), null):
declaração:
vars:
    string a="asdsada"
    real der3=23.2;
    char b1='w'
    int d1=1
    list int c=[11,12,5 to 10 step 1]
ou
vars: string a,b,c;
    int e,f,g;

- Atribuicao:=
a=b=c
- Comando de entrada de dados: read("msg",var1,var2,var3)
read("Entre com os dados",a,b,c)
- Comando de saída de dados: print("msg","titulojanela")
print("O valor de der3 é".$der3,"janela 1")
- Operadores:
    Numéricos: +,-,*,/,^,%
    String e Lista: in (testa se char pertence à string ou elemento à lista),
    .(concatenar string e listas),$(representação em string de qq objeto),@(representacao numerica de uma string ou char que representem números)
    Relacional: >,>=,<,<=,==,!= (== serve para strings tambem)
    Lógicos: and, or, not, xor, nand, nor
    $(1,2,3,4,5)="12345"=['1','2','3','4','5']
- Comando Condicional: inicio if, senao else, fim da estrutura fi
(tabulação marca a estrutura de bloco)
        if(a and b)
            vars: real d;
            a="22"
            d=2.34
            a=a.$(1).$(1.23)
            b=@(a)*(23+1)
        else
            out("Olha lá".$(b),"janela2")
        fi
- Comandos de Repetição:
        foreach(a in [6 to 1 step 1])
        foreach(a in [1 to 100 step 2])
        foreach(a in [1,2,4])
            print($(a),"Janela 3")
        end
        while(1)
            print("oi")
        end
- A linguagem é case-sensitive
- nomes de variáveis: (_|letras)(numeros,letras,_)*
- "string"
- variáveis são declaradas no inicio de um bloco de comandos com criando um bloco com a palavra chave vars
- A extensão dos arquivos desta linguagem é .zel
