import org.example.manageOperation
import kotlin.test.Test
import kotlin.test.assertEquals

class Tests {

    @Test
    fun SimpleAdditionTest() {
        val operationResults = manageOperation("3+3")
        assertEquals(6, operationResults)
    }

    @Test
    fun SimpleSubstractionTest() {
        val operationResults = manageOperation("3-3")
        assertEquals(0, operationResults)
    }

    @Test
    fun SimpleMultiplicationTest() {
        val operationResults = manageOperation("3*3")
        assertEquals(9, operationResults)
    }

    @Test
    fun SimpleDivisionTest() {
        val operationResults = manageOperation("20/2")
        assertEquals(10, operationResults)
    }
}