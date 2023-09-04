package machine.coffeeMachineOptions

/**
 * Manages the process of refilling supplies in the coffee machine.
 *
 * @property data The CoffeeMachineStatusManager instance to manage coffee machine status.
 */
class RefillManager(val data: CoffeeMachineStatusManager) {
    // Lazily initialize the refill values using the getFillValues function
    val refillValues by lazy { convertToMap(getFillValues()) }

    /**
     * Prompts the user for refill amounts and returns a list of refill pairs.
     * Each pair consists of a supply name (e.g., "water") and the amount to refill.
     */
    private fun getFillValues(): MutableList<Pair<String, Int>> {
        val refillValues = mutableListOf<Pair<String, Int>>()

        println("Write how many ml of water you want to add:")
        refillValues.add("water" to readln().toInt())

        println("Write how many ml of milk you want to add:")
        refillValues.add("milk" to readln().toInt())

        println("Write how many grams of coffee beans you want to add:")
        refillValues.add("coffee beans" to readln().toInt())

        println("Write how many disposable cups you want to add: ")
        refillValues.add("disposable cups" to readln().toInt())

        return refillValues
    }

    /**
     * Converts a list of refill pairs to a map for easier use.
     */
    fun convertToMap(inputList: MutableList<Pair<String, Int>>): Map<String, Int> {
        val resultMap = mutableMapOf<String, Int>()
        for ((key, value) in inputList) {
            resultMap[key] = value
        }
        return resultMap
    }

    /**
     * Updates the coffee machine status after refilling supplies.
     */
    fun updateValues() {
        data.updateStatusAfterRefill(refillValues)
    }
}
