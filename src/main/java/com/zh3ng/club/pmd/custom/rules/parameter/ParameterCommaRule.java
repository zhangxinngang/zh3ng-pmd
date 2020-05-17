package com.zh3ng.club.pmd.custom.rules.parameter;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-05-12
 *
 * 方法的定义 参数之间逗号后要加一个空格
 */
public class ParameterCommaRule extends AbstractJavaRule {
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
                    RuleContext ruleContext = (RuleContext)data;
                    if (parameterBehind.getBeginColumn() - parameter.getEndColumn() != 3
                            && parameterBehind.getBeginLine()==parameter.getEndLine()){
                        String message = ruleContext.getSourceCodeFilename() +" "+ node.getBeginLine()+" 方法的定义-参数之间逗号分隔，逗号之后加一个空格";
                        this.addViolation(data, node, message);
                    }
                }
            }
        }
        return super.visit(node, data);
    }

}
