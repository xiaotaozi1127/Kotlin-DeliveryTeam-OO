package deliveryteaminkotlin

open class Member(val name: String) {
    open fun work() {}
    var team: Team? = null
}
