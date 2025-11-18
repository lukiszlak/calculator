package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    val operation = args.joinToString("")

    val operationResults = manageOperation(operation)
    println(operationResults)
}

fun manageOperation(operation: String): Int {
    val regexExpression = "(?<=[+-])|(?=[+-])".toRegex()
    val operations = operation.split(regexExpression).toMutableList()
    val operatorsList = arrayListOf<String>("+", "-", "/", "*")
    for (i in operations.indices) {
        val operation = operations[i]
        operations[i] = when {
            operation.toIntOrNull() != null -> operation
            operatorsList.contains(operation) -> operation
            isMultiplicationOrDivision(operation) -> runDivisionMultiplicationOperations(operation)
            // TODO Do the above function and then run the result by runDivisionMultiplicationOperations

            else -> throw error("Wrong operation type $operation")
        }
    }

    val finalResult = runAdditionSubstractionOperations(operations)

    return finalResult.toInt()
}

fun isMultiplicationOrDivision(operation: String): Boolean {
    return operation.split("([*/])".toRegex()).size > 1
}

fun runDivisionMultiplicationOperations(operation: String): String {
    // regex uses lookbehind and lookahead to separate values and operators
    val regex = Regex("(?<=[*/])|(?=[*/])")
    val listedOperationRaw = operation.split(regex)
    val listedOperation = listedOperationRaw.toMutableList()

    while (listedOperation.size >= 3) {
        val value1 = listedOperation[0].toInt()
        val operator = listedOperation[1]
        val value2 = listedOperation[2].toInt()

        val operationResult = when (operator) {
            "/" -> value1 / value2
            "*" -> value1 * value2
            else -> throw error("Wrong operator $operator")
        }

        listedOperation.subList(0,3).clear()
        listedOperation.add(0, operationResult.toString())
    }
    return listedOperation[0]
}

fun runAdditionSubstractionOperations(operation: MutableList<String>): String {
    while (operation.size >= 3) {
        val value1 = operation[0].toInt()
        val operator = operation[1]
        val value2 = operation[2].toInt()

        val operationResult = when (operator) {
            "+" -> value1 + value2
            "-" -> value1 - value2
            else -> throw error("Wrong operator $operator")
        }

        operation.subList(0,3).clear()
        operation.add(0, operationResult.toString())
    }
    return operation[0]
}