package com.wedecom.digito

import mu.KotlinLogging
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class DigitoApplication(var cmdGtw: CommandGateway) : ApplicationRunner {

    private val log = KotlinLogging.logger {}

    override fun run(args: ApplicationArguments?) {
/*        log.info("Initializing data")

        var visitId = NanoIdUtils.randomNanoId(Random(), charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g'), 8)
        var tableId = NanoIdUtils.randomNanoId()


        cmdGtw.sendAndWait<CreateVisit>(CreateVisit(visitId, tableId))

        var personId = UUID.randomUUID().toString()

        cmdGtw.sendAndWait<AddPerson>(AddPerson(visitId, personId, "Thomas"))
        cmdGtw.sendAndWait<AddPerson>(AddPerson(visitId, personId, "Hans"))
        cmdGtw.sendAndWait<AddPerson>(AddPerson(visitId, personId, "Werner"))
        cmdGtw.sendAndWait<AddPerson>(AddPerson(visitId, personId, "Franz"))*/
    }
}

fun main(args: Array<String>) {
    runApplication<DigitoApplication>(*args)

}

