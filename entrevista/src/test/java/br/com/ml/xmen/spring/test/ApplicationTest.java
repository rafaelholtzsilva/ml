package br.com.ml.xmen.spring.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk());
    }
    /*

    @Test
    public void notMuntantIsNullJson() throws Exception {
    	DnaJson p = new DnaJson();
    	String[] a = {"ssss","aaa"};
    	p.setDna(a);

    	MockHttpServletRequestBuilder r = post("/mutant");
    	r.contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(r).andExpect(status().isOk());
        
    }*/

}