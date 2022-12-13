package deliveryteaminkotlin

import kotlin.math.min

class BA(name: String): Member(name) {
    override fun work() {
        if (team == null) return

        val stories = team!!.getAllStories().filter { it.status == StoryStatus.BACKLOG }.take(3)
        stories.forEach { it.status = StoryStatus.READY_FOR_DEV }

        val readyForDevStories = team!!.getAllStories().filter { it.status == StoryStatus.READY_FOR_DEV }
        val devs = team!!.getMembers { it is Dev && it.assignedStory == null }
        if (readyForDevStories.isEmpty() || devs.isEmpty()) return

        val count: Int = min(readyForDevStories.size, devs.size)
        for (index in 0 until count) {
            val story = stories[index]
            val dev = devs[index]
            if (dev is Dev) {
                dev.assignedStory = story
            }
        }
    }
}
