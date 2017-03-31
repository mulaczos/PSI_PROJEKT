package groovy.shop.infrastructure.service

import groovy.shop.infrastructure.base.BaseControllerIT
import shop.infrastructure.domain.model.Customer

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class CustomerControllerIT extends BaseControllerIT {

    def "Post customer"() {

        given: "that there is new customer"
        def customer = new Customer(firstName: "FIRST", secondName: "SECOND")

        when: "post with customer is requested"
        def response = perform(post("/customer", (customer)));

        then: "response should contain customer details"
        response.andReturn().response.contentAsString

        }
    }

