package com.wedecom.digito.visit

import com.wedecom.digito.api.AddPerson
import com.wedecom.digito.api.CreateVisit
import com.wedecom.digito.api.PersonAdded
import com.wedecom.digito.api.VisitCreated
import mu.KotlinLogging
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle.apply
import org.axonframework.spring.stereotype.Aggregate


@Aggregate
class Visit() {

    private val log = KotlinLogging.logger {}


    @AggregateIdentifier
    var id: String = ""

    private var persons: MutableList<Person> = mutableListOf();

    @CommandHandler
    constructor(cmd: CreateVisit) : this() {
        apply(VisitCreated(cmd.visitId))
    }

    @CommandHandler
    fun addPerson(cmd: AddPerson) {
        apply(PersonAdded(cmd.personId, cmd.name, cmd.visitId))
    }

    @EventSourcingHandler
    fun on(evt: VisitCreated) {
        id = evt.id
    }

    @EventSourcingHandler
    fun on(evt: PersonAdded) {
        log.info("Person added") { "Name ${evt.name}" }

        persons.add(Person(evt.personId, evt.name))
    }


}