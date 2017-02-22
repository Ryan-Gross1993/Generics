import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryan on 2/22/17.
 */
public class MyArrayListTest {
    MyArrayList<String> stringMyArrayList;
    MyArrayList<String> letters;
    MyArrayList<String> numbers;

    @Before
    public void setUp() {
        stringMyArrayList = new MyArrayList<>();
        letters = new MyArrayList<>();
        numbers = new MyArrayList<>();
        stringMyArrayList.add("Testing");
        stringMyArrayList.add("More Testing");
        letters.add("a");
        letters.add("b");
        letters.add("c");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
    }

    @Test
    public void addTest() {
       Assert.assertEquals(2, stringMyArrayList.size());
    }

    @Test
    public void addOverrideTest() {
        stringMyArrayList.add(1, "Pushed into myArrayList");
        Assert.assertEquals(3, stringMyArrayList.size());
        Assert.assertEquals("Pushed into myArrayList", stringMyArrayList.get(1));
        Assert.assertEquals("More Testing", stringMyArrayList.get(2));
    }

    @Test
    public void addAllTest() {
        MyArrayList<String> stringTwo = new MyArrayList<>();
        stringTwo.add("added");
        stringTwo.add("to the end");
        stringMyArrayList.addAll(stringTwo);
        Assert.assertEquals(4, stringMyArrayList.size());
    }

    @Test
    public void addAllOverrideTest() {
        numbers.addAll(1, letters);
        Assert.assertEquals(6, numbers.size());
        Assert.assertEquals("a", numbers.get(1));
        Assert.assertEquals("3", numbers.get(numbers.size() - 1));
    }

    @Test
    // Note: Consider an OOB exception for this..
    public void getTest() {
    Assert.assertEquals("Testing", stringMyArrayList.get(0));
    }

    @Test
    public void removeTest() {
        stringMyArrayList.remove(0);
        Assert.assertEquals("More Testing", stringMyArrayList.get(0));
    }

    @Test
    public void removeRange() {
        letters.removeRange(0, 1);
        Assert.assertEquals("b", letters.get(0));
    }

    @Test
    public void setTest() {
        stringMyArrayList.set(0, "Hey");
        Assert.assertEquals("Hey", stringMyArrayList.get(0));
    }

    @Test
    public void clearTest() {
        stringMyArrayList.clear();
        Assert.assertTrue(stringMyArrayList.isEmpty());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertFalse(stringMyArrayList.isEmpty());
    }

    @Test
    public void containsTest() {
        Assert.assertFalse(stringMyArrayList.contains("false"));
    }

}
