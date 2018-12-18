package AVLTree;

/**
 * @author jijngbao
 * @date 18-12-17
 */
public class AVLNode {
    private AVLNode lift;
    private AVLNode right;
    private int hight=0;
    private int element;

    public AVLNode getLift() {
        return lift;
    }

    public void setLift(AVLNode lift) {
        this.lift = lift;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public AVLNode(AVLNode lift, AVLNode right, int element) {
        this.lift = lift;
        this.right = right;
        this.element = element;
    }

    public AVLNode() {
    }

}
