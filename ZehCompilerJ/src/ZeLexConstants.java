/* Generated By:JavaCC: Do not edit this line. ZeLexConstants.java */

/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ZeLexConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int INDENT = 3;
  /** RegularExpression Id. */
  int UNINDENT = 4;
  /** RegularExpression Id. */
  int VAR_DCL = 14;
  /** RegularExpression Id. */
  int TP_STRING = 15;
  /** RegularExpression Id. */
  int TP_REAL = 16;
  /** RegularExpression Id. */
  int TP_INT = 17;
  /** RegularExpression Id. */
  int TP_CHAR = 18;
  /** RegularExpression Id. */
  int TP_LIST = 19;
  /** RegularExpression Id. */
  int DOISP = 20;
  /** RegularExpression Id. */
  int PNTVIRG = 21;
  /** RegularExpression Id. */
  int PNT = 22;
  /** RegularExpression Id. */
  int ATRIB = 23;
  /** RegularExpression Id. */
  int VIRG = 24;
  /** RegularExpression Id. */
  int ABRERET = 25;
  /** RegularExpression Id. */
  int FECHARET = 26;
  /** RegularExpression Id. */
  int ABREPAR = 27;
  /** RegularExpression Id. */
  int FECHAPAR = 28;
  /** RegularExpression Id. */
  int ARROBA = 29;
  /** RegularExpression Id. */
  int DOLLAR = 30;
  /** RegularExpression Id. */
  int IF = 31;
  /** RegularExpression Id. */
  int FI = 32;
  /** RegularExpression Id. */
  int ELSE = 33;
  /** RegularExpression Id. */
  int IN = 34;
  /** RegularExpression Id. */
  int TO = 35;
  /** RegularExpression Id. */
  int STEP = 36;
  /** RegularExpression Id. */
  int FOREACH = 37;
  /** RegularExpression Id. */
  int WHILE = 38;
  /** RegularExpression Id. */
  int END = 39;
  /** RegularExpression Id. */
  int READ = 40;
  /** RegularExpression Id. */
  int PRINT = 41;
  /** RegularExpression Id. */
  int OPER_REL = 42;
  /** RegularExpression Id. */
  int PLUS = 43;
  /** RegularExpression Id. */
  int MINUS = 44;
  /** RegularExpression Id. */
  int EXP = 45;
  /** RegularExpression Id. */
  int MULT = 46;
  /** RegularExpression Id. */
  int DIV = 47;
  /** RegularExpression Id. */
  int MOD = 48;
  /** RegularExpression Id. */
  int AND = 49;
  /** RegularExpression Id. */
  int NAND = 50;
  /** RegularExpression Id. */
  int OR = 51;
  /** RegularExpression Id. */
  int NOR = 52;
  /** RegularExpression Id. */
  int XOR = 53;
  /** RegularExpression Id. */
  int NOT = 54;
  /** RegularExpression Id. */
  int NUM_REAL = 55;
  /** RegularExpression Id. */
  int NUM_INT = 56;
  /** RegularExpression Id. */
  int CHAR = 57;
  /** RegularExpression Id. */
  int VAR = 58;
  /** RegularExpression Id. */
  int STRING = 59;
  /** RegularExpression Id. */
  int EOL = 60;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int INDENTING = 1;
  /** Lexical state. */
  int UNINDENTING = 2;
  /** Lexical state. */
  int IN_LINE = 3;
  /** Lexical state. */
  int comentario1 = 4;
  /** Lexical state. */
  int comentario2 = 5;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"\\r\"",
    "<token of kind 2>",
    "\"\"",
    "\"\"",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"!!\"",
    "\"\\n\"",
    "<token of kind 10>",
    "\"!#\"",
    "\"#!\"",
    "<token of kind 13>",
    "\"vars\"",
    "\"string\"",
    "\"real\"",
    "\"int\"",
    "\"char\"",
    "\"list\"",
    "\":\"",
    "\";\"",
    "\".\"",
    "\"=\"",
    "\",\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\"@\"",
    "\"$\"",
    "\"if\"",
    "\"fi\"",
    "\"else\"",
    "\"in\"",
    "\"to\"",
    "\"step\"",
    "\"foreach\"",
    "\"while\"",
    "\"end\"",
    "\"read\"",
    "\"print\"",
    "<OPER_REL>",
    "\"+\"",
    "\"-\"",
    "\"^\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"and\"",
    "\"nand\"",
    "\"or\"",
    "\"nor\"",
    "\"xor\"",
    "\"not\"",
    "<NUM_REAL>",
    "<NUM_INT>",
    "<CHAR>",
    "<VAR>",
    "<STRING>",
    "\"\\n\"",
  };

}
