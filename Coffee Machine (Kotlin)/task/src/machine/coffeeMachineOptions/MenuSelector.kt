package machine.coffeeMachineOptions

/**
 * Represents the menu selector for the coffee machine program.
 * Manages user interactions by displaying options and directing actions.
 *
 * @property data The CoffeeMachineStatusManager instance to manage coffee machine status.
 */
class MenuSelector(val data: CoffeeMachineStatusManager) {
    // Initialize instances of various managers
    val purchaseManager = PurchaseManager(data, this)
    val refillManager = RefillManager(data)
    val machineMoneyManager = MachineMoneyManager(data)

    /**
     * Displays the main menu to the user and handles their input.
     * Interprets user choices and delegates actions to appropriate managers.
     */
    fun showMenu() {
        while (true) {
            println()
            println("Write action (buy, fill, take, remaining, exit):")
            val option = readln()
            when (option) {
                "buy" -> purchaseManager.buyCoffee() // Handle coffee purchase
                "fill" -> {
                    refillManager.refillValues // Display refill prompt
                    refillManager.updateValues() // Update supplies after refill
                }
                "take" -> machineMoneyManager.giveTheMoney() // Give money to user
                "remaining" -> data.showStatus() // Display remaining resources
                "exit" -> break // Exit the menu loop
                else -> println("Invalid option")
            }
        }
    }
}

