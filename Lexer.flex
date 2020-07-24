package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens

D1=[0-9]
D2 = [0-9]


%{
    public String lexeme;
%}
%%

{D1}>{D2} {lexeme=yytext(); return Mayor;}
{D1}<{D2} {lexeme = yytext(); return Menor;}
 {D1} != {D2} {lexeme = yytext(); return Noesigual;}
{D1}=={D2} {lexeme=yytext(); return EsIgual;}
 . {return ERROR;}
