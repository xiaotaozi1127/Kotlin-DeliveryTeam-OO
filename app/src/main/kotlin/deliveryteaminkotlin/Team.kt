package deliveryteaminkotlin

class Team {
    private var members: MutableList<Dev> = mutableListOf()
    fun assignMember(dev: Dev) {
        members.add(dev)
    }

    fun getAllMembers(): List<Dev> {
        return members
    }
}
