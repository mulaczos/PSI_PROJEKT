package groovy.shop.infrastructure.service

import groovy.shop.infrastructure.base.BaseControllerIT
import shop.infrastructure.domain.model.Customer

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class CustomerControllerIT extends BaseControllerIT {

    def "Post customer"() {

        given: "that there is new customer"
        def customer = new Customer({
            firstName:
            'FIRST' secondName: 'SECOND'
        })

        when: "post with customer is requested"
        def response = performAndReturnAsJsonSlurperObject(post('/customer', (customer)))

        then: "response should contain customer details"
        response.id == 1
        response.firstName == 'FIRST'
        response.secondName == 'SECOND'

        }
    }

