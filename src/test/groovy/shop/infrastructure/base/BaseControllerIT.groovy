package groovy.shop.infrastructure.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import shop.Application
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
abstract class BaseControllerIT extends Specification {

    @Shared
    protected MockMvc client
    @Autowired
    protected WebApplicationContext context

    def setup() {
        client = MockMvcBuilders.webAppContextSetup(context).build();
    }

    def performAndReturnAsJson(MockHttpServletRequestBuilder requestBuilder) {
        return fromJson(performAndReturnAsString(requestBuilder))
    }

    def performAndReturnAsString(MockHttpServletRequestBuilder requestBuilder) {
        perform(requestBuilder).andReturn().response.contentAsString
    }

    def perform(MockHttpServletRequestBuilder request) {
        client.perform(request)
    }

}