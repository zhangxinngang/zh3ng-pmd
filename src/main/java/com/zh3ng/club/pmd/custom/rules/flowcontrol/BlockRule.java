package com.zh3ng.club.pmd.custom.rules.flowcontrol;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTBlock;
import net.sourceforge.pmd.lang.java.ast.ASTBlockStatement;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;
import org.jaxen.JaxenException;

import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-06-04
 *
 *
 * * 左大括号前不换行。
 * * 左大括号后换行。
 * * 右大括号前换行。
 * * 右大括号后还有else等代码则不换行;表示终止的右大括号后必须换行。
 */
public class BlockRule extends AbstractJavaRule {

    @Override
    public Object visit(ASTBlock node, Object data) {
        Node parent = node.getNthParent(1);
        Node child = node.getFirstChildOfType(Node.class);
        if (node.getBeginLine() != parent.getBeginLine()){
            //ok;
            super.addViolationWithMessage(data, node,"左大括号前不换行");
        }
        if (child != null && child.getBeginLine() == node.getBeginLine()){
            super.addViolationWithMessage(data, node, "左大括号后要换行");
        }
        return super.visit(node, data);
    }

//    @Override
//    public Object visit(ASTBlockStatement node, Object data) {
//        Node parent = node.getNthParent(1);
//        Node child = null;
//        if (node.hasDescendantMatchingXPath("Statement/Block")){
//            try {
//                List<Node> nodeList = node.findChildNodesWithXPath("Statement/Block");
//                if (nodeList.size() > 0){
//                    child = nodeList.get(0);
//                }
//            } catch (JaxenException e) {
//                e.printStackTrace();
//            }
//        }
//        if (node.getBeginLine() != parent.getBeginLine()){
//            //ok;
//            super.addViolationWithMessage(data, node,"左大括号前不换行");
//        }
//        if (child != null && child.getBeginLine() == node.getBeginLine()){
//            super.addViolationWithMessage(data, node, "左大括号后要换行");
//        }
//        return super.visit(node, data);
//    }
}
