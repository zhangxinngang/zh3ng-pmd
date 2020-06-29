package com.zh3ng.club.pmd.custom.rules.parameter;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-05-12
 * 关于方法 参数的代码规则
 */
public class ParameterCommaRule extends AbstractJavaRule {

    /**
     * 方法的定义-参数之间逗号后要加一个空格
     * @param node
     * @param data
     * @return
     */
    @Override
    public Object visit(ASTMethodDeclaration node, Object data) {
        ASTMethodDeclarator declarator = node.getFirstChildOfType(ASTMethodDeclarator.class);

        if (declarator != null){
            int paramCount = declarator.getParameterCount();
            if (paramCount > 1){
                ASTFormalParameters formalParameters = declarator.getFirstChildOfType(ASTFormalParameters.class);
                List<ASTFormalParameter> parameters = formalParameters.findChildrenOfType(ASTFormalParameter.class);
                for (int i = 0; i< parameters.size() - 1; i++){
                    ASTFormalParameter parameter = parameters.get(i);
                    ASTFormalParameter parameterBehind = parameters.get(i+1);
                    if (parameterBehind.getBeginColumn() - parameter.getEndColumn() != 3
                            && parameterBehind.getBeginLine()==parameter.getEndLine()){
                        String message = " 方法的定义-参数之间逗号分隔，逗号之后加一个空格";
                        this.addViolationWithMessage(data, node, message);
                    }
                }
            }
        }
        return super.visit(node, data);
    }

    /**
     * 方法的调用-参数之间逗号分隔，逗号之后加一个空格
     * @param node
     * @param data
     * @return
     */
    @Override
    public Object visit(ASTPrimaryExpression node, Object data) {
        int nodeCount = node.jjtGetNumChildren();
        for (int i = 0;i<nodeCount;i++){
            Node n = node.jjtGetChild(i);
            if (n.getClass() == ASTPrimarySuffix.class && ((ASTPrimarySuffix)n).getArgumentCount() > 0){
                ASTArguments arguments = ((ASTPrimarySuffix)n).getFirstChildOfType(ASTArguments.class);
                ASTArgumentList argumentList = arguments.getFirstChildOfType(ASTArgumentList.class);
                for (int j=0;j < arguments.getArgumentCount() - 1;j++){
                    if (argumentList.jjtGetChild(j+1).getBeginLine() == argumentList.jjtGetChild(j).getBeginLine()
                            && argumentList.jjtGetChild(j+1).getBeginColumn() - argumentList.jjtGetChild(j).getEndColumn() != 3){
                        String message = " 方法的调用-参数之间逗号分隔，逗号之后加一个空格";
                        this.addViolationWithMessage(data, node, message);
                    }
                }
            }
        }

        return super.visit(node, data);
    }

}
