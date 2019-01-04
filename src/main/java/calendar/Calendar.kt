package calendar

import java.time.LocalDateTime

class Calendar(val name:String, val owner:Owner ) {
    var active:Boolean = true
    // in case there are two appointments with the same date, we use the title as disambiguation
    private val appointments: MutableSet<Appointment> = sortedSetOf(compareBy ({ it.date }, {it.title}))

    constructor(name:String, owner: Owner, active:Boolean ) : this(name, owner) {
        this.active = active
    }

    // read only set over appointments
    fun getAppointments() : Set<Appointment> {
        return appointments.toSet()
    }

    fun addAppointments(element:Appointment) {
        val result = appointments.add(element)
        println("added ${element.title} : ${result}")
    }
}

data class Owner(val firstname:String, val lastname:String)

data class Appointment (val title:String,  val description:String, val date:LocalDateTime)



