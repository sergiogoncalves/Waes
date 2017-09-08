package com.wearewaes.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wearewaes.domainobject.DifferenceDO;
import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.domainvalue.Messages;
import com.wearewaes.service.difference.DifferenceService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class DifferenceControllerTest {
	
	@Autowired
	private MockMvc mvc;

	
	@Test
	public void shouldLeftSideReceiveIsCreatedStatusWithDifferenceDOAlreadyCreated() throws Exception {

		this.mvc.perform(post("/v1/1/left")
				.accept(MediaType.APPLICATION_JSON)
				.content(Messages.ENCODED_PERSON_DO_STRING))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldRightSideReceiveIsCreatedStatusWithDifferenceDOAlreadyCreated() throws Exception {

		this.mvc.perform(post("/v1/1/right")
				.accept(MediaType.APPLICATION_JSON)
				.content(Messages.ENCODED_PERSON_DO_STRING))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldLeftSideReceiveIsCreatedStatusWithDifferenceDONoCreated() throws Exception {

		this.mvc.perform(post("/v1/2/left")
				.accept(MediaType.APPLICATION_JSON)
				.content(Messages.ENCODED_PERSON_DO_STRING))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldLeftSideRespondBadRequest() throws Exception {

		this.mvc.perform(post("/v1/2/left")
				.accept(MediaType.APPLICATION_JSON)
				.content(Messages.DECODED_PERSON_DO_STRING))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldRightSideRespondBadRequest() throws Exception {

		this.mvc.perform(post("/v1/2/right")
				.accept(MediaType.APPLICATION_JSON)
				.content(Messages.DECODED_PERSON_DO_STRING))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldRightSideReceiveIsCreatedStatusWithDifferenceDONoCreated() throws Exception {

		this.mvc.perform(post("/v1/2/right")
				.accept(MediaType.APPLICATION_JSON)
				.content(Messages.ENCODED_PERSON_DO_STRING))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldAnalyseFalseReturn() throws Exception {

		this.mvc.perform(get("/v1/diff/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(Messages.DECODED_DIFFERENCE_DO_FALSE_STRING));		
						
	}
	
	@Test
	public void shouldAnalyseTrueReturn() throws Exception {

		this.mvc.perform(get("/v1/diff/2")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(Messages.DECODED_DIFFERENCE_DO_TRUE_STRING));		
						
	}
	
	@Test
	public void shouldAnalyseReturnBadRequest() throws Exception {

		this.mvc.perform(get("/v1/diff/5")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
						
						
	}
	


}
