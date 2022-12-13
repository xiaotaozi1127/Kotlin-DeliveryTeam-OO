package deliveryteaminkotlin

import kotlin.math.min

class BA(name: String): Member(name) {
    override fun work() {
        if (team == null) return

        val stories = team!!.getAllStories().filter { it.status == StoryStatus.BACKLOG }
        val devs = team!!.getMembers { it is Dev }
        if (stories.isEmpty() || devs.isEmpty()) return

        val count: Int = min(stories.size, devs.size)
        for (index in 0 until count) {
            val story = stories[index]
            val dev = devs[index]
            story.status = StoryStatus.READY_FOR_DEV
            if (dev is Dev) {
                dev.assignedStory = story
            }
        }
    }
}
