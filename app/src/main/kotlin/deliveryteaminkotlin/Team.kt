package deliveryteaminkotlin

class Team {
    private var members: MutableList<Member> = mutableListOf()
    fun assignMember(member: Member) {
        members.add(member)
    }

    fun getAllMembers(): List<Member> {
        return members
    }
}
