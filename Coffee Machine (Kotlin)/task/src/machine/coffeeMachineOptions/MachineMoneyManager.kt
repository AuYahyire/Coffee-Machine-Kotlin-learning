package machine.coffeeMachineOptions

/**
 * Manages the dispensing of money from the coffee machine.
 *
 * @property data The CoffeeMachineStatusManager instance to manage coffee machine status.
 */
class MachineMoneyManager(val data: CoffeeMachineStatusManager) {
    /**
     * Dispenses the money stored in the coffee machine to the user.
     * Updates the coffee machine status by resetting the money amount.
     */
    fun giveTheMoney(){
        println()
        println("I gave you $${data.statusData.moneyInMachine}")

        // Update the coffee machine status after taking the money
        data.updateStatusAfterTake()
    }
}
