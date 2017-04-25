package groovy.shop.infrastructure.service

import groovy.json.JsonOutput
import groovy.shop.infrastructure.base.BaseControllerIT
import org.springframework.http.MediaType
import shop.infrastructure.domain.model.customer.Customer

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class CustomerControllerIT extends BaseControllerIT {

    def "Post customer"() {

        given: "that there is new customer"
        def customer = new Customer(firstName: 'FIRST', secondName: 'SECOND')

        when: "post with customer is requested"
        def response = perform(post('/customer').content(JsonOutput.toJson(customer)).contentType(MediaType.APPLICATION_JSON_UTF8))

        then: "response should contain customer details"

        println response.andReturn().response.contentAsString
    }
}

