/**
 * Created by ryan on 2/22/17.
 */
public class MyMap<T, S> {

   private T[] keyArray;
   private S[] valueArray;

    public MyMap() {
        keyArray = (T[]) new Object[]{};
        valueArray = (S[]) new Object[]{};
    }

    public T[] getKeyArray() {
        return keyArray;
    }

    public S[] getValueArray() {
        return valueArray;
    }

    public void setKeyArray(T[] keyArray) {
        this.keyArray = keyArray;
    }

    public void setValueArray(S[] valueArray) {
        this.valueArray = valueArray;
    }

    public boolean put(T key, S value) {
        for(int i = 0; i < getKeyArray().length; i++) {
            if (getKeyArray()[i] == key) {
                return false;
            }
        }
        T[] keyReplacement = (T[]) new Object[getKeyArray().length +1];
        S[] valueReplacement = (S[]) new Object[getValueArray().length + 1];
        keyReplacement[keyReplacement.length - 1] = key;
        valueReplacement[valueReplacement.length - 1] = value;
        setKeyArray(keyReplacement);
        setValueArray(valueReplacement);
        return true;
    }
}
