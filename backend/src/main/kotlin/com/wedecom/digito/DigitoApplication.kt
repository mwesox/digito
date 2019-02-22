package com.wedecom.digito

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.wedecom.digito.api.AddPerson
import com.wedecom.digito.api.CreateVisit
import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*


@SpringBootApplication
class DigitoApplication(var cmdGtw: CommandGateway) : ApplicationRunner {

    private val log = KotlinLogging.logger {}

    override fun run(args: ApplicationArguments?) {
        log.info("Initializing data")

        var visitId = NanoIdUtils.randomNanoId(Random(), charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g'), 8)
        var tableId = NanoIdUtils.randomNanoId()
        cmdGtw.sendAndWait<CreateVisit>(CreateVisit(visitId, tableId))

        var personId = UUID.randomUUID().toString()

        cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Thomas"))
        cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Hans"))
        cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Werner"))
        cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Franz"))
    }
}

fun main(args: Array<String>) {
    runApplication<DigitoApplication>(*args)

}

