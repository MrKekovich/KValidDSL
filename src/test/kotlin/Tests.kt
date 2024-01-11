import org.junit.jupiter.api.Test
import validators.validateAll
import validators.value

internal class Tests {
    @Test
    fun `simple test`() {
        val moscow = City("Moscow")
        val losAngeles = City("Los Angeles")
        val ivan = User("Ivan", null, moscow)
        val peter = User("Peter", "Parker", losAngeles)
        val violations = validateAll {
            ivan::name.notBlank()
            ivan::city {
                value::name {
                    notBlank()
                    notEqualTo(losAngeles.name)
                }
            }
        }
    }
}

data class User(
    val name: String,
    @Alias("surname")
    val surname: String?,
    val city: City,
)

data class City(val name: String)
