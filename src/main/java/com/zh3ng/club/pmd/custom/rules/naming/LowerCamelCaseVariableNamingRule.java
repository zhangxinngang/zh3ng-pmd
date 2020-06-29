package com.zh3ng.club.pmd.custom.rules.naming;

import com.alibaba.p3c.pmd.I18nResources;
import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import com.alibaba.p3c.pmd.lang.java.util.ViolationUtils;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.*;

import java.util.regex.Pattern;

/**
 * @author zhangxingang
 * @created on 2020-06-29
 *
 * 复制自 ali p3c 同名类，修改了正则表达式。
 */
public class LowerCamelCaseVariableNamingRule extends AbstractAliRule {
    private Pattern pattern = Pattern.compile("^[a-z][a-z0-9]*([A-Z][a-z0-9]+)*(DO|PO|VO|BO|DTO)?([A-Za-z0-9]+)*(DO|PO|VO|BO|DTO)?(DAO|List|Map|Set|DAOList|Example|Mapper|ListMap|VersionUID|[A-Z])?$");

    public LowerCamelCaseVariableNamingRule() {
    }

    @Override
    public Object visit(ASTVariableDeclaratorId node, Object data) {
        if (this.variableNamingStartOrEndWithDollarAndUnderLine(node.getImage())) {
            return super.visit(node, data);
        } else {
            ASTTypeDeclaration typeDeclaration = (ASTTypeDeclaration)node.getFirstParentOfType(ASTTypeDeclaration.class);
            Node jjtGetChild = typeDeclaration.jjtGetChild(0);
            if (jjtGetChild instanceof ASTAnnotationTypeDeclaration) {
                return super.visit(node, data);
            } else {
                ASTFieldDeclaration astFieldDeclaration = (ASTFieldDeclaration)node.getFirstParentOfType(ASTFieldDeclaration.class);
                boolean isNotCheck = astFieldDeclaration != null && (astFieldDeclaration.isFinal() || astFieldDeclaration.isStatic());
                if (isNotCheck) {
                    return super.visit(node, data);
                } else {
                    if (!this.pattern.matcher(node.getImage()).matches()) {
                        ViolationUtils.addViolationWithPrecisePosition(this, node, data, I18nResources.getMessage("java.naming.LowerCamelCaseVariableNamingRule.violation.msg.variable", new Object[]{node.getImage()}));
                    }

                    return super.visit(node, data);
                }
            }
        }
    }

    @Override
    public Object visit(ASTMethodDeclarator node, Object data) {
        if (!this.variableNamingStartOrEndWithDollarAndUnderLine(node.getImage()) && !this.pattern.matcher(node.getImage()).matches()) {
            ViolationUtils.addViolationWithPrecisePosition(this, node, data, I18nResources.getMessage("java.naming.LowerCamelCaseVariableNamingRule.violation.msg.method", new Object[]{node.getImage()}));
        }

        return super.visit(node, data);
    }

    private boolean variableNamingStartOrEndWithDollarAndUnderLine(String variable) {
        return variable.startsWith("$") || variable.startsWith("_");
    }

}
