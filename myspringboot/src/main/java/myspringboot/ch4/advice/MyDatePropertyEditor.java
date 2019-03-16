package myspringboot.ch4.advice;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.StringUtils;

public class MyDatePropertyEditor extends PropertyEditorSupport {
	
	private final String[] dateFormat;
	
	private final static String specifiedDateFormat = "yyyy-MM-dd HH:mm:ss";

	private final boolean allowEmpty;

	private final int exactDateLength;
	
	public MyDatePropertyEditor(boolean allowEmpty, String... dateFormat) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	public MyDatePropertyEditor(boolean allowEmpty, int exactDateLength, String... dateFormat) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}
		else if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
			throw new IllegalArgumentException("Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
		}
		else {
			try {
				setValue(DateUtils.parseDate(text, dateFormat));
			}
			catch (ParseException ex) {
				IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		}
	}

	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	public String getAsText() {
		Date value = (Date) getValue();
		return (value != null ? DateFormatUtils.format(value, specifiedDateFormat) : "");
	}
}
