package deliveryteaminkotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class QATest {
    @Test fun qa_should_be_able_to_test_stories() {
        val team = Team()
        val ba = BA("xixi")
        val dev = Dev("yanmin")
        val qa = QA("shanshan")
        team.assignMember(ba)
        team.assignMember(dev)
        team.assignMember(qa)
        val story = Story("fix bug")
        team.assignStory(story)

        ba.work()
        dev.work()
        qa.work()

        assertEquals(StoryStatus.DONE, story.status)
    }
}
