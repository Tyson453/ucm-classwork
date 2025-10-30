package MinMaxFinder;

public class MinMaxFinder<T extends Comparable<T>> {

    private T[] elements;

    public MinMaxFinder(T[] elements) {
        this.elements = elements;
    }

    public T findMin() {
        // currentMin starts off as first element
        T currentMin = this.elements[0];

        // For each element, check if it is less than currentMin
        // If so, set currentMin to the element
        for (T el : this.elements) {
            if (el.compareTo(currentMin) < 0) {
                currentMin = el;
            }
        }

        return currentMin;
    }

    public T findMax() {
        // currentMax starts off as first element
        T currentMax = this.elements[0];

        // For each element, check if it is greater than currentMax
        // If so, set currentMin to the element
        for (T el : this.elements) {
            if (el.compareTo(currentMax) > 0) {
                currentMax = el;
            }
        }

        return currentMax;
    }
}
