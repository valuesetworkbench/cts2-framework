package edu.mayo.cts2.framework.webapp.rest.controller
import edu.mayo.cts2.framework.model.association.Association
import edu.mayo.cts2.framework.model.core.CodeSystemReference
import edu.mayo.cts2.framework.model.core.CodeSystemVersionReference
import edu.mayo.cts2.framework.model.core.NameAndMeaningReference
import edu.mayo.cts2.framework.model.directory.DirectoryResult
import edu.mayo.cts2.framework.service.profile.association.AssociationReadService
import edu.mayo.cts2.framework.service.profile.entitydescription.EntityDescriptionQueryService
import org.junit.Test
import org.springframework.test.web.server.setup.MockMvcBuilders

import javax.annotation.Resource

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.server.result.MockMvcResultActions.response

class AssociationControllerRestBindingTest extends ControllerRestBindingTestBase {
	
	@Resource
	AssociationController controller
	
	@Override
	public getByUriUrl() {
		"/associationbyuri"
	}
	
	@Override
	public getByNameUrl() {
		"/association/http://some/association.org"
	}

	@Override
	public getUriToTest() {
		"http://some/association.org"
	}

	@Override
	void testGetByUriWithForward(){}

	@Override
	void testGetByUriWithRedirect(){}

	@Test
	void testGetChildren(){
		MockMvcBuilders
				.webApplicationContextSetup(context).build()
				.perform(get("/codesystem/foo/version/1/entity/ns:entityName/children"))
				.andExpect(response().status().isOk())
	}

	@Test
	void testGetDescendants(){
		MockMvcBuilders
				.webApplicationContextSetup(context).build()
				.perform(get("/codesystem/foo/version/1/entity/ns:entityName/descendants"))
				.andExpect(response().status().isOk())
	}

	@Test
	void testGetAncestors(){
		MockMvcBuilders
				.webApplicationContextSetup(context).build()
				.perform(get("/codesystem/foo/version/1/entity/ns:entityName/ancestors"))
				.andExpect(response().status().isOk())
	}
	
	@Override
	public initController() {
		def a = new Association(
			assertedBy:new CodeSystemVersionReference(
				codeSystem:new CodeSystemReference(content:"csname"),
				version:new NameAndMeaningReference(content:"csvname")),
			associationID:"http://some/association.org")
		
		def rs = [
			read:{id,readcontext -> a }
		] as AssociationReadService;
	
		controller.setAssociationReadService(rs);

		controller.setEntityDescriptionQueryService([
				getResourceSummaries: { query, sortCriteria, page ->
					new DirectoryResult([], true)
				}
		] as EntityDescriptionQueryService)
		
		controller
	}
}
