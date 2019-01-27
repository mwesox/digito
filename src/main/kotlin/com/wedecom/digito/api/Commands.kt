package com.wedecom.digito.api

import org.axonframework.modelling.command.AggregateIdentifier

data class CreateVisit(val visitId: String, val tableId: String)
data class AddPerson(val personId: String, @AggregateIdentifier val visitId: String, val name: String)
data class RemovePerson(val personId: String, @AggregateIdentifier val visitId: String)