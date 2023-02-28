package deliveryteaminkotlin

class Team(name: String = "myteam") {
    var members: MutableList<Member> = mutableListOf()
    private set
    var stories: MutableList<Story> = mutableListOf()
    private set

    fun assignMember(member: Member) {
        members.add(member)
        member.team = this
    }

    fun assignStory(story: Story) {
        stories.add(story)
    }

    fun getMembers(lambda: (Member) -> Boolean): List<Member> {
        return members.filter { lambda(it) }
    }
}
