package com.lify.girl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//mvn clean package ; mvn clean package -Dmaven.test.skip=true//不通过单元测试，直接进行 打包
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girl/girls")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("abc"));//这里 url要给从 contextPath /之后的开始写
    }
}
