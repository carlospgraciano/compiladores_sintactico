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
"(" {return Abre_Parentesis;}
")" {return Cierra_Parentesis;}
{D}{espacio}>{espacio}{D} {lexeme=yytext(); return Mayor;}
{D}{espacio}>={espacio}{D} {lexeme=yytext(); return MayorOIgual;}
{D}{espacio}<{espacio}{D} {lexeme = yytext(); return Menor;}
{D}{espacio}<={espacio}{D} {lexeme = yytext(); return MenorOIgual;}
{D}{espacio}!={espacio}{D} {lexeme = yytext(); return NoIgual;}
{D}{espacio}=={espacio}{D} {lexeme=yytext(); return Igual;}
 . {return ERROR;}