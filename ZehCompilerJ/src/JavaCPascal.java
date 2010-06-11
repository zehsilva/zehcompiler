/* Generated By:JavaCC: Do not edit this line. JavaCPascal.java */
import java.io.*;
public class JavaCPascal implements JavaCPascalConstants {
      static int numeros=0;
      static int operadores=0;
   public static void main(String args[])  throws ParseException  {
      JavaCPascal analisador = null;

      try {
         analisador = new JavaCPascal(new FileInputStream("prog_fonte.my"));
         analisador.inicio();
         System.out.println("N\u00fameros: "+numeros+"\u005cnOperadores:"+operadores);
      }
      catch(FileNotFoundException e) {
         System.out.println("Erro: arquivo n\u00e3o encontrado");
      }
      catch(TokenMgrError e) {
         System.out.println("Erro l\u00e9xico\u005cn" + e.getMessage());
      }
   }

  static final public void inicio() throws ParseException {
                  Token t;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REAL:
      case OPER_REL_JAVA_C_PASCAL:
      case OPER_REL_JAVA_C:
      case OPER_REL_PASCAL:
      case OPER_LOG_JAVA_C:
      case OPER_LOG_PASCAL:
      case HEX:
      case ABRE_PAR:
      case FECHA_PAR:
      case VAR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REAL:
        t = jj_consume_token(REAL);
                numeros++; System.out.println(t.image+" - n\u00famero real");
        break;
      case HEX:
        t = jj_consume_token(HEX);
              numeros++; System.out.println(t.image+" - n\u00famero hexadecimal do Java/C");
        break;
      case OPER_REL_JAVA_C_PASCAL:
        t = jj_consume_token(OPER_REL_JAVA_C_PASCAL);
                                 operadores++; System.out.println(t.image+" - operador relacional do Java/C/Pascal");
        break;
      case OPER_REL_JAVA_C:
        t = jj_consume_token(OPER_REL_JAVA_C);
                          operadores++; System.out.println(t.image+" - operador relacional do Java/C");
        break;
      case OPER_REL_PASCAL:
        t = jj_consume_token(OPER_REL_PASCAL);
                          operadores++; System.out.println(t.image+" - operador relacional do Pascal");
        break;
      case OPER_LOG_JAVA_C:
        t = jj_consume_token(OPER_LOG_JAVA_C);
                          operadores++; System.out.println(t.image+" - operador l\u00f3gico do Java/C");
        break;
      case OPER_LOG_PASCAL:
        t = jj_consume_token(OPER_LOG_PASCAL);
                         operadores++; System.out.println(t.image+" - operador l\u00f3gico do Pascal");
        break;
      case ABRE_PAR:
        t = jj_consume_token(ABRE_PAR);
                   System.out.println(t.image+" - Abre parentesis");
        break;
      case FECHA_PAR:
        t = jj_consume_token(FECHA_PAR);
                    System.out.println(t.image+" - Abre parentesis");
        break;
      case VAR:
        t = jj_consume_token(VAR);
              System.out.println(t.image+" - Vari\u00e1vel");
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public JavaCPascalTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x7fe0,0x7fe0,};
   }

  /** Constructor with InputStream. */
  public JavaCPascal(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JavaCPascal(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JavaCPascalTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public JavaCPascal(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JavaCPascalTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public JavaCPascal(JavaCPascalTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JavaCPascalTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[15];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 15; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
