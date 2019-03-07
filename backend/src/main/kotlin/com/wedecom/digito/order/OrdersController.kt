package com.wedecom.digito.order

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.wedecom.digito.api.CreateOrder
import com.wedecom.digito.views.visit.Visit
import com.wedecom.digito.views.visit.VisitRepository
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/api/orders")
class OrdersController(
        var cmdGtw: CommandGateway,
        var repo: VisitRepository
) {

    private val log = KotlinLogging.logger {}


    @PutMapping
    fun createOrder(): CompletableFuture<String>? {
        log.info("Received createOrder")
        return this.cmdGtw.send<String>(CreateOrder(NanoIdUtils.randomNanoId()))
    }

    @GetMapping
    fun getAllVisits(): List<Visit> {
        return repo.findAll()
    }
}
