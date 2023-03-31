package com.hardcodacii.logsindentation.service.impl;

import com.hardcodacii.logsindentation.service.CursorService;
import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

@Service
public class CursorServiceImpl implements CursorService {
	private static final String TAB = "\t";
	private static final String EMPTY = "";
	private static final Stack<StackElement> localStack = new Stack<>();
	private static String curs = EMPTY;
	private static int column = -1;
	private static int previousStackLength = 0;

	private static void processCursor() {
		var thread = Thread.currentThread();
		var stackLength = thread.getStackTrace().length;

		if (stackLength > previousStackLength) {
			incrementCursor();
			localStack.push(new StackElement(stackLength, column));
		} else if (stackLength < previousStackLength) {
			var flag = false;
			while (!localStack.empty() && !flag) {
				var el = localStack.pop();
				if (el.stackLength == stackLength) {
					localStack.push(el);
					column = el.column;
					createCursor();
					flag = true;
				}
			}
		}
		previousStackLength = stackLength;
	}

	private static void incrementCursor() {
		column++;
		createCursor();
	}

	private static void decrementCursor() {
		column--;
		if (column <= 0) column = 0;
		createCursor();
	}

	private static void resetCursor() {
		column = 0;
		createCursor();
	}

	private static void createCursor() {
		curs = EMPTY;
		curs = curs + TAB.repeat(Math.max(0, column));
	}

	@Override
	public String getCurs() {
		processCursor();
		return curs;
	}

	private static final class StackElement {
		int stackLength = 0;
		int column = 0;

		StackElement(int stackLength, int column) {
			this.stackLength = stackLength;
			this.column = column;
		}
	}
}
