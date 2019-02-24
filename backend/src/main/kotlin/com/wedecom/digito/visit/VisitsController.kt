package com.wedecom.digito.visit

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.wedecom.digito.api.AddPerson
import com.wedecom.digito.api.CreateVisit
import com.wedecom.digito.views.allVisits.AllVisitEntity
import com.wedecom.digito.views.allVisits.AllVisitsRepository
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/api/visits")
class VisitsController(
        var cmdGtw: CommandGateway,
        var repo: AllVisitsRepository
) {

    private val log = KotlinLogging.logger {}


    @PutMapping
    fun createVisit(): CompletableFuture<String>? {
        log.info("Received createVisit")
        return this.cmdGtw.send<String>(CreateVisit(NanoIdUtils.randomNanoId(), NanoIdUtils.randomNanoId()))
    }

    @PostMapping("/{visitId}")
    fun addPerson(@RequestBody firstName: String, @PathVariable visitId: String): String? {
        log.info("Received addPerson")
        val personId = NanoIdUtils.randomNanoId()
        this.cmdGtw.sendAndWait<String>(AddPerson(visitId, personId, firstName))
        return personId
    }

    @GetMapping
    fun getAllVisits(): List<AllVisitEntity> {
        return repo.findAll()
    }
}

