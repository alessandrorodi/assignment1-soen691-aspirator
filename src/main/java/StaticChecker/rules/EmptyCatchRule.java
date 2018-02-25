package StaticChecker.rules;

import StaticChecker.CheckerLogger;
import StaticChecker.Rule;
import StaticChecker.TypeOfWarning;
import com.github.javaparser.ast.stmt.CatchClause;

public class EmptyCatchRule implements Rule<CatchClause> {

    public void apply(CatchClause cc,String fileName){
        //process code block
        String codeBlock = cc.getBody().toString().trim().replaceAll("\\s ", "");
        //evaluate rule
        if(codeBlock.equals("{}") || codeBlock.equals("{\n}") || cc.getBody().getStatements().isEmpty()){
            String range = "Line " + cc.getRange().get().begin.line + " - Line " + cc.getRange().get().end.line;
            CheckerLogger.log(TypeOfWarning.EMPTY,fileName,range);
        }
    }
}
