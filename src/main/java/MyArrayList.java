import java.lang.reflect.Array;

/**
 * Created by ryan on 2/22/17.
 */
public class MyArrayList <T> {

    private T[] internalArray;

    public T[] getInternalArray() {
        return internalArray;
    }

    public void setInternalArray(T[] internalArray) {
        this.internalArray = internalArray;
    }

    // http://stackoverflow.com/questions/18581002/how-to-create-a-generic-array
    public MyArrayList() {
        internalArray = (T[]) new Array[]{};
    }

    public MyArrayList(int size) {
        internalArray = (T[]) new Array[size];
    }

    public int size() {
        return getInternalArray().length;
    }


    public void add(T object) {
        T[] replacement;
        if (getInternalArray().length == 0) {
            replacement =(T[]) new Object[] {object};
        } else {
            replacement = (T[]) new Object[getInternalArray().length + 1];
            System.arraycopy(getInternalArray(), 0, replacement, 0, getInternalArray().length);
            replacement[replacement.length - 1] = object;
        }
        setInternalArray(replacement);
    }

    public void add(int index, T object) {
        T[] replacement = (T[]) new Object[getInternalArray().length + 1];
        System.arraycopy(getInternalArray(), 0, replacement, 0, index);
        replacement[index] = object;

        for(int i = index; i < getInternalArray().length; i++) {
            replacement[i+1] = getInternalArray()[i];
        }
        setInternalArray(replacement);
    }

    public void addAll(MyArrayList<T> myArrayList) {
        for (T object : myArrayList.getInternalArray()) {
            this.add(object);
        }
    }

    public void addAll(int index, MyArrayList<T> myArrayList) {
        T[] replacement = (T[]) new Object[getInternalArray().length + myArrayList.size()];
        System.arraycopy(getInternalArray(), 0, replacement, 0, index);

        for(int i = 0; i < myArrayList.size(); i++) {
            replacement[index + i] = myArrayList.get(i);
        }

        for(int i = index; i < this.size(); i++) {
            replacement[i + myArrayList.size()] = this.get(i);
        }
        setInternalArray(replacement);



    }


    public T get(int index) {
        return getInternalArray()[index];
    }

    public void remove(int index) {

        T[] replacement = (T[]) new Object[getInternalArray().length - 1];
        int newCounter = 0;
        int oldCounter = 0;

        while (oldCounter != getInternalArray().length) {
            if (oldCounter != index) {
                replacement[newCounter] = getInternalArray()[oldCounter];
                oldCounter++;
                newCounter++;
            } else {
                oldCounter++;
            }
        }
        setInternalArray(replacement);
    }

    public void removeRange(int start, int end) {
        for(int i = start; i < end; i++) {
            this.remove(i);
        }
    }

    public void set(int index, T object) {
        getInternalArray()[index] = object;
    }

    public boolean isEmpty() {
        return (getInternalArray().length == 0);
    }

    public void clear() {
        setInternalArray( (T[]) new Object[] {} );
    }

    public boolean contains(T object) {
        for (int i = 0; i < getInternalArray().length; i++) {
            if (getInternalArray()[i] == object) {
                return true;
            }
        }
        return false;
    }

}
