package MultiThreads;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class DirtyHack {

    public static void main(String[] args) throws Exception {
        String s = "test";
        AddressExtractor addressExtractor = new AddressExtractor();
        Class<? extends AddressExtractor> clazz = addressExtractor.getClass();
        Field field = clazz.getDeclaredField("pointerValue");
        Field type = Field.class.getDeclaredField("type");
        AccessibleObject.setAccessible(new AccessibleObject[]{field, type}, true);
        type.set(field, Object.class);

        field.set(addressExtractor, s);
        System.out.println(Long.toHexString(addressExtractor.pointerValue));
    }

}

class AddressExtractor {
    public long pointerValue;
}
