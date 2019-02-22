package com.wedecom.digito.api

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreateVisit(@TargetAggregateIdentifier val visitId: String, val tableId: String)
data class AddPerson(val personId: String, @TargetAggregateIdentifier val visitId: String, val name: String)
data class RemovePerson(val personId: String, @TargetAggregateIdentifier val visitId: String)