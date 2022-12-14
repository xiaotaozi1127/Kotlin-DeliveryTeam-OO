package deliveryteaminkotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class QATest {
    @Test fun qa_should_be_able_to_test_stories() {
        val team = Team()
        val ba = BA("xixi")
        val dev = Dev("yanmin")
        val qa = QA("shanshan")
        val story = Story("fix bug")
        team.apply {
            assignMember(ba)
            assignMember(dev)
            assignMember(qa)
            assignStory(story)
        }

        ba.work()
        dev.work()
        qa.work()

        assertEquals(StoryStatus.DONE, story.status)
    }

    @Test fun qa_should_be_able_to_test_2_stories_at_most() {
        val team = Team()
        val ba = BA("xixi")
        val yanmin = Dev("yanmin")
        val yunlong = Dev("yunlong")
        val haotian = Dev("haotian")
        val qa = QA("shanshan")
        val story1 = Story("story1")
        val story2 = Story("story2")
        val story3 = Story("story3")

        team.apply {
            assignMember(ba)
            assignMember(yanmin)
            assignMember(yunlong)
            assignMember(haotian)
            assignMember(qa)
            assignStory(story1)
            assignStory(story2)
            assignStory(story3)
        }

        ba.work()
        yanmin.work()
        yunlong.work()
        haotian.work()
        qa.work()

        assertEquals(StoryStatus.DONE, story1.status)
        assertEquals(StoryStatus.DONE, story2.status)
        assertNotEquals(StoryStatus.DONE, story3.status)
    }
}
