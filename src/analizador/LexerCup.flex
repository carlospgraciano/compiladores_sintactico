package analizador;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L = [a-zA-Z_]+
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
if {return new Symbol(sym.If, yychar, yyline, yyText());}
{espacio} {/*Ignore*/}
"//" {/*Ignore*/}
"("  {return new Symbol(sym.Abre_Parentesis, yychar, yyline, yyText());}
")"  {return new Symbol(sym.Cierra_Parentesis, yychar, yyline, yyText());}
">"  {return new Symbol(sym.Mayor, yychar, yyline, yyText());}
">=" {return new Symbol(sym.MayorOIgual, yychar, yyline, yyText());}
"<"  {return new Symbol(sym.Menor, yychar, yyline, yyText());}
"<=" {return new Symbol(sym.MenorOIgual, yychar, yyline, yyText());}
"!=" {return new Symbol(sym.NoIgual, yychar, yyline, yyText());}
"==" {return new Symbol(sym.Igual, yychar, yyline, yyText());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yyText());}
("(-"{D}")")|{D} {return new Symbol(sym.Numero, yychar, yyline, yyText());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yyText());}