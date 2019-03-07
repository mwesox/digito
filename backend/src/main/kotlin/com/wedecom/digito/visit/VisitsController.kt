package com.wedecom.digito.visit

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.wedecom.digito.api.AddPerson
import com.wedecom.digito.api.CreateVisit
import com.wedecom.digito.api.SelectTable
import com.wedecom.digito.views.visit.Visit
import com.wedecom.digito.views.visit.VisitRepository
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/api/visits")
class VisitsController(
        var cmdGtw: CommandGateway,
        var repo: VisitRepository
) {

    private val log = KotlinLogging.logger {}


    @PutMapping
    fun createVisit(@RequestBody name: String): CompletableFuture<String>? {
        log.info("Received createVisit")
        return this.cmdGtw.send<String>(CreateVisit(NanoIdUtils.randomNanoId(), name))
    }

    @PostMapping("/{id}/addPerson")
    fun addPerson(@RequestBody firstName: String, @PathVariable id: String): String {
        log.info("Received addPerson")
        val personId = NanoIdUtils.randomNanoId()
        this.cmdGtw.sendAndWait<String>(AddPerson(id, personId, firstName))

        return personId

    }

    @PostMapping("/{visitId]")
    fun test() {
        log.info("test ok")
    }

    @PostMapping("/{visitId}/selectTable")
    fun selectTable(@RequestBody tableId: String, @PathVariable visitId: String): String {
        log.info("Received selectTable")
        this.cmdGtw.sendAndWait<String>(SelectTable(visitId, tableId))
        return visitId
    }

    @GetMapping("/{visitId}")
    fun getVisit(@PathVariable visitId: String): Visit? {
        return repo.findById(visitId)
                .orElseGet(null)
    }

    @GetMapping
    fun getAllVisits(): List<Visit> {
        return repo.findAll()
    }
}

