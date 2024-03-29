/**
 * Java XSL code library
 *
 * Copyright (C) 2010 Benoit Mercier <info@servicelibre.com> — All rights reserved.
 *
 * This file is part of jxsl.
 *
 * jxsl is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * jxsl is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with jxsl.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.servicelibre.jxsl.dstest.validations;

import java.util.ArrayList;
import java.util.List;

import com.servicelibre.jxsl.dstest.DocumentId;

public class ValidationReport
{

    protected XslValidation outputValidation;
    public List<ValidationFailure> failures = new ArrayList<ValidationFailure>();
	private DocumentId documentId;

    public ValidationReport(XslValidation outputValidation, DocumentId documentId)
    {
        super();
        this.outputValidation = outputValidation;
        this.documentId = documentId;
    }

    public void addValidationFailure(ValidationFailure failure) {
    	failures.add(failure);
    }

	public List<ValidationFailure> getFailures() {
		return failures;
	}

	public DocumentId getDocumentId() {
		return documentId;
	}

	public void setDocumentId(DocumentId documentId) {
		this.documentId = documentId;
	}
	
	public boolean isValidationSuccessful() {
	    return failures.size() == 0;
	}


	
}
