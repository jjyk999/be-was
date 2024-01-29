package model;

import com.google.common.collect.Maps;

import java.util.Map;

public class Session {
    // final 붙여봤자 의미없다? -> 일급 컬렉션으로?
    private Map<String, Object> sessionInfo = Maps.newHashMap();
    private long accessedTime;
    private static final long SESSION_TIMEOUT = 1000 * 60 * 5; // 5분


    private Session(String key, Object value) {
        sessionInfo.put(key, value);
        this.accessedTime = System.currentTimeMillis();
    }

}
