/* Generated By:JJTree&JavaCC: Do not edit this line. FStringsGrammar.java */
package org.python.pydev.parser.grammar_fstrings;

import org.python.pydev.parser.jython.FastCharStream;
import org.python.pydev.shared_core.string.FastStringBuffer;
import org.python.pydev.parser.jython.ParseException;
import org.python.pydev.parser.jython.Token;
import org.python.pydev.parser.fastparser.grammar_fstrings_common.AbstractFStringsGrammar;
import org.python.pydev.parser.fastparser.grammar_fstrings_common.AbstractFStringsTokenManager;
import org.python.pydev.parser.fastparser.grammar_fstrings_common.JJTFStringsGrammarState;
import org.python.pydev.parser.fastparser.grammar_fstrings_common.Node;
import org.python.pydev.parser.fastparser.grammar_fstrings_common.SimpleNode;
import org.python.pydev.parser.fastparser.grammar_fstrings_common.FStringsAST;

public final class FStringsGrammar extends AbstractFStringsGrammar/*@bgen(jjtree)*/implements FStringsGrammarTreeConstants, FStringsGrammarConstants {/*@bgen(jjtree)*/
  protected final JJTFStringsGrammarState jjtree = new JJTFStringsGrammarState(this);

// ============= Syntatic/Semantic actions =============
  final public FStringsAST f_string() throws ParseException {
                         /*@bgen(jjtree) f_string */
                         SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTF_STRING);
                         boolean jjtc000 = true;
                         jjtree.openNodeScope(jjtn000);
                         jjtreeOpenNodeScope(jjtn000);Token t; Token doubleRbrace=null;
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case RPAREN:
        case LBRACE:
        case RBRACE:
        case LBRACKET:
        case RBRACKET:
        case EXCLAMATION:
        case COLON:
        case QUOTE:
        case QUOTE2:
        case BACKSLASH:
        case TEXT:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
          f_string_expr();
          break;
        case TEXT:
          jj_consume_token(TEXT);
          break;
        case QUOTE:
          jj_consume_token(QUOTE);
          break;
        case QUOTE2:
          jj_consume_token(QUOTE2);
          break;
        case EXCLAMATION:
          jj_consume_token(EXCLAMATION);
          break;
        case COLON:
          jj_consume_token(COLON);
          break;
        case BACKSLASH:
          jj_consume_token(BACKSLASH);
          break;
        case LPAREN:
          jj_consume_token(LPAREN);
          break;
        case RPAREN:
          jj_consume_token(RPAREN);
          break;
        case LBRACKET:
          jj_consume_token(LBRACKET);
          break;
        case RBRACKET:
          jj_consume_token(RBRACKET);
          break;
        case RBRACE:
          t = jj_consume_token(RBRACE);
                     doubleRbrace=null;
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case RBRACE:
            doubleRbrace = jj_consume_token(RBRACE);
            break;
          default:
            jj_la1[1] = jj_gen;
            ;
          }
                if(doubleRbrace == null) addParseError(t, "Single '}' not allowed.");
          break;
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(0);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return new FStringsAST((SimpleNode)jjtree.popNode());}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public void f_string_expr() throws ParseException {
                       /*@bgen(jjtree) f_string_expr */
                       SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTF_STRING_EXPR);
                       boolean jjtc000 = true;
                       jjtree.openNodeScope(jjtn000);
                       jjtreeOpenNodeScope(jjtn000);Token start, end, bStart;boolean empty=true;SimpleNode bText;
    try {
      start = jj_consume_token(LBRACE);
      try {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACE:
        case LBRACKET:
        case QUOTE:
        case QUOTE2:
        case BACKSLASH:
        case TEXT:
                                bStart=getToken(1);
                            if(bStart.kind==LBRACE && bStart.beginColumn==start.beginColumn+1) {
                                // If we found 2 consecutive {{ it's an escaped {.
                                jj_consume_token(LBRACE);
                                {if (true) throw DOUBLE_LBRACE_FOUND;}
                             }
          bText = balanced_expression_text();
                                empty=false;
          break;
        default:
          jj_la1[3] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case EXCLAMATION:
          type_conversion();
          break;
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COLON:
          format_spec();
          break;
        default:
          jj_la1[5] = jj_gen;
          ;
        }
        try {
          end = jj_consume_token(RBRACE);
        } catch (ParseException e) {
                        addParseError(e, "Unbalanced '{'");
                        end = token;
        }
                        jjtree.markNodeStartEnd(jjtn000, start, end);
                        if(empty){
                            errorPyExprEmpty(jjtn000);
                        }
      } catch (DoubleLBraceFound e) {
                // Found double brace (not really an expression).
                jjtree.markNodeStartEnd(jjtn000, start, start);
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
  }

  final public void type_conversion() throws ParseException {
                         /*@bgen(jjtree) type_conversion */
                         SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTTYPE_CONVERSION);
                         boolean jjtc000 = true;
                         jjtree.openNodeScope(jjtn000);
                         jjtreeOpenNodeScope(jjtn000);Token t;boolean foundText=false;
    try {
      jj_consume_token(EXCLAMATION);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TEXT:
        t = jj_consume_token(TEXT);
                  errorIfTextIsNotASR(t);
         foundText=true;
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     if(!foundText){errorTypeConversionEmpty(jjtn000);}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
  }

  final public void format_spec() throws ParseException {
                     /*@bgen(jjtree) format_spec */
                     SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTFORMAT_SPEC);
                     boolean jjtc000 = true;
                     jjtree.openNodeScope(jjtn000);
                     jjtreeOpenNodeScope(jjtn000);Token start, end, bStart;boolean empty=true;SimpleNode bText; Token t;
    try {
      jj_consume_token(COLON);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
        case QUOTE:
        case QUOTE2:
        case BACKSLASH:
        case TEXT:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_2;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case TEXT:
          label_3:
          while (true) {
            jj_consume_token(TEXT);
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case TEXT:
              ;
              break;
            default:
              jj_la1[8] = jj_gen;
              break label_3;
            }
          }
          break;
        case LBRACE:
          start = jj_consume_token(LBRACE);
          try {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case LPAREN:
            case LBRACE:
            case LBRACKET:
            case QUOTE:
            case QUOTE2:
            case BACKSLASH:
            case TEXT:
                                        bStart=getToken(1);
                                    if(bStart.kind==LBRACE && bStart.beginColumn==start.beginColumn+1) {
                                        // If we found 2 consecutive {{ it's an escaped {.
                                        jj_consume_token(LBRACE);
                                        {if (true) throw DOUBLE_LBRACE_FOUND;}
                                     }
              bText = balanced_expression_text();
                                        empty=false;
              break;
            default:
              jj_la1[9] = jj_gen;
              ;
            }
            try {
              end = jj_consume_token(RBRACE);
            } catch (ParseException e) {
                                addParseError(e, "Unbalanced '{'");
                                end = token;
            }
                                jjtree.markNodeStartEnd(jjtn000, start, end);
                                if(empty){
                                    errorPyExprEmpty(jjtn000);
                                }
          } catch (DoubleLBraceFound e) {
                        // Found double brace (not really an expression).
                        jjtree.markNodeStartEnd(jjtn000, start, start);
          }
          break;
        case QUOTE:
          string();
          break;
        case QUOTE2:
          string2();
          break;
        case BACKSLASH:
          t = jj_consume_token(BACKSLASH);
                         errorBackSlashInvalidInFStrings(t);
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
  }

  final public SimpleNode balanced_expression_text() throws ParseException {
                                        /*@bgen(jjtree) balanced_expression_text */
                                        SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTBALANCED_EXPRESSION_TEXT);
                                        boolean jjtc000 = true;
                                        jjtree.openNodeScope(jjtn000);
                                        jjtreeOpenNodeScope(jjtn000);Token start; Token end; Token t;
    try {
                start = getToken(1);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACE:
        case LBRACKET:
          initial_balanced_expression_text();
          break;
        case QUOTE:
          string();
          break;
        case QUOTE2:
          string2();
          break;
        case TEXT:
          label_5:
          while (true) {
            jj_consume_token(TEXT);
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case TEXT:
              ;
              break;
            default:
              jj_la1[11] = jj_gen;
              break label_5;
            }
          }
          break;
        case BACKSLASH:
          t = jj_consume_token(BACKSLASH);
                         errorBackSlashInvalidInFStrings(t);
          break;
        default:
          jj_la1[12] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case LBRACE:
        case LBRACKET:
        case QUOTE:
        case QUOTE2:
        case BACKSLASH:
        case TEXT:
          ;
          break;
        default:
          jj_la1[13] = jj_gen;
          break label_4;
        }
      }
            end = token;
            jjtree.markNodeStartEnd(jjtn000, start, end);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return (SimpleNode)jjtree.peekNode();}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public SimpleNode initial_balanced_expression_text() throws ParseException {
                                                /*@bgen(jjtree) initial_balanced_expression_text */
                                                SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTINITIAL_BALANCED_EXPRESSION_TEXT);
                                                boolean jjtc000 = true;
                                                jjtree.openNodeScope(jjtn000);
                                                jjtreeOpenNodeScope(jjtn000);Token start; Token end;
    try {
                start = getToken(1);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        jj_consume_token(LPAREN);
        label_6:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACE:
          case LBRACKET:
          case EXCLAMATION:
          case COLON:
          case QUOTE:
          case QUOTE2:
          case BACKSLASH:
          case TEXT:
            ;
            break;
          default:
            jj_la1[14] = jj_gen;
            break label_6;
          }
          inner_balanced_expression_text_with_exclamation_and_colon();
        }
        try {
          jj_consume_token(RPAREN);
        } catch (ParseException e) {
                addParseError(e, "Unbalanced '('");
        }
        break;
      case LBRACE:
        jj_consume_token(LBRACE);
        label_7:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACE:
          case LBRACKET:
          case EXCLAMATION:
          case COLON:
          case QUOTE:
          case QUOTE2:
          case BACKSLASH:
          case TEXT:
            ;
            break;
          default:
            jj_la1[15] = jj_gen;
            break label_7;
          }
          inner_balanced_expression_text_with_exclamation_and_colon();
        }
        try {
          jj_consume_token(RBRACE);
        } catch (ParseException e) {
                addParseError(e, "Unbalanced '{'");
        }
        break;
      case LBRACKET:
        jj_consume_token(LBRACKET);
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACE:
          case LBRACKET:
          case EXCLAMATION:
          case COLON:
          case QUOTE:
          case QUOTE2:
          case BACKSLASH:
          case TEXT:
            ;
            break;
          default:
            jj_la1[16] = jj_gen;
            break label_8;
          }
          inner_balanced_expression_text_with_exclamation_and_colon();
        }
        try {
          jj_consume_token(RBRACKET);
        } catch (ParseException e) {
                addParseError(e, "Unbalanced '['");
        }
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
            end = token;
            jjtree.markNodeStartEnd(jjtn000, start, end);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return (SimpleNode)jjtree.peekNode();}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public SimpleNode inner_balanced_expression_text_with_exclamation_and_colon() throws ParseException {
                                                                         /*@bgen(jjtree) inner_balanced_expression_text_with_exclamation_and_colon */
                                                                         SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTINNER_BALANCED_EXPRESSION_TEXT_WITH_EXCLAMATION_AND_COLON);
                                                                         boolean jjtc000 = true;
                                                                         jjtree.openNodeScope(jjtn000);
                                                                         jjtreeOpenNodeScope(jjtn000);Token start; Token end; Token t;
    try {
                start = getToken(1);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        jj_consume_token(LPAREN);
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACE:
          case LBRACKET:
          case EXCLAMATION:
          case COLON:
          case QUOTE:
          case QUOTE2:
          case BACKSLASH:
          case TEXT:
            ;
            break;
          default:
            jj_la1[18] = jj_gen;
            break label_9;
          }
          inner_balanced_expression_text_with_exclamation_and_colon();
        }
        try {
          jj_consume_token(RPAREN);
        } catch (ParseException e) {
                addParseError(e, "Unbalanced '('");
        }
        break;
      case LBRACE:
        jj_consume_token(LBRACE);
        label_10:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACE:
          case LBRACKET:
          case EXCLAMATION:
          case COLON:
          case QUOTE:
          case QUOTE2:
          case BACKSLASH:
          case TEXT:
            ;
            break;
          default:
            jj_la1[19] = jj_gen;
            break label_10;
          }
          inner_balanced_expression_text_with_exclamation_and_colon();
        }
        try {
          jj_consume_token(RBRACE);
        } catch (ParseException e) {
                addParseError(e, "Unbalanced '{'");
        }
        break;
      case LBRACKET:
        jj_consume_token(LBRACKET);
        label_11:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case LPAREN:
          case LBRACE:
          case LBRACKET:
          case EXCLAMATION:
          case COLON:
          case QUOTE:
          case QUOTE2:
          case BACKSLASH:
          case TEXT:
            ;
            break;
          default:
            jj_la1[20] = jj_gen;
            break label_11;
          }
          inner_balanced_expression_text_with_exclamation_and_colon();
        }
        try {
          jj_consume_token(RBRACKET);
        } catch (ParseException e) {
                addParseError(e, "Unbalanced '['");
        }
        break;
      case QUOTE:
        string();
        break;
      case QUOTE2:
        string2();
        break;
      case EXCLAMATION:
      case COLON:
      case TEXT:
        label_12:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case TEXT:
            jj_consume_token(TEXT);
            break;
          case EXCLAMATION:
            jj_consume_token(EXCLAMATION);
            break;
          case COLON:
            jj_consume_token(COLON);
            break;
          default:
            jj_la1[21] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case EXCLAMATION:
          case COLON:
          case TEXT:
            ;
            break;
          default:
            jj_la1[22] = jj_gen;
            break label_12;
          }
        }
        break;
      case BACKSLASH:
        t = jj_consume_token(BACKSLASH);
                         errorBackSlashInvalidInFStrings(t);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
            end = token;
            jjtree.markNodeStartEnd(jjtn000, start, end);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return (SimpleNode)jjtree.peekNode();}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public void string() throws ParseException {
                /*@bgen(jjtree) string */
                SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTSTRING);
                boolean jjtc000 = true;
                jjtree.openNodeScope(jjtn000);
                jjtreeOpenNodeScope(jjtn000);Token start; Token end; Token t;
    try {
                start = getToken(1);
      jj_consume_token(QUOTE);
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case RPAREN:
        case LBRACE:
        case RBRACE:
        case LBRACKET:
        case RBRACKET:
        case EXCLAMATION:
        case COLON:
        case QUOTE2:
        case BACKSLASH:
        case TEXT:
          ;
          break;
        default:
          jj_la1[24] = jj_gen;
          break label_13;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case TEXT:
          jj_consume_token(TEXT);
          break;
        case LPAREN:
          jj_consume_token(LPAREN);
          break;
        case RPAREN:
          jj_consume_token(RPAREN);
          break;
        case LBRACE:
          jj_consume_token(LBRACE);
          break;
        case RBRACE:
          jj_consume_token(RBRACE);
          break;
        case LBRACKET:
          jj_consume_token(LBRACKET);
          break;
        case RBRACKET:
          jj_consume_token(RBRACKET);
          break;
        case QUOTE2:
          jj_consume_token(QUOTE2);
          break;
        case EXCLAMATION:
          jj_consume_token(EXCLAMATION);
          break;
        case COLON:
          jj_consume_token(COLON);
          break;
        case BACKSLASH:
          t = jj_consume_token(BACKSLASH);
                          errorBackSlashInvalidInFStrings(t);
          break;
        default:
          jj_la1[25] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      try {
        jj_consume_token(QUOTE);
      } catch (ParseException e) {
        addParseError(e, "Unbalanced \u005c"'\u005c"");
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
            end = token;
            jjtree.markNodeStartEnd(jjtn000, start, end);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  final public void string2() throws ParseException {
                 /*@bgen(jjtree) string2 */
                 SimpleNode jjtn000 = (SimpleNode)SimpleNode.jjtCreate(this, JJTSTRING2);
                 boolean jjtc000 = true;
                 jjtree.openNodeScope(jjtn000);
                 jjtreeOpenNodeScope(jjtn000);Token start; Token end; Token t;
    try {
                start = getToken(1);
      jj_consume_token(QUOTE2);
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LPAREN:
        case RPAREN:
        case LBRACE:
        case RBRACE:
        case LBRACKET:
        case RBRACKET:
        case EXCLAMATION:
        case COLON:
        case QUOTE:
        case BACKSLASH:
        case TEXT:
          ;
          break;
        default:
          jj_la1[26] = jj_gen;
          break label_14;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case TEXT:
          jj_consume_token(TEXT);
          break;
        case LPAREN:
          jj_consume_token(LPAREN);
          break;
        case RPAREN:
          jj_consume_token(RPAREN);
          break;
        case LBRACE:
          jj_consume_token(LBRACE);
          break;
        case RBRACE:
          jj_consume_token(RBRACE);
          break;
        case LBRACKET:
          jj_consume_token(LBRACKET);
          break;
        case RBRACKET:
          jj_consume_token(RBRACKET);
          break;
        case QUOTE:
          jj_consume_token(QUOTE);
          break;
        case EXCLAMATION:
          jj_consume_token(EXCLAMATION);
          break;
        case COLON:
          jj_consume_token(COLON);
          break;
        case BACKSLASH:
          t = jj_consume_token(BACKSLASH);
                          errorBackSlashInvalidInFStrings(t);
          break;
        default:
          jj_la1[27] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      try {
        jj_consume_token(QUOTE2);
      } catch (ParseException e) {
        addParseError(e, "Unbalanced '\u005c"'");
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
            end = token;
            jjtree.markNodeStartEnd(jjtn000, start, end);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
            jjtreeCloseNodeScope(jjtn000);
          }
    }
  }

  /** Generated Token Manager. */
  public FStringsGrammarTokenManager token_source;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1ffe0,0x100,0x1ffe0,0x1e2a0,0x800,0x1000,0x10000,0x1e080,0x10000,0x1e2a0,0x1e080,0x10000,0x1e2a0,0x1e2a0,0x1faa0,0x1faa0,0x1faa0,0x2a0,0x1faa0,0x1faa0,0x1faa0,0x11800,0x11800,0x1faa0,0x1dfe0,0x1dfe0,0x1bfe0,0x1bfe0,};
   }

  /** Constructor with user supplied FastCharStream. */
  public FStringsGrammar(FastCharStream stream) {
    token_source = new FStringsGrammarTokenManager(stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  //Removed Reinit}

  /** Constructor with generated Token Manager. */
  public FStringsGrammar(FStringsGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  //Removed Reinit}

  private Token jj_consume_token(int kind) throws ParseException {
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
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
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
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
