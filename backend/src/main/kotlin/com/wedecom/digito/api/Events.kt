package com.wedecom.digito.api

data class VisitCreated(val id: String, val name: String)
data class PersonAdded(val personId: String, val name: String, val visitId: String)
data class OrderCreated(val id: String)
data class TableSelected(val tableId: String, val visitId: String)
