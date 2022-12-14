package deliveryteaminkotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class BATest {
    @Test fun ba_should_be_able_to_prepare_story_and_assign_card() {
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
        story.let {
            assertEquals(it, dev.assignedStory)
            assertEquals(StoryStatus.READY_FOR_DEV, it.status)
        }
    }

    @Test fun ba_should_be_able_to_prepare_3_stories_at_most() {
        val team = Team()
        val ba = BA("xixi")
        val yanmin = Dev("yanmin")
        val yunlong = Dev("yunlong")
        val haotian = Dev("haotian")
        val yanhua = Dev("yanhua")
        val story1 = Story("story1")
        val story2 = Story("story2")
        val story3 = Story("story3")
        val story4 = Story("story4")

        team.apply {
            assignMember(ba)
            assignMember(yanmin)
            assignMember(yunlong)
            assignMember(haotian)
            assignMember(yanhua)
            assignStory(story1)
            assignStory(story2)
            assignStory(story3)
            assignStory(story4)
        }

        ba.work()

        assertAll("ba work", {
            assertEquals(StoryStatus.READY_FOR_DEV, story1.status)
            assertEquals(StoryStatus.READY_FOR_DEV, story2.status)
            assertEquals(StoryStatus.READY_FOR_DEV, story3.status)
            assertEquals(StoryStatus.BACKLOG, story4.status)
            assertNotNull(yanmin.assignedStory)
            assertNotNull(yunlong.assignedStory)
            assertNotNull(haotian.assignedStory)
            assertNull(yanhua.assignedStory)
        })
    }
}
