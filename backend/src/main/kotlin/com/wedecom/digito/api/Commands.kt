package com.wedecom.digito.api

import org.axonframework.modelling.command.TargetAggregateIdentifier

// Visit
data class CreateVisit(@TargetAggregateIdentifier val visitId: String, val tableId: String)
data class AddPerson(@TargetAggregateIdentifier val visitId: String, val personId: String,  val name: String)
data class RemovePerson(val personId: String, @TargetAggregateIdentifier val visitId: String)

// Order
data class CreateOrder(@TargetAggregateIdentifier val orderId: String)