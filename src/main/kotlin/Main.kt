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