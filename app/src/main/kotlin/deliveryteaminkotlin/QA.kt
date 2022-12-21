package deliveryteaminkotlin

class QA(name: String): Member(name) {
    override fun work() {
        if (team == null) return

        team!!.stories
            .filter { it.status == StoryStatus.READY_FOR_QA }
            .take(2)
            .forEach {it.status = StoryStatus.DONE}

    }
}
