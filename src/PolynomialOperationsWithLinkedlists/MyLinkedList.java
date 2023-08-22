package PolynomialOperationsWithLinkedlists;

/**
 *
 * @author tokta
 */
public class MyLinkedList {

    private Node first;
    private Node last;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
    }

    private boolean isEmpty() {
        return (first == null);
    }

    private void insertFirst(Node newNode) {
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    private void insertLast(Node newNode) {
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    private void insertMiddle(Node newNode) {
        Node current = first;

        while (current != null) {
            if (newNode.power > current.next.power) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    private Node removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node oldFirst = first; // you save first node
        first = first.next;
        return oldFirst;
    }

    private Node removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node secondLast = first;

        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        Node oldLast = last; // you save last node
        secondLast.next = null;
        last = secondLast;
        return oldLast;
    }

    private Node removeMiddle(int power) {
        if (isEmpty()) {
            return null;
        }

        Node current = first;
        Node oldMiddle = null; // you save middle node

        while (current.next != null) {
            if (current.next.power == power) {
                oldMiddle = current.next;
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        return oldMiddle;
    }

    private boolean isPowerSame(int coef, int power) {
        Node current = first;
        boolean control = false;

        while (current != null) {
            if (current.power == power) {
                current.coef = current.coef + coef;

                if (current.coef == 0) {
                    removeWithGivenPower(current.power);
                }

                control = true;
                break;
            }
            current = current.next;
        }

        return control;
    }

    public void insertSortedList(int coef, int power) {
        if (coef == 0 || power < 0 || isPowerSame(coef, power)) {
            return;
        }

        Node newNode = new Node(coef, power);

        if (isEmpty() || (newNode.power > first.power)) {
            insertFirst(newNode);
        } else if (newNode.power < last.power) {
            insertLast(newNode);
        } else {
            insertMiddle(newNode);
        }

    }

    public MyLinkedList add(MyLinkedList other) {
        if (isEmpty() || other.isEmpty()) {
            System.out.println("List is empty!");
        }

        MyLinkedList res = new MyLinkedList();
        Node current = first;

        while (current != null) {
            res.insertSortedList(current.coef, current.power);
            current = current.next;
        }

        current = other.first;

        while (current != null) {
            res.insertSortedList(current.coef, current.power);
            current = current.next;
        }
        return res;
    }

    public MyLinkedList multiply(MyLinkedList other) {
        if (isEmpty() || other.isEmpty()) {
            System.out.println("List is empty!");
        }

        MyLinkedList res = new MyLinkedList();
        Node tmp1 = this.first; // this LinkedList iterator
        Node tmp2;              // other LinkedList iterator

        while (tmp1 != null) {
            tmp2 = other.first;

            while (tmp2 != null) {
                res.insertSortedList((tmp1.coef * tmp2.coef), (tmp1.power + tmp2.power));
                tmp2 = tmp2.next;
            }
            tmp1 = tmp1.next;
        }
        return res;
    }

    public void removeWithGivenPower(int power) {
        if (isEmpty()) {
            System.out.println("List is empty!");
        }

        if (first.power == power) {
            removeFirst();
            System.out.println("The elements having this power(" + power + ") has been deleted.");
        } else if (last.power == power) {
            removeLast();
            System.out.println("The elements having this power(" + power + ") has been deleted.");
        } else {
            if (removeMiddle(power) == null) {
                System.out.println("This power(" + power + ") does not exist in the polynomial.");
            } else {
                System.out.println("The elements having this power(" + power + ") has been deleted.");
            }
        }
    }

    public String printPolynomial() {
        if (isEmpty()) {
            return "Polynomial is empty!";
        }

        Node tmp = first;
        String s = "";

        while (tmp != null) {
            if (tmp.power == 0) {
                if (tmp.coef > 0) {
                    s = s + " +";
                } else {
                    s = s + " ";
                }
                s = s + tmp.coef;
            } else {
                if (tmp.coef > 0) {
                    s = s + " +";
                } else {
                    s = s + " ";
                }
                s = s + tmp.coef + "x" + "^" + tmp.power;
            }
            tmp = tmp.next;
        }
        return s;
    }

}
