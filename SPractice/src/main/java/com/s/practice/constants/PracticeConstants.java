package com.s.practice.constants;

public interface PracticeConstants {

	char COMMA_SEPARATOR = ',';
	char PIPE_SEPARATOR = '|';
	char TAB_SEPARATOR = '	';
	
	enum Separators{
		COMMA_SEPARATOR(','),
		PIPE_SEPARATOR('|'),
		TAB_SEPARATOR('	');
		private char separator;
		public char getSeparator() {
			return this.separator;
		}
		private Separators(char separator) {
			this.separator = separator;
		}
	}
}
