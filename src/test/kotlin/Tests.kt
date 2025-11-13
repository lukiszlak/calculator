import org.example.manageOperation
import org.example.runDivisionMultiplicationOperations
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

    @Test
    fun MultipleDivisionTest() {
        val operationResultsDivision = runDivisionMultiplicationOperations("20/2/2")
        assertEquals(5, operationResultsDivision.toInt())

        val operationResultsMultiplication = runDivisionMultiplicationOperations("20*2*2")
        assertEquals(80, operationResultsMultiplication.toInt())

        val operationResultsMixed = runDivisionMultiplicationOperations("20/2*2")
        assertEquals(20, operationResultsMixed.toInt())
    }
}