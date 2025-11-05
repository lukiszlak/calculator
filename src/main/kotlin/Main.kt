package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    println("Arguments = ${args.joinToString("")}")
    val operation = args.joinToString("")
    println("operation is $operation")

    val operator = getOperation(operation)
    println("Operator is $operator")
    println("Getting Values")
    val values = operation.split(operator)
    println("values are $values ")
    println("Getting Operation Results")
    val operationResult = runOperation(operator, values)
    println(operationResult)

}

fun getOperation(operation: String): String {
    println("Getting Operator")
    val regexExpression = "\\d+(.*?)\\d+".toRegex()
    val matchResults = regexExpression.find(operation)

    val operator = matchResults!!.groups[1]!!.value
    println("Operator is $operator")
    return operator
}

fun runOperation(operator: String, values: List<String>): Int {
    println("Getting Run Operation from $values")
    return when(operator) {
        "+"-> values[0].toInt() + values[1].toInt()
        "-"-> values[0].toInt() - values[1].toInt()
        "*"-> values[0].toInt() * values[1].toInt()
        "/"-> values[0].toInt() / values[1].toInt()
        else -> throw Exception("The operator '$operator' is unsupported, use +/-/*//")
    }

}