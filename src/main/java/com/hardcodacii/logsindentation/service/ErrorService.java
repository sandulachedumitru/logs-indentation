package com.hardcodacii.logsindentation.service;

import com.hardcodacii.logsindentation.service.model.Error;

import java.util.List;

/**
 * @author Dumitru Săndulache (sandulachedumitru@hotmail.com)
 */

public interface ErrorService {
	void addError(Error error);

	void emptyErrorsList();

	List<Error> getErrors();

	void displayErrors();
}
