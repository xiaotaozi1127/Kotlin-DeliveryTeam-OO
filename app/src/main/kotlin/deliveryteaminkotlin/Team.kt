package deliveryteaminkotlin

class Team {
    private var members: MutableList<Member> = mutableListOf()
    private var stories: MutableList<Story> = mutableListOf()
    fun assignMember(member: Member) {
        members.add(member)
    }

    fun getAllMembers(): List<Member> {
        return members
    }

    fun assignStory(story: Story) {
        stories.add(story)
    }

    fun getAllStories(): List<Story> {
        return stories
    }
}
