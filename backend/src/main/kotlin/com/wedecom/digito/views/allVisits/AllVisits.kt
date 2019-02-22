package com.wedecom.digito.views.allVisits

import com.wedecom.digito.api.PersonAdded
import com.wedecom.digito.api.VisitCreated
import mu.KotlinLogging
import org.axonframework.eventhandling.EventHandler
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import javax.persistence.Id

@Document
data class AllVisitEntity(@Id val id: String, val visitId: String, val personNames: MutableList<String>)

@Repository
interface AllVisitsRepository: MongoRepository<AllVisitEntity, String>

@Service
class AllVisitsView(var repo: AllVisitsRepository){

    private val log = KotlinLogging.logger {}

    @EventHandler
    fun on(evt: VisitCreated) {
        log.info("event handler $evt")
        repo.save(AllVisitEntity(evt.id, evt.id, mutableListOf()) )
    }

    @EventHandler
    fun on(evt: PersonAdded) {
        log.info("event handler $evt") {  }
        repo.findById(evt.visitId).ifPresent {t: AllVisitEntity ->
            t.personNames.add(evt.name)
            log.info ("Adding names $t")
            repo.save(t)
        }
    }
}



