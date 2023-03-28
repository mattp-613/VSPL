# VSPL

This is an assignment I did for one of my classes that worked with compiler syntax

the grammar is as follows:

<program> ::={<statement_list>}
<statement_list> ::=<statement>;<statement_list>
|<statement>;
<statement> ::=call: <procedure_call>
|compute: <expression>
<procedure_call>::=id(<parameters>)
<parameters>::=<factor>,<parameters>
|<factor>
<expression> ::=id=<factor>+<factor>
|id=<factor>-<factor>
|id=<factor>
<factor> ::=id|num

the grammar isn't entirely what is represented in the code as I left factored and removed left recursion (specifically from statement_list and parameters)
