/* The following code was generated by JFlex 1.4.1 on 8/21/09 3:31 PM */

/*
 * 8/19/2009
 *
 * ScalaTokenMaker.java - Scanner for the Scala programming language.
 * 
 * This library is distributed under a modified BSD license.  See the included
 * RSyntaxTextArea.License.txt file for details.
 */
package org.fife.ui.rsyntaxtextarea.modes;

import java.io.*;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.*;


/**
 * Scanner for the Scala programming language.<p>
 *
 * This implementation was created using
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1; however, the generated file
 * was modified for performance.  Memory allocation needs to be almost
 * completely removed to be competitive with the handwritten lexers (subclasses
 * of <code>AbstractTokenMaker</code>, so this class has been modified so that
 * Strings are never allocated (via yytext()), and the scanner never has to
 * worry about refilling its buffer (needlessly copying chars around).
 * We can achieve this because RText always scans exactly 1 line of tokens at a
 * time, and hands the scanner this line as an array of characters (a Segment
 * really).  Since tokens contain pointers to char arrays instead of Strings
 * holding their contents, there is no need for allocating new memory for
 * Strings.<p>
 *
 * The actual algorithm generated for scanning has, of course, not been
 * modified.<p>
 *
 * If you wish to regenerate this file yourself, keep in mind the following:
 * <ul>
 *   <li>The generated ScalaTokenMaker.java</code> file will contain two
 *       definitions of both <code>zzRefill</code> and <code>yyreset</code>.
 *       You should hand-delete the second of each definition (the ones
 *       generated by the lexer), as these generated methods modify the input
 *       buffer, which we'll never have to do.</li>
 *   <li>You should also change the declaration/definition of zzBuffer to NOT
 *       be initialized.  This is a needless memory allocation for us since we
 *       will be pointing the array somewhere else anyway.</li>
 *   <li>You should NOT call <code>yylex()</code> on the generated scanner
 *       directly; rather, you should use <code>getTokenList</code> as you would
 *       with any other <code>TokenMaker</code> instance.</li>
 * </ul>
 *
 * @author Robert Futrell
 * @version 0.5
 *
 */

public class ScalaTokenMaker extends AbstractJFlexCTokenMaker {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** lexical states */
  public static final int EOL_COMMENT = 2;
  public static final int YYINITIAL = 0;
  public static final int MLC = 1;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\31\1\24\1\0\1\31\23\0\1\31\1\33\1\25\1\33"+
    "\1\1\1\33\1\33\1\22\2\4\1\30\1\16\1\33\1\16\1\21"+
    "\1\27\1\12\11\3\1\42\1\33\1\0\1\33\1\0\2\33\3\10"+
    "\1\17\1\14\1\17\5\1\1\6\6\1\1\52\7\1\1\4\1\23"+
    "\1\4\1\0\1\5\1\26\1\44\1\45\1\11\1\20\1\15\1\40"+
    "\1\61\1\34\1\41\1\56\1\60\1\7\1\53\1\50\1\47\1\36"+
    "\1\2\1\46\1\37\1\35\1\55\1\57\1\43\1\13\1\51\1\54"+
    "\1\32\1\0\1\32\1\33\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\2\1\1\2\1\3\2\1\1\2\3\1\1\4"+
    "\1\5\1\6\2\1\1\7\15\1\1\10\1\11\5\10"+
    "\1\12\3\10\1\1\1\2\1\0\2\13\3\1\1\0"+
    "\3\1\1\14\1\15\1\4\1\6\1\16\1\6\1\17"+
    "\1\20\26\1\1\21\10\0\1\1\1\13\1\0\4\1"+
    "\1\22\1\1\1\23\11\1\1\14\12\1\10\0\21\1"+
    "\2\0\1\24\2\0\1\25\4\1\1\14\6\1\4\0"+
    "\3\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\226\0\u012c"+
    "\0\u015e\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\226\0\u028a"+
    "\0\u02bc\0\u02ee\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a"+
    "\0\u044c\0\u047e\0\u04b0\0\u04e2\0\u0514\0\u0546\0\u0578\0\u05aa"+
    "\0\u05dc\0\226\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\226"+
    "\0\u0708\0\u073a\0\u076c\0\u079e\0\226\0\u07d0\0\226\0\u0802"+
    "\0\u0834\0\u0866\0\u0898\0\u08ca\0\u08fc\0\u092e\0\u0960\0\310"+
    "\0\226\0\u0992\0\u09c4\0\226\0\u09f6\0\226\0\226\0\u0a28"+
    "\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54\0\u0b86\0\u0bb8"+
    "\0\u0bea\0\u0c1c\0\u0c4e\0\u0c80\0\u0cb2\0\u0ce4\0\u0d16\0\u0d48"+
    "\0\u0d7a\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\226\0\u0e74\0\u0ea6"+
    "\0\u0ed8\0\u0f0a\0\u0f3c\0\u0f6e\0\u0fa0\0\u0fd2\0\u1004\0\u1036"+
    "\0\u1068\0\u109a\0\u10cc\0\u10fe\0\u1130\0\u08ca\0\u1162\0\226"+
    "\0\u1194\0\u11c6\0\u11f8\0\u122a\0\u125c\0\u128e\0\u12c0\0\u12f2"+
    "\0\u1324\0\u1356\0\u1388\0\u13ba\0\u13ec\0\u141e\0\u1450\0\u1482"+
    "\0\u14b4\0\u14e6\0\u1518\0\u154a\0\u157c\0\u15ae\0\u15e0\0\u1612"+
    "\0\u1644\0\u1676\0\u16a8\0\u16da\0\u170c\0\u173e\0\u1770\0\u17a2"+
    "\0\u17d4\0\u1806\0\u1838\0\u186a\0\u189c\0\u18ce\0\u1900\0\u1932"+
    "\0\u1964\0\u1996\0\u19c8\0\u19fa\0\u1a2c\0\u1a5e\0\u1a90\0\u1ac2"+
    "\0\u1af4\0\u1b26\0\u1b58\0\u1b8a\0\u1bbc\0\u1bee\0\u1c20\0\u1c52"+
    "\0\u1c84\0\u1cb6\0\u1ce8\0\u1d1a\0\u1d4c\0\u1d7e\0\u1db0\0\u1ac2"+
    "\0\u1de2\0\u1b58\0\u1e14\0\u1e46\0\u1e78";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\6\1\7\2\5\1\10\1\5\1\11"+
    "\1\12\2\5\1\13\1\4\1\5\1\14\1\15\1\16"+
    "\1\4\1\17\1\20\1\21\1\22\1\4\1\23\1\7"+
    "\1\4\1\5\1\24\1\25\1\26\1\27\1\30\1\4"+
    "\1\31\1\32\1\5\1\33\1\34\1\35\1\36\1\5"+
    "\1\37\3\5\1\40\2\5\24\41\1\42\3\41\1\43"+
    "\3\41\1\44\3\41\1\45\2\41\1\46\16\41\24\47"+
    "\1\50\7\47\1\51\3\47\1\52\2\47\1\53\16\47"+
    "\63\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\6\5\1\0\17\5\3\0\1\6\2\0\2\55\2\0"+
    "\1\6\1\0\2\56\1\0\2\57\1\60\16\0\1\57"+
    "\22\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\6\5\1\0\1\5\1\61\15\5\1\0\3\5\1\0"+
    "\1\54\1\5\1\62\6\5\1\0\2\5\13\0\6\5"+
    "\1\0\1\5\1\63\15\5\3\0\1\6\2\0\2\55"+
    "\2\0\1\6\1\64\2\56\1\0\2\57\1\60\16\0"+
    "\1\57\22\0\3\5\1\0\1\54\1\5\1\65\3\5"+
    "\1\66\2\5\1\0\2\5\13\0\6\5\1\0\17\5"+
    "\1\0\3\5\1\0\1\54\7\5\1\67\1\0\2\5"+
    "\13\0\6\5\1\0\4\5\1\70\12\5\3\0\1\60"+
    "\6\0\1\60\47\0\22\16\1\71\1\72\36\16\23\20"+
    "\1\73\1\20\1\74\34\20\26\75\1\0\33\75\27\0"+
    "\1\76\1\77\62\0\1\23\31\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\1\100\5\5\1\0\3\5"+
    "\1\101\2\5\1\102\10\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\6\5\1\0\1\5\1\103"+
    "\1\5\1\104\13\5\1\0\3\5\1\0\1\54\7\5"+
    "\1\105\1\0\2\5\13\0\6\5\1\0\12\5\1\106"+
    "\4\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\5\5\1\107\1\0\1\5\1\110\2\5\1\111"+
    "\12\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\4\5\1\70\1\5\1\0\10\5\1\112\6\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\1\113\4\5\1\114\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\6\5\1\0\2\5"+
    "\1\115\14\5\1\0\3\5\1\0\1\54\7\5\1\116"+
    "\1\0\2\5\13\0\6\5\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\6\5\1\0"+
    "\2\5\1\117\11\5\1\120\2\5\1\0\3\5\1\0"+
    "\1\54\7\5\1\121\1\0\2\5\13\0\6\5\1\0"+
    "\12\5\1\122\4\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\5\5\1\123\1\0\17\5\1\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\1\5\1\124\15\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\6\5\1\0\1\5\1\125"+
    "\15\5\24\41\1\0\3\41\1\0\3\41\1\0\3\41"+
    "\1\0\2\41\1\0\16\41\27\0\1\126\67\0\1\127"+
    "\61\0\1\130\3\0\1\131\63\0\1\132\16\0\24\47"+
    "\1\0\7\47\1\0\3\47\1\0\2\47\1\0\16\47"+
    "\35\0\1\133\61\0\1\134\3\0\1\135\63\0\1\136"+
    "\16\0\1\137\3\5\1\0\1\54\10\5\1\137\2\5"+
    "\1\0\7\137\1\0\2\137\6\5\1\137\17\5\3\0"+
    "\1\140\6\0\1\140\3\0\1\141\46\0\1\60\6\0"+
    "\1\60\1\0\2\56\1\0\2\57\17\0\1\57\22\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\11\5\1\142\5\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\6\5\1\0\1\5\1\143"+
    "\15\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\1\5\1\144\1\5\1\145\2\5\1\0\17\5"+
    "\3\0\1\146\4\0\3\146\1\0\2\146\1\0\2\146"+
    "\17\0\1\146\3\0\2\146\15\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\3\5\1\145\2\5\1\0"+
    "\17\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\1\5\1\147\4\5\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\4\5\1\70"+
    "\1\5\1\0\17\5\24\16\1\0\35\16\24\20\1\0"+
    "\35\20\26\75\1\150\33\75\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\5\5\1\151\1\0\3\5"+
    "\1\152\13\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\2\5\13\0\6\5\1\0\1\5\1\153\4\5\1\70"+
    "\3\5\1\145\4\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\2\5\1\145\3\5\1\0\17\5"+
    "\1\0\3\5\1\0\1\54\3\5\1\154\4\5\1\0"+
    "\2\5\13\0\6\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\5\5\1\155\1\0"+
    "\4\5\1\156\12\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\6\5\1\0\1\5\1\157\15\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\2\5\1\160\3\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\6\5\1\0\5\5"+
    "\1\161\11\5\1\0\3\5\1\0\1\54\1\5\1\65"+
    "\6\5\1\0\2\5\13\0\6\5\1\0\17\5\1\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\3\5\1\162\13\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\2\5\1\163\3\5\1\0"+
    "\17\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\5\5\1\164\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\1\5\1\165\4\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\2\5\13\0\3\5\1\166\2\5\1\0\17\5\1\0"+
    "\1\5\1\167\1\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\1\5\1\170\4\5\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\6\5\1\0"+
    "\13\5\1\171\3\5\1\0\3\5\1\0\1\54\7\5"+
    "\1\172\1\0\2\5\13\0\6\5\1\0\17\5\1\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\1\70\16\5\1\0\3\5\1\0\1\54\1\5"+
    "\1\173\6\5\1\0\2\5\13\0\6\5\1\0\17\5"+
    "\1\0\3\5\1\0\1\54\7\5\1\174\1\0\2\5"+
    "\13\0\6\5\1\0\17\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\1\5\1\144\4\5\1\0"+
    "\17\5\1\0\3\5\1\0\1\54\1\5\1\70\6\5"+
    "\1\0\2\5\13\0\6\5\1\0\3\5\1\70\13\5"+
    "\35\0\1\175\62\0\1\176\32\0\1\177\115\0\1\200"+
    "\53\0\1\201\62\0\1\202\32\0\1\203\115\0\1\204"+
    "\16\0\1\137\15\0\1\137\3\0\7\137\1\0\2\137"+
    "\6\0\1\137\22\0\1\140\6\0\1\140\4\0\2\57"+
    "\17\0\1\57\24\0\1\140\6\0\1\140\50\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\6\5\1\0"+
    "\6\5\1\70\10\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\3\5\1\151\2\5\1\0\17\5"+
    "\1\0\3\5\1\0\1\54\3\5\1\165\4\5\1\0"+
    "\2\5\13\0\6\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\7\5\1\70\1\0\2\5\13\0\6\5\1\0"+
    "\17\5\1\0\3\5\1\0\1\54\7\5\1\205\1\0"+
    "\2\5\13\0\6\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\3\5\1\70\2\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\2\5\13\0\6\5\1\0\4\5\1\121\12\5\1\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\5\5"+
    "\1\206\1\0\17\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\6\5\1\0\15\5\1\207\1\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\6\5\1\0\14\5\1\210\2\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\1\5\1\211\4\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\1\5\1\212"+
    "\6\5\1\0\2\5\13\0\6\5\1\0\17\5\1\0"+
    "\3\5\1\0\1\54\7\5\1\213\1\0\2\5\13\0"+
    "\6\5\1\0\17\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\6\5\1\0\1\5\1\214\15\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\6\5\1\0\7\5\1\215\7\5\1\0\3\5\1\0"+
    "\1\54\1\5\1\216\6\5\1\0\2\5\13\0\6\5"+
    "\1\0\4\5\1\217\12\5\1\0\3\5\1\0\1\54"+
    "\1\5\1\145\6\5\1\0\2\5\13\0\6\5\1\0"+
    "\17\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\1\70\5\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\1\5\1\220\4\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\2\5\13\0\6\5\1\0\12\5\1\221\4\5\1\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\12\5\1\222\4\5\1\0\3\5\1\0\1\54"+
    "\7\5\1\223\1\0\2\5\13\0\6\5\1\0\17\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\6\5\1\0\3\5\1\224\13\5\1\0\3\5\1\0"+
    "\1\54\1\5\1\70\6\5\1\0\2\5\13\0\6\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\1\5\1\225"+
    "\6\5\1\0\2\5\13\0\6\5\1\0\17\5\36\0"+
    "\1\226\65\0\1\227\34\0\1\176\65\0\1\230\76\0"+
    "\1\231\65\0\1\232\34\0\1\202\65\0\1\233\41\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\5\5\1\234\11\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\1\5\1\70\4\5\1\0"+
    "\17\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\6\5\1\0\1\5\1\235\15\5\1\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\6\5\1\0"+
    "\1\5\1\236\15\5\1\0\3\5\1\0\1\54\7\5"+
    "\1\237\1\0\2\5\13\0\6\5\1\0\17\5\1\0"+
    "\3\5\1\0\1\54\7\5\1\225\1\0\2\5\13\0"+
    "\6\5\1\0\17\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\6\5\1\0\3\5\1\70\13\5"+
    "\1\0\3\5\1\0\1\54\1\5\1\240\6\5\1\0"+
    "\2\5\13\0\6\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\6\5\1\0\4\5"+
    "\1\241\12\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\2\5\13\0\5\5\1\242\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\6\5\1\0"+
    "\3\5\1\206\13\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\2\5\13\0\6\5\1\0\3\5\1\243\13\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\5\5\1\244\1\0\17\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\6\5\1\0\3\5\1\245"+
    "\13\5\1\0\3\5\1\0\1\54\3\5\1\206\4\5"+
    "\1\0\2\5\13\0\6\5\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\10\5\1\0\2\5\13\0\6\5\1\0"+
    "\3\5\1\246\13\5\1\0\3\5\1\0\1\54\10\5"+
    "\1\0\1\5\1\70\13\0\6\5\1\0\17\5\37\0"+
    "\1\176\2\0\1\227\46\0\1\247\33\0\3\230\1\250"+
    "\11\230\1\250\2\230\2\250\4\0\1\230\1\250\2\0"+
    "\1\250\6\230\1\250\17\230\37\0\1\202\2\0\1\232"+
    "\46\0\1\251\33\0\3\233\1\252\11\233\1\252\2\233"+
    "\2\252\4\0\1\233\1\252\2\0\1\252\6\233\1\252"+
    "\17\233\1\0\3\5\1\0\1\54\10\5\1\0\1\5"+
    "\1\151\13\0\6\5\1\0\17\5\1\0\3\5\1\0"+
    "\1\54\10\5\1\0\2\5\13\0\6\5\1\0\16\5"+
    "\1\145\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\1\5\1\145\4\5\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\3\5\1\253\4\5\1\0\2\5\13\0"+
    "\6\5\1\0\17\5\1\0\3\5\1\0\1\54\1\5"+
    "\1\142\6\5\1\0\2\5\13\0\6\5\1\0\17\5"+
    "\1\0\3\5\1\0\1\54\10\5\1\0\2\5\13\0"+
    "\6\5\1\0\10\5\1\145\6\5\1\0\3\5\1\0"+
    "\1\54\3\5\1\153\4\5\1\0\2\5\13\0\6\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\2\5\13\0\6\5\1\0\1\5\1\223\15\5\1\0"+
    "\3\5\1\0\1\54\10\5\1\0\2\5\13\0\6\5"+
    "\1\0\3\5\1\254\13\5\1\0\3\5\1\0\1\54"+
    "\10\5\1\0\2\5\13\0\6\5\1\0\5\5\1\70"+
    "\11\5\1\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\5\5\1\255\1\0\17\5\27\0\1\230\61\0"+
    "\1\233\33\0\3\5\1\0\1\54\10\5\1\0\2\5"+
    "\13\0\1\5\1\212\4\5\1\0\17\5\1\0\3\5"+
    "\1\0\1\54\7\5\1\151\1\0\2\5\13\0\6\5"+
    "\1\0\17\5\1\0\3\5\1\0\1\54\10\5\1\0"+
    "\1\5\1\145\13\0\6\5\1\0\17\5";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7850];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\2\1\1\11\7\1\1\11\22\1\1\11"+
    "\5\1\1\11\4\1\1\11\1\0\1\11\4\1\1\0"+
    "\4\1\1\11\2\1\1\11\1\1\2\11\26\1\1\11"+
    "\10\0\2\1\1\0\6\1\1\11\24\1\10\0\21\1"+
    "\2\0\1\1\2\0\14\1\4\0\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */


	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public ScalaTokenMaker() {
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addToken(int, int, int)
	 */
	private void addHyperlinkToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, true);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos-1, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addHyperlinkToken(int, int, int)
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, false);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
	 * @param startOffset The offset in the document at which this token
	 *                    occurs.
	 * @param hyperlink Whether this token is a hyperlink.
	 */
	@Override
	public void addToken(char[] array, int start, int end, int tokenType,
						int startOffset, boolean hyperlink) {
		super.addToken(array, start,end, tokenType, startOffset, hyperlink);
		zzStartRead = zzMarkedPos;
	}


	/**
	 * Returns the text to place at the beginning and end of a
	 * line to "comment" it in a this programming language.
	 *
	 * @return The start and end strings to add to a line to "comment"
	 *         it out.
	 */
	@Override
	public String[] getLineCommentStartAndEnd() {
		return new String[] { "//", null };
	}


	/**
	 * Returns the first token in the linked list of tokens generated
	 * from <code>text</code>.  This method must be implemented by
	 * subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which
	 *        <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing
	 *         the syntax highlighted text.
	 */
	@Override
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {

		resetTokenList();
		this.offsetShift = -text.offset + startOffset;

		// Start off in the proper state.
		int state = TokenTypes.NULL;
		switch (initialTokenType) {
			case TokenTypes.COMMENT_MULTILINE:
				state = MLC;
				start = text.offset;
				break;
			default:
				state = TokenTypes.NULL;
		}

		s = text;
		try {
			yyreset(zzReader);
			yybegin(state);
			return yylex();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new DefaultToken();
		}

	}


	/**
	 * Refills the input buffer.
	 *
	 * @return      <code>true</code> if EOF was reached, otherwise
	 *              <code>false</code>.
	 * @exception   IOException  if any I/O-Error occurs.
	 */
	private boolean zzRefill() throws java.io.IOException {
		return zzCurrentPos>=s.offset+s.count;
	}


	/**
	 * Resets the scanner to read from a new input stream.
	 * Does not close the old reader.
	 *
	 * All internal variables are reset, the old input stream 
	 * <b>cannot</b> be reused (internal buffer is discarded and lost).
	 * Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader   the new input stream 
	 */
	public final void yyreset(java.io.Reader reader) throws IOException {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill
		 * no longer "refills" the buffer (since the way we do it, it's always
		 * "full" the first time through, since it points to the segment's
		 * array).  So, we assign zzEndRead here.
		 */
		//zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtEOF  = false;
	}




  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ScalaTokenMaker(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public ScalaTokenMaker(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 150) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  @Override
public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public org.fife.ui.rsyntaxtextarea.Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { addNullToken(); return firstToken;
          }
        case 22: break;
        case 13: 
          { addToken(TokenTypes.LITERAL_CHAR);
          }
        case 23: break;
        case 17: 
          { yybegin(YYINITIAL); addToken(start,zzStartRead+1, TokenTypes.COMMENT_MULTILINE);
          }
        case 24: break;
        case 16: 
          { start = zzMarkedPos-2; yybegin(MLC);
          }
        case 25: break;
        case 7: 
          { addToken(TokenTypes.WHITESPACE);
          }
        case 26: break;
        case 18: 
          { addToken(TokenTypes.LITERAL_NUMBER_HEXADECIMAL);
          }
        case 27: break;
        case 11: 
          { addToken(TokenTypes.LITERAL_NUMBER_FLOAT);
          }
        case 28: break;
        case 12: 
          { addToken(TokenTypes.RESERVED_WORD);
          }
        case 29: break;
        case 3: 
          { addToken(TokenTypes.SEPARATOR);
          }
        case 30: break;
        case 19: 
          { addToken(TokenTypes.LITERAL_BACKQUOTE);
          }
        case 31: break;
        case 1: 
          { addToken(TokenTypes.IDENTIFIER);
          }
        case 32: break;
        case 10: 
          { addToken(start,zzStartRead-1, TokenTypes.COMMENT_EOL); addNullToken(); return firstToken;
          }
        case 33: break;
        case 15: 
          { start = zzMarkedPos-2; yybegin(EOL_COMMENT);
          }
        case 34: break;
        case 4: 
          { addToken(TokenTypes.ERROR_CHAR); addNullToken(); return firstToken;
          }
        case 35: break;
        case 6: 
          { addToken(TokenTypes.ERROR_STRING_DOUBLE); addNullToken(); return firstToken;
          }
        case 36: break;
        case 14: 
          { addToken(TokenTypes.LITERAL_STRING_DOUBLE_QUOTE);
          }
        case 37: break;
        case 21: 
          { int temp=zzStartRead; addToken(start,zzStartRead-1, TokenTypes.COMMENT_EOL); addHyperlinkToken(temp,zzMarkedPos-1, TokenTypes.COMMENT_EOL); start = zzMarkedPos;
          }
        case 38: break;
        case 20: 
          { int temp=zzStartRead; addToken(start,zzStartRead-1, TokenTypes.COMMENT_MULTILINE); addHyperlinkToken(temp,zzMarkedPos-1, TokenTypes.COMMENT_MULTILINE); start = zzMarkedPos;
          }
        case 39: break;
        case 2: 
          { addToken(TokenTypes.LITERAL_NUMBER_DECIMAL_INT);
          }
        case 40: break;
        case 8: 
          { 
          }
        case 41: break;
        case 9: 
          { addToken(start,zzStartRead-1, TokenTypes.COMMENT_MULTILINE); return firstToken;
          }
        case 42: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case EOL_COMMENT: {
              addToken(start,zzStartRead-1, TokenTypes.COMMENT_EOL); addNullToken(); return firstToken;
            }
            case 174: break;
            case YYINITIAL: {
              addNullToken(); return firstToken;
            }
            case 175: break;
            case MLC: {
              addToken(start,zzStartRead-1, TokenTypes.COMMENT_MULTILINE); return firstToken;
            }
            case 176: break;
            default:
            return null;
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
