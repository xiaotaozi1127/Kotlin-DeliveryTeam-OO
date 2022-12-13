package deliveryteaminkotlin

class QA(name: String): Member(name) {
    override fun work() {
        if (team == null) return

        team!!.getAllStories().filter { it.status == StoryStatus.READY_FOR_QA }.subList(0, 2).forEach {it.status = StoryStatus.DONE}

    }
}
