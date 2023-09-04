// write the class Complex here
class Complex(
    val hiddenReal: Double = 0.0,
    val hiddenImage: Double = 0.0
) {
    var real = hiddenReal
        get() = field
        set(value) {
            field = value
        }

    var image = hiddenImage
        get() = field
        set(value) {
            field = value
        }
// Practicing encasuplation with custom getters and setters, it's a complex class after all ;)
}
