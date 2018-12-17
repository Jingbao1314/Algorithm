package ADTTree;

import AVLTree.AVLNode;

/**
 * @author jijngbao
 * @date 18-12-17
 */
public class ADTNode {
    private ADTNode lift;
    private ADTNode right;
    private int element;

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public ADTNode getLift() {
        return lift;
    }

    public void setLift(ADTNode lift) {
        this.lift = lift;
    }

    public ADTNode getRight() {
        return right;
    }

    public void setRight(ADTNode right) {
        this.right = right;
    }
}
