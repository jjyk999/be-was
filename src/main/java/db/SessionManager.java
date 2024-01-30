package db;

import com.google.common.collect.Maps;
import model.Session;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.RequestHandler;

import java.util.Map;
import java.util.UUID;

public class SessionManager {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);
    private static final Map<String, Session> sessionDB = Maps.newConcurrentMap();

    // 세션 id를 생성하고, 해당 세션의 주인(유저) 정보를 포함하여 세션 DB에 저장한다.. 그후 sid 반환.
    public static String createSession(User user) {
        String sid = generateSessionId();
        sessionDB.put(sid, Session.of("user", user));
        logger.debug("SessionDB put >>>>>> " + sid);
        logger.debug("SessionDB put >>>>>> " + user.getUserId());
        return sid;
    }

    private static String generateSessionId() {
        return UUID.randomUUID().toString();
    }

    private static void checkExpiration(String sid, Session session) {
        if(session != null) {
            if(session.isExpired()) {
                logger.debug("generateSessionId >>>>>> session expired.");
                sessionDB.remove(sid);
            }
            // 아직 세션 살아있으면 기한 연장.
            else {
                logger.debug("generateSessionId >>>>>> session updated.");
                session.updateAccessedTime();
            }
        }
    }

    // 세션 sid에서 사용자의 정보를 가져온다..
    // 아직 살아있는 세션일 때만 유저 반환, 아니면 null 반환.
    public static User getUserInfo(String sid) {
        Session session = sessionDB.get(sid);

        checkExpiration(sid, session);
        if(sessionDB.get(sid) != null) {
            logger.debug("getUserInfo >>>>>> found userdata.");
            return (User) session.getValue("user");
        }
        logger.debug("getUserInfo >>>>>> no valid user.");
        return null;
    }


    // 세션 제거하기
    public static void removeSession(String sid) {
        if(sid != null) {
            sessionDB.remove(sid);
        }
    }
}
