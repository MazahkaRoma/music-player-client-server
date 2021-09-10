import Exceptions.NoBindingException;

import java.util.HashMap;
import java.util.Map;

public interface BasicConfig {

    void setBinding(String key, String value);

    String getBinding(String key) throws NoBindingException;
}
