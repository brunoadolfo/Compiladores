grammar prog;
@lexer::header{
   package comp;
}
@parser::header{
   package comp;
   import java.util.*;
}
@parser::members{
   Map<String, InfoToken> memory = new HashMap<String,InfoToken>();
}
prog: decl+ cmd+
    ;
decl: (declVar|declConst) ';'
    ;
declVar: tipo listaIds
    ;
declConst: tipo ID '=' NUM
    ;
tipo returns [int val]:
     'int'
    |'float'
    |'bool'
    ;
listaIds: ID (',' ID)*
        ;
cmd: (atrib | impressao) ';'
   ;
atrib: ID '=' expr
     ;
expr returns [double val]: 
      termo op=('+'|'-') expr
    | termo
    ;
    
termo returns [double val]:
      fator op=('*'|'/') termo
    | fator;
    
fator returns [double val]: 
       NUM
     | ID
     | '(' expr ')'
     ;
impressao: 'print' '(' listaIds ')' | 'printAll' '('')'   
         ;
              
ID: [a-zA-Z]([a-zA-Z0-9])*
  ;
NUM: [0-9]+('.'[0-9]+)?
   ;
WS: [ \t\r\n]+ ->skip;