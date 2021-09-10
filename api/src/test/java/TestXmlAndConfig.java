
import Exceptions.NoBindingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestXmlAndConfig {
    @Test
    public void Test1() {
        try {
            BasicConfig config = new BasicConfig() {
                Map<String, String> bindings = new HashMap<>();

                @Override
                public void setBinding(String key, String value) {
                    bindings.put(key, value);
                }

                @Override
                public String getBinding(String key) throws NoBindingException {
                    return bindings.get(key);
                }
            };
        } catch (Exception e) {
            assert (1 == 0);
        }
    }
}
