package com.wedecom.digito.visit

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.wedecom.digito.api.CreateVisit
import com.wedecom.digito.views.allVisits.AllVisitEntity
import com.wedecom.digito.views.allVisits.AllVisitsRepository
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/api/visits")
class VisitController(
        var cmdGtw: CommandGateway,
        var repo: AllVisitsRepository
) {

    private val log = KotlinLogging.logger {}


    @PostMapping
    fun createVisit(@RequestBody firstName: String): CompletableFuture<String>? {
        log.info("Received createVisit")
        return this.cmdGtw.send<String>(CreateVisit(NanoIdUtils.randomNanoId(), NanoIdUtils.randomNanoId()))
    }

    @GetMapping
    fun getAllVisits(): List<AllVisitEntity> {
        return repo.findAll()
    }
}

