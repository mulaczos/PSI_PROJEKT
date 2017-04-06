package groovy.shop.infrastructure.base

import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import shop.Application
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(loader = SpringBootContextLoader.class, classes = Application.class)
abstract class BaseControllerIT extends Specification {

    @Shared
    protected MockMvc client
    @Autowired
    protected WebApplicationContext context

    def setup() {
        client = MockMvcBuilders.webAppContextSetup(context).build();
    }

    def performAndReturnAsJsonSlurperObject(MockHttpServletRequestBuilder requestBuilder) {
        def slurper = new JsonSlurper();
        return slurper.parseText(performAndReturnAsString(requestBuilder))
    }

    def performAndReturnAsString(MockHttpServletRequestBuilder requestBuilder) {
        perform(requestBuilder).andReturn().response.contentAsString
    }

    def perform(MockHttpServletRequestBuilder request) {
        client.perform(request)
    }

}
