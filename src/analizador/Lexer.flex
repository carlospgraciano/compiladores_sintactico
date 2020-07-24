package analizador;
import static analizador.Tokens.*;
%%
%class Lexer
%type Tokens
L = [a-zA-Z_]+
D = [0-9]+
espacio = [ ,\t,\r]+
%{
    public String lexeme;
%}
%%
if {lexeme=yytext(); return If;}
"(" {lexeme=yytext(); return Abre_Parentesis;}
")" {lexeme=yytext(); return Cierra_Parentesis;}
">" {lexeme=yytext(); return Mayor;}
">=" {lexeme=yytext(); return Mayor_Igual;}
"<" {lexeme = yytext(); return Menor;}
"<=" {lexeme = yytext(); return Menor_Igual;}
"!=" {lexeme = yytext(); return No_Igual;}
"==" {lexeme=yytext(); return Igual;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}")")|{D} {lexeme=yytext(); return Numero;}
 . {return ERROR;}