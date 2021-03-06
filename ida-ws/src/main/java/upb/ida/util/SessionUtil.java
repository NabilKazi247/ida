package upb.ida.util;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * SessionUtil contians sessionMap
 * 
 * @author Faisal
 *
 */
@SessionScope
@Component
public class SessionUtil {
	
	/**
	 * Method to return a session scoped Map and a String
	 * @return - Map
	 * @return - String
	 */
	private Map<String,Object> sessionMap;
	private String algoNameOrignal;
	public String getAlgoNameOrignal() {
		return algoNameOrignal;
	}
	public void setAlgoNameOrignal(String algoNameOrignal) {
		this.algoNameOrignal = algoNameOrignal;
	}
	public SessionUtil() {
		sessionMap = new HashMap<>();
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
}
