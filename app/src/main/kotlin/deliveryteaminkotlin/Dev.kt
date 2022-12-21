package deliveryteaminkotlin

class Dev(name: String): Member(name) {
    var assignedStory: Story? = null
    set(value) {
        if (assignedStory != null && value != null) {
            throw Exception("developer already assigned a story")
        }
        field = value
    }

    override fun work() {
        if (team == null || assignedStory == null) return
        assignedStory!!.status = StoryStatus.READY_FOR_QA
        assignedStory = null
    }
}
