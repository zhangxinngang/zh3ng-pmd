package com.zh3ng.club.pmd.custom.rules.parameter;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

/**
 * @author zhangxingang
 * @created on 2020-05-15
 *
 * 方法的调用-参数之间逗号分隔，逗号之后加一个空格
 */
public class ParameterPutInCommaRule extends AbstractJavaRule {
    @Override
    public Object visit(ASTPrimaryExpression node, Object data) {
        int nodeCount = node.jjtGetNumChildren();
        for (int i = 0;i<nodeCount;i++){
            Node n = node.jjtGetChild(i);
            if (n.getClass() == ASTPrimarySuffix.class && ((ASTPrimarySuffix)n).getArgumentCount() > 0){
                ASTArguments arguments = ((ASTPrimarySuffix)n).getFirstChildOfType(ASTArguments.class);
                ASTArgumentList argumentList = arguments.getFirstChildOfType(ASTArgumentList.class);
                RuleContext ruleContext = (RuleContext)data;
                for (int j=0;j < arguments.getArgumentCount() - 1;j++){
                    if (argumentList.jjtGetChild(i+1).getBeginLine() == argumentList.jjtGetChild(i).getBeginLine()
                    && argumentList.jjtGetChild(i+1).getBeginColumn() - argumentList.jjtGetChild(i).getEndColumn() != 3){
                        String message = ruleContext.getSourceCodeFilename() +" "+ node.getBeginLine()+" 方法的调用-参数之间逗号分隔，逗号之后加一个空格";
                        this.addViolation(data, node, message);
                    }
                }
            }
        }

        return super.visit(node, data);
    }
}
