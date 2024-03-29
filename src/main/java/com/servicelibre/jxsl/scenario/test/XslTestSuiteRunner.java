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

package com.servicelibre.jxsl.scenario.test;

import java.io.File;
import java.util.List;

/**
 * Descendant of this class allows execution of 1..n XslTestScenario
 * 
 * Input: files, folders (recursively or not)
 * 
 * Choice could be made based on file extension or explicit configuration via
 * setter
 * 
 * 
 */
public interface XslTestSuiteRunner
{

    public TestReport run(File testFile);

    public List<TestReport> runAll();


}
