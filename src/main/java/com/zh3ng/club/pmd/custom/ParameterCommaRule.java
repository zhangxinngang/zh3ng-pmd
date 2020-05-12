package com.zh3ng.club.pmd.custom;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-05-12
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
                    System.out.println(ruleContext.getSourceCodeFilename() +" "+ node.getBeginLine()+ "  former" +parameter.getEndColumn()+ " later"+parameterBehind.getBeginColumn());
                    if (parameterBehind.getBeginColumn() - parameter.getEndColumn() != 2
                            && parameterBehind.getBeginLine()==parameter.getEndLine()){
                        System.out
                    }
                }
            }
        }
        return super.visit(node,data);
    }

}
