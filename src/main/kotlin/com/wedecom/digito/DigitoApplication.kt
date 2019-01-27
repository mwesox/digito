package com.wedecom.digito

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DigitoApplication()

/*
@Autowired
lateinit var cmdGtw: CommandGateway
*/

private val log = KotlinLogging.logger {}

fun main(args: Array<String>) {
    runApplication<DigitoApplication>(*args)
}

/*
@PostConstruct
fun post() {

    log.info ("Initializing data")

    var visitId = UUID.randomUUID().toString()
    var tableId = UUID.randomUUID().toString()
    cmdGtw.sendAndWait<CreateVisit>(CreateVisit(visitId, tableId))

    var personId = UUID.randomUUID().toString()

    cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Thomas"))
    cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Hans"))
    cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Werner"))
    cmdGtw.sendAndWait<AddPerson>(AddPerson(personId, visitId, "Franz"))

}
*/
