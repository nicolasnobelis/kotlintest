import calendar.Appointment
import calendar.Calendar
import calendar.Owner
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class Tests {
    fun createOwner(): Owner {
        return Owner("Max", "Mustermann")
    }

    fun createAppointment(title: String = "RDV Dentist"): Appointment {
        return Appointment(title, "Appointment at the dentist", LocalDateTime.now())
    }

    fun createCalendar(): Calendar {
        return Calendar("test Calendar", createOwner())
    }

    fun assertOwner(owner:Owner) {
        assertNotNull(owner)
        assertEquals("Max", owner.firstname)
        assertEquals("Mustermann", owner.lastname)
    }

    @Test
    fun testOwner() {
        val owner = createOwner()
        assertOwner(owner)
    }

    @Test
    fun testCalendar() {
        val calendar = createCalendar()

        assertEquals("test Calendar", calendar.name)
        assertTrue { calendar.active }
        assertOwner(calendar.owner)
    }

    @Test
    fun testAppointment() {
        val appointment = createAppointment()
        val calendar = createCalendar()

        assertTrue(calendar.getAppointments().isEmpty())

        calendar.addAppointments(appointment)

        val appointments = calendar.getAppointments()
        assertEquals(1, appointments.size)
    }

    @Test
    fun testAppointmentOrdering() {
        val appointment1 = createAppointment("Test 1")
        val appointment2 = createAppointment("Test 2")
        val calendar = createCalendar()

        assertTrue(calendar.getAppointments().isEmpty())

        calendar.addAppointments(appointment2)
        calendar.addAppointments(appointment1)

        val appointments = calendar.getAppointments()
        val appointmentsList = appointments.toList();
        assertEquals(2, appointments.size)
        assertEquals("Test 1", appointmentsList.get(0).title)
        assertEquals("Test 2", appointmentsList.get(1).title)
    }
}