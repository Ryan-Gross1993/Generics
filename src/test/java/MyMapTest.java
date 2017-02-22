import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryan on 2/22/17.
 */
public class MyMapTest {

    MyMap<String, String> aMap;

    @Before
    public void setUp() {
        aMap = new MyMap<>();
    }

    @Test
    public void putTest() {
        aMap.put("Ryan", "Gross");
      //  System.out.println(aMap.getKeyArray()[aMap.getKeyArray().length]);
//        Assert.assertEquals(1, aMap.getKeyArray().length);
    }

}
