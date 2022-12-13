package deliveryteaminkotlin

class Dev(name: String): Member(name) {
    var assignedStory: Story? = null

    override fun work() {
        if (team == null || assignedStory == null) return
        assignedStory!!.status = StoryStatus.READY_FOR_QA
        assignedStory = null
    }
}
