/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.viewer.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * Model for the AST Panel Tree component
 *
 * @author Boris Gruschko ( boris at gruschko.org )
 * @version $Id$
 */
@Deprecated // to be removed with PMD 7.0.0
public class ASTModel implements TreeModel {

    private Node root;
    private List<TreeModelListener> listeners = new ArrayList<>(1);

    /**
     * creates the tree model
     *
     * @param root
     *            tree's root
     */
    public ASTModel(Node root) {
        this.root = root;
    }

    /**
     * @see TreeModel
     */
    @Override
    public Object getChild(Object parent, int index) {
        return ((Node) parent).getChild(index);
    }

    /**
     * @see TreeModel#getChildCount(Object)
     */
    @Override
    public int getChildCount(Object parent) {
        return ((Node) parent).getNumChildren();
    }

    /**
     * @see TreeModel#getIndexOfChild(Object, Object)
     */
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        Node node = (Node) parent;
        for (int i = 0; i < node.getNumChildren(); i++) {
            if (node.getChild(i).equals(child)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @see TreeModel#isLeaf(Object)
     */
    @Override
    public boolean isLeaf(Object node) {
        return ((Node) node).getNumChildren() == 0;
    }

    /**
     * @see TreeModel#getRoot()
     */
    @Override
    public Object getRoot() {
        return root;
    }

    /**
     * @see TreeModel#valueForPathChanged(TreePath, Object)
     */
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see TreeModel#addTreeModelListener(TreeModelListener)
     */
    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);
    }

    /**
     * @see TreeModel#removeTreeModelListener(TreeModelListener)
     */
    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }

    protected void fireTreeModelEvent(TreeModelEvent e) {
        for (TreeModelListener listener : listeners) {
            listener.treeNodesChanged(e);
        }
    }

}
