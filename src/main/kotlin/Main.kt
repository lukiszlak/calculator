package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    val operation = args.joinToString("")

    val operationResults = manageOperation(operation)
    println(operationResults)
}

fun manageOperation(operation: String): Int {
    val operator = getOperation(operation)
    val values = operation.split(operator)
    val operationResult = runOperation(operator, values)
    return operationResult
}

fun getOperation(operation: String): String {
    val regexExpression = "\\d+(.*?)\\d+".toRegex()
    val matchResults = regexExpression.find(operation)

    val operator = matchResults!!.groups[1]!!.value
    return operator
}

fun runOperation(operator: String, values: List<String>): Int {
    return when(operator) {
        "+"-> values[0].toInt() + values[1].toInt()
        "-"-> values[0].toInt() - values[1].toInt()
        "*"-> values[0].toInt() * values[1].toInt()
        "/"-> values[0].toInt() / values[1].toInt()
        else -> throw Exception("The operator '$operator' is unsupported, use +/-/*//")
    }
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

        val operationResult = if (operator == "/") {
            value1 / value2
        } else {
            value1 * value2
        }

        listedOperation.subList(0,3).clear()
        listedOperation.add(0, operationResult.toString())
    }
    return listedOperation[0]
}