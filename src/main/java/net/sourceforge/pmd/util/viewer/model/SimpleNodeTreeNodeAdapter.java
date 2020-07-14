/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.viewer.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.TreeNode;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * provides the adapter for the tree model
 *
 * @author Boris Gruschko ( boris at gruschko.org )
 * @version $Id$
 */
@Deprecated // to be removed with PMD 7.0.0
public class SimpleNodeTreeNodeAdapter implements TreeNode {

    private Node node;
    private List<TreeNode> children;
    private SimpleNodeTreeNodeAdapter parent;

    /**
     * constructs the node
     *
     * @param node
     *            underlying AST's node
     */
    public SimpleNodeTreeNodeAdapter(SimpleNodeTreeNodeAdapter parent, Node node) {
        this.parent = parent;
        this.node = node;
    }

    /**
     * retrieves the underlying node
     *
     * @return AST node
     */
    public Node getSimpleNode() {
        return node;
    }

    /**
     * @see TreeNode#getChildAt(int)
     */
    @Override
    public TreeNode getChildAt(int childIndex) {
        checkChildren();
        return children.get(childIndex);
    }

    /**
     * @see TreeNode#getChildCount()
     */
    @Override
    public int getChildCount() {
        checkChildren();
        return children.size();
    }

    /**
     * @see TreeNode#getParent()
     */
    @Override
    public TreeNode getParent() {
        return parent;
    }

    /**
     * @see TreeNode#getIndex(TreeNode)
     */
    @Override
    public int getIndex(TreeNode node) {
        checkChildren();
        return children.indexOf(node);
    }

    /**
     * @see TreeNode#getAllowsChildren()
     */
    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    /**
     * @see TreeNode#isLeaf()
     */

    @Override
    public boolean isLeaf() {
        checkChildren();
        return children.isEmpty();
    }

    /**
     * @see TreeNode#children()
     */

    @Override
    public Enumeration<TreeNode> children() {
        return Collections.enumeration(children);
    }

    /**
     * checks the children and creates them if neccessary
     */
    private void checkChildren() {
        if (children == null) {
            children = new ArrayList<>(node.getNumChildren());
            for (int i = 0; i < node.getNumChildren(); i++) {
                children.add(new SimpleNodeTreeNodeAdapter(this, node.getChild(i)));
            }
        }
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return node.toString();
    }
}
