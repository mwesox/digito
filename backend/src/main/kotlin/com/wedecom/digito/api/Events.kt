package com.wedecom.digito.api

data class VisitCreated(val id: String)
data class PersonAdded(val personId: String, val name: String, val visitId: String)