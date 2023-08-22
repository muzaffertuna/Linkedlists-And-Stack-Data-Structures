package PolynomialOperationsWithLinkedlists;

/**
 *
 * @author tokta
 */
public class Node {

    public int coef;
    public int power;
    public Node next;

    public Node(int coef, int pow) {
        this.coef = coef;
        this.power = pow;
        next = null;
    }
}
