import java.util.Iterator;

/**
 * Created by ryan on 2/22/17.
 */
public class MySet <T> {

    T[] setArray;

    public MySet() {
        setArray = (T[]) new Object[]{};
    }

    public T[] getSetArray() {
        return setArray;
    }

    public void setSetArray(T[] setArray) {
        this.setArray = setArray;
    }

    public int size() {
        return setArray.length;
    }

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public void clear() {
        setSetArray((T[]) new Object[]{});
    }

    public boolean add(T object) {
        if (isEmpty()) {
            setSetArray((T[]) new Object[]{object});
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (getSetArray()[i] == object) {
                    return false;
                }
            }
            T[] replacement = (T[]) new Object[this.size() + 1];
            System.arraycopy(getSetArray(), 0, replacement, 0, this.size());
            replacement[replacement.length - 1] = object;
            setSetArray(replacement);
        }
        return true;
    }

    public void addAll(MySet<T> mySet) {
        for (T object : mySet.getSetArray()) {
            add(object);
        }
    }


    public boolean contains(T object) {
        for (T value : this.getSetArray()) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(MySet<T> set) {
        for(T value : set.getSetArray()) {
            if(! this.contains(value)) {
                return false;
            }
        }
        return true;
    }


    public int hashCode() {
        int total = 0;

        for (T value : this.getSetArray()) {
            total += value.hashCode();
        }
        return total;
    }

    public boolean equal(Object object) {

        if (!(object instanceof MySet)) {
            return false;
        }

        if (this.size() != ((MySet) object).size()) {
            return false;
        }

        for (Object value : ((MySet) object).getSetArray()) {
            if (!this.contains((T) value)) {
                return false;
            }
        }
        return true;
    }

    public boolean remove(Object object) {
        T[] replacement = (T[]) new Object[]{};

        for(T value : this.getSetArray()) {
            if (! this.contains((T)object)) {
                replacement = (T[]) new Object[replacement.length + 1];
                replacement[replacement.length - 1] = value;
            }
        }
        setSetArray(replacement);
        return this.contains((T)object);
    }

    // Returns void instead of boolean
    public void removeAll(MySet<T> set) {
        for(T value : set.getSetArray()) {
            if (this.contains(value)) {
               this.remove(value);
            }
        }
    }

    public boolean retainAll(MySet<T> set) {
        T[] replacement = (T[]) new Object[]{};

        for(T value: set.getSetArray()) {

            if (this.contains(value)) {
                replacement = (T[]) new Object[replacement.length + 1];
                replacement[replacement.length - 1] = value;
            }
        }

        if (this.size() != replacement.length) {
            setSetArray(replacement);
            return true;
        } else {
            return false;
        }
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[this.size()];

        for(int i = 0; i < this.size(); i++) {
            array[i] = this.getSetArray()[i];
        }
        return array;
    }

    public  T[] toArray(T[] anArray) {
        for(int i = 0; i < this.size(); i++) {
            anArray[i] = this.getSetArray()[i];
        }
        return anArray;
    }

}



