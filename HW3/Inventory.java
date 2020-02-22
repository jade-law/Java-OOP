/**
 * An Inventory.
 * @author jdierberger3 and <jlaw39>
 * @version 1331.
 */
public class Inventory {

    // TODO : Add an Item[] instance variable called contents.
    // Initialize it at declaration; give it a default length of 4.
    private Item[] contents = new Item[4];

    // Merge two inventorys, merging other into this inventory.
    public void merge(Inventory other) {
        // TODO : Compute contents.length + other.contents.length
        int thisLen = contents.length;
        int otherLen = other.contents.length;
        int totalLen = thisLen + otherLen;
        // TODO : Create a new Item[] of the size above
        Item[] mergeContents = new Item[totalLen];
        // TODO : Copy all the elements from contents into the new Item[]
        for (int i = 0; i < thisLen; i++) {
            mergeContents[i] = contents[i];
        }
        // TODO : Copy all the elements from other.contents into the new Item[]
        for (int i = thisLen; i < totalLen; i++) {
            mergeContents[i] = other.contents[i - thisLen];
        }
        contents = mergeContents;
        // TODO : Set contents to be the new Item[] we just filled
    }

    // Get the i-th item, where the 0th item is the first.
    // Return null if the index is invalid.
    public Item getItem(int i) {
        // TODO : Check if "i" is a bad index into our array
            // If so, return null
        int len = getContentsLength();
        if (i >= len || i < 0) {
            return null;
        } else {
            return contents[i];
        }
        // TODO : Otherwise, return the element at index i
    }

    // Put an item at the i-th position, where the 0th item is the first.
    // Return false if the index is invalid. Otherwise return true.
    public boolean putItem(int i, Item item) {
        // TODO : Check if "i" is a bad index into our array
        int len = getContentsLength();
        if (i >= len || i < 0) {
            return false;
            // If so, return false
        } else {
            contents[i] = item;
            return true;
        }
        // TODO : Otherwise, set the element at index i to item
    }

    // Get the length of contents.
    public int getContentsLength() {
        // TODO : Return the length of contents.
        return contents.length;
    }

}