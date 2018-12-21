package SplayTree;

/**
 * @author jijngbao
 * @date 18-12-20
 */
public class SplayTree {
    private SplayTree parent;
    private int element;
    private SplayTree right;
    private SplayTree lift;

    public SplayTree getParent() {
        return parent;
    }

    public void setParent(SplayTree parent) {
        this.parent = parent;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public SplayTree getRight() {
        return right;
    }

    public void setRight(SplayTree right) {
        this.right = right;
    }

    public SplayTree getLift() {
        return lift;
    }

    public void setLift(SplayTree lift) {
        this.lift = lift;
    }

    public SplayTree(int element, SplayTree right, SplayTree lift) {
        this.element = element;
        this.right = right;
        this.lift = lift;
    }
}
