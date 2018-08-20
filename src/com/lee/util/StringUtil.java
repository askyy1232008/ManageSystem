package com.lee.util;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
	public static boolean isNullOrEmpty(Object obj) {	
		return obj == null || "".equals(obj.toString());
	}
	public static String toString(Object obj){
		if(obj == null) return "null";
		return obj.toString();
	}
	public static String join(@SuppressWarnings("rawtypes") Collection s, String delimiter) {
        StringBuffer buffer = new StringBuffer();
        @SuppressWarnings("rawtypes")
		Iterator iter = s.iterator();
        while (iter.hasNext()) {
            buffer.append(iter.next());
            if (iter.hasNext()) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }
}
