package com.hardcodacii.logsindentation.service.impl;

import com.hardcodacii.logsindentation.service.CursorService;
import com.hardcodacii.logsindentation.service.DisplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Display logs
 *
 * @author Sandulache Dumitru (sandulachedumitru@hotmail.com)
 */

@Service
@RequiredArgsConstructor
public class DisplayServiceImpl implements DisplayService {
	private static final String ERROR = "[ERROR]";
	private static final String INFO = "[INFO]";
	private static final String WARNING = "[WARNING]";
	private final CursorService cursorService;
	private boolean isNewLine = true;

	@Override
	public void emptyLine() {
		System.out.println();
	}

	@Override
	public String infoLn(Object infoLog, Object... args) {
		return printLn(INFO, infoLog, args);
	}

	@Override
	public String info(Object infoLog, Object... args) {
		return print(INFO, infoLog, args);
	}

	@Override
	public String errorLn(Object errorLog, Object... args) {
		return printLn(ERROR, errorLog, args);
	}

	@Override
	public String error(Object errorLog, Object... args) {
		return print(ERROR, errorLog, args);
	}

	@Override
	public String warningLn(Object warningLog, Object... args) {
		return printLn(WARNING, warningLog, args);
	}

	@Override
	public String warning(Object warningLog, Object... args) {
		return print(WARNING, warningLog, args);
	}

	private String printLn(String prefix, Object logObj, Object... args) {
		if (!isNewLine) {
			System.out.println();
			isNewLine = true;
		}
		var log = cursorService.getCurs() + prefix + "\t" + logObj.toString();
		var processedLog = processLogs(log, args);
		System.out.println(processedLog);
		return processedLog;
	}

	private String print(String prefix, Object logObj, Object... args) {
		var log = logObj.toString();
		if (isNewLine) {
			log = cursorService.getCurs() + prefix + "\t" + log;
			isNewLine = false;
		}
		var processedLog = processLogs(log, args);
		System.out.print(processedLog);
		return processedLog;
	}

	private String processLogs(String log, Object... args) {
		var CURLY_BRACES_REGEX = "\\{}";
		var CURLY_BRACES = "{}";

		int index = 0;
		String newLog = log;
		while (newLog.contains(CURLY_BRACES)) {
			if (args.length != 0 && index < args.length) {
				var arg = args[index] != null ? args[index].toString() : "null";
				newLog = newLog.replaceFirst(CURLY_BRACES_REGEX, arg);
			} else break;
			index++;
		}

		return newLog;
	}
}
