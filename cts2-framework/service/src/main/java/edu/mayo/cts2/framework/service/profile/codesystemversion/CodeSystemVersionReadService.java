/*
 * Copyright: (c) 2004-2011 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.mayo.cts2.framework.service.profile.codesystemversion;

import edu.mayo.cts2.framework.model.codesystem.CodeSystemCatalogEntry;
import edu.mayo.cts2.framework.model.codesystemversion.CodeSystemVersionCatalogEntry;
import edu.mayo.cts2.framework.model.service.core.NameOrURI;
import edu.mayo.cts2.framework.model.service.core.ReadContext;
import edu.mayo.cts2.framework.service.profile.ReadService;

/**
 * The Interface CodeSystemVersionReadService.
 *
 * @author <a href="mailto:kevin.peterson@mayo.edu">Kevin Peterson</a>
 */
public interface CodeSystemVersionReadService extends
		ReadService<CodeSystemVersionCatalogEntry, NameOrURI> {

	/**
	 * Exists code system version for code system.
	 *
	 * @param codeSystemName the code system name
	 * @param tagName the tag name
	 * @return true, if successful
	 */
	public boolean existsCodeSystemVersionForCodeSystem(NameOrURI codeSystem, String tagName);
	
	/**
	 * Gets the code system version for code system.
	 *
	 * @param codeSystemName the code system name
	 * @param tagName the tag name
	 * @return the code system version for code system
	 */
	public CodeSystemVersionCatalogEntry getCodeSystemVersionForCodeSystem(NameOrURI codeSystem, String tagName);
	
	/**
	 * Exists version id.
	 *
	 * @param codeSystemName the code system name
	 * @param officialResourceVersionId the official resource version id
	 * @return true, if successful
	 */
	public boolean existsVersionId(NameOrURI codeSystem, String officialResourceVersionId);
	
	public CodeSystemVersionCatalogEntry getCodeSystemVersionForCodeSystem(NameOrURI codeSystem, String tagName, ReadContext readContext);
	
	public CodeSystemVersionCatalogEntry getCodeSystemByVersionId(NameOrURI codeSystem, String officialResourceVersionId, ReadContext readContext);


}


