package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.util.Fnv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ObjectReader3Test {
    @Test
    public void test() {
        ObjectReader objectReader = JSONFactory.getDefaultObjectReaderProvider().getObjectReader(Bean.class);
        assertNotNull(objectReader.getFieldReader("userId1"));
        assertNotNull(objectReader.getFieldReader(Fnv.hashCode64("userId1")));
        assertNotNull(objectReader.getFieldReaderLCase(Fnv.hashCode64("userid1")));

        assertNotNull(objectReader.getFieldReader("userId2"));
        assertNotNull(objectReader.getFieldReader(Fnv.hashCode64("userId2")));
        assertNotNull(objectReader.getFieldReaderLCase(Fnv.hashCode64("userid2")));

        assertNotNull(objectReader.getFieldReader("userId3"));
        assertNotNull(objectReader.getFieldReader(Fnv.hashCode64("userId3")));
        assertNotNull(objectReader.getFieldReaderLCase(Fnv.hashCode64("userid3")));

        assertNull(objectReader.getFieldReader("id"));
        assertNull(objectReader.getFieldReader(0));
        assertNull(objectReader.getFieldReaderLCase(0));
    }

    private class Bean {
        public int userId1;
        public int userId2;
        public int userId3;
    }
}
