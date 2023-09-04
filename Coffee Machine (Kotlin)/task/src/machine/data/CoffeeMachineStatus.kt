package machine.data

/**
 * Represents the status of the coffee machine, including money, supplies, and cups.
 *
 * @property moneyInMachine The amount of money stored in the coffee machine.
 * @property disposableCups The number of disposable cups available in the machine.
 * @property machineOrganicSupplies A map of organic supplies and their quantities along with units.
 */
class CoffeeMachineStatus(
    var moneyInMachine: Int = 0,
    var disposableCups: Int = 0,
    val machineOrganicSupplies: MutableMap<String, Pair<Int, String>> = mutableMapOf()
) {
    companion object {
        /**
         * Represents the initial status of the coffee machine with predefined supplies.
         */
        val initialSupplies = CoffeeMachineStatus(
            moneyInMachine = 550,
            disposableCups = 9,
            machineOrganicSupplies = mutableMapOf(
                "water" to Pair(400, "ml"),
                "milk" to Pair(540, "ml"),
                "coffee beans" to Pair(120, "g")
            )
        )
    }
}
