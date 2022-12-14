package deliveryteaminkotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DevTest {
    @Test fun dev_should_be_able_to_finish_assigned_card() {
        val team = Team()
        val ba = BA("xixi")
        val dev = Dev("yanmin")
        val story = Story("fix bug")
        team.apply {
            assignMember(ba)
            assignMember(dev)
            assignStory(story)
        }

        ba.work()
        dev.work()

        assertEquals(StoryStatus.READY_FOR_QA, story.status)
        assertNull(dev.assignedStory)
    }
}
