import calendar.Calendar
import calendar.Owner
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Tests {
    fun createOwner(): Owner {
        return Owner("Max", "Mustermann")
    }

    @Test
    fun testOwner() {
        val owner = createOwner()
        assertEquals("Max", owner.firstname)
        assertEquals("Mustermann", owner.lastname)
    }

    @Test
    fun testCalendar() {
        val owner = createOwner()
        val calendar = Calendar("test Calendar", createOwner())

        assertEquals("test Calendar", calendar.name)
        assertTrue { calendar.active }
        assertEquals(owner, calendar.owner)
    }

}