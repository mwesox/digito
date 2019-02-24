package com.wedecom.digito.views.allOrders

import com.wedecom.digito.api.OrderCreated
import mu.KotlinLogging
import org.axonframework.eventhandling.EventHandler
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import javax.persistence.Id

@Document
data class AllOrdersEntity(@Id val orderId: String)

@Repository
interface AllOrdersRepository: MongoRepository<AllOrdersEntity, String>

@Service
class AllOrdersView(var repo: AllOrdersRepository){

    private val log = KotlinLogging.logger {}

    @EventHandler
    fun on(evt: OrderCreated) {
        log.info("event handler $evt")
        repo.save(AllOrdersEntity(evt.id) )
    }

}



