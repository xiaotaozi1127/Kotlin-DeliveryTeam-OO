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

    @Test fun qa_should_be_able_to_test_2_stories_at_most() {
        val team = Team()
        val ba = BA("xixi")
        val yanmin = Dev("yanmin")
        val yunlong = Dev("yunlong")
        val haotian = Dev("haotian")
        val qa = QA("shanshan")
        team.assignMember(ba)
        team.assignMember(yanmin)
        team.assignMember(yunlong)
        team.assignMember(haotian)
        team.assignMember(qa)
        val story1 = Story("story1")
        val story2 = Story("story2")
        val story3 = Story("story3")
        team.assignStory(story1)
        team.assignStory(story2)
        team.assignStory(story3)

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
