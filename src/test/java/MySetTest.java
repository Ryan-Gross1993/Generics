import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by ryan on 2/22/17.
 */
public class MySetTest {
    MySet<String> stringSet;
    MySet<String> containsTest;
    MySet<String> similarSet;
    MySet<String> spareString;

    @Before
    public void setUp() {
        spareString = new MySet<>();
        stringSet = new MySet<>();
        similarSet = new MySet<>();
        containsTest = new MySet<>();
        spareString.add("Test");
        stringSet.add("Test");
        containsTest.add("Test");
        containsTest.add("Another Test");
        similarSet.add("Not a test");
    }

    @Test
    public void addTest() {
        Assert.assertEquals(1, stringSet.size());
    }

    @Test
    public void addAllTest() {
        stringSet.addAll(containsTest);
        Assert.assertEquals(2, stringSet.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertFalse(stringSet.isEmpty());
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(1, stringSet.size());
    }

    @Test
    public void clearTest() {
        stringSet.clear();
        Assert.assertTrue(stringSet.isEmpty());
    }

    @Test
    public void containsTest() {
        Assert.assertTrue(stringSet.contains("Test"));
    }

    @Test
    public void containsAllTest() {
        Assert.assertTrue(containsTest.containsAll(stringSet));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(2603186, stringSet.hashCode());
    }

    @Test
    public void equalsTest() {
        Assert.assertFalse(stringSet.equal(containsTest));
        Assert.assertFalse(stringSet.equal(similarSet));
    }

    @Test
    public void removeTest() {
        stringSet.remove("Test");
        Assert.assertTrue(stringSet.isEmpty());
    }

    @Test
    public void removeAllTest() {

        containsTest.removeAll(spareString);
        Assert.assertTrue(containsTest.isEmpty());
    }

    @Test
    public void retainAllTest() {
        Assert.assertTrue(containsTest.retainAll(spareString));
    }

}
