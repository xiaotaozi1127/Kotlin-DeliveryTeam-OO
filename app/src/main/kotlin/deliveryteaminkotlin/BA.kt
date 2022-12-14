package deliveryteaminkotlin

import kotlin.math.min

class BA(name: String): Member(name) {
    override fun work() {
        if (team == null) return

        team!!.getAllStories().filter { it.status == StoryStatus.BACKLOG }.take(3)
            .forEach { it.status = StoryStatus.READY_FOR_DEV }

        val readyForDevStories = team!!.getAllStories().filter { it.status == StoryStatus.READY_FOR_DEV }
        val devs = team!!.getMembers { it is Dev && it.assignedStory == null }.map { it as Dev }
        if (readyForDevStories.isEmpty() || devs.isEmpty()) return

        for (index in 0 until min(readyForDevStories.size, devs.size)) {
            devs[index].assignedStory = readyForDevStories[index]
        }
    }
}
