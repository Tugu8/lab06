package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded = 0;

    /**
     * Adds the specified int to the list and increments the attempt count.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
    }

    /**
     * Adds all of the elements of the IntegerList to the list and increments the attempt count.
     * Prevents double counting elements if super.addAll calls this.add under the hood.
     *
    //  * @param list IntegerList containing elements to be added to the list
    //  * @return true if the list changed as a result of the call
    //  */
    @Override
    public boolean addAll(IntegerList list) {
        boolean result = false;
        result = super.addAll(list);
        totalAdded += list.size();
        return result;
    }

    /**
     * @return integer denoting the number of attempted insertions into the list
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}
