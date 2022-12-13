package deliveryteaminkotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class BATest {
    @Test fun ba_should_be_able_to_prepare_story_and_assign_card() {
        val team = Team()
        val ba = BA("xixi")
        val dev = Dev("yanmin")
        team.assignMember(ba)
        team.assignMember(dev)
        val story = Story("fix bug")
        team.assignStory(story)

        ba.work()

        assertEquals(story, dev.assignedStory)
    }

    @Test fun ba_should_be_able_to_prepare_3_stories_at_most() {
        val team = Team()
        val ba = BA("xixi")
        val yanmin = Dev("yanmin")
        val yunlong = Dev("yunlong")
        val haotian = Dev("haotian")
        val yanhua = Dev("yanhua")
        team.assignMember(ba)
        team.assignMember(yanmin)
        team.assignMember(yunlong)
        team.assignMember(haotian)
        team.assignMember(yanhua)

        val story1 = Story("story1")
        val story2 = Story("story2")
        val story3 = Story("story3")
        val story4 = Story("story4")
        team.assignStory(story1)
        team.assignStory(story2)
        team.assignStory(story3)
        team.assignStory(story4)

        ba.work()

        assertEquals(StoryStatus.READY_FOR_DEV, story1.status)
        assertEquals(StoryStatus.READY_FOR_DEV, story2.status)
        assertEquals(StoryStatus.READY_FOR_DEV, story3.status)
        assertEquals(StoryStatus.BACKLOG, story4.status)
        assertNotNull(yanmin.assignedStory)
        assertNotNull(yunlong.assignedStory)
        assertNotNull(haotian.assignedStory)
        assertNull(yanhua.assignedStory)
    }
}
