package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class _271_EncodeAndDecodeStringsTest {

    _271_EncodeAndDecodeStrings.Codec codec = new _271_EncodeAndDecodeStrings().new Codec();

    @Test
    public void test() {
        String [] strs = {"sadffea354653", "325345423535", "0549tf,34", "3454gtub   .1/ 41W;CO58 42"};

        List<String> stringList = Arrays.asList(strs);
        String encoded = codec.encode(stringList);
        List<String> decoded = codec.decode(encoded);
        Assert.assertEquals(encoded, codec.encode(decoded));
    }
}
