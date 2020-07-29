package analizador;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
D = [0-9]+
espacio = [ ,\t,\r]+
%{
    private Symbol symbol(int type, Object value) {
    	return new Symbol(type, yyline, yycolumn, value);
    }
    
    private Symbol symbol(int type) {
    	return new Symbol(type, yyline, yycolumn);
    }
%}
%%
if {return new Symbol(sym.If, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//" {/*Ignore*/}
"("  {return new Symbol(sym.Abre_Parentesis, yychar, yyline, yytext());}
")"  {return new Symbol(sym.Cierra_Parentesis, yychar, yyline, yytext());}
">"  {return new Symbol(sym.Mayor, yychar, yyline, yytext());}
">=" {return new Symbol(sym.Mayor_Igual, yychar, yyline, yytext());}
"<"  {return new Symbol(sym.Menor, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.Menor_Igual, yychar, yyline, yytext());}
"!=" {return new Symbol(sym.No_Igual, yychar, yyline, yytext());}
"==" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
("(-"{D}")")|{D} {return new Symbol(sym.Numero, yychar, yyline, new Integer(yytext()));}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}