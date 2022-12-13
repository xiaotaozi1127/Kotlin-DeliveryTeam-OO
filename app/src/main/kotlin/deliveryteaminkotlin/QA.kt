package deliveryteaminkotlin

class QA(name: String): Member(name) {
    override fun work() {
        if (team == null) return

        team!!.getAllStories().filter { it.status == StoryStatus.READY_FOR_QA }.forEach {it.status = StoryStatus.DONE}

    }
}
