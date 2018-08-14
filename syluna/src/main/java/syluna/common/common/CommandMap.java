package syluna.common.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CommandMap {
	Map<String, Object> map = new HashMap();

	public Object get(String key) {
		return this.map.get(key);
	}

	public void put(String key, Object value) {
		this.map.put(key, value);
	}

	public Object remove(String key) {
		return this.map.remove(key);
	}

	public boolean containsKey(String key) {
		return this.map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return this.map.containsValue(value);
	}

	public void clear() {
		this.map.clear();
	}

	public Set<Entry<String, Object>> entrySet() {
		return this.map.entrySet();
	}

	public Set<String> keySet() {
		return this.map.keySet();
	}

	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		this.map.putAll(m);
	}

	public Map<String, Object> getMap() {
		return this.map;
	}
}